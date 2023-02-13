package com.ioffice.DataMigrationAPI.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table( name="users")
@ToString
public class User {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    @Column
    private String userName;
    @Column
    private String userEmail;
    @Column
    private String userPassword;
    @Column
    private String userCompanyName;
    @OneToOne
    @JoinColumn(name=" departmentId")
    private Department department;



}
