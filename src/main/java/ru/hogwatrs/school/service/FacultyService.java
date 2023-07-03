package ru.hogwatrs.school.service;

import ru.hogwatrs.school.model.Faculty;

import java.util.Collection;

public interface FacultyService {
    Faculty add(Faculty faculty);
    Faculty getById(Long id);
    Collection<Faculty> getAll();
    void delete(Long id);
    Faculty update(Faculty faculty);
    Collection<Faculty> getAllByColor(String color);
}

