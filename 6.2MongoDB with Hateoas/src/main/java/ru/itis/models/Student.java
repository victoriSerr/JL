package ru.itis.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Document(collection = "students")
public class Student implements Serializable {

    @Id
    private String id;

    private String firstName;
    private String lastName;

    private List<Course> courses;

    private List<Review> reviews;
}
