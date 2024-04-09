package org.turendar.fakestore3rdpartyapi.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.turendar.fakestore3rdpartyapi.models.Product;

import java.util.List;

@Service("selfproductservice")
//@Primary // conflicts between two beans here selfproductservice and Fakestoreapiservice
public class SelfProductService implements ProductService{
    @Override
    public Product getProductById(Long id) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }
}
