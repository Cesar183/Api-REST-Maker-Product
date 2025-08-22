package com.api.restUp.service;

import com.api.restUp.entities.Maker;

import java.util.List;
import java.util.Optional;

public interface MakerService {
    List<Maker> listAll();
    Optional<Maker> findById(Long id);
    Maker save(Maker maker);
    void delete(Long id);
}
