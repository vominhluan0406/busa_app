package com.luanvo.busa.service;

import com.luanvo.busa.io.resquest.GetListProductSaleRequest;
import org.json.simple.JSONObject;

public interface SaleService {
    JSONObject getListProduct(GetListProductSaleRequest request);
}
