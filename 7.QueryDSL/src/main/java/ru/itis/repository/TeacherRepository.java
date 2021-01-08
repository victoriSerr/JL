package ru.itis.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.itis.models.Teacher;

public interface TeacherRepository extends MongoRepository<Teacher, String> {
}
