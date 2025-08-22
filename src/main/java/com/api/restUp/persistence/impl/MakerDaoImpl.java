package com.api.restUp.persistence.impl;

import com.api.restUp.entities.Maker;
import com.api.restUp.persistence.MakerDao;
import com.api.restUp.repositories.MakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MakerDaoImpl implements MakerDao {

    @Autowired
    private MakerRepository repository;

    @Override
    public List<Maker> listAll() {
        return (List<Maker>) repository.findAll();
    }

    @Override
    public Optional<Maker> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Maker save(Maker maker) {
        return repository.save(maker);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
