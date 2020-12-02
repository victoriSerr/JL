package ru.itis.models;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "courses")
public class Course implements Serializable {

    private String _id;

    private String name;

    private String description;

    private Teacher teacher;

    private List<Lesson> lessons;

    @Override
    public String toString() {
        return "Course{" +
                "_id='" + _id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", teacher=" + teacher +
                ", lessons=" + lessons +
                '}';
    }

    private List<Student> students;
}
