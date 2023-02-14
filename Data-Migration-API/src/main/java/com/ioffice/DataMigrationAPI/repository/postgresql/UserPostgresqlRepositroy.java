package com.ioffice.DataMigrationAPI.repository.postgresql;

import com.ioffice.DataMigrationAPI.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPostgresqlRepositroy
        extends JpaRepository<User,Integer> {
}
