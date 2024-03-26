package org.turendar.fakestore3rdpartyapi.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.turendar.fakestore3rdpartyapi.models.Product;
import org.turendar.fakestore3rdpartyapi.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;
    ProductController(ProductService productService){
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
}
