package ru.hogwatrs.school.service.impl;

import org.springframework.stereotype.Service;
import ru.hogwatrs.school.model.Faculty;
import ru.hogwatrs.school.model.Student;
import ru.hogwatrs.school.repository.FacultyRepository;
import ru.hogwatrs.school.service.FacultyService;

import java.util.Collection;
import java.util.stream.Collectors;
@Service
public class FacultyServiceImpl implements FacultyService {
    private final FacultyRepository facultyRepository;
    public FacultyServiceImpl(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }
    @Override
    public Faculty addFaculty(Faculty faculty) {
        facultyRepository.save(faculty);
        return faculty;
    }
    @Override
    public Faculty findFaculty(long facultyId) {
        return facultyRepository.findById(facultyId).get();
    }
    @Override
    public Faculty editFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }
    @Override
    public void deleteFaculty(long facultyId) {
        facultyRepository.deleteById(facultyId);
    }
    @Override
    public Collection<Faculty> getAllFaculties() {
        return facultyRepository.findAll();
    }
    @Override
    public Collection<Faculty> getAllFacultiesByColor(String color) {
        return getAllFaculties()
                .stream()
                .filter(e->e.getColor().equals(color))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Faculty> getAllFacultiesByColorOrName(String color, String name) {
        return facultyRepository.findByColorOrNameIgnoreCase(color, name);
    }

    @Override
    public Collection<Student> getAllStudentsOfFaculty(long facultyId) {
        return facultyRepository.findById(facultyId).get().getStudents();
    }
}


