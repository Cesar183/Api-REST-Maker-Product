package com.api.restUp.service.impl;

import com.api.restUp.entities.Product;
import com.api.restUp.persistence.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements com.api.restUp.service.ProductService {

    @Autowired
    private ProductDao dao;

    @Override
    public List<Product> listAll() {
        return dao.listAll();
    }

    @Override
    public List<Product> findPriceInRange(BigDecimal minPrice, BigDecimal maxPrice) {
        return dao.findPriceInRange(minPrice, maxPrice);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public Product save(Product product) {
        return dao.save(product);
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }
}
