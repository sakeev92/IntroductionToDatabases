package ru.hogwatrs.school.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
public class Faculty {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String color;
    @JsonManagedReference
    @OneToMany(mappedBy = "faculty")
    private Collection<Student> students;

    public Collection<Student> getStudents() {
        return students;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }}
