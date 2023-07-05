package com.stackroute.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
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

@Configuration
@ComponentScan("com.stackroute")
@EnableTransactionManagement
@PropertySource({"classpath:application.properties"})
public class DbConfig {
	
	@Autowired
	private Environment env;
	
	//DataSource
	@Bean
	public DataSource getDataSource() {
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setDriverClassName(env.getProperty("jdbc.driver"));
		dataSource.setUrl(env.getProperty("jdbc.url"));
		dataSource.setUsername(env.getProperty("jdbc.username"));
		dataSource.setPassword(env.getProperty("jdbc.password"));
		
		return dataSource;
	}
	
	//Hibernate properties
	final Properties hibernateProperties() {
		final Properties hibernateProp = new Properties();
		hibernateProp.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		hibernateProp.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		hibernateProp.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
		return hibernateProp;
	}
	
	//SessionFactory
	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(getDataSource());
		sessionFactory.setPackagesToScan("com.stackroute.model");
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}
	
	//TransactionManagement
	@Bean
	public PlatformTransactionManager getTransactionManager() {
		return new HibernateTransactionManager(getSessionFactory().getObject());
	}

}
