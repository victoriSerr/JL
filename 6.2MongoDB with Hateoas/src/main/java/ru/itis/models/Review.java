package ru.itis.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "reviews")
public class Review implements Serializable {

    @Id
    private String id;

    @DBRef
    private Teacher teacher;

    @DBRef
    private Student student;

    private String text;

    private Status status;

    public enum Status {
        REQUESTED, REPLIED
    }

    public void reply() {
        if (this.status.equals(Status.REQUESTED)) {
            this.status = Status.REPLIED;
        } else if (this.status.equals(Status.REPLIED)) {
            throw new IllegalStateException();
        }
    }
}
