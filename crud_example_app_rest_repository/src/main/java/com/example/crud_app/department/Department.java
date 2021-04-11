package com.example.crud_app.department;

import javax.persistence.*;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private Integer maxNumberOfStudents;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getMaxNumberOfStudents() {
        return maxNumberOfStudents;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMaxNumberOfStudents(Integer maxNumberOfStudents) {
        this.maxNumberOfStudents = maxNumberOfStudents;
    }
}
