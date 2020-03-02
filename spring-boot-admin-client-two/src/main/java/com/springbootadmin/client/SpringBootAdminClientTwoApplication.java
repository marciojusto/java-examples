package com.springbootadmin.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringBootAdminClientTwoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAdminClientTwoApplication.class, args);
    }

}
