package com.kmlyne.PetCareServer.repository;

import com.kmlyne.PetCareServer.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderResponsitory extends JpaRepository<Orders, Integer> {
//    @Query("SELECT SUM(o.totalamount) FROM Orders o")
//    Long sumTotalRevenue();
}
