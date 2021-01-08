package ru.itis.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import ru.itis.models.Student;

public interface StudentRepository extends MongoRepository<Student, String>, QuerydslPredicateExecutor<Student> {
}
