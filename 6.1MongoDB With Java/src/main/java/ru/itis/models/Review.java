package ru.itis.models;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@Entity
public class Review implements Serializable {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne
    private Teacher teacher;

//    @ManyToOne
    private Student student;

    private String text;

//    @Enumerated(EnumType.STRING)
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
