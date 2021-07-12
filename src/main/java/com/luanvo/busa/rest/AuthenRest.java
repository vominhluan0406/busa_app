package com.luanvo.busa.rest;

import com.luanvo.busa.io.resquest.LoginRequest;
import com.luanvo.busa.service.AuthenService;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authen")
public class AuthenRest {

    private static final Logger log = LoggerFactory.getLogger(AuthenRest.class);

    @Autowired
    AuthenService authenService;

    @PostMapping("/login")
    public JSONObject login(@RequestBody LoginRequest request){
        log.info("/authen/login");
        return authenService.login(request);
    }
}
