package com.tabadegacontrol.app.product.service;

import com.tabadegacontrol.app.product.model.Product;
import com.tabadegacontrol.app.product.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutcService {

    private static final Logger logger = LoggerFactory.getLogger(ProdutcService.class);

    private final ProductRepository productRepository;

    @Autowired
    public ProdutcService(ProductRepository productRepository, Product Product) {
        this.productRepository = productRepository;
    }

    @Transactional
    public void createProduct(Product Product) {
        logger.info("Criando um novo Product", Product);
        try {
            productRepository.save(Product);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao adicionar um novo Product", e);
        }

    }

    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductByid(Long id) {
        return productRepository.findById(id);

    }

    public void saveProduct(Product saveProduct) {
        productRepository.save(saveProduct);
    }


    public void deletProduct(Long id) {
        productRepository.deleteById(id);
    }

    public Product updateProduct(Long id, Product ProductAtualizado) {

        Product ProductExistente = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product não encontrado com ID: " + id));

        ProductExistente.setNome(ProductAtualizado.getNome());
        ProductExistente.setCategoria(ProductAtualizado.getCategoria());
        ProductExistente.setQuantidade(ProductExistente.getQuantidade());
        ProductExistente.setPrecoCusto(ProductAtualizado.getPrecoCusto());
        ProductExistente.setMarca(ProductAtualizado.getMarca());
        ProductExistente.setEstoqueAtual((ProductAtualizado.getEstoqueAtual()));
        return productRepository.save(ProductExistente);
    }


}

