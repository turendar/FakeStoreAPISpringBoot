package org.turendar.fakestore3rdpartyapi.models;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product  extends BaseModel{
    private String title;
    private String description;
    private Double price;
    private String image;

    @ManyToOne
    private Category category;
}
