package com.luanvo.busa.io.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "products")
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
}
