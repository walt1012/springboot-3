package com.wushang.datasource;

import com.mysql.cj.jdbc.MysqlXAConnection;
import com.mysql.cj.jdbc.MysqlXADataSource;
import com.wushang.dbconfig.DBConfig1;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @ClassName DataSource01
 * @Description TODO
 * @Author wushang
 * @Date 2019-09-10 23:57
 */

// @Configuration
// @MapperScan(basePackages = "com.wushang.test1.mapper", sqlSessionFactoryRef = "test1SqlSessionFactory")
// public class DataSource01 {
//
// 	@Bean(name = "test1DataSource")
// 	@Primary//主数据源,一个应用只能有一个主数据源
// 	@ConfigurationProperties(prefix = "spring.datasource.test1")
// 	public DataSource dataSource() {
// 		return DataSourceBuilder.create().build();
// 	}
//
// 	@Bean(name = "test1SqlSessionFactory")
// 	public SqlSessionFactory sqlSessionFactory(@Qualifier("test1DataSource") DataSource ds) throws Exception {
// 		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
// 		bean.setDataSource(ds);
// 		return bean.getObject();
// 	}
//
// 	@Bean(name = "test1TransactionManager")
// 	@Primary//主事务
// 	public DataSourceTransactionManager transactionManager(@Qualifier("test1DataSource") DataSource dataSource) {
// 		return new DataSourceTransactionManager(dataSource);
// 	}
//
// 	@Bean(name = "test1SqlSessionTemplate")
// 	public SqlSessionTemplate sqlSessionTemplate(@Qualifier("test1SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
// 		return new SqlSessionTemplate(sqlSessionFactory);
// 	}
//
//
// }

@Configuration
@MapperScan(basePackages = "com.wushang.test1.mapper", sqlSessionFactoryRef = "test1SqlSessionFactory")
public class DataSource01 {

	//配置数据源
	@Primary
	@Bean(name = "test1DataSource")
	public DataSource testDataSource(DBConfig1 testConfig) throws Exception {
		MysqlXADataSource mysqlXADataSource = new MysqlXADataSource();
		mysqlXADataSource.setUrl(testConfig.getUrl());
		mysqlXADataSource.setPinGlobalTxToPhysicalConnection(true);
		mysqlXADataSource.setUser(testConfig.getUsername());
		mysqlXADataSource.setPassword(testConfig.getPassword());

		AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
		xaDataSource.setXaDataSource(mysqlXADataSource);
		xaDataSource.setUniqueResourceName("test1DataSource");

		return xaDataSource;
	}

	@Bean(name = "test1SqlSessionFactory")
	public SqlSessionFactory testSqlSessionFactory(@Qualifier("test1DataSource") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		return bean.getObject();
	}

	@Bean(name = "test1SqlSessionTemplate")
	public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("test1SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}