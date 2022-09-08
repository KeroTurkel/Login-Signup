/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainApp;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import la_120_8001_login_signup.Model.Model_Login;
import la_120_8001_login_signup.Model.Model_Signup;
import la_120_8001_login_signup.View.LoginController;
import la_120_8001_login_signup.View.SignUpController;
import la_120_8001_login_signup.ViewModel.ViewModel_Login;
import la_120_8001_login_signup.ViewModel.ViewModel_SignUp;

/**
 *
 * @author k_tur
 */
public class MainApp extends Application {

    private Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        SceneLogin();

    }

    public void SceneLogin() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/la_120_8001_login_signup/View/Login.fxml"));
        Parent root = loader.load();
        LoginController loginController = loader.getController();

        Model_Login model_login = new Model_Login();
        ViewModel_Login viewModel_login = new ViewModel_Login(model_login);

        loginController.setViewModel_Login(viewModel_login);

        model_login.addPropertyChangeListener(viewModel_login);

        viewModel_login.setMainApp(this); //zu Scene Signup

        loginController.bind();

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    public void SceneSignUp() throws IOException {
        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/la_120_8001_login_signup/View/SignUp.fxml"));
        Parent root = loader2.load();
        SignUpController signupController = loader2.getController();
        Model_Signup model_signup = new Model_Signup();
        ViewModel_SignUp viewModel_signup = new ViewModel_SignUp(model_signup);

        signupController.setViewModel_SignUp(viewModel_signup);

        model_signup.addPropertyChangeListener(viewModel_signup);

        viewModel_signup.setMainApp(this); //zu Scene Login

        signupController.bind();

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
