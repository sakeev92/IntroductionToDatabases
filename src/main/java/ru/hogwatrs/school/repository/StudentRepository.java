package ru.hogwatrs.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwatrs.school.model.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findAllByAgeBetweenOrderByAge(int min, int max);

}
