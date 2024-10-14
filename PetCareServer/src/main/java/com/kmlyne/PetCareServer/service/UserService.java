package com.kmlyne.PetCareServer.service;


import com.kmlyne.PetCareServer.model.Products;
import com.kmlyne.PetCareServer.model.User;
import com.kmlyne.PetCareServer.repository.ProductRepository;
import com.kmlyne.PetCareServer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public Optional<User> getCustomerById(int customerID) {
        return userRepository.findById(customerID);
    }


//    public Optional<User> findByEmail(String email) {
//        return userRepository.findByEmail(email);
//    }
//
//    public Boolean existsByEmail(String email) {
//        return userRepository.existsByEmail(email);
//    }
//
//    public User saveUser(User user) {
//        return userRepository.save(user);
//    }

}
