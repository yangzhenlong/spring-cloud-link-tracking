package dev.yzl.springcloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.sleuth.SpanName;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class TrackingServerApp {

    private static Logger log = LoggerFactory.getLogger(TrackingServerApp.class);

    public static void main(String[] args) {
        SpringApplication.run(TrackingServerApp.class, args);
    }


    private static List<Map<String, String>> list = new ArrayList<>();

    @GetMapping("/api/users")
    @SpanName("getusers")
    public List<Map<String, String>> users() {
        log.info("[server]get users");
        return list;
    }

    @PostMapping("/api/users")
    public Map<String, String> addUser(String id, String name) {
        log.info("[server] add users");
        Map<String, String> map = Collections.singletonMap(id, name);
        list.add(map);
        return map;
    }

    @DeleteMapping("/api/users/{id}")
    public Map<String, String> delUser(@PathVariable String id) {
        log.info("[server] del users");
        for (Map<String, String> user : list) {
            if (user.containsKey(id)) {
                list.remove(user);
                return user;
            }
        }
        throw new IllegalArgumentException("user not exists");
    }
}
