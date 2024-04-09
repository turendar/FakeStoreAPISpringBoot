package org.turendar.fakestore3rdpartyapi.representinginheritance.joinedtable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_ta")
@PrimaryKeyJoinColumn(name = "user_id")
public class ta extends User {
    private int noOfSessions;
    private double avgRating;
}
