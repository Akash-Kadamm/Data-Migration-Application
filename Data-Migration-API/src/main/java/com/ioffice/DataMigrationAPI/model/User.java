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
    @Column(name = "user_name")
    private String userName;
    @Column(name="user_email")
    private String userEmail;
    @Column(name = "user_password")
    private String userPassword;
    @Column(name = "user_company_name")
    private String userCompanyName;
    @OneToOne
    @JoinColumn(name=" departmentId")
    private Department department;

    @Column(name = "is_migrate")
    private boolean isMigrate;

}
