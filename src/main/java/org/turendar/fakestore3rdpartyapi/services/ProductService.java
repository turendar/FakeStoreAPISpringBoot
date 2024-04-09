package org.turendar.fakestore3rdpartyapi.services;

import org.turendar.fakestore3rdpartyapi.models.Product;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public interface ProductService {
    Product getProductById(Long id);
    List<Product> getAllProducts();

    Product replaceProduct(Long id, Product product);
}
