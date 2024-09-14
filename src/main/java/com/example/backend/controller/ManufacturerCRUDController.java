package com.example.backend.controller;

import com.example.backend.dto.ManufacturerDto;
import com.example.backend.dto.NewManufacturerDto;
import com.example.backend.service.ManufacturerCRUDService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/backend/v1/manufacturer")
public class ManufacturerCRUDController {

    @Autowired
    private ManufacturerCRUDService service;

    @GetMapping
    public List<ManufacturerDto> listAll() {
        return service.listAll();
    }

    @GetMapping("{id}")
    public ManufacturerDto getById(@PathVariable String id) {
        return service.getById(id);
    }

    @PostMapping
    public ManufacturerDto create(@RequestBody NewManufacturerDto newDto) {
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
        value = "{id}/website",
        consumes = "application/json",
        produces = "application/json"
    )
    public void updateWebsite(
        @PathVariable String id,
        @RequestBody Object value
    ) {
        final java.lang.String website = (java.lang.String) value;
        service.updateWebsite(id, website);
    }

    @DeleteMapping("{id}/website")
    public void clearWebsite(
        @PathVariable String id,
        @RequestBody java.lang.String website
    ) {
        service.clearWebsite(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        service.deleteById(id);
    }
}
