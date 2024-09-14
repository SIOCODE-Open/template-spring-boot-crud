package com.example.backend.repository;

import com.example.backend.entity.ManufacturerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * A manufacturer of products
 */
@Repository
public interface ManufacturerRepository
    extends
        JpaRepository<ManufacturerEntity, String>,
        JpaSpecificationExecutor<ManufacturerEntity> {}
