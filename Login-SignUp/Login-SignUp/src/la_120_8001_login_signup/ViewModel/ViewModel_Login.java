/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package la_120_8001_login_signup.ViewModel;

import MainApp.MainApp;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import la_120_8001_login_signup.Model.Model_Login;

/**
 *
 * @author k_tur
 */
public class ViewModel_Login extends ViewModel implements PropertyChangeListener {

    private final Model_Login m;
    private StringProperty benutzername_login = new SimpleStringProperty();
    private StringProperty passwort_login = new SimpleStringProperty();
    private BooleanProperty button_login = new SimpleBooleanProperty(false);
    private StringProperty message = new SimpleStringProperty();

    public void check_Anmeldung() {
        m.check(benutzername_login.getValue(), passwort_login.getValue()); //Überprüfung in Model aufgerufen
        benutzername_login.setValue("");
        passwort_login.setValue("");
       
      

    }
    
    public ViewModel_Login(Model_Login m) { //Mit Model verbinden
        this.m = m;
    }

    public StringProperty getBenutzername_login() {
        return benutzername_login;
    }
   

    /*public void setBenutzername(StringProperty benutzername_login) {
        this.benutzername_login = benutzername_login;
    }*/

    public StringProperty getPasswort_login() {
        return passwort_login;
    }

    /*public void setPassword(StringProperty passwort_login) {
        //passwort_login.set("test");
        this.passwort_login = passwort_login;
    }*/

    public BooleanProperty getButton_login() {
        return button_login;
    }
    
    public StringProperty getMessage_Login(){
        return message;
    }

    public void setMessage(StringProperty message) {
        this.message = message;
    }

    public void switchToSignUp() throws IOException {
        mainApp.SceneSignUp();
    }

    @Override
    public void propertyChange(PropertyChangeEvent pce) {

        message.setValue(pce.getNewValue().toString());
        
        /*switch (pce.getPropertyName()) {
            case "benutzername":
                System.out.println("username changed");
                benutzername_login.setValue(pce.getNewValue().toString());
                break;
            case "password":
                passwort_login.setValue(pce.getNewValue().toString());
                System.out.println("password changed");
                break;
            case "message":
                message.setValue(pce.getNewValue().toString());
                System.out.println("message changed");
                break;
        }*/

    }

}
