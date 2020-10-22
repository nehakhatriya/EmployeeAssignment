package com.employee.config;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:persistence-mysql.properties")
public class DatabaseConfig {

	@Autowired 
	private Environment env;
	
	@Bean
	public DataSource getDataSource() {
		ComboPooledDataSource securityDataSource = new ComboPooledDataSource();
		
		try {
			securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {
			throw new RuntimeException(e);
		}
		securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		securityDataSource.setUser(env.getProperty("jdbc.user"));
		securityDataSource.setPassword(env.getProperty("jdbc.password"));
		
		securityDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		securityDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		securityDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
		securityDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
		
		return securityDataSource;
	}
	
	private int getIntProperty(String str) {
		String prop=env.getProperty(str);
		int val=Integer.parseInt(prop);
		return val;
	}
	
	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		 sessionFactoryBean.setPackagesToScan("com.employee");
		 sessionFactoryBean.setDataSource(getDataSource());
		 sessionFactoryBean.setHibernateProperties(getHibernateProperties());
		 
		 return sessionFactoryBean;
	}

	@Bean
    public HibernateTransactionManager getTransactionManager() throws IOException{
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
       transactionManager.setSessionFactory(getSessionFactory().getObject());

        return transactionManager;
   }
	
	private Properties getHibernateProperties() {
		 Properties hibernateProperties = new Properties();
	        hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
	        hibernateProperties.put("hibernate.show_sql", true);

	        return hibernateProperties;
	}
}
