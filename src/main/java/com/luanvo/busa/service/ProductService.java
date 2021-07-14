package com.luanvo.busa.service;

import com.luanvo.busa.io.resquest.AddNewProductRequest;
import com.luanvo.busa.io.resquest.GetAllProductRequest;
import org.json.simple.JSONObject;

public interface ProductService {
    JSONObject getList(GetAllProductRequest request);

    JSONObject getDetail(int id);

    JSONObject addNew(AddNewProductRequest request);
}
