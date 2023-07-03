package ru.hogwatrs.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwatrs.school.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
