package ru.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.models.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
