package tutorial;

public class LoginService {

    public String performLogin(LoginCredentials loginCredentials) throws IncorrectLoginCredentialsException {

        if (loginCredentials.getLoginName() != null && loginCredentials.getLoginName().trim().equalsIgnoreCase("alba")
            && loginCredentials.getPassword() != null && loginCredentials.getPassword().trim().equalsIgnoreCase("pass")) {
            return "success";
        } else {
            throw new IncorrectLoginCredentialsException();
        }

    }
}