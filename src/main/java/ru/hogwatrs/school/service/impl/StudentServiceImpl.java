package ru.hogwatrs.school.service.impl;

import org.springframework.stereotype.Service;
import ru.hogwatrs.school.model.Faculty;
import ru.hogwatrs.school.model.Student;
import ru.hogwatrs.school.repository.StudentRepository;
import ru.hogwatrs.school.service.StudentService;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }
    @Override
    public Student findStudent(long studentId) {
        return studentRepository.findById(studentId).get();
    }
    @Override
    public Student editStudent(Student student) {
        return studentRepository.save(student);
    }
    @Override
    public void deleteStudent(long studentId) {
        studentRepository.deleteById(studentId);
    }
    @Override
    public Collection<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    @Override
    public Collection<Student> getAllStudentsByAge(int age) {
        return studentRepository.findAll()
                .stream()
                .filter(student -> student.getAge() == age)
                .collect(Collectors.toList());
    }
    @Override
    public Collection<Student> findByAgeBetween(int min, int max) {
        return studentRepository.findByAgeBetween(min,max);
    }

    @Override
    public Faculty getFacultyOfStudentById(long studentId) {
        return studentRepository.findById(studentId).get().getFaculty();
    }
}