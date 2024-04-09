package org.turendar.fakestore3rdpartyapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
// no table for this class
public class BaseModel {
    @Id
    private Long id;
    private Date createdAt;
    private Date updatedAt;
}
