/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package la_120_8001_login_signup.Model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author k_tur
 */
public class Model_Login {

    protected final PropertyChangeSupport changes = new PropertyChangeSupport(this);

    private String message;

    // Zuerst mit Driver verbinden
    public void SQL_verbinden(String benutzername, String password) {

        String url = "jdbc:mysql://localhost:3306/1303_login_signup";  //Datenbank muss ausgewählt werden und zusätzlich jdbc Driver installieren/einbinden
        String user = "root";
        String passw = "";

        try {

            Connection conn = DriverManager.getConnection(url, user, passw);
            System.out.println("Connected");
            PreparedStatement prst = conn.prepareStatement("SELECT * FROM login WHERE benutzername = ? AND passwort = ?"); //überprüft die Logindaten in der DAtenbank

            prst.setString(1, benutzername);
            prst.setString(2, password);

            ResultSet rs = prst.executeQuery();

            if (rs.next()) {
                message = "Login erfolgreich";

            } else {
                message = "Login fehlgeschlagen";
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void check(String benutzername, String password) {
        //getConntection_sql(){ aufrufen der Methode

        String oldmessage = message;

        System.out.println("_" + benutzername + "_");
        System.out.println("_" + password + "_");

        //Wenn nichts eingebgen wird
        if (benutzername == null || password == null) {

            message = "Benutzernae und Passwort eingeben";

        } else if (benutzername.equals("") || password.equals("")) {

            message = "Benutzernae und Passwort eingeben";

        } else {
            message = "username or password wrong";
            SQL_verbinden(benutzername, password);                 
        }

        changes.firePropertyChange("message", oldmessage, message); //Text in Label wird verändert, wenn eine Eingabe bestätigt wird

    }

    public void addPropertyChangeListener(final PropertyChangeListener listener) {
        changes.addPropertyChangeListener(listener);

    }

}
