package com.api.restUp.controllers;

import com.api.restUp.controllers.dto.ProductDto;
import com.api.restUp.entities.Product;
import com.api.restUp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping(path = "product")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listAll()
                .stream()
                .map(product -> ProductDto.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .price(product.getPrice())
                        .maker(product.getMaker())
                        .build())
                .toList());
    }

    @GetMapping("/range")
    public ResponseEntity<?> findByRangePrice(@RequestParam BigDecimal min, @RequestParam BigDecimal max){
        return ResponseEntity.status(HttpStatus.OK).body(service.findPriceInRange(min, max)
                .stream()
                .map(product -> ProductDto.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .price(product.getPrice())
                        .maker(product.getMaker())
                        .build())
                .toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return service.findById(id)
                .map(product -> ResponseEntity.status(HttpStatus.OK).body(ProductDto.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .price(product.getPrice())
                        .maker(product.getMaker())
                        .build()))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ProductDto productDto){
        if(productDto.getName().isBlank()){
            ResponseEntity.badRequest().build();
        }
        var product = service.save(Product.builder()
                        .id(productDto.getId())
                        .name(productDto.getName())
                        .price(productDto.getPrice())
                        .maker(productDto.getMaker())
                        .build());
        return ResponseEntity.status(HttpStatus.CREATED).body(ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .maker(product.getMaker())
                .build());
    }


}
