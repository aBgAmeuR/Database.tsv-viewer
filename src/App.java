import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import Film.Film;
import FilmDatabase.FilmDatabase;


public class App {

    public static String FullPath = "databases/IMDbmoviesFULL.tsv";
    public static String CUT40000Path = "databases/IMDbmoviesCUT40000.tsv";
    public static String CUT10000Path = "databases/IMDbmoviesCUT10000.tsv";
    public static String CUT1000Path = "databases/IMDbmoviesCUT1000.tsv";
    public static String CUT100Path = "databases/IMDbmoviesCUT100.tsv";

    static Scanner Scanner = new Scanner(System.in);
    static FilmDatabase database = new FilmDatabase(new LinkedList<Film>());

    static long startTime;
    static long endTime;
    static long duration;

    public static void main(String[] args) throws Exception {

        selectFichier();

    }

    public static void selectFichier() throws IOException {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
        System.out.println("────────────────────────────────────────");
        System.out.println("  Quel fichier souhaitez-vous charger ?");
        System.out.println("");
        System.out.println("    [1] Base complète (80 944 films)");
        System.out.println("    [2] Base partielle (40 000 films)");
        System.out.println("    [3] Base partielle (10 000 films)");
        System.out.println("    [4] Base partielle (1 000 films)");
        System.out.println("    [5] Base partielle (100 films)");
        System.out.println("");
        System.out.println("  ────────────────────────────────────");
        System.out.println("");
        System.out.println("    [0] Pour quitter le programme"); 
        System.out.println("");
        System.out.println("────────────────────────────────────────");
        System.out.print("Votre réponse : ");
        String response = Scanner.nextLine();
        switch (response) {
            case "1":
                database.loadData(FullPath);
                break;
            case "2":
                database.loadData(CUT40000Path);
                break;
            case "3":
                database.loadData(CUT10000Path);
                break;
            case "4":
                database.loadData(CUT1000Path);
                break;
            case "5":
                database.loadData(CUT100Path);
                break;
            case "0":
                System.exit(0);
                break;
            default:
                selectFichier();
                break;
        }
        menuPrincipal();
    }

    public static void menuPrincipal() throws IOException {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
        System.out.println("────────────────────────────────────────");
        System.out.println("  Combien de données à afficher ?");
        System.out.println("");
        System.out.println("    [A] Afficher toutes les données");
        System.out.println("    [B] Afficher 1000 données");
        System.out.println("    [C] Afficher 10 données");
        System.out.println("");
        System.out.println("  ────────────────────────────────────");
        System.out.println("  Que souhaité-vous faire ?");
        System.out.println("");
        System.out.println("    [X] Créer un Filtre");
        System.out.println("    [Y] Faire un Tri");
        System.out.println("    [Z] Faire une Recherche");
        System.out.println("");
        System.out.println("  ────────────────────────────────────");
        System.out.println("");
        System.out.println("    [9] Pour changer de fichier");
        System.out.println("    [0] Pour quitter le programme");
        System.out.println("");
        System.out.println("────────────────────────────────────────");
        System.out.print("Votre réponse : ");
        String response = Scanner.nextLine();
        switch (response) {
            case "A":
                database.displayData(0);
                System.out.println("Appuyez sur Entrer pour continuer...");
                Scanner.nextLine();
                menuPrincipal();
                break;
            case "a":
                database.displayData(0);
                System.out.print("Appuyez sur Entrer pour continuer...");
                Scanner.nextLine();
                menuPrincipal();
                break;
            case "B":
                database.displayData(1000);
                System.out.print("Appuyez sur Entrer pour continuer...");
                Scanner.nextLine();
                menuPrincipal();
                break;
            case "b":
                database.displayData(1000);
                System.out.print("Appuyez sur Entrer pour continuer...");
                Scanner.nextLine();
                menuPrincipal();
                break;
            case "C":
                database.displayData(10);
                System.out.print("Appuyez sur Entrer pour continuer...");
                Scanner.nextLine();
                menuPrincipal();
                break;
            case "c":
                database.displayData(10);
                System.out.print("Appuyez sur Entrer pour continuer...");
                Scanner.nextLine();
                menuPrincipal();
                break;
            case "X":
                interfaceFiltre();
                break;
            case "x":
                interfaceFiltre();
                break;
            case "Y":
                interfaceTri();
                break;
            case "y":
                interfaceTri();
                break;
            case "Z":
                interfaceRecherche();
                break;
            case "z":
                interfaceRecherche();
                break;
            case "9":
                database.suppressionUnAUn();
                selectFichier();
                break;
            case "0":
                System.exit(0);
                break;
            default:
                menuPrincipal();
                break;
        }
    }

    private static void interfaceRecherche() throws IOException {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
        System.out.println("────────────────────────────────────────");
        System.out.println("  Quelle recherche souhaiter-vous faire ?");
        System.out.println("");
        System.out.println("    [1] Recherche Linéaire");
        System.out.println("    [2] Recherche Dichomotique");
        System.out.println("");
        System.out.println("  ────────────────────────────────────");
        System.out.println("");
        System.out.println("    [8] Pour revenir au menu principal");
        System.out.println("    [9] Pour changer de fichier");
        System.out.println("    [0] Pour quitter le programme");
        System.out.println("");
        System.out.println("────────────────────────────────────────");
        System.out.print("Votre réponse : ");
        String response = Scanner.nextLine();
        switch (response) {
            case "1":
                interfaceRechercheLinéaireTitre();
                break;
            case "2":
                interfaceRechercheDichotomiqueTitre();
                break;
            case "8":
                menuPrincipal();
                break;
            case "9":
                database.suppressionUnAUn();
                selectFichier();
                break;
            case "0":
                System.exit(0);
                break;
            default:
                interfaceRecherche();
                break;
        }
    }

    private static void interfaceRechercheLinéaireTitre() throws IOException {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("────────────────────────────────────────");
        System.out.println("  Quelles catégories voulez-vous trier ?");
        System.out.println("");
        System.out.println("  ────────────────────────────────────");
        System.out.println("");
        System.out.println("    [8] Pour revenir au menu principal");
        System.out.println("    [9] Pour changer de fichier");
        System.out.println("    [0] Pour quitter le programme");
        System.out.println("");
        System.out.println("────────────────────────────────────────");
        System.out.print("Votre réponse : ");
        String response = Scanner.nextLine();
        switch (response) {
            case "8":
                menuPrincipal();
                break;
            case "9":
                database.suppressionUnAUn();
                selectFichier();
                break;
            case "0":
                System.exit(0);
                break;
            default:
                startTime = System.nanoTime();
                LinkedList<Film> list = database.rechercheLinéaireTitre(response);
                endTime = System.nanoTime();
                for (Film film : list) {
                    System.out.println(film);
                }
                duration = (endTime - startTime) / 1000000;
                System.out.println("Temps d'exécution : " + duration + "ms");
                System.out.print("Appuyez sur Entrer pour continuer...");
                Scanner.nextLine();
                menuPrincipal();
                break;
        }
    }
    
    private static void interfaceRechercheDichotomiqueTitre() throws IOException {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
        System.out.println("────────────────────────────────────────");
        System.out.println("  Quelles catégories voulez-vous trier ?");
        System.out.println("");
        System.out.println("  ────────────────────────────────────");
        System.out.println("");
        System.out.println("    [8] Pour revenir au menu principal");
        System.out.println("    [9] Pour changer de fichier");
        System.out.println("    [0] Pour quitter le programme");
        System.out.println("");
        System.out.println("────────────────────────────────────────");
        System.out.print("Votre réponse : ");
        String response = Scanner.nextLine();
        switch (response) {
            case "8":
                menuPrincipal();
                break;
            case "9":
                database.suppressionUnAUn();
                selectFichier();
                break;
            case "0":
                System.exit(0);
                break;
            default:
                startTime = System.nanoTime();
                Film list = database.rechercheDichotomiqueTitre(response);
                endTime = System.nanoTime();
                System.out.println(list);
                duration = (endTime - startTime) / 1000000;
                System.out.println("Temps d'exécution : " + duration + "ms");
                System.out.print("Appuyez sur Entrer pour continuer...");
                Scanner.nextLine();
                menuPrincipal();
                break;
        }
    }

    private static void interfaceFiltre() throws IOException {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
        System.out.println("────────────────────────────────────────");
        System.out.println("  Quelle filtre voulez-vous utiliser ?");
        System.out.println("");
        System.out.println("    [1] Filtre Linéaire");
        System.out.println("    [2] Filtre Java");
        System.out.println("");
        System.out.println("  ────────────────────────────────────");
        System.out.println("");
        System.out.println("    [8] Pour revenir au menu principal");
        System.out.println("    [9] Pour changer de fichier");
        System.out.println("    [0] Pour quitter le programme");
        System.out.println("");
        System.out.println("────────────────────────────────────────");
        System.out.print("Votre réponse : ");
        String response = Scanner.nextLine();
        switch (response) {
            case "8":
                menuPrincipal();
                break;
            case "9":
                database.suppressionUnAUn();
                selectFichier();
                break;
            case "0":
                System.exit(0);
                break;
            default:
                interfaceFiltre();
                break;
        }
    }

    private static void interfaceTri() throws IOException {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
        System.out.println("────────────────────────────────────────");
        System.out.println("  Quelle Tri souhaitez-vous utiliser ?");
        System.out.println("    [1] Tri sélection");
        System.out.println("    [2] Tri fusion");
        System.out.println("    [3] Tri java");
        System.out.println("");
        System.out.println("  ────────────────────────────────────");
        System.out.println("");
        System.out.println("    [8] Pour revenir au menu principal");
        System.out.println("    [9] Pour changer de fichier");
        System.out.println("    [0] Pour quitter le programme");
        System.out.println("");
        System.out.println("────────────────────────────────────────");
        System.out.print("Votre réponse : ");
        String response = Scanner.nextLine();
        switch (response) {
            case "1":
                interfaceTriSelect();
                break;
            case "2":
                interfaceTriFusion();
                break;
            case "3":
                interfaceTriJava();
                break;
            case "8":
                menuPrincipal();
                break;
            case "9":
                database.suppressionUnAUn();
                selectFichier();
                break;
            case "0":
                System.exit(0);
                break;
            default:
                interfaceTri();
                break;
        }
    }

    private static void interfaceTriSelect() throws IOException {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
        System.out.println("────────────────────────────────────────");
        System.out.println("  Sur quoi voulez vous faire le tri Sélection ?");
        System.out.println("    [A] Le titre du film");
        System.out.println("    [B] L'année de réalisation");
        System.out.println("    [C] Le genre du film");
        System.out.println("    [D] La durée du film");
        System.out.println("    [E] Le pays de production");
        System.out.println("    [F] La langue");
        System.out.println("    [G] Le réalisateur");
        System.out.println("    [H] La liste des acteurs");
        System.out.println("    [I] La description");
        System.out.println("    [J] Le nombre de votes de spectateurs");
        System.out.println("    [K] La moyenne des votes");
        System.out.println("");
        System.out.println("  ────────────────────────────────────");
        System.out.println("");
        System.out.println("    [8] Pour revenir au menu principal");
        System.out.println("    [9] Pour changer de fichier");
        System.out.println("    [0] Pour quitter le programme");
        System.out.println("");
        System.out.println("────────────────────────────────────────");
        System.out.print("Votre réponse : ");
        String response = Scanner.nextLine().toUpperCase();
        switch (response) {
            case "A":
                startTime = System.nanoTime();
                database.triSelection("titre");
                endTime = System.nanoTime();
                duration = (endTime - startTime) / 1000000;
                System.out.println("Le tri sélection sur le titre du film : " + duration + "ms");
                System.out.print("Appuyez sur Entrer pour continuer...");
                Scanner.nextLine();
                menuPrincipal();
                break;
            case "B":
                startTime = System.nanoTime();
                database.triSelection("anneeRea");
                endTime = System.nanoTime();
                duration = (endTime - startTime) / 1000000;
                System.out.println("Le tri sélection sur l'année de réalisation : " + duration + "ms");
                System.out.print("Appuyez sur Entrer pour continuer...");
                Scanner.nextLine();
                menuPrincipal();
                break;
            case "C":
                startTime = System.nanoTime();
                database.triSelection("Genre");
                endTime = System.nanoTime();
                duration = (endTime - startTime) / 1000000;
                System.out.println("Le tri sélection sur le genre du film : " + duration + "ms");
                System.out.print("Appuyez sur Entrer pour continuer...");
                Scanner.nextLine();
                menuPrincipal();
                break;
            case "D":
                startTime = System.nanoTime();
                database.triSelection("Duree");
                endTime = System.nanoTime();
                duration = (endTime - startTime) / 1000000;
                System.out.println("Le tri sélection sur la durée du film : " + duration + "ms");
                System.out.print("Appuyez sur Entrer pour continuer...");
                Scanner.nextLine();
                menuPrincipal();
                break;
            case "E":
                startTime = System.nanoTime();
                database.triSelection("PaysProd");
                endTime = System.nanoTime();
                duration = (endTime - startTime) / 1000000;
                System.out.println("Le tri sélection sur le pays de production : " + duration + "ms");
                System.out.print("Appuyez sur Entrer pour continuer...");
                Scanner.nextLine();
                menuPrincipal();
                break;
            case "F":
                startTime = System.nanoTime();
                database.triSelection("langue");
                endTime = System.nanoTime();
                duration = (endTime - startTime) / 1000000;
                System.out.println("Le tri sélection sur la langue : " + duration + "ms");
                System.out.print("Appuyez sur Entrer pour continuer...");
                Scanner.nextLine();
                menuPrincipal();
                break;
            case "G":
                startTime = System.nanoTime();
                database.triSelection("Realisateur");
                endTime = System.nanoTime();
                duration = (endTime - startTime) / 1000000;
                System.out.println("Le tri sélection sur le réalisateur : " + duration + "ms");
                System.out.print("Appuyez sur Entrer pour continuer...");
                Scanner.nextLine();
                menuPrincipal();
                break;
            case "H":
                startTime = System.nanoTime();
                database.triSelection("Acteurs");
                endTime = System.nanoTime();
                duration = (endTime - startTime) / 1000000;
                System.out.println("Le tri sélection sur la liste des acteurs : " + duration + "ms");
                System.out.print("Appuyez sur Entrer pour continuer...");
                Scanner.nextLine();
                menuPrincipal();
                break;
            case "I":
                startTime = System.nanoTime();
                database.triSelection("desc");
                endTime = System.nanoTime();
                duration = (endTime - startTime) / 1000000;
                System.out.println("Le tri sélection sur la description : " + duration + "ms");
                System.out.print("Appuyez sur Entrer pour continuer...");
                Scanner.nextLine();
                menuPrincipal();
                break;
            case "J":
                startTime = System.nanoTime();
                database.triSelection("nbVotesParSpec");
                endTime = System.nanoTime();
                duration = (endTime - startTime) / 1000000;
                System.out.println("Le tri sélection sur le nombre de votes par spécificité : " + duration + "ms");
                System.out.print("Appuyez sur Entrer pour continuer...");
                Scanner.nextLine();
                menuPrincipal();
                break;
            case "K":
                startTime = System.nanoTime();
                database.triSelection("moyVotes");
                endTime = System.nanoTime();
                duration = (endTime - startTime) / 1000000;
                System.out.println("Le tri sélection sur la moyenne des votes : " + duration + "ms");
                System.out.print("Appuyez sur Entrer pour continuer...");
                Scanner.nextLine();
                menuPrincipal();
                break;
            case "8":
                menuPrincipal();
                break;
            case "9":
                database.suppressionUnAUn();
                selectFichier();
                break;
            case "0":
                System.exit(0);
                break;
            default:
                interfaceTriSelect();
                break;  
        }
    }

    private static void interfaceTriFusion() throws IOException {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("────────────────────────────────────────");
        System.out.println("  Sur quoi voulez vous faire le tri Sélection ?");
        System.out.println("    [A] Le titre du film");
        System.out.println("    [B] L'année de réalisation");
        System.out.println("    [C] Le genre du film");
        System.out.println("    [D] La durée du film");
        System.out.println("    [E] Le pays de production");
        System.out.println("    [F] La langue");
        System.out.println("    [G] Le réalisateur");
        System.out.println("    [H] La liste des acteurs");
        System.out.println("    [I] La description");
        System.out.println("    [J] Le nombre de votes de spectateurs");
        System.out.println("    [K] La moyenne des votes");
        System.out.println("");
        System.out.println("  ────────────────────────────────────");
        System.out.println("");
        System.out.println("    [8] Pour revenir au menu principal");
        System.out.println("    [9] Pour changer de fichier");
        System.out.println("    [0] Pour quitter le programme");
        System.out.println("");
        System.out.println("────────────────────────────────────────");
        System.out.print("Votre réponse : ");
        String response = Scanner.nextLine().toUpperCase();
        switch (response) {
            case "A":
                startTime = System.nanoTime();
                database.triFussion("titre");
                endTime = System.nanoTime();
                duration = (endTime - startTime) / 1000000;
                System.out.println("Tri fusion sur le titre du film : " + duration + "ms");
                System.out.print("Appuyez sur Entrer pour continuer...");
                Scanner.nextLine();
                menuPrincipal();
                break;
            case "B":
                startTime = System.nanoTime();
                database.triFussion("anneeRea");
                endTime = System.nanoTime();
                duration = (endTime - startTime) / 1000000;
                System.out.println("Tri fusion sur l'année de réalisation : " + duration + "ms");
                System.out.print("Appuyez sur Entrer pour continuer...");
                Scanner.nextLine();

                menuPrincipal();
                break;
            case "C":
                startTime = System.nanoTime();
                database.triFussion("Genre");
                endTime = System.nanoTime();
                duration = (endTime - startTime) / 1000000;
                System.out.println("Tri fusion sur le genre du film : " + duration + "ms");
                System.out.print("Appuyez sur Entrer pour continuer...");
                Scanner.nextLine();
                menuPrincipal();
                break;
            case "D":
                startTime = System.nanoTime();
                database.triFussion("Duree");
                endTime = System.nanoTime();
                duration = (endTime - startTime) / 1000000;
                System.out.println("Tri fusion sur la durée du film : " + duration + "ms");
                System.out.print("Appuyez sur Entrer pour continuer...");
                Scanner.nextLine();
                menuPrincipal();
                break;
            case "E":
                startTime = System.nanoTime();
                database.triFussion("PaysProd");
                endTime = System.nanoTime();
                duration = (endTime - startTime) / 1000000;
                System.out.println("Tri fusion sur le pays de production : " + duration + "ms");
                System.out.print("Appuyez sur Entrer pour continuer...");
                Scanner.nextLine();
                menuPrincipal();
                break;
            case "F":
                startTime = System.nanoTime();
                database.triFussion("langue");
                endTime = System.nanoTime();
                duration = (endTime - startTime) / 1000000;
                System.out.println("Tri fusion sur la langue : " + duration + "ms");
                System.out.print("Appuyez sur Entrer pour continuer...");
                Scanner.nextLine();
                menuPrincipal();
                break;
            case "G":
                startTime = System.nanoTime();
                database.triFussion("Realisateur");
                endTime = System.nanoTime();
                duration = (endTime - startTime) / 1000000;
                System.out.println("Tri fusion sur le réalisateur : " + duration + "ms");
                System.out.print("Appuyez sur Entrer pour continuer...");
                Scanner.nextLine();
                menuPrincipal();
                break;
            case "H":
                startTime = System.nanoTime();
                database.triFussion("Acteurs");
                endTime = System.nanoTime();
                duration = (endTime - startTime) / 1000000;
                System.out.println("Tri fusion sur la liste des acteurs : " + duration + "ms");
                System.out.print("Appuyez sur Entrer pour continuer...");
                Scanner.nextLine();
                menuPrincipal();
                break;
            case "I":
                startTime = System.nanoTime();
                database.triFussion("desc");
                endTime = System.nanoTime();
                duration = (endTime - startTime) / 1000000;
                System.out.println("Tri fusion sur la description : " + duration + "ms");
                System.out.print("Appuyez sur Entrer pour continuer...");
                Scanner.nextLine();
                menuPrincipal();
                break;
            case "J":
                startTime = System.nanoTime();
                database.triFussion("nbVotesParSpec");
                endTime = System.nanoTime();
                duration = (endTime - startTime) / 1000000;
                System.out.println("Tri fusion sur le nombre de votes de spectateurs : " + duration + "ms");
                System.out.print("Appuyez sur Entrer pour continuer...");
                Scanner.nextLine();
                menuPrincipal();
                break;
            case "K":
                startTime = System.nanoTime();
                database.triFussion("moyVotes");
                endTime = System.nanoTime();
                duration = (endTime - startTime) / 1000000;
                System.out.println("Tri fusion sur la moyenne des votes : " + duration + "ms");
                System.out.print("Appuyez sur Entrer pour continuer...");
                Scanner.nextLine();
                menuPrincipal();
                break;
            case "8":
                menuPrincipal();
                break;
            case "9":
                database.suppressionUnAUn();
                selectFichier();
                break;
            case "0":
                System.exit(0);
                break;
            default:
                interfaceTriFusion();
                break;
        }
    }
    
    private static void interfaceTriJava() throws IOException {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
        System.out.println("────────────────────────────────────────");
        System.out.println("  Sur quoi voulez vous faire le tri Java ?");
        System.out.println("    [A] Le titre du film");
        System.out.println("    [B] L'année de réalisation");
        System.out.println("    [C] Le genre du film");
        System.out.println("    [D] La durée du film");
        System.out.println("    [E] Le pays de production");
        System.out.println("    [F] La langue");
        System.out.println("    [G] Le réalisateur");
        System.out.println("    [H] La liste des acteurs");
        System.out.println("    [I] La description");
        System.out.println("    [J] Le nombre de votes de spectateurs");
        System.out.println("    [K] La moyenne des votes");
        System.out.println("");
        System.out.println("  ────────────────────────────────────");
        System.out.println("");
        System.out.println("    [8] Pour revenir au menu principal");
        System.out.println("    [9] Pour changer de fichier");
        System.out.println("    [0] Pour quitter le programme");
        System.out.println("");
        System.out.println("────────────────────────────────────────");
        System.out.print("Votre réponse : ");
        String response = Scanner.nextLine();
        switch (response) {
            case "A":
                startTime = System.nanoTime();
                database.triJava("titre");
                endTime = System.nanoTime();
                duration = (endTime - startTime) / 1000000;
                System.out.println("Tri Java sur le titre du film : " + duration + "ms");
                System.out.print("Appuyez sur Entrer pour continuer...");
                Scanner.nextLine();
                menuPrincipal();
                break;
            case "B":
                startTime = System.nanoTime();
                database.triJava("anneeRea");
                endTime = System.nanoTime();
                duration = (endTime - startTime) / 1000000;
                System.out.println("Tri Java sur l'année de réalisation : " + duration + "ms");
                System.out.print("Appuyez sur Entrer pour continuer...");
                Scanner.nextLine();
                menuPrincipal();
                break;
            case "C":
                startTime = System.nanoTime();
                database.triJava("Genre");
                endTime = System.nanoTime();
                duration = (endTime - startTime) / 1000000;
                System.out.println("Tri Java sur le genre du film : " + duration + "ms");
                System.out.print("Appuyez sur Entrer pour continuer...");
                Scanner.nextLine();
                menuPrincipal();
                break;
            case "D":
                startTime = System.nanoTime();
                database.triJava("Duree");
                endTime = System.nanoTime();
                duration = (endTime - startTime) / 1000000;
                System.out.println("Tri Java sur la durée du film : " + duration + "ms");
                System.out.print("Appuyez sur Entrer pour continuer...");
                Scanner.nextLine();
                menuPrincipal();
                break;
            case "E":
                startTime = System.nanoTime();
                database.triJava("PaysProd");
                endTime = System.nanoTime();
                duration = (endTime - startTime) / 1000000;
                System.out.println("Tri Java sur le pays de production : " + duration + "ms");
                System.out.print("Appuyez sur Entrer pour continuer...");
                Scanner.nextLine();
                menuPrincipal();
                break;
            case "F":
                startTime = System.nanoTime();
                database.triJava("langue");
                endTime = System.nanoTime();
                duration = (endTime - startTime) / 1000000;
                System.out.println("Tri Java sur la langue : " + duration + "ms");
                System.out.print("Appuyez sur Entrer pour continuer...");
                Scanner.nextLine();
                menuPrincipal();
                break;
            case "G":
                startTime = System.nanoTime();
                database.triJava("Realisateur");
                endTime = System.nanoTime();
                duration = (endTime - startTime) / 1000000;
                System.out.println("Tri Java sur le réalisateur : " + duration + "ms");
                System.out.print("Appuyez sur Entrer pour continuer...");
                menuPrincipal();
                break;
            case "H":
                startTime = System.nanoTime();
                database.triJava("Acteurs");
                endTime = System.nanoTime();
                duration = (endTime - startTime) / 1000000;
                System.out.println("Tri Java sur la liste des acteurs : " + duration + "ms");
                System.out.print("Appuyez sur Entrer pour continuer...");
                Scanner.nextLine();
                menuPrincipal();
                break;
            case "I":
                startTime = System.nanoTime();
                database.triJava("desc");
                endTime = System.nanoTime();
                duration = (endTime - startTime) / 1000000;
                System.out.println("Tri Java sur la description : " + duration + "ms");
                System.out.print("Appuyez sur Entrer pour continuer...");
                Scanner.nextLine();
                menuPrincipal();
                break;
            case "J":
                startTime = System.nanoTime();
                database.triJava("nbVotesParSpec");
                endTime = System.nanoTime();
                duration = (endTime - startTime) / 1000000;
                System.out.println("Tri Java sur le nombre de votes de spectateurs : " + duration + "ms");
                System.out.print("Appuyez sur Entrer pour continuer...");
                Scanner.nextLine();
                menuPrincipal();
                break;
            case "K":
                startTime = System.nanoTime();
                database.triJava("moyVotes");
                endTime = System.nanoTime();
                duration = (endTime - startTime) / 1000000;
                System.out.println("Tri Java sur la moyenne des votes : " + duration + "ms");
                System.out.print("Appuyez sur Entrer pour continuer...");
                Scanner.nextLine();
                menuPrincipal();
                break;
            case "8":
                menuPrincipal();
                break;
            case "9":
                database.suppressionUnAUn();
                selectFichier();
                break;
            case "0":
                System.exit(0);
                break;
            default:
                interfaceTriJava();
                break; 
        }
    }
}
