package com.luanvo.busa.service;

import com.luanvo.busa.io.resquest.GetInfoAddressRequest;
import org.json.simple.JSONObject;

public interface AddressService {
    JSONObject getAddressInfo(GetInfoAddressRequest request);

    JSONObject getListAddressInfo(GetInfoAddressRequest request);
}
