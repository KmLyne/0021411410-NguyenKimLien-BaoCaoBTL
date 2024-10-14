package com.kmlyne.PetCareServer.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="animals")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Animals {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int animalid;
    private String animalname;
}
