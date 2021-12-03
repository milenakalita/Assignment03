package JavaAss;

public class NewUserPresenter extends NewUserView {
    public NewUserModel model;
    public NewUserView view;
    public boolean emailResult;
    public boolean passwordResult;
    public String message;

    // instantiating the objects of View and Model Interface
    public NewUserPresenter(NewUserView view) {
        this.view = view;
        this.model = new NewUserModel(this);
    }

    String onClick(String email, String password){
        message = "Invalid E-Mail/Password";
        emailResult = this.model.setEmail(email);
        passwordResult = this.model.setPassword(password);
        if (emailResult) {
                if (passwordResult){
                    System.out.println(true);
                    message = "Successfully Registered";
                }
        }
        return message;
    }


}