package com.example.backend.repository;

import com.example.backend.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * A product in the system
 */
@Repository
public interface ProductRepository
    extends
        JpaRepository<ProductEntity, String>,
        JpaSpecificationExecutor<ProductEntity> {}
