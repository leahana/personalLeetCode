package top.yannyi.feign.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.yannyi.feign.client.HelloClient;

@RestController
public class DemoController {

    private final HelloClient helloClient;

    public DemoController(HelloClient helloClient) {
        this.helloClient = helloClient;
    }

    @GetMapping("/feign")
    public String demo() {
        return helloClient.hello();
    }
}
