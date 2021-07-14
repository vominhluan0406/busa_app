package com.luanvo.busa.io.entity;

import com.luanvo.busa.io.resquest.AddNewProductRequest;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "products")
@NoArgsConstructor
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "city_id")
    private int city_id;

    @Column(name = "district_id")
    private int district_id;

    @Column(name = "ward_id")
    private int ward_id;

    @Column(name = "type")
    private int type;

    @Column(name = "price")
    private double price;

    @Column(name = "price_min")
    private double price_min;

    @Column(name = "price_max")
    private double price_max;

    @Column(name = "categories_id")
    private int categories_id;

    @Column(name = "categories_child_id")
    private int categories_child_id;

    @Column(name = "thumb_img")
    private String thumb_img;

    @Column(name = "create_at")
    private Date create_date;

    public static ProductEntity addNew(AddNewProductRequest request){
        ProductEntity productEntity = new ProductEntity();
        productEntity.setCategories_child_id(request.getCategories_child_id());
        productEntity.setCategories_id(request.getCategories_id());
        productEntity.setCity_id(request.getCity_id());
        productEntity.setDescription(request.getDescription());
        productEntity.setDistrict_id(request.getDistrict_id());
        productEntity.setWard_id(request.getWard_id());
        productEntity.setName(request.getName());
        productEntity.setPrice(request.getPrice());
        productEntity.setPrice_max(request.getPrice_max());
        productEntity.setPrice_min(request.getPrice_min());
        productEntity.setThumb_img(request.getThumb_images());
        productEntity.setType(request.getType());
        productEntity.setCreate_date(new Date());
        return productEntity;
    }
}
