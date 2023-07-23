package com.jwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    @RequestMapping("/welcome")
    public String welcome(){
        String text="this is a private page";
        text+="this page is not allowed to unauthenticated users";
        return text;
    }
}
