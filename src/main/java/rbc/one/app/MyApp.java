package rbc.one.app;

import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class MyApp {


    public static void main(String[] args) {
        SpringApplication.run(MyApp.class, args);
       
    }

    @Bean
    InitializingBean usersAndGroupsInitializer(final IdentityService identityService) {

        return new InitializingBean() {
            public void afterPropertiesSet() throws Exception {

                if(identityService.createGroupQuery().groupName("users").count()==0){
	            	Group group = identityService.newGroup("user");
	                group.setName("users");
	                group.setType("security-role");
	                identityService.saveGroup(group);
                }
                if(identityService.createUserQuery().userId("admin").count()==0){               	
	                User admin = identityService.newUser("admin");
	                admin.setPassword("admin");
	                identityService.saveUser(admin);
	                
                }                
                //add admin group and set the admin user into
                if(identityService.createGroupQuery().groupName("Admin").count()==0){
	            	Group group = identityService.newGroup("admin");
	                group.setName("admin");
	                group.setType("security-role");
	                identityService.saveGroup(group);
	               
                }
                if(identityService.createGroupQuery().groupMember("admin")==null)
                	identityService.createMembership("admin", "admin");
            }
        };
    }
}
