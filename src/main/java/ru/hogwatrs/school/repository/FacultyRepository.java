package ru.hogwatrs.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwatrs.school.model.Faculty;

import java.util.Collection;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    Collection<Faculty> findByColorOrNameIgnoreCase(String color, String name);
}
