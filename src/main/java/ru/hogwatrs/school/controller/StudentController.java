package ru.hogwatrs.school.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwatrs.school.model.Student;
import ru.hogwatrs.school.service.StudentService;

import java.util.Collection;


@RestController
@RequestMapping("/student")

public class StudentController {

    private final StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public Collection<Student> getAll() {
        return studentService.getAll();
    }

    @PostMapping
    public Student add(@RequestBody Student student) {
        return studentService.add(student);
    }


    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id) {
        return studentService.getById(id);
    }
    @PutMapping
    public Student update(@RequestBody Student student){
        return  studentService.update(student);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        studentService.delete(id);
    }

    @GetMapping("/find")
    public Collection<Student> getAllByAge(@RequestParam int age) {

        return studentService.getAllByAge(age);
    }
}
