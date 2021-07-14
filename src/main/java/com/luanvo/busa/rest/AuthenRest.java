package com.luanvo.busa.rest;

import com.luanvo.busa.io.resquest.LoginRequest;
import com.luanvo.busa.io.values.UserJWT;
import com.luanvo.busa.utils.JWTUtils;
import com.luanvo.busa.utils.Response;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authen")
public class AuthenRest {

    private static final Logger log = LoggerFactory.getLogger(AuthenRest.class);

    @Autowired
    JWTUtils jwtUtils;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public JSONObject login(@RequestBody LoginRequest request){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateToken((UserJWT) authentication.getPrincipal());
        JSONObject data = new JSONObject();
        data.put("token",jwt);
        return Response.success(data);
    }
}
