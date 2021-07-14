package com.luanvo.busa.repository;

import com.luanvo.busa.io.entity.ImagesProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagesProductRepository extends JpaRepository<ImagesProductEntity, Integer> {
}
