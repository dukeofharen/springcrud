package org.ducode.springcrud.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;

    @Getter
    @Setter
    private String name;

    @ManyToOne
    @JoinColumn(name = "department_id")
    @Getter
    @Setter
    private Department department;
}
