/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package la_120_8001_login_signup.ViewModel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import la_120_8001_login_signup.Model.Model_Signup;

/**
 *
 * @author k_tur
 */
public class ViewModel_SignUp extends ViewModel implements PropertyChangeListener {

    private final Model_Signup m;
    private StringProperty benutzername_signup = new SimpleStringProperty();
    private StringProperty passwort_signup = new SimpleStringProperty();
    private StringProperty passwortBest_signup = new SimpleStringProperty();
    private StringProperty message = new SimpleStringProperty();

    public ViewModel_SignUp(Model_Signup m) {
        this.m = m;
    }

    public void check_Registrierung() {
        m.check(benutzername_signup.getValue(), passwort_signup.getValue(), passwortBest_signup.getValue());
        
    }

    public void switchLogin() throws IOException {
        mainApp.SceneLogin();
    }

    public StringProperty getBenutzername_signup() {
        return benutzername_signup;
    }

    public StringProperty getPasswort_signup() {
        return passwort_signup;
    }

    public StringProperty getPasswortBest_signup() {
        return passwortBest_signup;
    }

    public StringProperty getMessage() {
        return message;
    }

    public void setMessage(StringProperty message) {
        this.message = message;
    }

    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        message.setValue(pce.getNewValue().toString());
    }

}
