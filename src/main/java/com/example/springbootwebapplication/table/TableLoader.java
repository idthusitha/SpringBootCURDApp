package com.example.springbootwebapplication.table;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.springbootwebapplication.utilities.CommonUtils;

@Component
public class TableLoader {

	static Logger logger = LoggerFactory.getLogger(TableLoader.class);

	public TableLoader() {
		checkTabale();
	}

	private void checkTabale() {
		String uuid = UUID.randomUUID().toString();
		Properties prop = CommonUtils.getInstance().getProperties();

		try {
			JdbcTemplate jdbcTemplate = new CustomJDBCTemplate().getJDBCTemplate();
			DatabaseMetaData dbm = jdbcTemplate.getDataSource().getConnection().getMetaData();
			String tableNameList[] = prop.getProperty("data.table.list").split(",");

			for (String tableName : tableNameList) {
				ResultSet tables = dbm.getTables(null, null, "rezos_common." + tableName, null);
				if (!tables.next()) {
					logger.info("ELK<~>" + uuid + "<~>S<~>table status<~>" + tableName + " Not available in this server...");
					createTable(jdbcTemplate, tableName);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void createTable(JdbcTemplate jdbcTemplate, String tableName) {
		String uuid = UUID.randomUUID().toString();
		try {
			String tableScript = CommonUtils.getInstance().getFile(tableName + ".sql");
			logger.info("ELK<~>" + uuid + "<~>S<~>tableScript<~>" + tableScript);
			logger.debug(tableScript);

			jdbcTemplate.execute(tableScript);

			logger.warn(tableName + " created...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
