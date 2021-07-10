package com.luanvo.busa.io.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "cities")
public class AddressEntity {

    @Id
    private String _id;

    @Field(name = "id")
    private String id;

    @Field(name = "name")
    private String name;
}
