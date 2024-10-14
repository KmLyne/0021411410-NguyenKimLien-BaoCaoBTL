package com.kmlyne.PetCareServer.controller;


import com.kmlyne.PetCareServer.model.Products;
import com.kmlyne.PetCareServer.model.User;
import com.kmlyne.PetCareServer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/customers")
public class CustomerCotroller {

    @Autowired
    private UserService userService;



    @GetMapping
    public List<User> getAllUser() {
        List<User> users = userService.getAllUser();
        System.out.println("Danh sách khách hàng: " + users); // Log để kiểm tra danh sách khách hàng
        return users;
    }


    @GetMapping("/{id}")
    public ResponseEntity<User> getCustomerById(@PathVariable int id) {
        Optional<User> customer = userService.getCustomerById(id);
        return customer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
