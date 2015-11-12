package Beans;

import BusinessLogic.UserHandler;
import Entity.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.util.List;

/**
 * Created by robin on 9/11/15.
 */
@ManagedBean(name = "User")
@RequestScoped
public class UserBean {

    private String email;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String country;
    private String city;
    private List<User> browse;
    private User user;
    private int getUserId;


    public List<User> getBrowse() {
        System.out.println("UserBean: KIL");
        return UserHandler.browse();
    }

    public void setBrowse(List<User> browse) {
        this.browse = browse;
    }

    public UserBean() {
        super();
    }

    public void register() {
        boolean registerSuccess = UserHandler.registerUser(email, username, password, firstname, lastname, country, city);

        if (registerSuccess) {
            try {
                ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
                ec.redirect(ec.getRequestContextPath() + "/index.xhtml");
            } catch (IOException e) {
                System.out.println("failed redirecting");
                e.printStackTrace();
            }
        } else {
            // TODO: Assign variable if registration failed. (http://stackoverflow.com/questions/15452539/redirecting-form-jsf-managed-bean-and-showing-js-alert-based-on-condition-in-man)
        }
    }

    public void login() {
        boolean loginSuccess = UserHandler.loginUser(username, password);
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();

        try {
            if (loginSuccess) {
                ec.redirect(ec.getRequestContextPath() + "/timeline.xhtml");
            } else {
                ec.redirect(ec.getRequestContextPath() + "/login.xhtml");
            }
        } catch (IOException e) {
            System.out.println("failed redirecting");
            e.printStackTrace();
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public User getUser() {
        return UserHandler.getUser(getUserId);
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getGetUserId() {
        return getUserId;
    }

    public void setGetUserId(int getUserId) {
        this.getUserId = getUserId;
    }
}
