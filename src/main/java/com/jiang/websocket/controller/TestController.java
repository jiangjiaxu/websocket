package com.jiang.websocket.controller;

import com.jiang.websocket.annotation.SysLog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @SysLog("测试")
    @GetMapping("/test")
    public String test(@RequestParam("name") String name){
        return name;
    }
}
