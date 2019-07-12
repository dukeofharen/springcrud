package org.ducode.springcrud.models;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(min = 2)
    @Column(unique = true)
    private String name;

    public Department(String name) {
        this.name = name;
    }

    public Department() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
