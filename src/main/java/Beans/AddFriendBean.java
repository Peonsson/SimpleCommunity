package Beans;

import BusinessLogic.UserHandler;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by Peonsson on 19/11/15.
 */
@ManagedBean
@SessionScoped
public class AddFriendBean {

    private String friendId;

    public AddFriendBean() {
    }

    public void addFriend() {
        UserHandler.addFriend();
    }

    public String getFriendId() {
        return friendId;
    }

    public void setFriendId(String friendId) {
        this.friendId = friendId;
    }
}
