package org.turendar.fakestore3rdpartyapi.representinginheritance.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@DiscriminatorValue(value = "2")
@Entity
public class ta extends User {
    private int noOfSessions;
    private double avgRating;
}
