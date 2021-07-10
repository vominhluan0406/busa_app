package com.luanvo.busa.repository;

import com.luanvo.busa.io.entity.AddressEntity;
import org.json.simple.JSONObject;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends MongoRepository<AddressEntity, String> {

    @Query(value = "{\"id\" : '?0'}")
    JSONObject getByIds( String id);
}
