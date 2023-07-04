package ru.hogwatrs.school.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Objects;
@Entity
public class Student {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int age;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    public Faculty getFaculty() {
        return faculty;
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
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }}