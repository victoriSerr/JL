package ru.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.models.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
