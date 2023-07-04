package ru.hogwatrs.school.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwatrs.school.model.Faculty;
import ru.hogwatrs.school.model.Student;
import ru.hogwatrs.school.service.FacultyService;


import java.util.Collection;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
    private final FacultyService facultyService;
    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }
    @GetMapping("{id}")
    public ResponseEntity<Faculty> getStudentInfo (@PathVariable long id){
        Faculty faculty = facultyService.findFaculty(id);
        if (faculty != null) {
            return ResponseEntity.ok(faculty);
        }
        return ResponseEntity.notFound().build();
    }
    @PostMapping
    public Faculty createStudent (@RequestBody Faculty faculty){
        return facultyService.addFaculty(faculty);
    }
    @PutMapping
    public ResponseEntity<Faculty> editStudent (@RequestBody Faculty faculty){
        Faculty foundFaculty = facultyService.editFaculty(faculty);
        if (foundFaculty == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(foundFaculty);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Faculty> deleteStudent (@PathVariable long id){
        facultyService.deleteFaculty(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public Collection<Faculty> getAllFacultiesInfo (){
        return facultyService.getAllFaculties();
    }
    @GetMapping("getByColor/{color}")
    public Collection<Faculty> getAllFacultiesByColorInfo (@PathVariable String color){
        return facultyService.getAllFacultiesByColor(color);
    }
    @GetMapping("/getByColorOrName")
    public Collection<Faculty> getAllFacultiesByColorOrName (@RequestParam(required = false) String color,
                                                             @RequestParam(required = false) String name){
        return facultyService.getAllFacultiesByColorOrName(color, name);
    }
    @GetMapping("/getAllStudentsOfFaculty/{facultyId}")
    public Collection<Student> getAllStudentsOfFaculty(@PathVariable long facultyId){
        return facultyService.getAllStudentsOfFaculty(facultyId);
    }
}

