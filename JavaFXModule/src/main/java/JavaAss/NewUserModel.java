package JavaAss;

import javafx.css.Match;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewUserModel {
    private String email = null;
    private String password = null;

    public void setEmail(String email) {
        if (validateEmail(email)) {
            this.email = email;
        }
    }

    public void setPassword(String password){
        if (validatePassword(password)){
            this.password = password;
        }
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword(){
        return this.password;
    }

    public boolean validateEmail(String email){
        Pattern emailRegex = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = emailRegex.matcher(email);
        if (matcher.matches()) {
            return true;
        }
        else{
            throw new IllegalArgumentException ("Invalid Email");
        }
    }

    public boolean validatePassword(String password){
        Pattern passRegex = Pattern.compile("^.*(?=.{7,})(?=..*[0-9])(?=.*[A-Z])(?=.*[*^&@!]).*$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = passRegex.matcher(password);
        if (matcher.matches()) {
            return true;
        }
        else{
            throw new IllegalArgumentException("Invalid Password");
        }
    }

}
