package com.ioffice.DataMigrationAPI.configuration.mysql;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;
import java.util.HashMap;



/*
 * ***** Mysql data source Configurations ******
 *
 * */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "mysqlEntityManagerFactory",
        transactionManagerRef = "mysqlTransactionManager",
        basePackages = "com.ioffice.DataMigrationAPI.repository.mysql"

        )
public class MysqlDataSourceConfig {
    /*
     * Create DataSource object which make database connection.
     *
     * @param
     * @return DataSource object
     * */
    @Primary
    @Bean
    @ConfigurationProperties(prefix="mysql.datasource")
    public DataSource mysqlDataSource() {
        return DataSourceBuilder.create().build();
    }


    /*
     * Creating EntityManagerFactoryBean object which provides all the operation of database.
     *
     * @param EntityManagerFactoryBuilder
     * @return LocalContainerEntityManagerFactoryBean object
     *
     * */
    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean mysqlEntityManagerFactory(
            EntityManagerFactoryBuilder builder
             ) {
        HashMap<String , Object> properties=new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        return  builder
                .dataSource(mysqlDataSource())
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
    @Primary
    @Bean
    public PlatformTransactionManager mysqlTransactionManager(
            @Qualifier("mysqlEntityManagerFactory")
            EntityManagerFactory entityManagerFactory
            ) {
        return new JpaTransactionManager(entityManagerFactory);
    }

}
