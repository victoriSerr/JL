package ru.itis.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.itis.models.Course;

public interface CourseRepository extends MongoRepository<Course, String> {
}
