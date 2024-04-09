package org.turendar.fakestore3rdpartyapi.representinginheritance.tableperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tpc_intructor")
public class Instructor extends User {
    private String specialization;
}
