package com.tabadegacontrol.app.Suppliers.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.stereotype.Component;


@Data
@Component
@Entity(name = "Suppliers")
public class Suppliers {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int phone;
    private String address;
    private String city;
    private String category;

}
