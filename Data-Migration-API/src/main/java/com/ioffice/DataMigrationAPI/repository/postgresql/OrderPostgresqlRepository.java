package com.ioffice.DataMigrationAPI.repository.postgresql;

import com.ioffice.DataMigrationAPI.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderPostgresqlRepository
            extends JpaRepository<Order,Integer> {
}
