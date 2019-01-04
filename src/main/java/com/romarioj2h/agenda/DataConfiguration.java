package com.romarioj2h.agenda;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.romarioj2h.agenda.models.Contacto;

import org.hibernate.SessionFactory;

@Configuration
@ComponentScan
public class DataConfiguration {

	@Bean
	public DataSource dataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		basicDataSource.setUrl("jdbc:mysql://localhost:3306/agenda?useSSL=false");
		basicDataSource.setUsername("root");
		basicDataSource.setPassword("123");
		return basicDataSource;
	}
	
	@Bean
	public SessionFactory hibernateTransactionManager() {
		LocalSessionFactoryBean localSessionFactoryBean = this.getLocalSessionFactoryBean();
		return localSessionFactoryBean.getObject();
	}
	
	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		properties.put("hibernate.show_sql", true);
		properties.put("hibernate.format_sql", true);
		return properties;
	}
	
	private LocalSessionFactoryBean getLocalSessionFactoryBean() {
		LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
		localSessionFactoryBean.setDataSource(this.dataSource());
		localSessionFactoryBean.setPackagesToScan("com.romarioj2h.agenda.models");
		Properties properties = this.getHibernateProperties();
		localSessionFactoryBean.setHibernateProperties(properties);
		try {
			localSessionFactoryBean.afterPropertiesSet();
		} catch (IOException e) {
		    e.printStackTrace();
		}
		return localSessionFactoryBean;
	}
}
