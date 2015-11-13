package Beans;

import sun.rmi.log.LogHandler;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by Peonsson on 11/11/15.
 */
@ManagedBean(name="Log")
@SessionScoped
public class LogBean {

    private String subject;
    private String message;

    public LogBean() {
        super();
    }

//    public submit() {
//        LogHandler.submit(subject, message);
//    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
