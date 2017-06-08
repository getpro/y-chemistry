package com.example;

import org.nutz.dao.Dao;
import org.nutz.dao.sql.Sql;
import org.nutz.dao.util.Daos;
import org.nutz.plugin.spring.boot.config.SqlManagerProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String add(String cname,String ename){
        ElementBean bean = new ElementBean();
        bean.setcNameCn(cname);
        bean.setcNameEn(ename);
        dao.insert(bean);
        return "ok";
    }

    @RequestMapping("/del/{id}")
    public String del(@PathVariable int id){
        int result = dao.delete(ElementBean.class,id);
        if(result>0){
            return "ok";
        }
        return "fail";
    }

    @RequestMapping("/cn")
    public String cn(){
        return "中文";
    }
}
