package com.example.backend.dto;

import lombok.*;

/**
 * A product in the system
 */
@Data
public class ProductDto {

    /**
     * The unique identifier for the Product
     */
    private String id;
    /**
     * The name of the product
     */
    private java.lang.String name;
    /**
     * The description of the product, supports Markdown
     */
    private java.lang.String description;
    /**
     * The manufacturer of the product
     */
    private String manufacturerId;
}
