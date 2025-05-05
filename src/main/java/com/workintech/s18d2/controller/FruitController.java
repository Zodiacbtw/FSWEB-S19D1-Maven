package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.exceptions.SuccessResponse;
import com.workintech.s18d2.services.FruitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class FruitController {
    
    private final FruitService fruitService;
    
    @Autowired
    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }
    
    @GetMapping("/fruit")
    public List<Fruit> getAllFruits() {
        return fruitService.getByPriceAsc();
    }
    
    @GetMapping("/fruit/{id}")
    public Fruit getFruitById(@PathVariable Long id) {
        return fruitService.getById(id);
    }
    
    @GetMapping("/fruit/desc")
    public List<Fruit> getAllFruitsDesc() {
        return fruitService.getByPriceDesc();
    }
    
    @PostMapping("/fruit")
    public SuccessResponse<Fruit> saveFruit(@RequestBody Fruit fruit) {
        Fruit savedFruit = fruitService.save(fruit);
        return new SuccessResponse<>(savedFruit, "Fruit successfully saved");
    }
    
    @GetMapping("/fruit/name/{name}")
    public List<Fruit> searchFruitsByName(@PathVariable String name) {
        return fruitService.searchByName(name);
    }
    
    @DeleteMapping("/fruit/{id}")
    public Fruit deleteFruit(@PathVariable Long id) {
        return fruitService.delete(id);
    }

    // Also keep the endpoints with prefix as specified in the requirements
    @GetMapping("/workintech/fruits")
    public List<Fruit> getAllFruitsWithPrefix() {
        return fruitService.getByPriceAsc();
    }
    
    @GetMapping("/workintech/fruits/{id}")
    public Fruit getFruitByIdWithPrefix(@PathVariable Long id) {
        return fruitService.getById(id);
    }
    
    @GetMapping("/workintech/fruits/desc")
    public List<Fruit> getAllFruitsDescWithPrefix() {
        return fruitService.getByPriceDesc();
    }
    
    @PostMapping("/workintech/fruits")
    public SuccessResponse<Fruit> saveFruitWithPrefix(@RequestBody Fruit fruit) {
        Fruit savedFruit = fruitService.save(fruit);
        return new SuccessResponse<>(savedFruit, "Fruit successfully saved");
    }
    
    @GetMapping("/workintech/fruits/name/{name}")
    public List<Fruit> searchFruitsByNameWithPrefix(@PathVariable String name) {
        return fruitService.searchByName(name);
    }
    
    @DeleteMapping("/workintech/fruits/{id}")
    public Fruit deleteFruitWithPrefix(@PathVariable Long id) {
        return fruitService.delete(id);
    }
} 