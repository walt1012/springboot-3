package com.wushang.datasource;

import com.mysql.cj.jdbc.MysqlXADataSource;
import com.wushang.dbconfig.DBConfig1;
import com.wushang.dbconfig.DBConfig2;
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
 * @ClassName DataSource02
 * @Description TODO
 * @Author wushang
 * @Date 2019-09-10 23:57
 */
//
// @Configuration
// @MapperScan(basePackages = "com.wushang.test2.mapper", sqlSessionFactoryRef = "test2SqlSessionFactory")
// public class DataSource02 {
//
// 	@Bean(name = "test2DataSource")
// 	@ConfigurationProperties(prefix = "spring.datasource.test2")
// 	public DataSource dataSource() {
// 		return DataSourceBuilder.create().build();
// 	}
//
// 	@Bean(name = "test2SqlSessionFactory")
// 	public SqlSessionFactory sqlSessionFactory(@Qualifier("test2DataSource") DataSource ds) throws Exception {
// 		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
// 		bean.setDataSource(ds);
// 		return bean.getObject();
// 	}
//
// 	@Bean(name = "test2TransactionManager")
// 	public DataSourceTransactionManager transactionManager(@Qualifier("test2DataSource") DataSource dataSource) {
// 		return new DataSourceTransactionManager(dataSource);
// 	}
//
// 	@Bean(name = "test2SqlSessionTemplate")
// 	public SqlSessionTemplate sqlSessionTemplate(@Qualifier("test2SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
// 		return new SqlSessionTemplate(sqlSessionFactory);
// 	}
//
//
// }


@Configuration
@MapperScan(basePackages = "com.wushang.test2.mapper", sqlSessionFactoryRef = "test2SqlSessionFactory")
public class DataSource02 {

	//配置数据源
	@Bean(name = "test2DataSource")
	public DataSource testDataSource(DBConfig2 testConfig) throws Exception {
		MysqlXADataSource mysqlXADataSource = new MysqlXADataSource();
		mysqlXADataSource.setUrl(testConfig.getUrl());
		mysqlXADataSource.setPinGlobalTxToPhysicalConnection(true);
		mysqlXADataSource.setUser(testConfig.getUsername());
		mysqlXADataSource.setPassword(testConfig.getPassword());

		AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
		xaDataSource.setXaDataSource(mysqlXADataSource);
		xaDataSource.setUniqueResourceName("test2DataSource");

		return xaDataSource;
	}

	@Bean(name = "test2SqlSessionFactory")
	public SqlSessionFactory testSqlSessionFactory(@Qualifier("test2DataSource") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		return bean.getObject();
	}

	@Bean(name = "test2SqlSessionTemplate")
	public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("test2SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}