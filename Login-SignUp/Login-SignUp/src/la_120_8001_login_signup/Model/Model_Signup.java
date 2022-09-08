/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package la_120_8001_login_signup.Model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author k_tur
 */
public class Model_Signup {

    protected final PropertyChangeSupport changes = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(final PropertyChangeListener listener) {
        changes.addPropertyChangeListener(listener);

    }

    public void SQL_verbinden(String benutzername, String password) {
        String url = "jdbc:mysql://localhost:3306/1303_login_signup";
        String user = "root";
        String p = "";

        try {
            Connection conn = DriverManager.getConnection(url, user, p);
            Statement stat = conn.createStatement();
            
            stat.executeUpdate("INSERT INTO login(benutzername, passwort)"
                            + "VALUES ('" + benutzername + "', '" + password + "');");
            
            
            
            

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    private String message;

    public void check(String benutzername, String password, String bestaetigen) {

        String oldMessage = message;

        if (benutzername == null || password == null || bestaetigen == null) {
            message = "Benutzername und Passwort eingeben";

        } else if (benutzername.equals(benutzername) && password.equals(password) && bestaetigen == null) {
            message = "Passwort bestätigen";
        } else if (!password.equals(bestaetigen)) {
            message = "Passwort stimmt nicht überein";
        } else if (password.equals(bestaetigen)){
            message = "Registrierung erfolgreich";
        } else{
            SQL_verbinden(benutzername, password);
        }
        
        changes.firePropertyChange("message", oldMessage, message);
    }
    
    

}
