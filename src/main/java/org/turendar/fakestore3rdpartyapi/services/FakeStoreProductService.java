package org.turendar.fakestore3rdpartyapi.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.turendar.fakestore3rdpartyapi.dto.FakeStoreAPIDto;
import org.turendar.fakestore3rdpartyapi.models.Category;
import org.turendar.fakestore3rdpartyapi.models.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class FakeStoreProductService implements ProductService{
    private RestTemplate restTemplate;
    FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    private Product convertFakeStoreDtoTOProduct(FakeStoreAPIDto dto){
        Product product = new Product();
        product.setId(dto.getId());
        product.setTitle(dto.getTitle());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setImage(dto.getImage());

        Category category = new Category();
        category.setDescription(dto.getCategory());

        product.setCategory(category);

        return product;
    }

    private List<Product> convertFakeStoreDtosTOProducts(List<FakeStoreAPIDto> dtos){

        List<Product> productLists = new ArrayList<>();
        for (FakeStoreAPIDto dto : dtos)
        {
            Product product = new Product();
            product.setId(dto.getId());
            product.setTitle(dto.getTitle());
            product.setDescription(dto.getDescription());
            product.setPrice(dto.getPrice());
            product.setImage(dto.getImage());

            Category category = new Category();
            category.setDescription(dto.getCategory());
            product.setCategory(category);

            productLists.add(product);
        }

        return productLists;
    }

    @Override
    public Product getProductById(Long id) {

//        RestTemplate restTemplate = new RestTemplate();
// RestTemplate object moved to config for creating object in Beans container while spring initializer

        FakeStoreAPIDto fakestoredto = restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeStoreAPIDto.class);
        return convertFakeStoreDtoTOProduct(fakestoredto);
    }

    @Override
    public ArrayList<Product> getAllProducts() {
        List<FakeStoreAPIDto> fakeStoleProdLists = new ArrayList<>();
        fakeStoleProdLists = List.of(Objects.requireNonNull(restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreAPIDto[].class)));

        return (ArrayList<Product>) convertFakeStoreDtosTOProducts(fakeStoleProdLists);
    }
}
