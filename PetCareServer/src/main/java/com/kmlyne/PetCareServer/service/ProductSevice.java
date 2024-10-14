package com.kmlyne.PetCareServer.service;

import com.kmlyne.PetCareServer.model.Products;
import com.kmlyne.PetCareServer.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductSevice {

    @Autowired
    private ProductRepository productRepository;
    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Products> getProductById(int productID) {
        return productRepository.findById(productID);
    }
    public Products addProduct(Products product) {
        return productRepository.save(product);
    }
    public Products updateProduct(int productID, Products productDetails) {
        Products product = productRepository.findById(productID).orElseThrow();
        product.setProductname(productDetails.getProductname());
        product.setCategoryid(productDetails.getCategoryid());
        product.setAnimalid(productDetails.getAnimalid());
        product.setDescription(productDetails.getDescription());
        product.setPrice(productDetails.getPrice());
        product.setStockquantity(productDetails.getStockquantity());
        product.setImage(productDetails.getImage());
        return productRepository.save(product);

    }
    public void deleteProduct(int productID) {
        productRepository.deleteById(productID);
    }
}
