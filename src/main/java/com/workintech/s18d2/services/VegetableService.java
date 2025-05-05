package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Vegetable;

import java.util.List;

public interface VegetableService {
    List<Vegetable> getAll();
    List<Vegetable> getByPriceDesc();
    List<Vegetable> getByPriceAsc();
    Vegetable getById(Long id);
    Vegetable save(Vegetable vegetable);
    Vegetable delete(Long id);
    List<Vegetable> searchByName(String name);
} 