package JavaAss;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewUserModel {
    private String email = null;

    public void setEmail(String email) {
        if (validateEmail(email)) {
            this.email = email;
        }
    }

    public String getEmail() {
        return this.email;
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
}
