package dev.yzl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
@EnableFeignClients
public class TrackingClientApp {

    public static void main(String[] args) {
        SpringApplication.run(TrackingClientApp.class, args);
    }

}
