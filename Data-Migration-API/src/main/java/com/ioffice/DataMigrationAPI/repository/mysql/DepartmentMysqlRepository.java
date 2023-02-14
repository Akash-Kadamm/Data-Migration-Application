package com.ioffice.DataMigrationAPI.repository.mysql;

import com.ioffice.DataMigrationAPI.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentMysqlRepository
        extends JpaRepository<Department,Integer> {
}
