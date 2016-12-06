package com.rbc.one.registry2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.subethamail.wiser.Wiser;

import rbc.one.app.MyApp;
import rbc.one.app.repository.RequestRepository;
import rbc.one.app.workflow.bean.Request;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {MyApp.class})
@WebAppConfiguration
@IntegrationTest
public class AccountClonningRequestTest {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private HistoryService historyService;

    @Autowired
    private RequestRepository requestRepository;

    private Wiser wiser;

    @Before
    public void setup() {
        wiser = new Wiser();
        wiser.setPort(1025);
        wiser.start();
    }

    @After
    public void cleanup() {
        wiser.stop();
    }

    @Test
    public void testHappyPath() {

        // Create test applicant
        Request request = new Request("12302554", "1235478","This is my json file", "Account");
        requestRepository.save(request);
        
        // Start process instance
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("request", request);
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("accountClonningRequest", variables);

        // First, the 'phone interview' should be active
        Task task = taskService.createTaskQuery()
                .processInstanceId(processInstance.getId())
                .singleResult();
        Assert.assertEquals("Submit request", task.getName());

        // Completing the sudmit with cancel
        Map<String, Object> taskVariables = new HashMap<String, Object>();
        taskVariables.put("resultaction", "cancel");
        taskService.complete(task.getId(), taskVariables);

        // Verify process completed
        Assert.assertEquals(1, historyService.createHistoricProcessInstanceQuery().processDefinitionId(processInstance.getId()).finished().count());

    }

}
