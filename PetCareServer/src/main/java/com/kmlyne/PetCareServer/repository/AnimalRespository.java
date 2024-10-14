package com.kmlyne.PetCareServer.repository;

import com.kmlyne.PetCareServer.model.Animals;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRespository extends JpaRepository<Animals, Integer> {
}
