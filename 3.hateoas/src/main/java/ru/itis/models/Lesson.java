package ru.itis.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Lesson implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private boolean isFinished;

    @ManyToOne
    private Course course;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "lesson_skill",
            joinColumns = @JoinColumn(name = "lesson_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private List<Skill> skills;

    public void finish() {
        if (!this.isFinished) {
            this.isFinished = true;
        } else {
            throw new IllegalStateException();
        }
    }
}
