package com.stubhub.devops.spanneroperation.configuration;

import com.stubhub.devops.spanneroperation.datamodel.repository.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * @Author: Longgui Wang
 * @Date: 2021/1/21 9:48 AM
 */
@Configuration
@PropertySource({ "classpath:datasource.properties" })
@EnableJpaRepositories(basePackageClasses = {OrderRepository.class},entityManagerFactoryRef = "orderEntityManager",
        transactionManagerRef = "orderTransactionManager")
public class PersistenceOrderConfiguration {

    @Autowired
    private Environment env;

    @Primary
    @Bean
    @ConfigurationProperties(prefix="spring.order.datasource")
    public DataSource orderDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean orderEntityManager() {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(orderDataSource());
        em.setPackagesToScan(
                new String[] { "com.stubhub.devops.spanneroperation.datamodel.repository.order","com.stubhub.devops.spanneroperation.datamodel.entity" });

        HibernateJpaVendorAdapter vendorAdapter
                = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.dialect",
                env.getProperty("spring.jpa.database-platform"));
        em.setJpaPropertyMap(properties);
        return em;
    }

    @Primary
    @Bean
    public PlatformTransactionManager orderTransactionManager() {

        JpaTransactionManager transactionManager
                = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
                orderEntityManager().getObject());
        return transactionManager;
    }
}
