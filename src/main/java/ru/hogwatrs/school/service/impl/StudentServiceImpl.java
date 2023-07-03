package ru.hogwatrs.school.service.impl;

import org.springframework.stereotype.Service;
import ru.hogwatrs.school.model.Student;
import ru.hogwatrs.school.service.StudentService;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private Long counter = 0L;

    private final Map<Long, Student> students = new HashMap<>();


    @Override
    public Student add(Student student) {

        student.setId(++counter);
        students.put(student.getId(), student);
        return students.get(student.getId());
    }

    @Override
    public Student getById(Long id) {
        return students.get(id);
    }

    @Override
    public Collection<Student> getAll() {
        return students.values();
    }

    @Override
    public void delete(Long id) {
        students.remove(id);

    }


    @Override
    public Student update(Student student) {
        students.put(student.getId(),student);
        return  students.get(student.getId());
    }

    @Override
    public Collection<Student> getAllByAge(int age) {
        return  getAll()
                .stream()
                .filter(it ->it.getAge() == age)
                .collect(Collectors.toList());
    }
}
