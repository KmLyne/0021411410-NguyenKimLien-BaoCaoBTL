package com.kmlyne.PetCareServer.service;


import com.kmlyne.PetCareServer.model.Categories;
import com.kmlyne.PetCareServer.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Categories> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Optional<Categories> getCategoryById(int id) {
        return categoryRepository.findById(id);
    }

    public Categories addCategory(Categories category) {
        return categoryRepository.save(category);
    }

    public Categories updateCategory(int categoryId, Categories category) {
        Categories categories = categoryRepository.findById(categoryId).orElseThrow();
        categories.setCategoryname(category.getCategoryname());
        return categoryRepository.save(categories);

    }

    public void deleteCategory(int categoryId) {
        categoryRepository.deleteById(categoryId);
    }


}
