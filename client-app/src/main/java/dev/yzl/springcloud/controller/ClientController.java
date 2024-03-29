package dev.yzl.springcloud.controller;

import dev.yzl.springcloud.feign.ServerAppFeign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class ClientController {

    private static Logger log = LoggerFactory.getLogger(ClientController.class);

    @Resource
    private ServerAppFeign serverAppFeign;

    @GetMapping("/api/v1/users")
    public List<Map<String, String>> users() {
        log.info("get users");
        return serverAppFeign.users();
    }

    @PostMapping("/api/v1/users")
    public Map<String, String> addUser(String id, String name) {
        log.info("add user:id={}, name={}", id, name);
        return serverAppFeign.addUser(id, name);
    }

    @DeleteMapping("/api/v1/users/{id}")
    public Map<String, String> delUser(@PathVariable String id) {
        log.info("delete user:id={}", id);
        return serverAppFeign.delUser(id);
    }
}
