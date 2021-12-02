package JavaAss;

import javafx.css.Match;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewUserModel {
    public NewUserPresenter presenter;
    private String email = null;
    private String password = null;
    private boolean message;

    public NewUserModel(NewUserPresenter presenter){
        this.presenter = presenter;
    }

    public boolean setEmail(String email) {
        message = false;
        if (validateEmail(email)) {
            this.email = email;
            message = true;
        }
        return message;
    }

    public boolean setPassword(String password){
        message = false;
        if (validatePassword(password)){
            this.password = password;
            message = true;
        }
        return message;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword(){
        return this.password;
    }

    public boolean validateEmail(String email){
        try {
            Pattern emailRegex = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
            Matcher matcher = emailRegex.matcher(email);
            if (matcher.matches()) {
                return true;
            } else {
                throw new IllegalArgumentException("Invalid Email");
            }
        }
        catch(IllegalArgumentException e) {
            return false;
        }
    }

    public boolean validatePassword(String password){
        try {
            Pattern passRegex = Pattern.compile("^.*(?=.{7,})(?=..*[0-9])(?=.*[A-Z])(?=.*[*^&@!]).*$", Pattern.CASE_INSENSITIVE);
            Matcher matcher = passRegex.matcher(password);
            if (matcher.matches()) {
                return true;
            } else {
                throw new IllegalArgumentException("Invalid Password");
            }
        }
        catch(IllegalArgumentException e) {
            System.out.println("thrown");
            return false;
            }
    }
}
