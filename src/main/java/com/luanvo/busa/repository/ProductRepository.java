package com.luanvo.busa.repository;

import com.luanvo.busa.io.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

    @Query(value = "SELECT * FROM products \n" +
            "WHERE `name` like CONCAT('%',CONVERT(:search,BINARY),'%')\n" +
            "AND price >= :min AND ( price <= :max OR 0 = 0)\n" +
            "AND ( city_id = :city_id OR 0 = 0)",
            countQuery = "SELECT COUNT(*) FROM products \n" +
                    "WHERE `name` like CONCAT('%',CONVERT(:search,BINARY),'%')\n" +
                    "AND price >= :min AND ( price <= :max OR 0 = 0)\n" +
                    "AND ( city_id = :city_id OR 0 = 0)", nativeQuery = true)
    Page<ProductEntity> findByFilter(@Param("search") String search, @Param("min") double min, @Param("max") double max,
                                     @Param("city_id") int city_id, Pageable pageable);
}
