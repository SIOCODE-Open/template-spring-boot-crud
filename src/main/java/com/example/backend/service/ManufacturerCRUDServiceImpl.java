package com.example.backend.service;

import com.example.backend.dto.ManufacturerDto;
import com.example.backend.dto.NewManufacturerDto;
import com.example.backend.dto.convert.ManufacturerEntityToDto;
import com.example.backend.entity.*;
import com.example.backend.repository.*;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of the CRUD service for Manufacturer entities.
 */
@Service
@Transactional
public class ManufacturerCRUDServiceImpl implements ManufacturerCRUDService {

    @Autowired
    private ManufacturerRepository repository;

    private final ManufacturerEntityToDto entityToDto =
        new ManufacturerEntityToDto();

    @Override
    public List<ManufacturerDto> listAll() {
        return repository
            .findAll()
            .stream()
            .map(entityToDto::convert)
            .collect(Collectors.toList());
    }

    @Override
    public ManufacturerDto getById(String id) {
        return repository.findById(id).map(entityToDto::convert).orElse(null);
    }

    @Override
    public ManufacturerDto create(NewManufacturerDto newDto) {
        final ManufacturerEntity entity = new ManufacturerEntity();
        entity.setId(UUID.randomUUID().toString());
        entity.setName(newDto.getName());
        entity.setDescription(newDto.getDescription());
        entity.setWebsite(newDto.getWebsite());
        return entityToDto.convert(repository.save(entity));
    }

    @Override
    public void updateName(String id, java.lang.String newValue) {
        final ManufacturerEntity entity = repository
            .findById(id)
            .orElseThrow(() ->
                new IllegalArgumentException("No Name entity with id " + id)
            );
        entity.setName(newValue);
        repository.save(entity);
    }

    @Override
    public void clearName(String id) {
        final ManufacturerEntity entity = repository
            .findById(id)
            .orElseThrow(() ->
                new IllegalArgumentException("No Name entity with id " + id)
            );
        entity.setName(null);
        repository.save(entity);
    }

    @Override
    public void updateDescription(String id, java.lang.String newValue) {
        final ManufacturerEntity entity = repository
            .findById(id)
            .orElseThrow(() ->
                new IllegalArgumentException(
                    "No Description entity with id " + id
                )
            );
        entity.setDescription(newValue);
        repository.save(entity);
    }

    @Override
    public void clearDescription(String id) {
        final ManufacturerEntity entity = repository
            .findById(id)
            .orElseThrow(() ->
                new IllegalArgumentException(
                    "No Description entity with id " + id
                )
            );
        entity.setDescription(null);
        repository.save(entity);
    }

    @Override
    public void updateWebsite(String id, java.lang.String newValue) {
        final ManufacturerEntity entity = repository
            .findById(id)
            .orElseThrow(() ->
                new IllegalArgumentException("No Website entity with id " + id)
            );
        entity.setWebsite(newValue);
        repository.save(entity);
    }

    @Override
    public void clearWebsite(String id) {
        final ManufacturerEntity entity = repository
            .findById(id)
            .orElseThrow(() ->
                new IllegalArgumentException("No Website entity with id " + id)
            );
        entity.setWebsite(null);
        repository.save(entity);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
