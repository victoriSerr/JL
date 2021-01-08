package ru.itis.models;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@Entity
public class Teacher implements Serializable {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private String institute;

//    @OneToMany(cascade = CascadeType.ALL,
//            mappedBy = "teacher")
    private List<Course> courses;

//    @OneToMany(
//            mappedBy = "teacher",
//            cascade = CascadeType.ALL)
    private List<Review> reviews;
}
