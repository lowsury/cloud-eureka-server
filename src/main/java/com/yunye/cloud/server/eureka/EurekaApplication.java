package com.yunye.cloud.server.eureka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@EnableAutoConfiguration
@SpringBootApplication
@EnableEurekaServer
@RestController
public class EurekaApplication {

    @Autowired
    private DiscoveryClient discoveryClient;

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
    }

    @RequestMapping("/service/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(
            @PathVariable String applicationName) {
        return this.discoveryClient.getInstances(applicationName);
    }
}