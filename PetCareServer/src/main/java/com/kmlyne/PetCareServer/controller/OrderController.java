package com.kmlyne.PetCareServer.controller;


import com.kmlyne.PetCareServer.model.OrderDetails;
import com.kmlyne.PetCareServer.model.OrderRequest;
import com.kmlyne.PetCareServer.model.Orders;
import com.kmlyne.PetCareServer.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {

    @Autowired
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;

    }
    @PostMapping("/checkout")
    public ResponseEntity<?> checkout(@RequestBody OrderRequest orderRequest) {
        try {
            orderService.processOrder(orderRequest);
            // Trả về đối tượng JSON thay vì chuỗi đơn giản
            return ResponseEntity.ok().body(Collections.singletonMap("message", "Đơn hàng đã được đặt"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(Collections.singletonMap("error", "Có lỗi xảy ra khi đặt hàng"));
        }
    }


    @GetMapping
    public ResponseEntity<List<Orders>> getAllOrders() {
        List<Orders> orders = orderService.getAllOrders();
        return ResponseEntity.ok().body(orders);
    }



//    @GetMapping
//    public List<Orders> getAllOrders() {
//        return orderService.getAllOrders();
//    }
//
    @GetMapping("/{id}")
    public ResponseEntity<Orders> getOrderById(@PathVariable int id) {
        Optional<Orders> order = orderService.getOrderById(id); // Trả về Optional<Orders>

        if (order.isPresent()) {
            return ResponseEntity.ok().body(order.get()); // Nếu tồn tại, trả về đối tượng Orders
        } else {
            return ResponseEntity.notFound().build(); // Nếu không tìm thấy, trả về 404
        }

}
    @PutMapping("/{id}/status")
    public ResponseEntity<?> updateOrderStatus(@PathVariable int id, @RequestBody Map<String, String> request) {
        String status = request.get("status");
        try {
            orderService.updateOrderStatus(id, status);
            return ResponseEntity.ok().body(Collections.singletonMap("message", "Trạng thái đơn hàng đã được cập nhật"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(Collections.singletonMap("error", "Có lỗi xảy ra khi cập nhật trạng thái đơn hàng"));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable int id) {
        try {
            orderService.deleteOrder(id);
            return ResponseEntity.ok().body(Collections.singletonMap("message", "Đơn hàng và chi tiết đơn hàng đã được xóa"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(Collections.singletonMap("error", "Có lỗi xảy ra khi xóa đơn hàng"));
        }
    }

    @GetMapping("/{orderId}/details")
    public ResponseEntity<List<OrderDetails>> getOrderDetails(@PathVariable int orderId) {
        List<OrderDetails> orderDetails = orderService.getOrderDetailsByOrderId(orderId);
        return ResponseEntity.ok(orderDetails);
    }


//    @DeleteMapping("/{orderId}") // Xóa đơn hàng
//    public ResponseEntity<String> deleteOrder(@PathVariable int orderId) {
//        try {
//            orderService.deleteOrder(orderId);
//            return ResponseEntity.ok("Đơn hàng đã được xóa thành công.");
//        } catch (RuntimeException e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Có lỗi xảy ra khi xóa đơn hàng.");
//        }
//    }

//@PutMapping("/{id}")
//public ResponseEntity<?> updateOrderStatus(@PathVariable int id, @RequestBody Map<String, String> request) {
//    String status = request.get("status");
//    System.out.println("Updating order ID: " + id + " with status: " + status); // Log cho kiểm tra
//
//    Optional<Orders> orderOptional = orderService.getOrderById(id);
//    if (orderOptional.isPresent()) {
//        Orders order = orderOptional.get();
//        order.setStatus(status);
//        orderService.save(order); // Ghi cập nhật trạng thái vào database
//        return ResponseEntity.ok().body(Collections.singletonMap("message", "Trạng thái đã cập nhật"));
//    } else {
//        return ResponseEntity.status(404).body(Collections.singletonMap("error", "Đơn hàng không tồn tại"));
//    }
//}


//
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Orders> updatedOrder(@PathVariable int id, @RequestBody String status) {
//        Orders updatedOrder = orderService.updatedOrder(id, status);
//        return ResponseEntity.ok(updatedOrder);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteOrder(@PathVariable int id) {
//        orderService.deleteOrder(id);
//        return ResponseEntity.noContent().build();
//    }
}
