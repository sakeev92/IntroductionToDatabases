package ru.hogwatrs.school.service;

import ru.hogwatrs.school.model.Faculty;
import ru.hogwatrs.school.model.Student;

import java.util.Collection;

public interface FacultyService {
    Faculty addFaculty (Faculty faculty);
    Faculty findFaculty (long id);
    Faculty editFaculty (Faculty faculty);
    void deleteFaculty (long id);
    Collection<Faculty> getAllFaculties ();
    Collection<Faculty> getAllFacultiesByColor (String color);
    Collection<Faculty> getAllFacultiesByColorOrName(String color, String name);
    Collection<Student> getAllStudentsOfFaculty(long facultyId);
}

