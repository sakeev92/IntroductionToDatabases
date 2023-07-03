package ru.hogwatrs.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwatrs.school.model.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
}
