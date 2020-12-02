package ru.itis.spring;

import org.bson.types.ObjectId;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import ru.itis.models.Course;
import ru.itis.models.Student;

import java.util.*;
import java.util.Collections;

public class StudentRepository {


    public static void save(MongoTemplate template, Student student) {
        template.save(student, "students");
    }

    public static List<Student> findAll(MongoTemplate template) {
        return template.findAll(Student.class, "students");
    }

    public static void update(MongoTemplate template, Student student) {

        template.save(student, "students");
    }

    public static void delete(MongoTemplate template, String id) {
        template.remove(new Query().addCriteria(Criteria.where("_id").is(new ObjectId(id))), "students");
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MongoConfig.class);
        MongoTemplate template = context.getBean(MongoTemplate.class);

        Course course = Course.builder()
                .name("aaaaaaaaa").build();

        Student student = Student.builder()
                .firstName("asd")
                .lastName("asd")
                .courses(Collections.singletonList(course))
                .build();

//        save(template, student);

//        System.out.println(findAll(template));

        student.setFirstName("update");
//        update(template, student);

        delete(template, "5fc654d912a3324213fe2d9f");
        System.out.println(findAll(template));

    }
}
