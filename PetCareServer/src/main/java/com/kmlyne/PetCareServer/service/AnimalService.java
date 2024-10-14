package com.kmlyne.PetCareServer.service;


import com.kmlyne.PetCareServer.controller.AnimalController;
import com.kmlyne.PetCareServer.model.Animals;
import com.kmlyne.PetCareServer.repository.AnimalRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    @Autowired
    private AnimalRespository animalRespository;
    public List<Animals> getAllAnimals() {
        return animalRespository.findAll();
    }


}
