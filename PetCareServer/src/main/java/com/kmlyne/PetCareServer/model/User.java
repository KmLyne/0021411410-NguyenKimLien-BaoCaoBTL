package com.kmlyne.PetCareServer.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

@Entity
@Table(name="customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerid")
    private int customerid;
    private String fullname;
    private String email;
    private String passwordhash;
    private int phonenumber;
    private String address;
    private String image;

    @Column(insertable = false, updatable = false)  // Prevent duplicate mapping of 'roleId'
    private Integer roleid;

//    @ManyToOne
//    @JoinColumn(name = "roleid", referencedColumnName = "roleid")
//    private Role role;  // Không cần roleid riêng

    @Column(updatable = false)
    private LocalDateTime registrationdate;

    @PrePersist
    protected void onCreate() {
        registrationdate = LocalDateTime.now();
    }
}

