package crowdfunding.dapp.crowdfundingdapp.message.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class LoginForm {

    @NotBlank
    @Email
    @Size(min = 3, max = 60)
    private String userName;

    @NotBlank
    @Size(min = 6, max = 100)
    private String password;
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

