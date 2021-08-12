package com.intership.internshipmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "projects")
@NoArgsConstructor
@AllArgsConstructor
public class Project  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Long projectId;

    @Column(name = "project_name" , nullable = false)
    private String name;

    @Column(name = "project_explanation" , nullable = false)
    private String explanation;

    @Column(name = "project_content",nullable = false)
    private String content;


}
