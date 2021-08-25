package br.com.communication.app.cfg;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

@Configuration
public class DatabaseConfig {
	
	@Value("${cfg.db.url}")
	private String dbUrl;
	
	@Value("${cfg.db.username}")
	private String dbUsername;
	
	@Value("${cfg.db.password}")
	private String dbPassword;
	
	@Value("${cfg.db.schemas.init}")
	private String dbInitSchema;
	
	@Bean(name = "dataSource")
    public DataSource mysqlDataSource() throws SQLException  {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(dbUrl);
	    dataSource.setUsername(dbUsername);
	    dataSource.setPassword(dbPassword);
	    return dataSource;
	}
	
	@Bean
	public DataSourceInitializer dataSourceInitializer(@Qualifier("dataSource") DataSource dataSource) {
		ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
		resourceDatabasePopulator.addScript(new ClassPathResource(dbInitSchema));			
		
		DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
		dataSourceInitializer.setDataSource(dataSource);												
		dataSourceInitializer.setDatabasePopulator(resourceDatabasePopulator);
		return dataSourceInitializer;
	}
}
