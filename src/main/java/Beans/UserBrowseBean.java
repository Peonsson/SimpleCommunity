package Beans;

import Entity.User;

import javax.faces.bean.ManagedBean;
import java.util.List;

/**
 * Created by robin on 13/11/15.
 */
@ManagedBean(name="UserBrowse")
public class UserBrowseBean {
    private List<User> users;

    public UserBrowseBean() {
        super();
    }

    public List<User> getUsers() {
        return User.browse();
    }
}
