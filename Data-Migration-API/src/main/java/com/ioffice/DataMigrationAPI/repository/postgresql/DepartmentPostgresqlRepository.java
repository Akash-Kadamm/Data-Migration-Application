package com.ioffice.DataMigrationAPI.repository.postgresql;

import com.ioffice.DataMigrationAPI.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentPostgresqlRepository
        extends JpaRepository<Department,Integer> {
}
