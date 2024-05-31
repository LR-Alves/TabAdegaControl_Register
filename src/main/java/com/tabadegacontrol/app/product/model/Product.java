package com.tabadegacontrol.app.product.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Data
@Component
@Entity(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String categoria;
    private String marca;
    private int quantidade;
    private double precoVenda;
    private double precoCusto;
    private int estoqueAtual;
    private LocalDate dataCriacao;


}
