package com.tabadegacontrol.application.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {


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
