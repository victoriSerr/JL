package ru.itis.controllers;

import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.dto.StudentDto;
import ru.itis.models.Course;
import ru.itis.models.Student;
import ru.itis.repository.StudentRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class SearchController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/student/search")
    public ResponseEntity<List<StudentDto>> searchStudentsByPredicate(
            @QuerydslPredicate(root = Student.class) Predicate predicate
    ) {
        return ResponseEntity.ok(StreamSupport.stream(studentRepository.findAll(predicate).spliterator(), true)
        .map(student -> StudentDto.builder()
        .firstName(student.getFirstName())
        .lastName(student.getLastName())
        .courses(student.getCourses().stream().map(Course::getName).collect(Collectors.toList()))
        .build()).collect(Collectors.toList()));
    }
}
