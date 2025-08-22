package com.api.restUp.persistence;

import com.api.restUp.entities.Maker;

import java.util.List;
import java.util.Optional;

public interface MakerDao {
    List<Maker> listAll();
    Optional<Maker> findById(Long id);
    Maker save(Maker maker);
    void delete(Long id);
}
