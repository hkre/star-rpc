package com.star.controller;

import com.star.api.IUserService;

import com.star.spring.annotation.GpRemoteReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2082233439
 * http://www.gupaoedu.com
 **/
@RestController
public class HelloController {

    @GpRemoteReference
    private IUserService userService;


    @GetMapping("/test")
    public String test(){
        return userService.saveUser("Mic22222");
    }


}
