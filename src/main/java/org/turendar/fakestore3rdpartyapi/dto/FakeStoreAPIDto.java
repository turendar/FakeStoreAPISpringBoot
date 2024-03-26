package org.turendar.fakestore3rdpartyapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreAPIDto {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private String image;
    private String category;
}
