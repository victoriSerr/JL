package ru.itis.perositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.itis.models.Teacher;

public interface TeacherRepository extends MongoRepository<Teacher, String> {
}
