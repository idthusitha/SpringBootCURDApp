package com.example.springbootwebapplication.table;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.jdbc.core.JdbcTemplate;
import com.example.springbootwebapplication.utilities.CommonUtils;

public class CustomJDBCTemplate {

	public JdbcTemplate getJDBCTemplate() {
		JdbcTemplate jdbcTemplate = null;
		Properties props = CommonUtils.getInstance().getProperties();

		String driverClassName = props.getProperty("spring.datasource.driverclassname");
		String url = props.getProperty("spring.datasource.url");
		String userName = props.getProperty("spring.datasource.username");
		String password = props.getProperty("spring.datasource.password");

		DataSource dataSource = DataSourceBuilder.create().driverClassName(driverClassName).url(url).username(userName).password(password).build();
		jdbcTemplate = new JdbcTemplate(dataSource);

		return jdbcTemplate;
	}
}
