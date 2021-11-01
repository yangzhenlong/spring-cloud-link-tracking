package dev.yzl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class TrackingServerApp {

    public static void main(String[] args) {
        SpringApplication.run(TrackingServerApp.class, args);
    }


    private static List<Map<String, String>> list = new ArrayList<>();

    @GetMapping("/api/users")
    public List<Map<String, String>> users() {
        return list;
    }

    @PostMapping("/api/users")
    public Map<String, String> addUser(String id, String name) {
        Map<String, String> map = Collections.singletonMap(id, name);
        list.add(map);
        return map;
    }

    @DeleteMapping("/api/users/{id}")
    public Map<String, String> delUser(@PathVariable String id) {
        for (Map<String, String> user : list) {
            if (user.containsKey(id)) {
                list.remove(user);
                return user;
            }
        }
        throw new IllegalArgumentException("user not exists");
    }
}
