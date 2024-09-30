package exojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
        Scanner scanner = new Scanner(System.in);

        try {
            // Charger le driver et établir la connexion
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            statement = connection.createStatement();

            // Requête 1 : La personne ayant réalisé le nombre maximum de scripts en une journée
            String query1 = "SELECT Developpeurs, Jour, MAX(NbScripts) AS MaxScripts FROM DevData GROUP BY Jour";
            resultSet = statement.executeQuery(query1);

            System.out.println("La personne ayant réalisé le nombre maximum de scripts par jour :");
            while (resultSet.next()) {
                String developpeur = resultSet.getString("Developpeurs");
                String jour = resultSet.getString("Jour");
                int maxScripts = resultSet.getInt("MaxScripts");
                System.out.println(developpeur + " a réalisé " + maxScripts + " scripts le " + jour);
            }

            // Requête 2 : Liste des développeurs triée par nombre de scripts décroissant
            String query2 = "SELECT Developpeurs, SUM(NbScripts) AS c FROM DevData GROUP BY Developpeurs ORDER BY c DESC";
            resultSet = statement.executeQuery(query2);

            System.out.println("\nListe des développeurs triée par nombre total de scripts :");
            while (resultSet.next()) {
                String developpeur = resultSet.getString("Developpeurs");
                int totalScripts = resultSet.getInt("c");
                System.out.println(developpeur + " a réalisé " + totalScripts + " scripts au total.");
            }

            // Requête 3 : Nombre total de scripts réalisés en une semaine
            String query3 = "SELECT SUM(NbScripts) AS TotalScripts FROM DevData";
            resultSet = statement.executeQuery(query3);

            if (resultSet.next()) {
                int totalScripts = resultSet.getInt("TotalScripts");
                System.out.println("\nLe nombre total de scripts réalisés en une semaine est : " + totalScripts);
            }

            // Requête 4 : Nombre total de scripts réalisés par un programmeur donné
            System.out.print("\nEntrez le nom du programmeur pour calculer son total de scripts : ");
            String programmeur = scanner.nextLine();

            // Requête SQL pour calculer le total des scripts d'un programmeur donné
            String query4 = "SELECT Developpeurs, SUM(NbScripts) AS TotalScripts FROM DevData WHERE Developpeurs = '" + programmeur + "' GROUP BY Developpeurs";
            resultSet = statement.executeQuery(query4);

            if (resultSet.next()) {
                int totalScripts = resultSet.getInt("TotalScripts");
                System.out.println(programmeur + " a réalisé un total de " + totalScripts + " scripts.");
            } else {
                System.out.println("Le programmeur " + programmeur + " n'existe pas ou n'a réalisé aucun script.");
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
