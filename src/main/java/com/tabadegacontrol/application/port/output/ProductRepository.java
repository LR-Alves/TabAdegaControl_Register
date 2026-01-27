package com.tabadegacontrol.application.port.output;


import com.tabadegacontrol.domain.model.Product;

import java.util.Optional;

public interface ProductRepository {

    Optional<Product> getProductById(Long id);

    Optional<Product> addProduct(Product product);

    Optional<Product> updateProduct(Long id, Product product);

    Optional<Void> deleteProduct(Long id);
}
