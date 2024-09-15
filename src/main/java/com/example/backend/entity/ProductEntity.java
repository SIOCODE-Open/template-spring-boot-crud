package com.example.backend.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * A product in the system
 */
@Entity
@Table(name = "\"product\"")
@Data
public class ProductEntity {
    /**
     * The unique identifier for the Product
     */
    @Id
    @Column(name = "product_id", nullable = false)
    private String id;

    /**
     * The name of the product
     */
    @Column(name = "\"name\"", nullable = true, insertable = true, updatable = true)
    private java.lang.String name;
    /**
     * The description of the product, supports Markdown
     */
    @Column(name = "\"description\"", nullable = true, insertable = true, updatable = true)
    private java.lang.String description;
    /**
     * The manufacturer of the product
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "manufacturer_id", nullable = true, insertable = true, updatable = true)
    private ManufacturerEntity manufacturer;
}