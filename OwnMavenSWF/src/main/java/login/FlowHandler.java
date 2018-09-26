package login;

import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

@Component
public class FlowHandler {

    public UserBean initFlow() {
        return new UserBean();
    }

    public String validateDetails(UserBean userBean, MessageContext messageContext) {
        String status = "success";
        if (userBean.getUsername().isEmpty()) {
            messageContext.addMessage(new MessageBuilder().error().source("username")
                    .defaultText("Username field is empty!").build());
            status = "failure";
        } else if (!userBean.getUsername().equals("ADMIN")) {
            messageContext.addMessage(new MessageBuilder().error().source("username")
                    .defaultText("Username not recognized!").build());
            status = "failure";
        }
        if (userBean.getPassword().isEmpty()) {
            messageContext.addMessage(new MessageBuilder().error().source("password")
                    .defaultText("Password field is empty!").build());
            status = "failure";
        } else if (!userBean.getPassword().equals("admin")) {
            messageContext.addMessage(new MessageBuilder().error().source("password")
                    .defaultText("Invalid password!").build());
            status = "failure";
        }

        return status;
    }
}
