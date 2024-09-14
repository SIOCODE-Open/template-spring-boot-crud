package com.example.backend.service;

import com.example.backend.dto.NewProductDto;
import com.example.backend.dto.ProductDto;
import java.util.List;

/**
 * Provides CRUD (Create-Read-Update-Delete) operations for Product entities.
 */
public interface ProductCRUDService {
    /**
     * Lists all Product entities.
     *
     * @return A list of all Product entities.
     */
    List<ProductDto> listAll();

    /**
     * Retrieves a single Product entity by its unique identifier.
     *
     * @param id The unique identifier for the Product entity.
     * @return The Product entity with the given unique identifier, or null if none exists.
     */
    ProductDto getById(String id);

    /**
     * Creates a new Product entity.
     *
     * @param newDto The data for the new Product entity.
     * @return The newly created Product entity.
     */
    ProductDto create(NewProductDto newDto);

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
     * Updates the manufacturer association of a Manufacturer entity.
     *
     * @param id The unique identifier for the Manufacturer entity.
     * @param newId The unique identifier for the new manufacturer entity.
     * @return The updated Manufacturer entity.
     */
    void updateManufacturer(String id, String newId);

    /**
     * Clears the manufacturer association of a Manufacturer entity, setting it to null.
     *
     * @param id The unique identifier for the Manufacturer entity.
     */
    void clearManufacturer(String id);

    /**
     * Deletes a Product entity by its unique identifier.
     *
     * @param id The unique identifier for the Product entity.
     */
    void deleteById(String id);
}
