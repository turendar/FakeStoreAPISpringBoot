package org.turendar.fakestore3rdpartyapi.representinginheritance.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@DiscriminatorValue(value = "0")
@Entity
public class Instructor extends User {
    private String specialization;
}
