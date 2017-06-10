package win.i02.controller;

import org.nutz.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 管理入口
 * Created by Qi on 2017/6/10.
 */
@Controller
@EnableAutoConfiguration
@RequestMapping(value = "/m")
public class AdminController {
    @Autowired
    private Dao dao;

    @RequestMapping(value = {"/","/login","/index"})
    public String index(){
        return "admin/login";
    }
}
