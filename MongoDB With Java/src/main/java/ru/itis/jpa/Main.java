package ru.itis.jpa;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itis.models.Course;
import ru.itis.models.Lesson;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(RepositoriesConfig.class);

        LessonRepository lessonRepository = context.getBean(LessonRepository.class);


        Lesson lesson = Lesson.builder()
                .name("aaaaaaaaaa")
                .isFinished(false)
                .description("asdfasd")
                .build();


        lessonRepository.save(lesson);
    }
}
