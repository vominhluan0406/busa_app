package com.luanvo.busa.service;

import com.luanvo.busa.io.resquest.LoginRequest;
import org.json.simple.JSONObject;

public interface AuthenService {
    JSONObject login(LoginRequest request);
}
