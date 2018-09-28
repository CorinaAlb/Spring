package web;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "helloJsf", eager = true)
@RequestScoped
public class HelloJsf {

    @ManagedProperty(value = "#{message}")
    private Message messageBean;
    private String message;

    public HelloJsf() {
        System.out.println("Hello JSF!");
    }

    public String getMessage() {

        if (messageBean != null) {
            message = messageBean.getMessage();
        }
        return "Hello JSF!";
    }

    public void setMessageBean(Message message) {
        this.messageBean = message;
    }
}
