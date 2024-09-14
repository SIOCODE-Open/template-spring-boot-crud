package com.example.backend.service;

import com.example.backend.dto.ManufacturerDto;
import com.example.backend.dto.NewManufacturerDto;
import java.util.List;

/**
 * Provides CRUD (Create-Read-Update-Delete) operations for Manufacturer entities.
 */
public interface ManufacturerCRUDService {
    /**
     * Lists all Manufacturer entities.
     *
     * @return A list of all Manufacturer entities.
     */
    List<ManufacturerDto> listAll();

    /**
     * Retrieves a single Manufacturer entity by its unique identifier.
     *
     * @param id The unique identifier for the Manufacturer entity.
     * @return The Manufacturer entity with the given unique identifier, or null if none exists.
     */
    ManufacturerDto getById(String id);

    /**
     * Creates a new Manufacturer entity.
     *
     * @param newDto The data for the new Manufacturer entity.
     * @return The newly created Manufacturer entity.
     */
    ManufacturerDto create(NewManufacturerDto newDto);

    /**
     * Updates the name attribute of a Name entity.
     *
     * @param id The unique identifier for the Name entity.
     * @param newValue The new value for the name attribute.
     * @return The updated Name entity.
     */
    void updateName(String id, java.lang.String newValue);

    /**
     * Clears the name attribute of a Name entity, setting it to null.
     *
     * @param id The unique identifier for the Name entity.
     */
    void clearName(String id);
    /**
     * Updates the description attribute of a Description entity.
     *
     * @param id The unique identifier for the Description entity.
     * @param newValue The new value for the description attribute.
     * @return The updated Description entity.
     */
    void updateDescription(String id, java.lang.String newValue);

    /**
     * Clears the description attribute of a Description entity, setting it to null.
     *
     * @param id The unique identifier for the Description entity.
     */
    void clearDescription(String id);
    /**
     * Updates the website attribute of a Website entity.
     *
     * @param id The unique identifier for the Website entity.
     * @param newValue The new value for the website attribute.
     * @return The updated Website entity.
     */
    void updateWebsite(String id, java.lang.String newValue);

    /**
     * Clears the website attribute of a Website entity, setting it to null.
     *
     * @param id The unique identifier for the Website entity.
     */
    void clearWebsite(String id);

    /**
     * Deletes a Manufacturer entity by its unique identifier.
     *
     * @param id The unique identifier for the Manufacturer entity.
     */
    void deleteById(String id);
}
