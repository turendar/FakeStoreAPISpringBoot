package org.turendar.fakestore3rdpartyapi.representinginheritance.singletable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "user_type",
        discriminatorType = DiscriminatorType.INTEGER
)
@Entity(name = "st_user")
public class User {
    @Id
    private Long id;
    private String name;
    private String email;
    private String password;
}
