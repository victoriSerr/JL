package ru.itis.perositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.itis.models.Lesson;

import java.util.*;

public interface LessonRepository extends MongoRepository<Lesson, String> {

    List<Lesson> findAllByFinishedIsFalse();
}
