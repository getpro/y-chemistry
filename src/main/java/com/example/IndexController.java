package com.example;

import org.nutz.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import win.i02.bean.ElementBean;

import java.util.List;

/**
 * Created by Qi on 2017/6/8.
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/rest")
public class IndexController {
    @Autowired
    Dao dao;

    @RequestMapping("/test")
    public List<ElementBean> test(){
        return dao.query(ElementBean.class,null);
    }
}
