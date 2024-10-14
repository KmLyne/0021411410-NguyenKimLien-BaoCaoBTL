package com.kmlyne.PetCareServer.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name="categories")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int categoryid;
    private String categoryname;

    @Column(name = "createdat", updatable = false)
    private LocalDateTime createAt;

    @PrePersist
    protected void onCreate() {
        createAt = LocalDateTime.now();
    }

}
