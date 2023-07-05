package com.stackroute.newz.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/*This class will contain the application-context for the application. 
 * Define the following annotations:
 * @Configuration - Annotating a class with the @Configuration indicates that the 
 *                  class can be used by the Spring IoC container as a source of 
 *                  bean definitions
 * @EnableTransactionManagement - Enables Spring's annotation-driven transaction management capability.
 *                  
 * */
@Configuration
@ComponentScan("com.stackroute.newz.dao")
@EnableTransactionManagement
@PropertySource({ "classpath:application.properties" })
public class ApplicationContextConfig {

    /*
     * Define the bean for DataSource. In our application, we are using MySQL as the
     * dataSource. To create the DataSource bean, we need to know: 1. Driver class
     * name 2. Database URL 3. UserName 4. Password
     */
    @Autowired
    private Environment env;

    // DataSource
    @Bean
    public DataSource getDataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(env.getProperty("jdbc.driver"));
        dataSource.setUrl(env.getProperty("jdbc.url"));
        dataSource.setUsername(env.getProperty("jdbc.username"));
        dataSource.setPassword(env.getProperty("jdbc.password"));
        return dataSource;
    }

    // Hibernate properties
    final Properties hibernateProperties() {
        final Properties hibernateProp = new Properties();
        hibernateProp.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
        hibernateProp.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        hibernateProp.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        return hibernateProp;
    }
    /*
     * Use this configuration while submitting solution in hobbes.
     * dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
     * dataSource.setUrl("jdbc:mysql://" + System.getenv("MYSQL_HOST") + ":3306/" +
     * System.getenv("MYSQL_DATABASE")
     * +"?verifyServerCertificate=false&useSSL=false&requireSSL=false");
     * dataSource.setUsername(System.getenv("MYSQL_USER"));
     * dataSource.setPassword(System.getenv("MYSQL_PASSWORD"));
     */

    /*
     * Define the bean for SessionFactory. Hibernate SessionFactory is the factory
     * class through which we get sessions and perform database operations.
     */

    // SessionFactory
    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(getDataSource());
        sessionFactory.setPackagesToScan("com.stackroute.newz.model");
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    /*
     * Define the bean for Transaction Manager. HibernateTransactionManager handles
     * transaction in Spring. The application that uses single hibernate session
     * factory for database transaction has good choice to use
     * HibernateTransactionManager. HibernateTransactionManager can work with plain
     * JDBC too. HibernateTransactionManager allows bulk update and bulk insert and
     * ensures data integrity.
     */
    // TransactionManagement
    @Bean
    public PlatformTransactionManager getTransactionManager() {
        return new HibernateTransactionManager(getSessionFactory().getObject());
    }

}
