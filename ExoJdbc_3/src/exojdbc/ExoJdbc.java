/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exojdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ExoJdbc {
    private static final String URL = "jdbc:mysql://localhost:3306/tr"; // Remplacez par votre base
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Etablir la connexion à la base de données
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            statement = connection.createStatement();
            
            // Demander à l'utilisateur d'entrer une requête SQL libre
            Scanner scanner = new Scanner(System.in);
            System.out.print("Entrez une requête SQL : ");
            String query = scanner.nextLine();

            // Exécuter la requête SQL libre
            boolean hasResultSet = statement.execute(query);

            // Si la requête produit un ResultSet (par exemple une requête SELECT)
            if (hasResultSet) {
                resultSet = statement.getResultSet();

                // Obtenir les métadonnées sur le résultat
                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();

                // Afficher le nombre de colonnes
                System.out.println("Le nombre de colonnes : " + columnCount);

                // Afficher les informations sur chaque colonne (nom et type de données)
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    String columnType = metaData.getColumnTypeName(i);
                    System.out.println("Colonne " + i + ": Nom = " + columnName + ", Type = " + columnType);
                }

                // Afficher le contenu du ResultSet ligne par ligne
                System.out.println("\nContenu de la table :");
                while (resultSet.next()) {
                    for (int i = 1; i <= columnCount; i++) {
                        System.out.print(resultSet.getString(i) + "\t");
                    }
                    System.out.println();
                }

            } else {
                // Si la requête ne produit pas de ResultSet (par exemple un INSERT, UPDATE, DELETE)
                int rowCount = statement.getUpdateCount();
                System.out.println("Le nombre de lignes affectées : " + rowCount);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
