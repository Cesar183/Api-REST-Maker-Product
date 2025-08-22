package com.api.restUp.controllers.dto;

import com.api.restUp.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MakerDto {
    private Long id;
    private String name;
    private List<Product> productList = new ArrayList<>();
}
