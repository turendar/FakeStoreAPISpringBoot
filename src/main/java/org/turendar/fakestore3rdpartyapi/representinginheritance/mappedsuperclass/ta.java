package org.turendar.fakestore3rdpartyapi.representinginheritance.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "msc_ta")
public class ta extends User{
    private int noOfSessions;
    private double avgRating;
}
