package nl.yestelecom;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource({ "classpath:hibernate.properties",
		"classpath:database.properties" })
public class JpaConfig {

	@Autowired
	private Environment env;

	@Bean
	public DataSource dataSource() {
		BasicDataSource dsProvider = new BasicDataSource();
		dsProvider.setDriverClassName(env.getProperty("database.driver"));
		dsProvider.setUrl(env.getProperty("database.url"));
		dsProvider.setUsername(env.getProperty("database.user"));
		dsProvider.setPassword(env.getProperty("database.password"));
		return dsProvider;
	}

}
