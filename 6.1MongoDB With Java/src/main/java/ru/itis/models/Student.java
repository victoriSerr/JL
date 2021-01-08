package ru.itis.models;

import lombok.*;

//import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Student implements Serializable {

    private String id;

    private String firstName;
    private String lastName;

    private List<Course> courses;

    private List<Review> reviews;
}
