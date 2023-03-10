package com.chen;

import org.apache.tomcat.jdbc.pool.DataSource;


/**
 * @Author @Chenxc
 * @Date 2023/2/14 10:40
 */
public class DataSourceUtils {
    public static DataSource getDataSource(){
        DataSource dataSource = new DataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://192.168.0.56:3306/test?characterEncoding=UTF-8");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        dataSource.setInitialSize(5);
        return dataSource;
    }
    public static DataSource getDataSource2(){
        DataSource dataSource = new DataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://192.168.0.56:3306/h_test1?characterEncoding=UTF-8");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        dataSource.setInitialSize(5);
        return dataSource;
    }

}
