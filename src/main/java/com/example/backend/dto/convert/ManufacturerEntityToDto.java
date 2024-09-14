package com.example.backend.dto.convert;

import com.example.backend.dto.ManufacturerDto;
import com.example.backend.entity.ManufacturerEntity;

/**
 * Converts a ManufacturerEntity to a ManufacturerDto
 */
public class ManufacturerEntityToDto {

    /**
     * Converts a ManufacturerEntity to a ManufacturerDto
     *
     * @param entity the entity to convert
     * @return the converted dto
     */
    public ManufacturerDto convert(ManufacturerEntity entity) {
        ManufacturerDto dto = new ManufacturerDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setWebsite(entity.getWebsite());
        return dto;
    }
}
