package com.app.demo.config;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.app.demo" })
@PropertySource( value = { "classpath:jdbc.properties" } )
@MapperScan( "com.app.demo.mapper" )
public class AppConfigDAO
{
	@Autowired
	private Environment env;
	
	@Bean
	public DataSource dataSource()
	{
		DriverManagerDataSource driverManager = new DriverManagerDataSource();
		
		driverManager.setDriverClassName( env.getProperty( "jdbc.driverClassName" ) );
		driverManager.setUsername( env.getProperty( "jdbc.username" ) );
		driverManager.setPassword( env.getProperty( "jdbc.password" ) );
		driverManager.setUrl( env.getProperty( "jdbc.url" ) );
		
		return driverManager;
	}
	
	@Bean
	public DataSourceTransactionManager transactionManager()
	{
		return new DataSourceTransactionManager( dataSource() );
	}
	
	@Bean
	public SqlSessionFactoryBean sqlSessionFactory()
	{
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		
		sessionFactory.setDataSource( dataSource() );
		sessionFactory.setTypeAliasesPackage( "com.app.demo.entidad" );
		sessionFactory.setTypeHandlersPackage( "com.app.demo.typehandler" );
		
		return sessionFactory;
	}
}
