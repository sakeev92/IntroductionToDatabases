package ru.hogwatrs.school.service.impl;

import org.springframework.stereotype.Service;
import ru.hogwatrs.school.model.Faculty;
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
    public Faculty add(Faculty faculty) {

      return  facultyRepository.save(faculty);

    }

    @Override
    public Faculty getById(Long id) {
        return facultyRepository.findById(id).orElse(null);
    }

    @Override
    public Collection<Faculty> getAll() {
        return facultyRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        facultyRepository.deleteById(id);

    }


    @Override
    public Faculty update(Faculty faculty) {
        return  facultyRepository.save(faculty);
    }

    @Override
    public Collection<Faculty> getAllByColor(String color) {
        return  getAll()
                .stream()
                .filter(it ->it.getColor().equals(color))
                .collect(Collectors.toList());
    }
}


