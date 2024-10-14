package com.kmlyne.PetCareServer.service;


import com.kmlyne.PetCareServer.model.*;
import com.kmlyne.PetCareServer.repository.OrderDetailRespository;
import com.kmlyne.PetCareServer.repository.OrderResponsitory;
import com.kmlyne.PetCareServer.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderResponsitory orderResponsitory;
    @Autowired
    private OrderDetailRespository orderDetailRespository;
    @Autowired
    private UserRepository userRepository;

    public OrderService(OrderResponsitory orderResponsitory, OrderDetailRespository orderDetailRespository, UserRepository userRepository) {
        this.orderResponsitory = orderResponsitory;
        this.orderDetailRespository = orderDetailRespository;
        this.userRepository = userRepository;
    }


    public List<OrderDetails> getOrderDetailsByOrderId(int orderId) {
        return orderDetailRespository.findByOrderid(orderId); // Đảm bảo sử dụng đúng tên biến
    }


    @Transactional
    public void processOrder(OrderRequest orderRequest) {
        User user = new User();
        user.setFullname(orderRequest.getFullname());
        user.setEmail(orderRequest.getEmail());
        user.setPhonenumber(orderRequest.getPhonenumber());
        user.setAddress(orderRequest.getAddress());
        user.setRegistrationdate(LocalDateTime.now());
        userRepository.save(user);

        Orders orders = new Orders();
        orders.setCustomerid(user.getCustomerid());
        orders.setOrderDate(LocalDateTime.now());
        orders.setTotalamount(orderRequest.getTotalamount());
        orders.setStatus("Chờ xử lý");
        orders = orderResponsitory.save(orders);

        for (OrderDetailRequest detail : orderRequest.getOrderdetail()) {
            OrderDetails orderDetails = new OrderDetails();
            orderDetails.setOrderid(orders.getOrderid());
            orderDetails.setProductid(detail.getProductid()); // Lấy productid từ OrderDetailRequest
            orderDetails.setQuantity(detail.getQuantity());   // Lấy quantity từ OrderDetailRequest
            orderDetails.setPrice(detail.getPrice());         // Lấy price từ OrderDetailRequest
            orderDetailRespository.save(orderDetails);
        }
        }
    @Transactional
    public List<Orders> getAllOrders() {
        return orderResponsitory.findAll();
    }

        public Optional<Orders> getOrderById(int orderID) {
        return orderResponsitory.findById(orderID);
    }
    public void updateOrderStatus(int orderId, String newStatus) {
        // Tìm đơn hàng theo ID
        Optional<Orders> optionalOrder = orderResponsitory.findById(orderId);

        // Kiểm tra xem đơn hàng có tồn tại không
        if (optionalOrder.isPresent()) {
            Orders order = optionalOrder.get();
            // Cập nhật trạng thái đơn hàng
            order.setStatus(newStatus);
            // Lưu lại thay đổi
            orderResponsitory.save(order);
        } else {
            throw new RuntimeException("Đơn hàng với ID: " + orderId + " không tồn tại");
        }
    }

    @Transactional
    public void deleteOrder(int orderId) {
        // Tìm đơn hàng theo ID
        Optional<Orders> optionalOrder = orderResponsitory.findById(orderId);

        if (optionalOrder.isPresent()) {
            Orders order = optionalOrder.get();
            // Xóa tất cả chi tiết đơn hàng liên quan
            orderDetailRespository.deleteByOrderid(order.getOrderid());
            // Xóa đơn hàng
            orderResponsitory.delete(order);
        } else {
            throw new RuntimeException("Đơn hàng với ID: " + orderId + " không tồn tại");
        }
    }




//    // Tính tổng doanh thu từ các đơn hàng
//    public long calculateTotalRevenue() {
//        return orderResponsitory.sumTotalRevenue();
//    }
//
//    // Đếm tổng số đơn hàng
//    public long countTotalOrders() {
//        return orderResponsitory.count();
//    }


//    public void deleteOrder(int orderId) {
//        // Tìm đơn hàng theo ID
//        Optional<Orders> optionalOrder = orderResponsitory.findById(orderId);
//
//        // Kiểm tra xem đơn hàng có tồn tại không
//        if (optionalOrder.isPresent()) {
//            // Lấy đơn hàng
//            Orders order = optionalOrder.get();
//
//            // Xóa tất cả các chi tiết đơn hàng liên quan
//            orderDetailRespository.deleteByOrderId(orderId);
//
//            // Xóa đơn hàng
//            orderResponsitory.delete(order);
//        } else {
//            throw new RuntimeException("Đơn hàng với ID: " + orderId + " không tồn tại");
//        }
//    }

}









//    public List<Orders> getAllOrders() {
//        return orderResponsitory.findAll();
//    }
//
////    public Optional<Orders> getOrderById(int orderID) {
////        return orderResponsitory.findById(orderID);
////    }
//
//    public Orders getOrderById(int id) {
//        return orderResponsitory.findById(id).orElseThrow(()-> new RuntimeException("Order not found"));
//    }
//
////    public Orders updateOrder(int orderID, Orders orderDetails) {
////        Orders order = orderResponsitory.findById(orderID).orElseThrow();
////        order.setCustomerid(orderDetails.getCustomerid());
////        order.setStatus(orderDetails.getStatus());
////        order.setTotalamount(orderDetails.getTotalamount());
////        return orderResponsitory.save(order);
////    }
//
//    public Orders updatedOrder(int id, String status) {
//        Orders order = getOrderById(id);
//        order.setStatus(status);
//        return orderResponsitory.save(order);
//    }
//
//
//
//    public void deleteOrder(int orderID) {
//        orderResponsitory.deleteById(orderID);
//    }
//
//
//}
