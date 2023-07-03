package ru.hogwatrs.school.service;

import ru.hogwatrs.school.model.Student;

import java.util.Collection;

public interface StudentService {

    Student add(Student student);
    Student getById(Long id);
    Collection<Student> getAll();
    void delete(Long id);
    Student update(Student student);
    Collection<Student> getAllByAge(int age);
    Collection<Student> findByAgeBetween(int min, int max);
}
