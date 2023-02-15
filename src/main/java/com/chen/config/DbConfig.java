package com.chen.config;

import com.chen.DataSourceUtils;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author @Chenxc
 * @Date 2023/2/15 11:52
 */
@Configuration
@ComponentScan(basePackages = "com.chen")
@EnableTransactionManagement
public class DbConfig {

    @Bean
    public DataSource dataSource(){
        return DataSourceUtils.getDataSource();
    }

    @Bean
    public JdbcTemplate template(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

}
