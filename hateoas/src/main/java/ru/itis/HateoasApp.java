package ru.itis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.itis.models.Course;
import ru.itis.models.Lesson;
import ru.itis.models.Student;
import ru.itis.repository.CourseRepository;
import ru.itis.repository.LessonRepository;
import ru.itis.repository.StudentRepository;

import java.util.Collections;

@SpringBootApplication
public class HateoasApp {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(HateoasApp.class);

        StudentRepository studentRepository = context.getBean(StudentRepository.class);
        CourseRepository courseRepository = context.getBean(CourseRepository.class);
        LessonRepository lessonRepository = context.getBean(LessonRepository.class);

        Course course = Course.builder()
                .name("course")
                .description("sdf")
                .build();

        courseRepository.save(course);

        Lesson lesson = Lesson.builder()
                .name("less")
                .description("asd")
                .course(course)
                .build();

        lessonRepository.save(lesson);
        Student student = Student.builder()
                .firstName("asd")
                .lastName("asd")
                .courses(Collections.singletonList(course))
                .build();

        studentRepository.save(student);
    }
}
