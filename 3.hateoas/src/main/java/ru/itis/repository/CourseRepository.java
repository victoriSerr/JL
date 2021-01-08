package ru.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.models.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
