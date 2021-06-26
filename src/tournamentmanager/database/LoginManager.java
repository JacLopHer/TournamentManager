/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tournamentmanager.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import static tournamentmanager.database.ConnectionWrapper.mySQLConnector;
import tournamentmanager.entities.Admin;

/**
 *
 * @author Jacinto López Hernández
 */
public class LoginManager {

    public static String checkLogin(Admin admin) {
        String result = "Username/Password incorrect";

        try {
            PreparedStatement sta = mySQLConnector.getCnx().prepareStatement("select users.user, users.password from users where users.admin = 1 and users.user = ? and users.password = ?");
            sta.setString(1, admin.getUser());
            sta.setString(2, admin.getPassword());
            ResultSet rs = sta.executeQuery();

            if (rs.first()) {
                result = "";
            }

        } catch (SQLException ex) {
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }
}
