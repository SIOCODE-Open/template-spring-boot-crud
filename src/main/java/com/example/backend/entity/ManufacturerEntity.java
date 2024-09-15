package com.example.backend.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * A manufacturer of products
 */
@Entity
@Table(name = "\"manufacturer\"")
@Data
public class ManufacturerEntity {
    /**
     * The unique identifier for the Manufacturer
     */
    @Id
    @Column(name = "manufacturer_id", nullable = false)
    private String id;

    /**
     * The name of the manufacturer
     */
    @Column(name = "\"name\"", nullable = true, insertable = true, updatable = true)
    private java.lang.String name;
    /**
     * The description of the manufacturer, supports Markdown
     */
    @Column(name = "\"description\"", nullable = true, insertable = true, updatable = true)
    private java.lang.String description;
    /**
     * The URL of the manufacturer's website
     */
    @Column(name = "\"website\"", nullable = true, insertable = true, updatable = true)
    private java.lang.String website;
}