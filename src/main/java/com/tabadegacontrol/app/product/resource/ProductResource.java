package com.tabadegacontrol.app.product.resource;

import com.tabadegacontrol.app.product.service.ProdutcService;
import com.tabadegacontrol.app.product.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/v1")
public class ProductResource {


    private Product product;

    private final ProdutcService produtcService ;

    @Autowired
    public ProductResource (ProdutcService produtcService){
        this.produtcService = produtcService;
    }
    @GetMapping("/status")
    public ResponseEntity<String> TestServiceEndpoint(String retornoStatus) {
        retornoStatus = "Service is running";
        return  ResponseEntity.ok(retornoStatus);
    }


@GetMapping
public ResponseEntity<List<Product>> getAllProduct() {
    List<Product> Products = produtcService.getAllProduct();
    return new ResponseEntity<>(Products, HttpStatus.OK);
}

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return produtcService.getProductByid(id).map(Product -> new ResponseEntity<>(Product, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product Product) {
        produtcService.createProduct(Product);
        return new ResponseEntity<>(Product, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, Product updateProduct) {
        produtcService.updateProduct(id, updateProduct);
        return new ResponseEntity<>(updateProduct, HttpStatus.OK);

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Product> DeleteProduct(@PathVariable Long id) {
        produtcService.deletProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
