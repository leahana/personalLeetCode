package top.yannyi.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "demo-service")
public interface HelloClient {

    @GetMapping("/token")
    String getToken();

    @GetMapping("/hello")
    String hello();
}
