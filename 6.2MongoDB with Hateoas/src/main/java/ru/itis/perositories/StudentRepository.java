package ru.itis.perositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.itis.models.Student;

public interface StudentRepository extends MongoRepository<Student, String> {
}
