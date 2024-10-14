package com.kmlyne.PetCareServer.repository;

import com.kmlyne.PetCareServer.model.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailRespository extends JpaRepository<OrderDetails, Integer> {
//    void deleteByOrderId(int orderId);
void deleteByOrderid(int orderid);

    List<OrderDetails> findByOrderid(int orderid);

}
