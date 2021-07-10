package com.luanvo.busa.rest;

import com.luanvo.busa.io.entity.AddressEntity;
import com.luanvo.busa.io.resquest.GetInfoAddressRequest;
import com.luanvo.busa.repository.AddressRepository;
import com.luanvo.busa.service.AddressService;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/info")
public class InfoRest {

    private static Logger log = LoggerFactory.getLogger(InfoRest.class);


    @Autowired
    AddressService addressService;

    @GetMapping("/address")
    public JSONObject getInfoAddress(GetInfoAddressRequest request) {
        log.info("GET /info/address?" + request);
        return addressService.getAddressInfo(request);
    }

    @GetMapping("/address_list")
    public JSONObject getListInfoAddress(GetInfoAddressRequest request) {
        log.info("GET /info/address?" + request);
        return addressService.getListAddressInfo(request);
    }
}
