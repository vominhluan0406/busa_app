package com.luanvo.busa.service.imp;

import com.luanvo.busa.io.resquest.GetInfoAddressRequest;
import com.luanvo.busa.repository.CitiesRepository;
import com.luanvo.busa.service.AddressService;
import com.luanvo.busa.utils.ErrorContent;
import com.luanvo.busa.utils.Response;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImp implements AddressService {

    @Autowired
    CitiesRepository citiesRepository;

    @Override
    public JSONObject getAddressInfo(GetInfoAddressRequest request) {
        try{
            JSONObject data = citiesRepository.getInfoAddress(request.getId(), request.getType());
            if(data == null){
                return Response.error(ErrorContent.ERROR.getMsg());
            }

            JSONObject response = new JSONObject();
            response.put(Response.DATA,data);
            return Response.success(response);
        }catch (Exception e){
            e.printStackTrace();
            return Response.error(ErrorContent.ERROR.getMsg());
        }
    }

    @Override
    public JSONObject getListAddressInfo(GetInfoAddressRequest request) {
        try{
            List<JSONObject> data = citiesRepository.getListInfoAddress(request.getId(), request.getType());
            if(data == null){
                return Response.error(ErrorContent.ERROR.getMsg());
            }

            JSONObject response = new JSONObject();
            response.put(Response.DATA,data);
            return Response.success(response);
        }catch (Exception e){
            e.printStackTrace();
            return Response.error(ErrorContent.ERROR.getMsg());
        }
    }
}
