package com.kmlyne.PetCareServer.controller;


import com.kmlyne.PetCareServer.model.Animals;
import com.kmlyne.PetCareServer.repository.AnimalRespository;
import com.kmlyne.PetCareServer.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @GetMapping
    public List<Animals> getAllAnimals() {
        return animalService.getAllAnimals();
    }

}
