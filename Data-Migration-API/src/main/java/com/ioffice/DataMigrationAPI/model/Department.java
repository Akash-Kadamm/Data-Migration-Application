package com.ioffice.DataMigrationAPI.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table( name="departments")
@ToString
public class Department {
    @Id
    @Column(name = "department_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int departmentId;
    @Column(name = "department_name")
    private String departmentName;
    @Column(name = "designation")
    private String designation;




}
