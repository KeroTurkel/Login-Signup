/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package la_120_8001_login_signup.View;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import la_120_8001_login_signup.ViewModel.ViewModel_Login;

/**
 * FXML Controller class
 *
 * @author k_tur
 */
public class LoginController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField benutzername_login;

    @FXML
    private PasswordField passwort_login;

    @FXML
    private Button button_login;

    @FXML
    private Label message_login;

    private ViewModel_Login viewModel_login;


    public void setViewModel_Login(ViewModel_Login viewModel_login) {
        this.viewModel_login = viewModel_login;
    }

    @FXML
    public void anmelden(ActionEvent event) {
       
        viewModel_login.check_Anmeldung();
    }

    @FXML
    public void switchToSignUp(ActionEvent event) throws IOException {
        viewModel_login.switchToSignUp();

    }

    public void bind() {  //Die Eingaben werden zum Viewmodel gebunden 
        benutzername_login.textProperty().bindBidirectional(viewModel_login.getBenutzername_login());
        passwort_login.textProperty().bindBidirectional(viewModel_login.getPasswort_login());
        button_login.disableProperty().bind(viewModel_login.getButton_login());
        message_login.textProperty().bind(viewModel_login.getMessage_Login());

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

  

}
