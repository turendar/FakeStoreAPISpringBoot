package org.turendar.fakestore3rdpartyapi.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private String image;
    private Category category;
}
