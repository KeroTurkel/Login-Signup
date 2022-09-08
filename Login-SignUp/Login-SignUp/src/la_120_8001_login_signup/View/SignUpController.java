/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package la_120_8001_login_signup.View;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import la_120_8001_login_signup.ViewModel.ViewModel_SignUp;

/**
 * FXML Controller class
 *
 * @author k_tur
 */
public class SignUpController implements Initializable {

    @FXML
    private TextField benutzername_signup;

    @FXML
    private PasswordField passwort_signup;

    @FXML
    private PasswordField passwortBest_signup;

    @FXML
    private Button button_signup;

    @FXML
    private Button btn_changeLogin;

    @FXML
    private Label message;

    private ViewModel_SignUp viewModel_signup;

    public void setViewModel_SignUp(ViewModel_SignUp viewModel_signup) {
        this.viewModel_signup = viewModel_signup;
    }

    @FXML
    public void registrieren(ActionEvent event) {
        viewModel_signup.check_Registrierung();
    }

    @FXML
    public void switchToLogin(ActionEvent event) throws IOException {
        viewModel_signup.switchLogin();
    }

    public void bind() {
        benutzername_signup.textProperty().bindBidirectional(viewModel_signup.getBenutzername_signup()); //bindBidirectional (von input zu model und model zu input)
        passwort_signup.textProperty().bindBidirectional(viewModel_signup.getPasswort_signup());
        passwortBest_signup.textProperty().bindBidirectional(viewModel_signup.getPasswortBest_signup());
        message.textProperty().bind(viewModel_signup.getMessage());

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
