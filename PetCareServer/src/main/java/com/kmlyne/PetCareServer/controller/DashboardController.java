//package com.kmlyne.PetCareServer.controller;
//
//
//import com.kmlyne.PetCareServer.service.OrderService;
//import com.kmlyne.PetCareServer.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/dashboard")
//@CrossOrigin(origins = "http://localhost:4200")
//
//public class DashboardController {
//
//    @Autowired
//    private OrderService orderService;
//
//    @Autowired
//    private UserService userService;
//
//    // API lấy doanh thu
//    @GetMapping("/revenue")
//    public ResponseEntity<Long> getTotalRevenue() {
//        long totalRevenue = orderService.calculateTotalRevenue();
//        return ResponseEntity.ok(totalRevenue);
//    }
//
//    // API lấy tổng số đơn hàng
//    @GetMapping("/orders")
//    public ResponseEntity<Long> getTotalOrders() {
//        long totalOrders = orderService.countTotalOrders();
//        return ResponseEntity.ok(totalOrders);
//    }
//
//    // API lấy tổng số khách hàng
//    @GetMapping("/customers")
//    public ResponseEntity<Long> getTotalCustomers() {
//        long totalCustomers = userService.countTotalCustomers();
//        return ResponseEntity.ok(totalCustomers);
//    }
//}
