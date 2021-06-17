package com.hclim.movein;

import static org.junit.Assert.fail;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })
@Log4j
public class DBConnectionTest {

	@Inject
	private DataSource ds;

//	@Ignore
	@Test
	public void testConnection() {
		try (Connection conn = ds.getConnection()) {
			log.info("DB Connection Success \n" + conn);
		} catch (Exception e) {
			// TODO: handle exception
			log.info("DB Connection Fail");
			fail(e.getMessage());
		}
	}

}
