package com.kmlyne.PetCareServer.repository;

import com.kmlyne.PetCareServer.model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Categories, Integer> {
}
