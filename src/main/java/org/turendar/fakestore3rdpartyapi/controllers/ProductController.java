package org.turendar.fakestore3rdpartyapi.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.turendar.fakestore3rdpartyapi.models.Product;
import org.turendar.fakestore3rdpartyapi.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;
    ProductController(@Qualifier("selfproductservice") ProductService productService){
        this.productService = productService;
    }
    @RequestMapping("/{id}")
    Product getProductById(@PathVariable("id") Long id){
        return productService.getProductById(id);
    }

    @RequestMapping()
    List<Product> getAllProductBy(){
        return productService.getAllProducts();
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return productService.replaceProduct(id, product);
    }
}
