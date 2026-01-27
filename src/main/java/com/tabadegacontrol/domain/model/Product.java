package com.tabadegacontrol.domain.model;

import lombok.Data;

import java.time.LocalDate;


@Data
public class Product {

    private Long id;
    private String name;
    private String category;
    private String brand;
    private int quantity;
    private double salePrice;
    private double costPrice;
    private int currentStock;
    private LocalDate creationDate;
}
