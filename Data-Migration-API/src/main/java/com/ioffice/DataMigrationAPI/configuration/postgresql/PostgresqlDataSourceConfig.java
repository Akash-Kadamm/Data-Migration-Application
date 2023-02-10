package com.ioffice.DataMigrationAPI.configuration.postgresql;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;
import java.util.HashMap;




/*
 * ****  Postgresql data source  configurations ********
 *
 * */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "postgresqlEntityManagerFactory",
        transactionManagerRef = "postgresqlTransactionManager",
        basePackages = "com.ioffice.DataMigrationAPI.repository.postgresql"

        )
public class PostgresqlDataSourceConfig {
    /*
     * Create DataSource object which make database connection.
     *
     * @param
     * @return DataSource object
     * */
    @Bean
    @ConfigurationProperties(prefix="postgresql.datasource")
    public DataSource db1DataSource() {
        return DataSourceBuilder.create().build();
    }


    /*
     * Creating EntityManagerFactoryBean object which provides all the operation of database.
     *
     * @param EntityManagerFactoryBuilder
     * @return LocalContainerEntityManagerFactoryBean object
     *
     * */
    @Bean
    public LocalContainerEntityManagerFactoryBean db1EntityManagerFactory(
            EntityManagerFactoryBuilder builder
            ) {
        HashMap<String , Object> properties=new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        return  builder
                .dataSource(db1DataSource())
                .packages("com.ioffice.DataMigrationAPI.model")
                .properties(properties)
                .build();
    }

    /*
     * Creating Transaction Manager bean for making transactions.
     *
     * @param EntityManagerFactory object
     * @return JpaTransactionManager object
     *
     * */
    @Bean
    public PlatformTransactionManager db1TransactionManager(
            @Qualifier("postgresqlEntityManagerFactory")
            EntityManagerFactory entityManagerFactory
            ) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
