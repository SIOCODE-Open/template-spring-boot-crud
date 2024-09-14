package com.example.backend.service;

import com.example.backend.dto.NewProductDto;
import com.example.backend.dto.ProductDto;
import com.example.backend.dto.convert.ProductEntityToDto;
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
 * Implementation of the CRUD service for Product entities.
 */
@Service
@Transactional
public class ProductCRUDServiceImpl implements ProductCRUDService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    private final ProductEntityToDto entityToDto = new ProductEntityToDto();

    @Override
    public List<ProductDto> listAll() {
        return repository
            .findAll()
            .stream()
            .map(entityToDto::convert)
            .collect(Collectors.toList());
    }

    @Override
    public ProductDto getById(String id) {
        return repository.findById(id).map(entityToDto::convert).orElse(null);
    }

    @Override
    public ProductDto create(NewProductDto newDto) {
        final ProductEntity entity = new ProductEntity();
        entity.setId(UUID.randomUUID().toString());
        entity.setName(newDto.getName());
        entity.setDescription(newDto.getDescription());
        if (newDto.getManufacturerId() != null) {
            entity.setManufacturer(
                manufacturerRepository
                    .findById(newDto.getManufacturerId())
                    .orElse(null)
            );
        } else {
            entity.setManufacturer(null);
        }
        return entityToDto.convert(repository.save(entity));
    }

    @Override
    public void updateName(String id, java.lang.String newValue) {
        final ProductEntity entity = repository
            .findById(id)
            .orElseThrow(() ->
                new IllegalArgumentException("No Name entity with id " + id)
            );
        entity.setName(newValue);
        repository.save(entity);
    }

    @Override
    public void clearName(String id) {
        final ProductEntity entity = repository
            .findById(id)
            .orElseThrow(() ->
                new IllegalArgumentException("No Name entity with id " + id)
            );
        entity.setName(null);
        repository.save(entity);
    }

    @Override
    public void updateDescription(String id, java.lang.String newValue) {
        final ProductEntity entity = repository
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
        final ProductEntity entity = repository
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
    public void updateManufacturer(String id, String newId) {
        final ProductEntity entity = repository
            .findById(id)
            .orElseThrow(() ->
                new IllegalArgumentException(
                    "No Manufacturer entity with id " + id
                )
            );
        if (newId != null) {
            entity.setManufacturer(
                manufacturerRepository.findById(newId).orElse(null)
            );
        } else {
            entity.setManufacturer(null);
        }
        repository.save(entity);
    }

    @Override
    public void clearManufacturer(String id) {
        final ProductEntity entity = repository
            .findById(id)
            .orElseThrow(() ->
                new IllegalArgumentException(
                    "No Manufacturer entity with id " + id
                )
            );
        entity.setManufacturer(null);
        repository.save(entity);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
