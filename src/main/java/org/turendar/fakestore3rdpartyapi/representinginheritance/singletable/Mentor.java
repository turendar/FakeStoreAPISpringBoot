package org.turendar.fakestore3rdpartyapi.representinginheritance.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@DiscriminatorValue(value = "1")
@Entity
public class Mentor extends User {
    private double mentorRating;
}
