package ru.hogwatrs.school.service.impl;

import org.springframework.stereotype.Service;
import ru.hogwatrs.school.model.Student;
import ru.hogwatrs.school.repository.StudentRepository;
import ru.hogwatrs.school.service.StudentService;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final Long counter = 0L;

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public Student add(Student student) {

       return studentRepository.save(student);

    }

    @Override
    public Student getById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Collection<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);

    }


    @Override
    public Student update(Student student) {

       return studentRepository.save(student);

    }

    @Override
    public Collection<Student> getAllByAge(int age) {
        return  getAll()
                .stream()
                .filter(it ->it.getAge() == age)
                .collect(Collectors.toList());
    }
    @Override
    public Collection<Student> findByAgeBetween(int min, int max){
        return studentRepository.findAllByAgeBetweenOrderByAge(min,max);
    }
}
