package org.turendar.fakestore3rdpartyapi.services;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;
import org.turendar.fakestore3rdpartyapi.dto.FakeStoreAPIDto;
import org.turendar.fakestore3rdpartyapi.models.Category;
import org.turendar.fakestore3rdpartyapi.models.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service("fakestoreapiproductservice")
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

    @Override
    public Product getProductById(Long id) {

//        RestTemplate restTemplate = new RestTemplate();
// RestTemplate object moved to config for creating object in Beans container while spring initializer

        FakeStoreAPIDto fakestoredto = restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeStoreAPIDto.class);
        return convertFakeStoreDtoTOProduct(fakestoredto);
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreAPIDto[] fakeStoleProdLists = restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreAPIDto[].class);
        List<Product> productLists = new ArrayList<>();
        for(FakeStoreAPIDto fsDto : fakeStoleProdLists)
            productLists.add(convertFakeStoreDtoTOProduct(fsDto));

        return productLists;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        FakeStoreAPIDto fakeStoreProductDto = new FakeStoreAPIDto();
        fakeStoreProductDto.setTitle(product.getTitle());
        fakeStoreProductDto.setImage(product.getImage());
        fakeStoreProductDto.setDescription(product.getDescription());

        RequestCallback requestCallback = restTemplate.httpEntityCallback(fakeStoreProductDto, FakeStoreAPIDto.class);
        HttpMessageConverterExtractor<FakeStoreAPIDto> responseExtractor = new HttpMessageConverterExtractor(FakeStoreAPIDto.class, restTemplate.getMessageConverters());
        FakeStoreAPIDto response =  restTemplate.execute("https://fakestoreapi.com/products/"+id, HttpMethod.PUT, requestCallback, responseExtractor);

        return convertFakeStoreDtoTOProduct(response);
    }
}
