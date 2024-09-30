/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.tr.test;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.MySQLConnection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import ma.tr.connexion.Connexion;
/**
 *
 * @author user
 */
public class Test {
    public static void main(String[] args) {
        java.sql.Connection connection = Connexion.getCn();  // Ouvrir la connexion

        if (connection != null) {
            // Créer la table
            CreateTable.createDevDataTable(connection);
            
            // Insérer les données dans la table
            Insert.insertDevData(connection);
            
            // Supprimer la table (optionnel, selon ce que vous voulez faire)
            // DropTable.dropDevDataTable(connection);

            // Fermer la connexion
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

