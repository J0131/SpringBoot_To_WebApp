package com.nongshim.nds.springboot.web;

import com.nongshim.nds.springboot.web.Dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String Hello(){
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto (@RequestParam("name") String name,
                                      @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }
}
