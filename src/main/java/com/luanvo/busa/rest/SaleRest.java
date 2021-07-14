package com.luanvo.busa.rest;

import com.luanvo.busa.io.resquest.GetListProductSaleRequest;
import com.luanvo.busa.service.SaleService;
import lombok.Data;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sale")
public class SaleRest {

    private static final Logger logger = LoggerFactory.getLogger(SaleRest.class);

    @Autowired
    SaleService saleService;

    @GetMapping("/list_product")
    public JSONObject getListProduct(GetListProductSaleRequest request) {
        logger.info("/sale/list_product " + request);
        return saleService.getListProduct(request);
    }
}
