package com.workintech.s18d2.services;

import com.workintech.s18d2.repository.VegetableRepository;
import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.exceptions.PlantException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class VegetableServiceImpl implements VegetableService {

    private final VegetableRepository vegetableRepository;

    @Autowired
    public VegetableServiceImpl(VegetableRepository vegetableRepository) {
        this.vegetableRepository = vegetableRepository;
    }

    @Override
    public List<Vegetable> getAll() {
        return vegetableRepository.findAll();
    }

    @Override
    public List<Vegetable> getByPriceDesc() {
        return vegetableRepository.getByPriceDesc();
    }

    @Override
    public List<Vegetable> getByPriceAsc() {
        return vegetableRepository.getByPriceAsc();
    }

    @Override
    public Vegetable getById(Long id) {
        if (id < 0) {
            log.error("Invalid ID: " + id);
            throw new PlantException("ID cannot be negative");
        }
        return vegetableRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Vegetable not found with ID: " + id);
                    return new PlantException("Vegetable not found with ID: " + id);
                });
    }

    @Override
    public Vegetable save(Vegetable vegetable) {
        if (vegetable.getName() == null || vegetable.getPrice() == null) {
            log.error("Incomplete vegetable data");
            throw new PlantException("All vegetable fields must be filled");
        }
        return vegetableRepository.save(vegetable);
    }

    @Override
    public Vegetable delete(Long id) {
        Vegetable vegetable = getById(id);
        vegetableRepository.delete(vegetable);
        return vegetable;
    }

    @Override
    public List<Vegetable> searchByName(String name) {
        return vegetableRepository.searchByName(name);
    }
} 