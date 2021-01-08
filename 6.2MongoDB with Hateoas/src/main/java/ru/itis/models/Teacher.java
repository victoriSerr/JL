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
@Document(collection = "teachers")
public class Teacher implements Serializable {

    @Id
    private Long id;

    private String name;
    private String surname;
    private String institute;

    private List<Course> courses;

    private List<Review> reviews;
}
