package com.stubhub.devops.spanneroperation.configuration;

import com.stubhub.devops.spanneroperation.datamodel.repository.userpref.UserPrefRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
@EnableJpaRepositories(basePackageClasses = {UserPrefRepository.class},entityManagerFactoryRef = "userEntityManager",
        transactionManagerRef = "userTransactionManager")
public class PersistenceUserPrefConfiguration {

    @Autowired
    private Environment env;

    @Bean
    @ConfigurationProperties(prefix="spring.userpref.datasource")
    public DataSource userDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean userEntityManager() {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(userDataSource());
        em.setPackagesToScan(
                new String[] { "com.stubhub.devops.spanneroperation.datamodel.repository.userpref","com.stubhub.devops.spanneroperation.datamodel.entity" });

        HibernateJpaVendorAdapter vendorAdapter
                = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.dialect",
                env.getProperty("spring.jpa.database-platform"));
        em.setJpaPropertyMap(properties);
        return em;
    }

    @Bean
    public PlatformTransactionManager userTransactionManager() {

        JpaTransactionManager transactionManager
                = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
                userEntityManager().getObject());
        return transactionManager;
    }
}
