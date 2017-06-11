package win.i02.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.nutz.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import win.i02.bean.UserBean;

import java.util.List;

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

    @RequestMapping(value = {"/","/login","/index"},method = RequestMethod.GET)
    public String index(){
        return "admin/login";
    }

    @RequestMapping("/edit/")
    public String edit(Model model){
        List<UserBean> beans = dao.query(UserBean.class,null);
        model.addAttribute("records",beans);
        return "admin/edit";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(Model model,@RequestParam String userName,@RequestParam String password){
        UsernamePasswordToken token = new UsernamePasswordToken(userName,password);
        Subject currentUser = SecurityUtils.getSubject();

        try {
            //在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查  
            //每个Realm都能在必要时对提交的AuthenticationTokens作出反应  
            //所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法  
            System.out.println("对用户[" + userName + "]进行登录验证..验证开始");
            currentUser.login(token);
            System.out.println("对用户[" + userName + "]进行登录验证..验证通过");
        }catch(UnknownAccountException uae){
            System.out.println("对用户[" + userName + "]进行登录验证..验证未通过,未知账户");
            model.addAttribute("error", "未知账户");
        }catch(IncorrectCredentialsException ice){
            System.out.println("对用户[" + userName + "]进行登录验证..验证未通过,错误的凭证");
            model.addAttribute("error", "密码不正确");
        }catch(LockedAccountException lae){
            System.out.println("对用户[" + userName + "]进行登录验证..验证未通过,账户已锁定");
            model.addAttribute("error", "账户已锁定");
        }catch(ExcessiveAttemptsException eae){
            System.out.println("对用户[" + userName + "]进行登录验证..验证未通过,错误次数过多");
            model.addAttribute("error", "用户名或密码错误次数过多");
        }catch(AuthenticationException ae){
            //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景  
            System.out.println("对用户[" + userName + "]进行登录验证..验证未通过,堆栈轨迹如下");
            ae.printStackTrace();
            model.addAttribute("error", "用户名或密码不正确");
        }
        //验证是否登录成功  
        if(currentUser.isAuthenticated()){
            System.out.println("用户[" + userName + "]登录认证通过(这里可以进行一些认证通过后的一些系统参数初始化操作)");
            return "redirect:/m/edit/";
        }else{
            token.clear();
            return "admin/login";
        }
    }
}
