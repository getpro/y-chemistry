package win.i02.controller;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.util.Daos;
import org.nutz.plugin.spring.boot.config.SqlManagerProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import win.i02.bean.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 测试入口
 * Created by Qi on 2017/6/8.
 */
@RestController
@EnableAutoConfiguration
@EnableConfigurationProperties(SqlManagerProperties.class)
@RequestMapping(value = "/rest")
public class IndexController {
    @Autowired
    Dao dao;

    @RequestMapping("/test")
    public List<ElementBean> test(){
//        Daos.createTablesInPackage(dao,"win.i02.bean",false);
        return dao.query(ElementBean.class,null);
    }

    @RequestMapping("/addrole")
    public BaseResultBean addRole(){
        return new BaseResultBean(200);
    }

    @RequestMapping("/add")
    public BaseResultBean addPermission(){
        dao.clear(RoleBean.class);
        dao.clear(UserBean.class);
        dao.clear(PermissionBean.class);
        dao.clear("t_users_roles");
        dao.clear("t_roles_permission");
        String[] str = new String[]{"管理员","注册用户","初级会员"};
        List<RoleBean> roles=new ArrayList<>();
        List<PermissionBean> permission=new ArrayList<>();
        List<UserBean> users=new ArrayList<>();
        for (String s:str){
            int count=dao.count(RoleBean.class, Cnd.where("roleName","=",s));
            if(count==0){
                roles.add(dao.insert(new RoleBean(s)));
            }
        }
        str = new String[]{"编辑","删除","新增","更新","发帖","回帖"};
        for (String s:str){
            int count=dao.count(PermissionBean.class, Cnd.where("permissionName","=",s));
            if(count==0){
                PermissionBean p=dao.insert(new PermissionBean(s,roles));
                dao.insertRelation(p,"roles");
                permission.add(p);
            }
        }
        for(int i=0;i<100;i++){
            RoleBean roleBean = null;
            if(i==0){
                roleBean = roles.get(0);
            }else if(i%2==0){
                roleBean=roles.get(1);
            }else{
                roleBean = roles.get(2);
            }
            UserBean u=dao.insert(new UserBean("测试"+i,"123456",i+"test@gmail.com","测试用户"+i,roleBean));
            dao.insertRelation(u,"roles");
            users.add(u);
        }

        Map<String,List> result = new HashMap<>();
        result.put("roles",roles);
        result.put("users",users);
        result.put("permissions",permission);

        return new BaseResultBean(result);
    }

    @RequestMapping("/list")
    public BaseResultBean list(){
        List<UserBean> users = dao.query(UserBean.class,null);
        dao.fetchLinks(users,null);
        for (UserBean user:users
             ) {
            dao.fetchLinks(user.getRoles(),"permissions");
        }
        return new BaseResultBean(users);
    }

    @RequestMapping("/del/{id}")
    public String del(@PathVariable int id){
        int result = dao.delete(ElementBean.class,id);
        if(result>0){
            return "ok";
        }
        return "fail";
    }
}
