package com.hipravin.samples.codesamples.dao.jpacodesamples2;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.hipravin.samples.codesamples.dao.jpacodesamples2",
        entityManagerFactoryRef = "codesamples2EntityManagerFactory",
        transactionManagerRef= "codesamples2TransactionManager"
)
public class PersistenceCodesamples2AutoConfiguration {
    @Bean
    @ConfigurationProperties("spring.codesamples2ds")
    public DataSourceProperties codesamples2DataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("spring.codesamples2ds.configuration")
    public DataSource codesamples2DataSource() {
        return codesamples2DataSourceProperties().initializeDataSourceBuilder()
                .type(HikariDataSource.class).build();
    }

    @Bean(name = "codesamples2EntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean memberEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(codesamples2DataSource())
                .packages(MeetingEntity.class)
                .build();

    }

    @Bean
    public PlatformTransactionManager codesamples2TransactionManager(
            final @Qualifier("codesamples2EntityManagerFactory") LocalContainerEntityManagerFactoryBean codesamples2EntityManagerFactory) {
        return new JpaTransactionManager(codesamples2EntityManagerFactory.getObject());
    }

    @Bean(name = "jdbcTemplateCodesamples2")
    public JdbcTemplate jdbcTemplateCodesamples2() {
        return new JdbcTemplate(codesamples2DataSource());
    }


}