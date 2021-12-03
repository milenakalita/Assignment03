package JavaAss;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.Scene;
import javafx.application.Application;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class NewUserView extends Application implements EventHandler<ActionEvent>{
    public NewUserPresenter presenter;
    public Label headerLabel;
    public Label emailLabel;
    private TextField emailInput;
    public GridPane gridPane;
    public Label passwordLabel;
    private TextField passwordInput;
    public Button button;
    private Label resultMessage;

    public void start(Stage stage){
        stage.setTitle("Registration");
        gridPane = createRegistrationFormPane();
        addUIControls(gridPane);
        Scene scene = new Scene(gridPane, 500, 300);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.presenter = new NewUserPresenter(this);
        String result = this.presenter.onClick(emailInput.getText(), passwordInput.getText());
        resultMessage.setText(result);
        System.out.println(result);
    }


    // the following method taken from
    // https://www.callicoder.com/javafx-registration-form-gui-tutorial/
    private GridPane createRegistrationFormPane() {
        // Instantiate a new Grid Pane
        GridPane gridPane = new GridPane();

        // Position the pane at the center of the screen, both vertically and horizontally
        gridPane.setAlignment(Pos.CENTER);

        // Set a padding of 20px on each side
        gridPane.setPadding(new Insets(40, 40, 40, 40));

        // Set the horizontal gap between columns
        gridPane.setHgap(10);

        // Set the vertical gap between rows
        gridPane.setVgap(10);

        // Add Column Constraints

        // columnOneConstraints will be applied to all the nodes placed in column one.
        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);

        // columnTwoConstraints will be applied to all the nodes placed in column two.
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

        return gridPane;
    }


    // the following method taken & adapted from
    // https://www.callicoder.com/javafx-registration-form-gui-tutorial/
    private void addUIControls(GridPane gridPane) {
        // Add Header
        headerLabel = new Label("Registration Form");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gridPane.add(headerLabel, 0,0,2,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));

        // Add Email Label
        emailLabel = new Label("E-Mail : ");
        gridPane.add(emailLabel, 0,1);

        // Add Name Text Field
        emailInput = new TextField();
        emailInput.setPrefHeight(40);
        gridPane.add(emailInput, 1,1);

        // Add Password Label
        passwordLabel = new Label("Password : ");
        gridPane.add(passwordLabel, 0, 2);

        // Add Password Field
        passwordInput = new PasswordField();
        passwordInput.setPrefHeight(40);
        gridPane.add(passwordInput, 1, 2);

        // Add Submit Button
        button = new Button("Register");
        button.setPrefHeight(40);
        button.setDefaultButton(true);
        button.setPrefWidth(100);
        gridPane.add(button, 0, 4, 2, 1);
        GridPane.setHalignment(button, HPos.CENTER);
        GridPane.setMargin(button, new Insets(20, 0,20,0));

        resultMessage = new Label("");
        gridPane.add(resultMessage, 1, 3);

        button.setOnAction(this);

    }


    public static void main(String[] args) {
        launch();
    }
}

