package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.exceptions.SuccessResponse;
import com.workintech.s18d2.services.VegetableService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class VegetableController {
    
    private final VegetableService vegetableService;
    
    @Autowired
    public VegetableController(VegetableService vegetableService) {
        this.vegetableService = vegetableService;
    }
    
    @GetMapping("/vegetable")
    public List<Vegetable> getAllVegetables() {
        return vegetableService.getByPriceAsc();
    }
    
    @GetMapping("/vegetable/{id}")
    public Vegetable getVegetableById(@PathVariable Long id) {
        return vegetableService.getById(id);
    }
    
    @GetMapping("/vegetable/desc")
    public List<Vegetable> getAllVegetablesDesc() {
        return vegetableService.getByPriceDesc();
    }
    
    @PostMapping("/vegetable")
    public SuccessResponse<Vegetable> saveVegetable(@RequestBody Vegetable vegetable) {
        Vegetable savedVegetable = vegetableService.save(vegetable);
        return new SuccessResponse<>(savedVegetable, "Vegetable successfully saved");
    }
    
    @GetMapping("/vegetable/name/{name}")
    public List<Vegetable> searchVegetablesByName(@PathVariable String name) {
        return vegetableService.searchByName(name);
    }
    
    @DeleteMapping("/vegetable/{id}")
    public Vegetable deleteVegetable(@PathVariable Long id) {
        return vegetableService.delete(id);
    }
    
    // Also keep the endpoints with prefix as specified in the requirements
    @GetMapping("/workintech/vegetables")
    public List<Vegetable> getAllVegetablesWithPrefix() {
        return vegetableService.getByPriceAsc();
    }
    
    @GetMapping("/workintech/vegetables/{id}")
    public Vegetable getVegetableByIdWithPrefix(@PathVariable Long id) {
        return vegetableService.getById(id);
    }
    
    @GetMapping("/workintech/vegetables/desc")
    public List<Vegetable> getAllVegetablesDescWithPrefix() {
        return vegetableService.getByPriceDesc();
    }
    
    @PostMapping("/workintech/vegetables")
    public SuccessResponse<Vegetable> saveVegetableWithPrefix(@RequestBody Vegetable vegetable) {
        Vegetable savedVegetable = vegetableService.save(vegetable);
        return new SuccessResponse<>(savedVegetable, "Vegetable successfully saved");
    }
    
    @GetMapping("/workintech/vegetables/name/{name}")
    public List<Vegetable> searchVegetablesByNameWithPrefix(@PathVariable String name) {
        return vegetableService.searchByName(name);
    }
    
    @DeleteMapping("/workintech/vegetables/{id}")
    public Vegetable deleteVegetableWithPrefix(@PathVariable Long id) {
        return vegetableService.delete(id);
    }
} 