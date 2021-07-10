package com.luanvo.busa.repository;

import com.luanvo.busa.io.entity.CitiesEntity;
import org.json.simple.JSONObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitiesRepository extends JpaRepository<CitiesEntity,Integer> {

    @Query(value = "SELECT id,name FROM `cities` WHERE id = :id AND 1 = :type\n" +
            "UNION\n" +
            "SELECT id,name FROM `districts` WHERE id = :id AND 2 = :type\n" +
            "UNION\n" +
            "SELECT id,name FROM `wards` WHERE id = :id AND 3 = :type",nativeQuery = true)
    JSONObject getInfoAddress(@Param("id") int id, @Param("type") int type);

    @Query(value = "SELECT id,name FROM `cities` WHERE  1 = :type\n" +
            "UNION\n" +
            "SELECT id,name FROM `districts` WHERE city_id = :id AND 2 = :type\n" +
            "UNION\n" +
            "SELECT id,name FROM `wards` WHERE district_id = :id AND 3 = :type",nativeQuery = true)
    List<JSONObject> getListInfoAddress(int id, int type);
}
