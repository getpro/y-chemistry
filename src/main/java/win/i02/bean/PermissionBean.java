package win.i02.bean;

import org.nutz.dao.entity.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 权限
 * Created by Qi on 2017/6/11.
 */
@Table("permissons")
public class PermissionBean {
    @Id
    @ColDefine(auto = true)
    private Long id;
    @Column
    private String permissionName;

    @ManyMany(relation = "t_roles_permission", from = "permissionid", to = "roleid")
    private List<RoleBean> roles;

    public PermissionBean() {
    }

    public PermissionBean(String permissionName, RoleBean... role) {
        this.permissionName = permissionName;
        if (role != null){
            this.roles = new ArrayList<>();
            this.roles.addAll(Arrays.asList(role));
        }
    }

    public PermissionBean(String permissionName, List<RoleBean> roles) {
        this.permissionName = permissionName;
        if (roles != null){
            this.roles = new ArrayList<>();
            this.roles.addAll(roles);
        }
    }

    public PermissionBean(String permissionName) {
        this.permissionName = permissionName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public List<RoleBean> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleBean> roles) {
        this.roles = roles;
    }
}
