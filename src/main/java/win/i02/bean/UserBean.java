package win.i02.bean;

import org.nutz.dao.entity.annotation.*;

import java.util.*;

/**
 * 用户
 * Created by Qi on 2017/6/11.
 */
@Table("users")
public class UserBean {
    @Id
    @ColDefine(auto = true)
    private Long id;
    @Column
    @Name
    private String userName;
    @Column
    private String password;
    @Column
    private String email;
    @Column
    private String nickName;
    @Column
    @Prev(els = @EL("$me.getNowDate()"))
    private Date createDate;
    @Column
    private Date lastLogin;

    @Column
    private String token;

    @ManyMany(relation = "t_users_roles", from = "userid", to = "roleid")
    private List<RoleBean> roles;

    public UserBean(String userName, String password, String email, String nickName) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.nickName = nickName;
    }

    public UserBean(String userName, String password, String email, String nickName, List<RoleBean> roles) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.nickName = nickName;
        this.roles = roles;
    }

    public UserBean(String userName, String password, String email, String nickName, RoleBean... role) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.nickName = nickName;
        if (role != null){
            this.roles = new ArrayList<>();
            this.roles.addAll(Arrays.asList(role));
        }
    }

    public UserBean() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Date getCreateDate() {
        if (createDate == null) {
            createDate = Calendar.getInstance().getTime();
        }
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public List<RoleBean> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleBean> roles) {
        this.roles = roles;
    }

    public Date getNowDate(){
        return Calendar.getInstance().getTime();
    }
}
