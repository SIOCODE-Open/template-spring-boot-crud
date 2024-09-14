package com.example.backend.controller;

import com.example.backend.dto.NewProductDto;
import com.example.backend.dto.ProductDto;
import com.example.backend.service.ProductCRUDService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/backend/v1/product")
public class ProductCRUDController {

    @Autowired
    private ProductCRUDService service;

    @GetMapping
    public List<ProductDto> listAll() {
        return service.listAll();
    }

    @GetMapping("{id}")
    public ProductDto getById(@PathVariable String id) {
        return service.getById(id);
    }

    @PostMapping
    public ProductDto create(@RequestBody NewProductDto newDto) {
        return service.create(newDto);
    }

    @PostMapping(
        value = "{id}/name",
        consumes = "application/json",
        produces = "application/json"
    )
    public void updateName(@PathVariable String id, @RequestBody Object value) {
        final java.lang.String name = (java.lang.String) value;
        service.updateName(id, name);
    }

    @DeleteMapping("{id}/name")
    public void clearName(
        @PathVariable String id,
        @RequestBody java.lang.String name
    ) {
        service.clearName(id);
    }

    @PostMapping(
        value = "{id}/description",
        consumes = "application/json",
        produces = "application/json"
    )
    public void updateDescription(
        @PathVariable String id,
        @RequestBody Object value
    ) {
        final java.lang.String description = (java.lang.String) value;
        service.updateDescription(id, description);
    }

    @DeleteMapping("{id}/description")
    public void clearDescription(
        @PathVariable String id,
        @RequestBody java.lang.String description
    ) {
        service.clearDescription(id);
    }

    @PostMapping(
        value = "{id}/manufacturer",
        consumes = "application/json",
        produces = "application/json"
    )
    public void updateManufacturer(
        @PathVariable String id,
        @RequestBody Object value
    ) {
        final String manufacturerId = (String) value;
        service.updateManufacturer(id, manufacturerId);
    }

    @DeleteMapping("{id}/manufacturer")
    public void clearManufacturer(@PathVariable String id) {
        service.clearManufacturer(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        service.deleteById(id);
    }
}
