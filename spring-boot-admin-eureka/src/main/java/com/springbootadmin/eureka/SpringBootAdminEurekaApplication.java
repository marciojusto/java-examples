package com.springbootadmin.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringBootAdminEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAdminEurekaApplication.class, args);
    }

}