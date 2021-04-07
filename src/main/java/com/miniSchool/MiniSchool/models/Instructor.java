package com.miniSchool.MiniSchool.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "instructor_id ")
    private Long instructorId;

    @Column(name = "instuctor_first_name")
    @NonNull
    private String instructorFirstName;

    @Column(name = "instuctor_last_name")
    @NonNull
    private String instructorLastName;

    public Instructor(String instructorFirstName, String instructorLastName) {
        this.instructorFirstName = instructorFirstName;
        this.instructorLastName = instructorLastName;
    }
}
