package dev.yzl.springcloud.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient(name = "server-app")
public interface ServerAppFeign {

    @GetMapping("/api/users")
    List<Map<String, String>> users();

    @PostMapping("/api/users")
    Map<String, String> addUser(@RequestParam("id") String id, @RequestParam("name") String name);

    @DeleteMapping("/api/users/{id}")
    Map<String, String> delUser(@RequestParam("id") String id);
}
