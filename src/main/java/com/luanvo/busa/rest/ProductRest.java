package com.luanvo.busa.rest;

import com.luanvo.busa.io.resquest.GetAllProductRequest;
import com.luanvo.busa.service.ProductService;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductRest {

    private static final Logger log = LoggerFactory.getLogger(ProductRest.class);

    @Autowired
    ProductService productService;

    @GetMapping("/get_list")
    public JSONObject getList(GetAllProductRequest request) {
        log.info("GET /product/get_list" + request);
        return productService.getList(request);
    }


}
