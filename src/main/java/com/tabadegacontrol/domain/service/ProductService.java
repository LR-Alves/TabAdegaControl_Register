package com.tabadegacontrol.domain.service;

import com.tabadegacontrol.application.dto.ProductRequest;
import com.tabadegacontrol.application.port.input.ProductUseCase;
import com.tabadegacontrol.application.port.output.ProductRepository;
import com.tabadegacontrol.domain.model.Product;

public class ProductService implements ProductUseCase {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public Product processProduct(ProductRequest productRequest) {
//        productRepository.getProductById()
        return null;
    }
}
