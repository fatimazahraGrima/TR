Voici un fichier README adapté pour la section "Travail à rendre : Scripts des développeurs" avec des espaces pour les captures d’écran :

---

# Travail à Rendre : Scripts des Développeurs

**Réaliser par :**  
GRIMA FATIMA ZAHRA

**Encadré par :**  
Pr. LACHGAR

**Année universitaire :**  
2024/2025

---

## Exercice 1 : Ouvrir une Connexion, Créer et Remplir une Table

### 1. Charger le driver JDBC de la base MySQL

Pour charger le driver JDBC, on utilise la méthode suivante :

```java
Class.forName("com.mysql.jdbc.Driver");
```

Ensuite, la connexion à la base de données se fait via la classe `DriverManager` en utilisant l'URL de la base de données, le nom d'utilisateur et le mot de passe :

```java
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tr", "root", "");
```

_**Capture d'écran :**_
```
![image](https://github.com/user-attachments/assets/543757ce-7883-4b3f-b128-67e5787d321c)
```
### 2. Envoyer des instructions SQL pour créer une table

#### a) Demander un objet `Statement` à partir de l’objet `Connection`

Utilisez l'objet `Statement` pour exécuter des instructions SQL :

```java
Statement stmt = conn.createStatement();
```

#### b) Création de la table `DevData`

Créez une classe `CreateTable` avec une méthode `createTable` pour créer la table `DevData` :

_**Capture d'écran :**_
```
![image](https://github.com/user-attachments/assets/9f87ffed-3b1b-4fb8-8650-3e64401f05d8)
```

#### c) Insérer des valeurs dans la table

Après avoir créé la table, insérez les valeurs appropriées :
_**Capture d'écran :**_
![image](https://github.com/user-attachments/assets/5239188e-0834-4489-96bb-0df8da9b8c1f)

### Tester dans la classe `Test`

Ajoutez une méthode `main` pour tester la connexion et l'insertion dans la table :

_**Capture d'écran :**_
```
![image](https://github.com/user-attachments/assets/32bc5a61-70cc-4be1-bc22-a343cac45656)
```
```
![image](https://github.com/user-attachments/assets/99a3a6cf-f717-4dd0-a87a-1f7f833d6355)
```
---

## Exercice 2 : Rechercher de l’Information dans la Base de Données

### 1. Programme ExoJDBC

#### a) La personne ayant réalisé le plus de scripts en une journée

Écrivez une requête SQL pour obtenir la personne avec le nombre maximum de scripts :

```java
String query1 = ""SELECT Developpeurs, Jour, MAX(NbScripts) AS MaxScripts FROM DevData GROUP BY Jour";
```

#### b) Liste des personnes triée par nombre de scripts (ordre décroissant)

Utilisez une requête SQL pour trier les personnes en fonction de leur nombre de scripts :

```java
String query2 = "SELECT Developpeurs, SUM(NbScripts) AS c FROM DevData GROUP BY Developpeurs ORDER BY c DESC";
```

_**Capture d'écran :**_
```
![image](https://github.com/user-attachments/assets/aa4e339e-fb79-40ae-9791-5f3fc62bb316)
```

### 2. Calculer le nombre total de scripts réalisés en une semaine

Modifiez le programme pour calculer le total de scripts :

```java
String query3 = "SELECT SUM(NbScripts) AS TotalScripts FROM DevData";
```

_**Capture d'écran :**_
```
![image](https://github.com/user-attachments/assets/06842b38-4ed9-4ecf-a7e5-b7f4ece6a095)
```

### 3. Calculer le nombre total de scripts pour un programmeur donné

Ajoutez un paramètre pour un programmeur spécifique :

```java
System.out.print("\nEntrez le nom du programmeur pour calculer son total de scripts : ");
String programmeur = scanner.nextLine();

String query4 = "SELECT Developpeurs, SUM(NbScripts) AS TotalScripts FROM DevData WHERE Developpeurs = '" + programmeur + "' GROUP BY Developpeurs";
```

_**Capture d'écran :**_
```
![image](https://github.com/user-attachments/assets/04b5d0fc-b674-4123-9a38-ea9bdcf3929b)
```

---

## Exercice 3 : Requête Libre et Métadonnées des Types de Données

### 1. Exécution d'une Requête Libre
Permettre à l'utilisateur d'entrer une requête SQL libre via le clavier :

```java
Scanner scanner = new Scanner(System.in);
System.out.println("Entrez votre requête SQL :");
String userQuery = scanner.nextLine();
boolean ResultSet rs = stmt.executeQuery(userQuery);
```


### 2. Afficher les informations du `ResultSet`

Si la requête produit un `ResultSet`, affichez le nombre de colonnes, leurs noms et types de données :

```java
ResultSetMetaData rsMetaData = rs.getMetaData();
int columnCount = rsMetaData.getColumnCount();

for (int i = 1; i <= columnCount; i++) {
    System.out.println("Nom de la colonne : " + rsMetaData.getColumnName(i));
    System.out.println("Type de données : " + rsMetaData.getColumnTypeName(i));
}
```

_**Capture d'écran :**_
```
![image](https://github.com/user-attachments/assets/31c543b3-f7f0-499f-8a0c-a5339aef2ab4)
```

Si la requête ne produit pas de `ResultSet` (requête `UPDATE` ou `DELETE`), affichez le nombre de lignes affectées.

_**Capture d'écran :**_
```
![image](https://github.com/user-attachments/assets/0f27c0d3-ef63-4120-a1c4-03f352a553de)
```
## Les technologies utilisées sont :

Java SE - Langage de programmation principal.
JDBC - API pour la connexion à la base de données MySQL.
NetBeans IDE - Environnement de développement.
MySQL - Base de données pour stocker et gérer les données.
Git & GitHub - Outils de gestion de code source et collaboration.
### Conclusion:

En conclusion, ce projet démontre comment intégrer une base de données MySQL avec une application Java en utilisant JDBC. Nous avons appris à créer un projet Java, établir une connexion à une base de données, insérer et récupérer des données via des requêtes SQL, tout en utilisant NetBeans comme environnement de développement. Ce TP illustre les bases de la gestion de données dans une application Java, offrant une base solide pour des projets plus complexes.
---

