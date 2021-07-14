package com.luanvo.busa.io.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "images_product")
@NoArgsConstructor
public class ImagesProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "product_id")
    private int product_id;

    @Column(name = "value")
    private String value;

    @Column(name = "create_at")
    private Date create_at;
}
