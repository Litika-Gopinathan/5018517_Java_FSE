package com.example.EmployeeManagementSystem;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import jakarta.persistence.EntityManagerFactory;

import javax.sql.DataSource;


@Configuration
@EnableJpaRepositories(
        basePackages = "com.example.employeemanagementsystem.repository",
        entityManagerFactoryRef = "employeeEntityManagerFactory",
        transactionManagerRef = "employeeTransactionManager"
)
public class DataSourceConfiguration {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource employeeDataSource() {
        return new DriverManagerDataSource();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean employeeEntityManagerFactory(
            @Qualifier("employeeDataSource") DataSource dataSource,
            JpaProperties jpaProperties) {
        return new LocalContainerEntityManagerFactoryBean();
        // Additional Configuration
    }

    @Bean
    public PlatformTransactionManager employeeTransactionManager(
            @Qualifier("employeeEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}


