package ru.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itis.models.Lesson;

import java.util.*;

public interface LessonRepository extends JpaRepository<Lesson, Long> {

}
