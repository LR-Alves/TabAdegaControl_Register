package com.tabadegacontrol.app.product.repository;


import com.tabadegacontrol.app.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    }
