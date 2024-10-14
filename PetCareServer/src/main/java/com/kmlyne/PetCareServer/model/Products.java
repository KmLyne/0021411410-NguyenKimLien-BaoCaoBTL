package com.kmlyne.PetCareServer.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name="products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productid;

    private String productname;
    private int animalid;
    private String description;
    private int price;

    @Column(name = "categoryid", nullable = false)  // Sửa lại kiểu cho phù hợp với cơ sở dữ liệu
    private int categoryid;  // Đổi từ String sang int

    private String image;
    private int stockquantity;

    @Column(name = "createdat", updatable = false)
    private LocalDateTime createAt;

    @Column(name = "updateat")
    private LocalDateTime updateAt;

    @PrePersist
    protected void onCreate() {
        createAt = LocalDateTime.now();
        updateAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updateAt = LocalDateTime.now();
    }
}
