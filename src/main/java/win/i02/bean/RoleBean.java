package win.i02.bean;

import org.nutz.dao.entity.annotation.*;

import java.util.List;

/**
 * 规则
 * Created by Qi on 2017/6/11.
 */
@Table("roles")
public class RoleBean {
    @Id
    @ColDefine(auto = true)
    private Long id;
    @Column
    private String roleName;

    @ManyMany(relation = "t_users_roles",from = "roleid",to="userid")
    private List<UserBean> users;

    @ManyMany(relation = "t_roles_permission",from = "roleid",to="permissionid")
    private List<PermissionBean> permissions;

    public RoleBean() {
    }

    public RoleBean(String roleName) {
        this.roleName = roleName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<UserBean> getUsers() {
        return users;
    }

    public void setUsers(List<UserBean> users) {
        this.users = users;
    }

    public List<PermissionBean> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<PermissionBean> permissions) {
        this.permissions = permissions;
    }
}
