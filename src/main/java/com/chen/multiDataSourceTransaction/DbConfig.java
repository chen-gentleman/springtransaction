package com.chen.multiDataSourceTransaction;

import com.chen.DataSourceUtils;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**2个数据源和2个事务管理器
 * @Author @Chenxc
 * @Date 2023/2/17 10:03
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.chen.multiDataSourceTransaction")
public class DbConfig {

    @Bean
    public DataSource dataSource1(){
        return DataSourceUtils.getDataSource();
    }

    @Bean
    public PlatformTransactionManager transactionManager1(DataSource dataSource1){
        return new DataSourceTransactionManager(dataSource1);
    }


    @Bean
    public DataSource dataSource2(){
        return DataSourceUtils.getDataSource2();
    }


    @Bean
    public PlatformTransactionManager transactionManager2(DataSource dataSource2){
        return new DataSourceTransactionManager(dataSource2);
    }

    @Bean
    public JdbcTemplate template1(DataSource dataSource1){
        return new JdbcTemplate(dataSource1);
    }

    @Bean
    public JdbcTemplate template2(DataSource dataSource2){
        return new JdbcTemplate(dataSource2);
    }

}
