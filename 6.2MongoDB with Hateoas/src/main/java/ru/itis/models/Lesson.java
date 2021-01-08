package ru.itis.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Document(collection = "lessons")
public class Lesson implements Serializable {

    @Id
    private String id;

    private String name;

    private String description;

    private boolean finished;

    @DBRef
    private Course course;

    private List<Skill> skills;


    public void finish() {
        if (!this.finished) {
            this.finished = true;
        } else {
            throw new IllegalStateException();
        }
    }

}
