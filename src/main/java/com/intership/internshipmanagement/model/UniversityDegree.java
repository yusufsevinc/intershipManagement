package com.intership.internshipmanagement.model;

import com.intership.internshipmanagement.enums.Degree;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "university_degree")
@NoArgsConstructor
@AllArgsConstructor
public class UniversityDegree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "degree_id")
    private Long degreeId;

    @Range(min = 0, max = 2)
    @Column(name = "degree" , nullable = false )
    private Degree degree;


    @ManyToMany(mappedBy = "degrees", cascade = CascadeType.PERSIST)
    private List<Teacher> teachers;

    @OneToMany(mappedBy = "universityDegree")
    private List<Student> students;

    @Override
    public String toString() {
        return "UniversityDegree{" +
                "degreeId=" + degreeId +
                ", degree=" + degree +
                '}';
    }
}
