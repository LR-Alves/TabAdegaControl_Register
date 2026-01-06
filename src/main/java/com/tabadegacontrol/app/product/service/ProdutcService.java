package com.tabadegacontrol.app.product.service;

import com.tabadegacontrol.app.product.model.Product;
import com.tabadegacontrol.app.product.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutcService {

    private static final Logger logger = LoggerFactory.getLogger(ProdutcService.class);

    private final ProductRepository productRepository;

    public ProdutcService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public Product createProduct(Product product) {
        logger.info("Criando novo produto: {}", product.getNome());
        return productRepository.save(product);
    }

    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductByid(Long id) {
        return productRepository.findById(id);
    }

    @Transactional
    public void deletProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new EntityNotFoundException("Product não encontrado com ID: " + id);
        }
        productRepository.deleteById(id);
    }

    @Transactional
    public Product updateProduct(Long id, Product productAtualizado) {

        Product productExistente = productRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Product não encontrado com ID: " + id)
                );

        productExistente.setNome(productAtualizado.getNome());
        productExistente.setCategoria(productAtualizado.getCategoria());
        productExistente.setMarca(productAtualizado.getMarca());
        productExistente.setQuantidade(productAtualizado.getQuantidade());
        productExistente.setPrecoCusto(productAtualizado.getPrecoCusto());
        productExistente.setPrecoVenda(productAtualizado.getPrecoVenda());
        productExistente.setEstoqueAtual(productAtualizado.getEstoqueAtual());

        return productRepository.save(productExistente);
    }
}
