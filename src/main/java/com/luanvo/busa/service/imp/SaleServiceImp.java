package com.luanvo.busa.service.imp;

import com.luanvo.busa.io.resquest.GetListProductSaleRequest;
import com.luanvo.busa.service.SaleService;
import com.luanvo.busa.utils.ErrorContent;
import com.luanvo.busa.utils.Response;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class SaleServiceImp implements SaleService {
    @Override
    public JSONObject getListProduct(GetListProductSaleRequest request) {
        try{

            return Response.success();
        }catch (Exception e){
            e.printStackTrace();
            return Response.error(ErrorContent.ERROR.getMsg());
        }
    }
}
