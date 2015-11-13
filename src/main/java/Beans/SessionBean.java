package Beans;

import BusinessLogic.UserHandler;

import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 * Created by robin on 13/11/15.
 */
@ManagedBean(name = "Session")
public class SessionBean {
    public static HttpSession getSession() {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        return (HttpSession) ec.getSession(false);
    }
}
