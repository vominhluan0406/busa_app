package com.luanvo.busa.io.resquest;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetAllProductRequest {
    private int page;
    private String search;
    private int city_id;
    private int district_id;
    private int type;
    private double price_max;
    private double price_min;

    public GetAllProductRequest(){
        this.search = "";
    }
}
