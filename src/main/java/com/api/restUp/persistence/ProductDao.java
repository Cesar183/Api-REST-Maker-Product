package com.api.restUp.persistence;

import com.api.restUp.entities.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductDao {
    List<Product> listAll();
    List<Product> findPriceInRange(BigDecimal minPrice, BigDecimal maxPrice);
    Optional<Product> findById(Long id);
    Product save(Product product);
    void delete(Long id);
}
