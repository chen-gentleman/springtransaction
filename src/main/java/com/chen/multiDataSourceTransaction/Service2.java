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
public class Service2 {
    @Autowired
    private JdbcTemplate template1;


    @Transactional(transactionManager = "transactionManager1", propagation = Propagation.REQUIRED)
    public void m2(){
        template1.update("insert into t_employee (emp_name,team_id) values ('陈杏昌0217',4)");
    }
}
