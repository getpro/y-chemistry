package com.example;

import org.nutz.dao.Dao;
import org.nutz.dao.sql.Sql;
import org.nutz.dao.util.Daos;
import org.nutz.plugin.spring.boot.config.SqlManagerProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import win.i02.bean.ElementBean;

import java.util.List;

/**
 * Created by Qi on 2017/6/8.
 */
@RestController
@EnableAutoConfiguration
@EnableConfigurationProperties(SqlManagerProperties.class)
@RequestMapping("/rest")
public class IndexController {
    @Autowired
    Dao dao;
    @Autowired
    SqlManagerProperties sqlManagerProperties;

    @RequestMapping("/sql")
    public SqlManagerProperties sql(){
        return sqlManagerProperties;
    }

    @RequestMapping("/test")
    public List<ElementBean> test(){
//        Daos.createTablesInPackage(dao,"win.i02.bean",false);
        return dao.query(ElementBean.class,null);
    }

    @RequestMapping("/add")
    public String add(){
        ElementBean bean = new ElementBean();
        bean.setcNameCn("测试");
        bean.setcNameEn("test");
        dao.insert(bean);
        return "ok";
    }
}
