package com.blog.website.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Configures database connection, JPA repositories and helper beans.
 * 
 * @author Jordan
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.blog.website.repository",
        entityManagerFactoryRef = "entityManagerFactory",
        transactionManagerRef = "transactionManager")
// @ComponentScan({"com.offside.feed.manager", "com.offside.core.util"})
public class DatabaseConfiguration {

    @Value("${persistence.connectionString}")
    private String url;

    @Bean
    public DataSource dataSource() throws Exception {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setMaxActive(64);
        dataSource.setMaxWait(2000);
        dataSource.setTestOnBorrow(true);
        dataSource.setValidationQuery("select 1");
        return dataSource;
    }

    @Bean
    public JpaTransactionManager transactionManager() throws Exception {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws Exception {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPersistenceUnitName("MapperEntityManagerFactory");
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan(
                "com.offside.feed.model",
                "com.offside.core.model.externalevents");
        entityManagerFactoryBean.setJpaProperties(hibernateProperties());
        return entityManagerFactoryBean;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
        properties.put("hibernate.id.new_generator_mappings", "false");
        properties.put("hibernate.show_sql", "false");
        return properties;
    }

}
