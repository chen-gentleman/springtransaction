package com.chen.multiDataSourceTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author @Chenxc
 * @Date 2023/2/17 10:09
 */
@Service
public class Service1 {

    @Autowired
    private JdbcTemplate template1;

    @Autowired
    private Service2 service2;

    @Transactional(transactionManager = "transactionManager1",propagation = Propagation.REQUIRED)
    public void m1(){
        template1.update("insert into t_employee (emp_name,team_id) values ('陈杏昌2023',4)");
        service2.m2();
    }

}
