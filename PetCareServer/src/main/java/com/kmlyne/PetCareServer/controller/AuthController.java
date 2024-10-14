//package com.kmlyne.PetCareServer.controller;
//
//
//import com.kmlyne.PetCareServer.model.Role;
//import com.kmlyne.PetCareServer.model.User;
//import com.kmlyne.PetCareServer.service.RoleService;
//import com.kmlyne.PetCareServer.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/auth")
//public class AuthController {
//
//    @Autowired
//    private UserService userService;
//    @Autowired
//    private RoleService roleService;
//
//    @PostMapping("/register")
//    public ResponseEntity<?> registerUser(@RequestBody User user) {
//        if (userService.existsByEmail(user.getEmail())) {
//            return ResponseEntity
//                    .badRequest()
//                    .body("Email already exists");
//        }
//
//        //gán vai tr mặc định là user
//        Optional<Role> userRole = roleService.findRoleByName("User");
//        user.setRole(userRole.orElseThrow(() -> new RuntimeException("Role not found")));
//        user.setPasswordhash(user.getPasswordhash());
//
//        userService.saveUser(user);
//        return ResponseEntity.ok("User registered successfully!");
//    }
//
//
//    @PostMapping("/login")
//    public ResponseEntity<String> loginUser(@RequestBody User user) {
//
//        Optional<User> existingUser = userService.findByEmail(user.getEmail());
//
//        if (existingUser.isPresent() && user.getPasswordhash().equals(existingUser.get().getPasswordhash())) {
//            return ResponseEntity.ok("User logged in successfully");
//        }else{
//            return ResponseEntity.status(401).body("Email hoặc password không đúng.");
//        }
//
//    }
//}
