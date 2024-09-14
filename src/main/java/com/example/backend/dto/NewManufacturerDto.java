package com.example.backend.dto;

import lombok.*;

/**
 * A manufacturer of products
 */
@Data
public class NewManufacturerDto {

    /**
     * The name of the manufacturer
     */
    private java.lang.String name;
    /**
     * The description of the manufacturer, supports Markdown
     */
    private java.lang.String description;
    /**
     * The URL of the manufacturer's website
     */
    private java.lang.String website;
}
