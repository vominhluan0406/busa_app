package com.luanvo.busa.io.resquest;

import lombok.Data;

import java.util.List;

@Data
public class AddNewProductRequest {
    private String name;
    private String description;
    private int city_id;
    private int district_id;
    private int ward_id;
    private int categories_id;
    private int categories_child_id;
    private double price;
    private int type;
    private double price_max;
    private double price_min;
    private String thumb_images;
    private List<String> images;
}
