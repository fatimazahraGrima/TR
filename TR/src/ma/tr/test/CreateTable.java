/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.tr.test;

/**
 *
 * @author user
 */
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class CreateTable {
    public static void createDevDataTable(Connection connection) {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS DevData ("
                              + "Developpeurs VARCHAR(32), "
                              + "Jour CHAR(11), "
                              + "NbScripts INTEGER)";
        
        try {
            Statement statement = connection.createStatement();  // Créer l'objet Statement
            statement.execute(createTableSQL);  // Exécuter l'instruction SQL pour créer la table
            System.out.println("Table DevData créée avec succès.");
        } catch (SQLException e) {
            System.out.println("Erreur lors de la création de la table.");
            e.printStackTrace();
        }
    }
}
