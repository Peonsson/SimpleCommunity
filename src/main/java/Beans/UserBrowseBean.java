package Beans;

import BusinessLogic.UserHandler;
import Entity.User;

import javax.faces.bean.ManagedBean;
import java.util.List;

/**
 * Created by robin on 13/11/15.
 */
@ManagedBean(name="UserBrowse")
public class UserBrowseBean {

    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String initBrowse() {
            users = UserHandler.browse();
        return "browse.xhtml";
    }
}
