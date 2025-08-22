package com.api.restUp.service.impl;

import com.api.restUp.entities.Maker;
import com.api.restUp.persistence.MakerDao;
import com.api.restUp.service.MakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MakerServiceImpl implements MakerService {

    @Autowired
    private MakerDao dao;

    @Override
    public List<Maker> listAll() {
        return dao.listAll();
    }

    @Override
    public Optional<Maker> findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public Maker save(Maker maker) {
        return dao.save(maker);
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }
}
