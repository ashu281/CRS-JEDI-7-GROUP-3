package com.flipkart.app;

import com.flipkart.restController.CustomerRestController;
import org.glassfish.jersey.server.ResourceConfig;

public class ApplicationConfig extends ResourceConfig {
    // Register controllers
    public ApplicationConfig() {

//        register(com.flipkart.restController.StudentRestAPI.class);
        register(com.flipkart.restController.UserRestAPI.class);
//        register(com.flipkart.application.ProfessorRestAPI.class);
//        register(com.flipkart.application.AdminRestAPI.class);
//        register(CustomerRestController.class);

    }
}
