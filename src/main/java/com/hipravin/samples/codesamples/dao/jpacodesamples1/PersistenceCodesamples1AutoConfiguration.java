package com.hipravin.samples.codesamples.dao.jpacodesamples1;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
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

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.hipravin.samples.codesamples.dao.jpacodesamples1",
        entityManagerFactoryRef = "codesamples1EntityManagerFactory",
        transactionManagerRef= "codesamples1TransactionManager"
)
public class PersistenceCodesamples1AutoConfiguration {
    @Bean
    @Primary
    @ConfigurationProperties("spring.codesamples1ds")
    public DataSourceProperties codesamples1DataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    @ConfigurationProperties("spring.codesamples1ds.configuration")
    public DataSource codesamples1DataSource() {
        return codesamples1DataSourceProperties().initializeDataSourceBuilder()
                .type(HikariDataSource.class).build();
    }

    @Primary
    @Bean(name = "codesamples1EntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean memberEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(codesamples1DataSource())
                .packages(MeetingEntity.class)
                .build();

    }

    @Primary
    @Bean
    public PlatformTransactionManager codesamples1TransactionManager(
            final @Qualifier("codesamples1EntityManagerFactory") LocalContainerEntityManagerFactoryBean codesamples1EntityManagerFactory) {
        return new JpaTransactionManager(codesamples1EntityManagerFactory.getObject());
    }

}