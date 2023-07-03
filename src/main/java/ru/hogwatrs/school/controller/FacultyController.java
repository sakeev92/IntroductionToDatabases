package ru.hogwatrs.school.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwatrs.school.model.Faculty;
import ru.hogwatrs.school.service.FacultyService;


import java.util.Collection;

@RestController
@RequestMapping("/faculties")

public class FacultyController {

    private final FacultyService facultyService;


    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping
    public Collection<Faculty> getAll() {
        return facultyService.getAll();
    }

    @PostMapping
    public Faculty add(@RequestBody Faculty faculty) {
        return facultyService.add(faculty);
    }


    @GetMapping("/{id}")
    public Faculty getById(@PathVariable Long id) {
        return facultyService.getById(id);
    }
    @PutMapping
    public Faculty update(@RequestBody Faculty faculty){
        return  facultyService.update(faculty);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        facultyService.delete(id);
    }

    @GetMapping("/find")
    public Collection<Faculty> getAllByAge(@RequestParam String color) {

        return facultyService.getAllByColor(color);
    }
}


