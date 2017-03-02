package com.mytest.shiro.realmModule;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by miyan(弥彦) on 2017/3/1 18:03.
 */
public class JdbcTemplateUtils {

    private JdbcTemplateUtils(){}

    public static JdbcTemplate getJdbcTemplate(){
        return Template.jdbcTemplate;
    }
    private static class Template{
        private static JdbcTemplate jdbcTemplate =createJdbcTemplate();
    }
    private static JdbcTemplate createJdbcTemplate() {
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/shiro");
        ds.setUsername("root");
        ds.setPassword("");
        return new JdbcTemplate(ds);
    }
}
