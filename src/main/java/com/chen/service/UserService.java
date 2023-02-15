package com.chen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author @Chenxc
 * @Date 2023/2/15 11:49
 */
@Component
public class UserService {

    @Autowired
    private JdbcTemplate template;


    @Transactional
    public void insert(){
        template.update("insert into t_employee (emp_name,team_id) values (?,?)","20",23);
        //int i =1/0;
        template.update("insert into t_employee (emp_name,team_id) values (?,?)","02",15);
    }

}
