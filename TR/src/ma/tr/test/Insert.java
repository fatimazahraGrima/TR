/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.tr.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author user
 */
public class Insert {
  
    public static void insertDevData(Connection connection) {
        try {
            Statement statement = connection.createStatement();
            
            // Insertion des données
            statement.executeUpdate("INSERT INTO DevData VALUES ('ALAMI', 'Lundi', 1)");
            statement.executeUpdate("INSERT INTO DevData VALUES ('WAFI', 'Lundi', 2)");
            statement.executeUpdate("INSERT INTO DevData VALUES ('SALAMI', 'Mardi', 9)");
            statement.executeUpdate("INSERT INTO DevData VALUES ('SAFI', 'Mardi', 2)");
            statement.executeUpdate("INSERT INTO DevData VALUES ('ALAMI', 'Mardi', 2)");
            statement.executeUpdate("INSERT INTO DevData VALUES ('SEBIHI', 'Mercredi', 2)");
            statement.executeUpdate("INSERT INTO DevData VALUES ('WAFI', 'Jeudi', 3)");
            statement.executeUpdate("INSERT INTO DevData VALUES ('ALAOUI', 'Vendredi', 9)");
            statement.executeUpdate("INSERT INTO DevData VALUES ('WAFI', 'Vendredi', 3)");
            statement.executeUpdate("INSERT INTO DevData VALUES ('SEBIHI', 'Vendredi', 4)");

            System.out.println("Données insérées avec succès.");
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'insertion des données.");
            e.printStackTrace();
        }
    }

}
