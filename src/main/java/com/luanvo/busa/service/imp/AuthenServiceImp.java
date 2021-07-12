package com.luanvo.busa.service.imp;

import com.luanvo.busa.io.resquest.LoginRequest;
import com.luanvo.busa.io.values.UserJWT;
import com.luanvo.busa.service.AuthenService;
import com.luanvo.busa.utils.ErrorContent;
import com.luanvo.busa.utils.JWTUtils;
import com.luanvo.busa.utils.Response;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthenServiceImp implements AuthenService {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JWTUtils jwtUtils;


    @Override
    public JSONObject login(LoginRequest request) {
        try{
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtUtils.generateToken((UserJWT) authentication.getPrincipal());

            JSONObject response = new JSONObject();
            response.put(Response.DATA,jwt);
            return Response.success(response);
        }catch (Exception e){
            e.printStackTrace();
            return Response.error(ErrorContent.ERROR.getMsg());
        }
    }


}
