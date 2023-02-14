package com.ioffice.DataMigrationAPI.repository.mysql;

import com.ioffice.DataMigrationAPI.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMysqlRepository
        extends JpaRepository<Order,Integer> {
}
