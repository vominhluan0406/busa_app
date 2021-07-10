package com.luanvo.busa.io.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cities")
public class CitiesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;
}
