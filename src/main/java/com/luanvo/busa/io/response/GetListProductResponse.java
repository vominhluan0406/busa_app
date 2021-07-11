package com.luanvo.busa.io.response;

import com.luanvo.busa.io.entity.ProductEntity;
import lombok.Data;

@Data
public class GetListProductResponse {
    private int id;
    private String name;
    private String image;
    private double price;

    public GetListProductResponse(ProductEntity p){
        this.id = p.getId();
        this.name = p.getName();
        this.image = p.getDescription();
        this.price = p.getPrice();
    }
}
