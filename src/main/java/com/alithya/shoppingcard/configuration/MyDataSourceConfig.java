package com.alithya.shoppingcard.configuration;




import javax.sql.DataSource;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@ComponentScan({"com.alithya.shoppingcard.service","com.alithya.shoppingcard.repository","com.alithya.shoppingcard.entity"})
@PropertySource("classpath:app.properties")
public class MyDataSourceConfig {
	
	@Autowired
	private Environment env;
	
	@Bean(name = "dataSource")
	@Profile("dev")
	public DataSource dataSource(){
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getProperty("db.driver"));
		dataSource.setUrl(env.getProperty("db.url"));
		dataSource.setUsername(env.getProperty("db.user"));
		dataSource.setPassword(env.getProperty("db.pass"));
		return dataSource;
	}
	
	@Bean(name = "transactionManager")
	@Profile("dev")
	public PlatformTransactionManager transactionManger(){
		return new DataSourceTransactionManager(dataSource());
	}
	
	
	@Bean(name = "dataSource" ,destroyMethod = "shutdown")
	@Profile("test")
	public DataSource dataSourceForTest(){
		return new EmbeddedDatabaseBuilder()
				.generateUniqueName(true)
				.setType(EmbeddedDatabaseType.H2)
				.setScriptEncoding("UTF-8")
				.ignoreFailedDrops(true)
				.addScript("schema.sql")
				.addScripts("data.sql")
				.build();
	}
	
	@Bean(name = "transactionManager")
	@Profile("test")
	public PlatformTransactionManager transactionMangerForTest(){
		return new DataSourceTransactionManager(dataSourceForTest());
	}
	
}
