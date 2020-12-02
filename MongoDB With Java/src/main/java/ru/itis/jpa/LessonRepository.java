package ru.itis.jpa;


import org.springframework.data.mongodb.repository.MongoRepository;
import ru.itis.models.Lesson;

public interface LessonRepository extends MongoRepository<Lesson, String> {
}
