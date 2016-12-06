package rbc.one.app.controller;

import java.util.Collections;
import java.util.Map;

import org.activiti.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import rbc.one.app.repository.RequestRepository;
import rbc.one.app.workflow.bean.Account;
import rbc.one.app.workflow.bean.Request;

@RestController
public class AccountCloningRequestController {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private RequestRepository requestRepository;

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/start-account-cloning-process", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void startAccountCloningProcess(@RequestBody Map<String, Object> data) {
    	Account acc = new Account().setPromotorCode("promotor")
  		.setPromotorName("promotorName")
  		.setFundName("fundName")
  		.setShareClass("shareClass")
  		.setJuridiction("juridiction")
  		.createAccountInfo("accountName", "accountNumber", "clientIdentifier")
  		.createRegistredAdress("streetAdress", "floor", "city");
    	ObjectMapper objectMapper = new ObjectMapper();
    	String accStr = "";
    	try{
    		accStr = objectMapper.writeValueAsString(acc);
    	} catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	Request accountClonningRequest = new Request("2345687999","ThisIsMyIDClient",accStr,"Account");
         requestRepository.save(accountClonningRequest);
        //requestRepository.save(accountClonningRequest);

        Map<String, Object> vars = Collections.<String, Object>singletonMap("request", accountClonningRequest);
        runtimeService.startProcessInstanceByKey("accountClonningRequest", vars);
    }

}