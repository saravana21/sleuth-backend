package com.comcast.xsp.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
@EnableAutoConfiguration
@RestController
@CrossOrigin
public class Billing {
    @Autowired RestTemplate restTemplate;

    @RequestMapping("/api") public String printDate() {
        return new Date().toString();
    }

    @Bean RestTemplate restTemplate() {
        return new RestTemplate();
    }
    public static void main(String[] args) {
        SpringApplication.run(Billing.class);
    }
    @Bean public AlwaysSampler defaultSampler() {
        return new AlwaysSampler();
    }
}
