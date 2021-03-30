package com.miniSchool.MiniSchool.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "instructor_id ")
    private Long instructorId;

    @Column(name = "instuctor_first_name")
    private String instructorFirstName;

    @Column(name = "instuctor_last_name")
    private String instructorLastName;


}
