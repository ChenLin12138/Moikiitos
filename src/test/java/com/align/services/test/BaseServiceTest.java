package com.align.services.test;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.align.config.DataSourceConfig;
import com.align.config.MybatisMapperConfig;

/**
 * @author Chen Lin
 * @date 2019-10-02
 */
@RunWith(SpringRunner.class)
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(classes = { DataSourceConfig.class, MybatisMapperConfig.class })
@ComponentScan(value="com.align.*")
public class BaseServiceTest {

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	@Test
	public void dummp() {
	}
}
