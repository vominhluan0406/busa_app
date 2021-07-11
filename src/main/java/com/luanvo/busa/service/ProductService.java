package com.luanvo.busa.service;

import com.luanvo.busa.io.resquest.GetAllProductRequest;
import org.json.simple.JSONObject;

public interface ProductService {
    JSONObject getList(GetAllProductRequest request);
}
