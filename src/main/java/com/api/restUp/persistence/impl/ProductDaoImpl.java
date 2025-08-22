package com.api.restUp.persistence.impl;

import com.api.restUp.entities.Product;
import com.api.restUp.persistence.ProductDao;
import com.api.restUp.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Component
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private ProductRepository repository;

    @Override
    public List<Product> listAll() {
        return (List<Product>) repository.findAll();
    }

    @Override
    public List<Product> findPriceInRange(BigDecimal minPrice, BigDecimal maxPrice) {
        return repository.findPriceInRange(minPrice, maxPrice);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Product save(Product product) {
        return repository.save(product);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
