package Beans;

import BusinessLogic.UserHandler;
import Entity.User;

import javax.faces.bean.ManagedBean;

/**
 * Created by Peonsson on 13/11/15.
 */

@ManagedBean(name="UserProfile")
public class UserProfileBean {

//    private UserViewModel userProfile;

    private int userId;
    private String username;
    private String firstname;
    private String lastname;
    private String country;
    private String city;

    public String getProfile() {
        System.out.println("user id = " + userId);
        User user = UserHandler.getUser(userId);

        System.out.println(user.getUsername());

        this.username = user.getUsername();
        this.firstname = user.getFirstname();
        this.lastname = user.getLastname();
        this.country = user.getCountry();
        this.city = user.getCity();

        return "profile.xhtml";
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}