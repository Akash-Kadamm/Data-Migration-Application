package com.ioffice.DataMigrationAPI.repository.mysql;

import com.ioffice.DataMigrationAPI.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMysqlRepository
        extends JpaRepository<User,Integer> {

    @Query(
            value = "select * from users where user_company_name=?1 ",
            nativeQuery = true
    )
     List<User> getByUserCompanyName(String companyName);

}
