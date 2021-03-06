package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.models.Lesson;
import ru.itis.perositories.LessonRepository;


@Service
public class LessonServiceImpl implements LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    @Override
    public Lesson finish(String id) {
        Lesson lesson = lessonRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        lesson.finish();
        lessonRepository.save(lesson);
        return lesson;
    }
}
