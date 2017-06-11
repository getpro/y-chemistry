package win.i02;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import win.i02.bean.PermissionBean;
import win.i02.bean.RoleBean;
import win.i02.bean.UserBean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Qi on 2017/6/12.
 */
public class MyShiroRealm extends AuthorizingRealm {
    @Autowired
    Dao dao;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String loginName = (String) super.getAvailablePrincipal(principalCollection);

        UserBean userBean = dao.fetch(UserBean.class, Cnd.where("userName", "=", loginName));

        if (userBean != null) {
            dao.fetchLinks(userBean, "roles");
            dao.fetchLinks(userBean.getRoles(), "permissions");
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            Set<String> roleNames = new HashSet<>();
            List<String> permissonNames = new ArrayList<>();
            for (RoleBean roleBean : userBean.getRoles()) {
                roleNames.add(roleBean.getRoleName());
                for (PermissionBean permissionBean : roleBean.getPermissions()) {
                    if (!permissonNames.contains(permissionBean.getPermissionName())) {
                        permissonNames.add(permissionBean.getPermissionName());
                    }
                }
            }
            info.setRoles(roleNames);
            info.addStringPermissions(permissonNames);
            System.out.println("当前用户权限："+ Json.toJson(roleNames)+Json.toJson(permissonNames));
            return info;
        }

        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        UserBean bean = dao.fetch(UserBean.class,Cnd.where("userName","=",token.getUsername()));

        if(bean!=null){
         return new SimpleAuthenticationInfo(bean.getUserName(),bean.getPassword(),getName());
        }

        return null;
    }
}
