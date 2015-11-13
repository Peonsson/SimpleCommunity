package Beans;

import BusinessLogic.UserHandler;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by robin on 13/11/15.
 */
@ManagedBean(name="Login")
@SessionScoped
public class LoginBean {
    private String username;
    private String password;
    private boolean loggedIn;

    public LoginBean() {
        super();
        loggedIn = false;

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

    public boolean isLoggedIn() {
        HttpSession session = SessionBean.getSession();

        if (session != null) {
            System.out.println("session");
            String user = (String) session.getAttribute("username");
            if (user != null) {
                System.out.println("user");
                System.out.println("LoginBean: found session");
                System.out.println("LoginBean: session username = " + session.getAttribute("username"));
                return true;
            }
        }

        System.out.println("LoginBean: didn't find session");
        return false;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public String login() {
        boolean loginSuccess = UserHandler.loginUser(username, password);

        if (loginSuccess) {
            setLoggedIn(true);

            HttpSession session = SessionBean.getSession();
            session.setAttribute("username", username);

            return "timeline.xhtml";
        }

        return "index.xhtml";
    }

    public String logout() {
        HttpSession session = SessionBean.getSession();

        session.invalidate();
        return "login";
    }
}
