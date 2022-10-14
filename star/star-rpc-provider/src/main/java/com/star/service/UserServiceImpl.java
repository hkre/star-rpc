package com.star.service;


import com.star.api.IUserService;
import com.star.spring.spring.annotation.GpRemoteService;
import lombok.extern.slf4j.Slf4j;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2082233439
 * http://www.gupaoedu.com
 **/
@GpRemoteService //表示讲当前服务发布成远程服务
@Slf4j
public class UserServiceImpl implements IUserService {
    @Override
    public String saveUser(String name) {
        log.info("begin saveUser:"+name);
        return "Save User Success!";
    }
}
