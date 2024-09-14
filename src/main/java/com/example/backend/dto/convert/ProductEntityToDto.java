package com.example.backend.dto.convert;

import com.example.backend.dto.ProductDto;
import com.example.backend.entity.ProductEntity;

/**
 * Converts a ProductEntity to a ProductDto
 */
public class ProductEntityToDto {

    /**
     * Converts a ProductEntity to a ProductDto
     *
     * @param entity the entity to convert
     * @return the converted dto
     */
    public ProductDto convert(ProductEntity entity) {
        ProductDto dto = new ProductDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        if (entity.getManufacturer() != null) {
            dto.setManufacturerId(entity.getManufacturer().getId());
        } else {
            dto.setManufacturerId(null);
        }
        return dto;
    }
}
