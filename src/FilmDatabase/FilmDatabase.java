package FilmDatabase;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import Film.Film;

public class FilmDatabase {
  private LinkedList<Film> films; // Liste de films

  // Constructeur
  public FilmDatabase(LinkedList<Film> films) { // On passe la liste de films en paramètre
    this.films = films; // On l'initialise
  }

  // Méthode de chargement de données à partir d'un fichier
  public void loadData(String filename) throws IOException {
    films.clear(); // On vide la liste avant de charger les données
    BufferedReader tsvReader = new BufferedReader(new FileReader(filename)); // On ouvre le fichier
    String row = tsvReader.readLine(); // On saute la ligne d'entête
    row = tsvReader.readLine(); // On saute la ligne d'entête
    int nb = 0; // On compte le nombre de films
    while (row != null) { // On lit le fichier ligne par ligne

      String[] data = row.split("\t"); // On découpe la ligne en champs

      nb++; // On incrémente le compteur de films
      String title = data[1];
      int anneeRea = Integer.parseInt(data[3]);
      String genre = data[5];
      int duree = Integer.parseInt(data[6]);
      String payString = data[7];
      String langue = data[8];
      String realisateur = data[9];
      String acteurs = data[11];
      String desc = data[12];
      Float nbVotesParSpec = Float.parseFloat(data[14]);
      int moyVotes = Integer.parseInt(data[15]);

      films.add(new Film(nb, title, anneeRea, genre, duree, payString, langue, realisateur, acteurs,
          desc, nbVotesParSpec, moyVotes)); // On crée un film et on l'ajoute à la liste

      row = tsvReader.readLine(); // On passe à la ligne suivante
    }
    tsvReader.close(); // On ferme le fichier
  }

  public int length() { // Retourne le nombre de films
    return films.size(); // On retourne la taille de la liste 
  }

  // ==================== FILTRES ====================

  // FILTRES LINEAIRES
  public void filtreLineareTitre(String titre) { // Filtre linéaire sur le titre
    for (int i = 0; i < films.size(); i++) { // On parcourt la liste de films
      if (!films.get(i).getTitre().contains(titre)) { // Si le titre ne contient pas le mot recherché
        films.remove(i); // On supprime le film
        i--; // On décrémente i pour ne pas sauter un élément
      } // Sinon on passe au film suivant
    }
  }

  public void filtreLineareAnneeRea(int annee) { // Filtre linéaire sur l'année
    for (int i = 0; i < films.size(); i++) { // On parcourt la liste de films
      if (films.get(i).getAnneeRea() != annee) { // Si l'année n'est pas celle recherchée
        films.remove(i); // On supprime le film
        i--; // On décrémente i pour ne pas sauter un élément
      } // Sinon on passe au film suivant
    }
  }

  public void filtreLineareGenre(String genre) { // Filtre linéaire sur le genre
    for (int i = 0; i < films.size(); i++) { // On parcourt la liste de films
      if (!films.get(i).getGenre().contains(genre)) { // Si le genre ne contient pas le mot recherché
        films.remove(i); // On supprime le film
        i--; // On décrémente i pour ne pas sauter un élément
      } // Sinon on passe au film suivant
    }
  }

  public void filtreLineareDuree(int min, int max) { // Filtre linéaire sur la durée
    for (int i = 0; i < films.size(); i++) { // On parcourt la liste de films
      if (films.get(i).getDuree() < min || films.get(i).getDuree() > max) { // Si la durée n'est pas comprise entre min et max
        films.remove(i); // On supprime le film
        i--; // On décrémente i pour ne pas sauter un élément
      } // Sinon on passe au film suivant
    }
  }

  public void filtreLinearePays(String pays) { // Filtre linéaire sur le pays
    for (int i = 0; i < films.size(); i++) { // On parcourt la liste de films
      if (!films.get(i).getPaysProd().contains(pays)) { // Si le pays ne contient pas le mot recherché
        films.remove(i); // On supprime le film
        i--; // On décrémente i pour ne pas sauter un élément
      } // Sinon on passe au film suivant
    }
  }

  public void filtreLineareLangue(String langue) { // Filtre linéaire sur la langue
    for (int i = 0; i < films.size(); i++) { // On parcourt la liste de films
      if (!films.get(i).getLangue().contains(langue)) { // Si la langue ne contient pas le mot recherché
        films.remove(i); // On supprime le film
        i--; // On décrémente i pour ne pas sauter un élément
      } // Sinon on passe au film suivant
    }
  }

  public void filtreLineareRealisateur(String realisateur) { // Filtre linéaire sur le réalisateur
    for (int i = 0; i < films.size(); i++) { // On parcourt la liste de films
      if (!films.get(i).getRealisateur().contains(realisateur)) { // Si le réalisateur ne contient pas le mot recherché
        films.remove(i); // On supprime le film
        i--; // On décrémente i pour ne pas sauter un élément
      } // Sinon on passe au film suivant
    }
  }

  public void filtreLineareActeur(String acteur) { // Filtre linéaire sur l'acteur
    for (int i = 0; i < films.size(); i++) { // On parcourt la liste de films
      if (!films.get(i).getActeurs().contains(acteur)) { // Si l'acteur ne contient pas le mot recherché
        films.remove(i); // On supprime le film
        i--; // On décrémente i pour ne pas sauter un élément
      } // Sinon on passe au film suivant
    }
  }

  public void filtreLineareDescription(String description) { // Filtre linéaire sur la description
    for (int i = 0; i < films.size(); i++) { // On parcourt la liste de films
      if (!films.get(i).getDesc().contains(description)) { // Si la description ne contient pas le mot recherché
        films.remove(i); // On supprime le film
        i--; // On décrémente i pour ne pas sauter un élément
      } // Sinon on passe au film suivant
    }
  }

  // FILTRES JAVA
  public void filtreJavaTitre(String titre) { // Filtre linéaire sur le titre
    films.removeIf(film -> !film.getTitre().contains(titre)); // Si le titre ne contient pas le mot recherché
  }

  public void filtreJavaAnneeRea(int annee) { // Filtre linéaire sur l'année de réalisation
    films.removeIf(film -> film.getAnneeRea() != annee); // Si l'année de réalisation n'est pas égale à l'année recherchée
  }

  public void filtreJavaGenre(String genre) { // Filtre linéaire sur le genre
    films.removeIf(film -> !film.getGenre().contains(genre)); // Si le genre ne contient pas le mot recherché
  }

  public void filtreJavaDuree(int min, int max) { // Filtre linéaire sur la durée
    films.removeIf(film -> film.getDuree() < min || film.getDuree() > max); // Si la durée n'est pas comprise entre min et max
  }

  public void filtreJavaPays(String pays) { // Filtre linéaire sur le pays
    films.removeIf(film -> !film.getPaysProd().contains(pays)); // Si le pays ne contient pas le mot recherché
  }

  public void filtreJavaLangue(String langue) { // Filtre linéaire sur la langue
    films.removeIf(film -> !film.getLangue().contains(langue)); // Si la langue ne contient pas le mot recherché
  }

  public void filtreJavaRealisateur(String realisateur) { // Filtre linéaire sur le réalisateur
    films.removeIf(film -> !film.getRealisateur().contains(realisateur)); // Si le réalisateur ne contient pas le mot recherché
  }

  public void filtreJavaActeur(String acteur) { // Filtre linéaire sur l'acteur
    films.removeIf(film -> !film.getActeurs().contains(acteur)); // Si l'acteur ne contient pas le mot recherché
  }

  public void filtreJavaDescription(String description) { // Filtre linéaire sur la description
      films.removeIf(film -> !film.getDesc().contains(description)); // Si la description ne contient pas le mot recherché
  }

  // ==================== TRI ====================

  // TRI SELECTION
  public void triSelection(String s) {
    if (s.equals("titre")) { // Si on veut trier par titre
      for (int i = 0; i < films.size() - 1; i++) { // On parcourt la liste de films
        int minIndex = i; // On initialise l'index du minimum à i
        for (int j = i + 1; j < films.size(); j++) { // On parcourt la liste de films à partir de i+1
          if (films.get(j).getTitre().compareTo(films.get(minIndex).getTitre()) < 0) { // Si le titre du film j est alphabétiquement inférieur au titre du film minIndex
            minIndex = j; // On met à jour l'index du minimum
          } // Sinon on passe au film suivant
        } // On a trouvé le minimum
        if (minIndex != i) { // Si l'index du minimum n'est pas égal à i
          Film temp = films.get(i); // On échange les films
          films.set(i, films.get(minIndex)); // On échange les films
          films.set(minIndex, temp); // On échange les films
        } // Sinon on passe au film suivant
      }  // On a trié la liste de films
    } else if (s.equals("AnneeRea")) {
      for (int i = 0; i < films.size() - 1; i++) {
        int minIndex = i;
        for (int j = i + 1; j < films.size(); j++) {
          if (films.get(j).getAnneeRea() < films.get(minIndex).getAnneeRea()) {
            minIndex = j;
          }
        }
        if (minIndex != i) {
          Film temp = films.get(i);
          films.set(i, films.get(minIndex));
          films.set(minIndex, temp);
        }
      }
    } else if (s.equals("Duree")) {
      for (int i = 0; i < films.size() - 1; i++) {
        int minIndex = i;
        for (int j = i + 1; j < films.size(); j++) {
          if (films.get(j).getDuree() < films.get(minIndex).getDuree()) {
            minIndex = j;
          }
        }
        if (minIndex != i) {
          Film temp = films.get(i);
          films.set(i, films.get(minIndex));
          films.set(minIndex, temp);
        }
      }
    } else if (s.equals("Genre")) {
      for (int i = 0; i < films.size() - 1; i++) {
        int minIndex = i;
        for (int j = i + 1; j < films.size(); j++) {
          if (films.get(j).getGenre().compareTo(films.get(minIndex).getGenre()) < 0) {
            minIndex = j;
          }
        }
        if (minIndex != i) {
          Film temp = films.get(i);
          films.set(i, films.get(minIndex));
          films.set(minIndex, temp);
        }
      }
    } else if (s.equals("PayProd")) {
      for (int i = 0; i < films.size() - 1; i++) {
        int minIndex = i;
        for (int j = i + 1; j < films.size(); j++) {
          if (films.get(j).getPaysProd().compareTo(films.get(minIndex).getPaysProd()) < 0) {
            minIndex = j;
          }
        }
        if (minIndex != i) {
          Film temp = films.get(i);
          films.set(i, films.get(minIndex));
          films.set(minIndex, temp);
        }
      }
    } else if (s.equals("langue")) {
      for (int i = 0; i < films.size() - 1; i++) {
        int minIndex = i;
        for (int j = i + 1; j < films.size(); j++) {
          if (films.get(j).getLangue().compareTo(films.get(minIndex).getLangue()) < 0) {
            minIndex = j;
          }
        }
        if (minIndex != i) {
          Film temp = films.get(i);
          films.set(i, films.get(minIndex));
          films.set(minIndex, temp);
        }
      }
    } else if (s.equals("Realisateur")) {
      for (int i = 0; i < films.size() - 1; i++) {
        int minIndex = i;
        for (int j = i + 1; j < films.size(); j++) {
          if (films.get(j).getRealisateur().compareTo(films.get(minIndex).getRealisateur()) < 0) {
            minIndex = j;
          }
        }
        if (minIndex != i) {
          Film temp = films.get(i);
          films.set(i, films.get(minIndex));
          films.set(minIndex, temp);
        }
      }
    } else if (s.equals("Acteurs")) {
      for (int i = 0; i < films.size() - 1; i++) {
        int minIndex = i;
        for (int j = i + 1; j < films.size(); j++) {
          if (films.get(j).getActeurs().compareTo(films.get(minIndex).getActeurs()) < 0) {
            minIndex = j;
          }
        }
        if (minIndex != i) {
          Film temp = films.get(i);
          films.set(i, films.get(minIndex));
          films.set(minIndex, temp);
        }
      }
    } else if (s.equals("desc")) {
      for (int i = 0; i < films.size() - 1; i++) {
        int minIndex = i;
        for (int j = i + 1; j < films.size(); j++) {
          if (films.get(j).getDesc().compareTo(films.get(minIndex).getDesc()) < 0) {
            minIndex = j;
          }
        }
        if (minIndex != i) {
          Film temp = films.get(i);
          films.set(i, films.get(minIndex));
          films.set(minIndex, temp);
        }
      }
    } else if (s.equals("nbVotesParSpec")) {
      for (int i = 0; i < films.size() - 1; i++) {
        int minIndex = i;
        for (int j = i + 1; j < films.size(); j++) {
          if (films.get(j).getNbVotesParSpec() < films.get(minIndex).getNbVotesParSpec()) {
            minIndex = j;
          }
        }
        if (minIndex != i) {
          Film temp = films.get(i);
          films.set(i, films.get(minIndex));
          films.set(minIndex, temp);
        }
      }
    } else if (s.equals("moyVotes")) {
      for (int i = 0; i < films.size() - 1; i++) {
        int minIndex = i;
        for (int j = i + 1; j < films.size(); j++) {
          if (films.get(j).getMoyVotes() < films.get(minIndex).getMoyVotes()) {
            minIndex = j;
          }
        }
        if (minIndex != i) {
          Film temp = films.get(i);
          films.set(i, films.get(minIndex));
          films.set(minIndex, temp);
        }
      }
    }
  }

  // TRI FUSSION
  public void triFussion(String s) {
    if (s.equals("titre")) {
      films = (LinkedList<Film>) triFussion(films, (f1, f2) -> f1.getTitre().compareTo(f2.getTitre()));
    } else if (s.equals("anneeRea")) {
      films = (LinkedList<Film>) triFussion(films, (f1, f2) -> f1.getAnneeRea() - f2.getAnneeRea());
    } else if (s.equals("Genre")) {
      films = (LinkedList<Film>) triFussion(films, (f1, f2) -> f1.getGenre().compareTo(f2.getGenre()));
    } else if (s.equals("Duree")) {
      films = (LinkedList<Film>) triFussion(films, (f1, f2) -> f1.getDuree() - f2.getDuree());
    } else if (s.equals("PaysProd")) {
      films = (LinkedList<Film>) triFussion(films, (f1, f2) -> f1.getPaysProd().compareTo(f2.getPaysProd()));
    } else if (s.equals("langue")) {
      films = (LinkedList<Film>) triFussion(films, (f1, f2) -> f1.getLangue().compareTo(f2.getLangue()));
    } else if (s.equals("Realisateur")) {
      films = (LinkedList<Film>) triFussion(films, (f1, f2) -> f1.getRealisateur().compareTo(f2.getRealisateur()));
    } else if (s.equals("Acteurs")) {
      films = (LinkedList<Film>) triFussion(films, (f1, f2) -> f1.getActeurs().compareTo(f2.getActeurs()));
    } else if (s.equals("desc")) {
      films = (LinkedList<Film>) triFussion(films, (f1, f2) -> f1.getDesc().compareTo(f2.getDesc()));
    } else if (s.equals("nbVotesParSpec")) {
      films = (LinkedList<Film>) triFussion(films,
          (f1, f2) -> Float.compare(f1.getNbVotesParSpec(), f2.getNbVotesParSpec()));
    } else if (s.equals("moyVotes")) {
      films = (LinkedList<Film>) triFussion(films, (f1, f2) -> f1.getMoyVotes() - f2.getMoyVotes());
    }
  }

  private LinkedList<Film> triFussion(LinkedList<Film> films, Comparator<Film> comp) {
    if (films.size() <= 1) { // si la liste est vide ou contient un seul élément, on la retourne
      return films; // si la liste est vide ou contient un seul élément, on la retourne
    }

    LinkedList<Film> left = new LinkedList<>(films.subList(0, films.size() / 2)); // on divise la liste en deux
    LinkedList<Film> right = new LinkedList<>(films.subList(films.size() / 2, films.size())); // on divise la liste en deux

    left = triFussion(left, comp); // on trie la liste de gauche
    right = triFussion(right, comp); // on trie la liste de droite

    return triFussion(left, right, comp); // on fusionne les deux listes
  }

  private LinkedList<Film> triFussion(LinkedList<Film> left, LinkedList<Film> right, Comparator<Film> comp) {
    LinkedList<Film> result = new LinkedList<>(); // liste de film

    int leftIndex = 0; // index de gauche
    int rightIndex = 0; // index de droite

    while (leftIndex < left.size() && rightIndex < right.size()) { // tant que l'index de gauche et de droite sont inferieur a la taille de la liste
      if (comp.compare(left.get(leftIndex), right.get(rightIndex)) < 0) { // si la comparaison de la liste de gauche et de droite est inferieur a 0
        result.add(left.get(leftIndex++)); // ajouter la liste de gauche
      } else { // sinon
        result.add(right.get(rightIndex++)); // ajouter la liste de droite
      } 
    }
    while (leftIndex < left.size()) { // tant que l'index de gauche est inferieur a la taille de la liste de gauche
      result.add(left.get(leftIndex++));  // ajouter la liste de gauche
    } 
    while (rightIndex < right.size()) { // tant que l'index de droite est inferieur a la taille de la liste de droite
      result.add(right.get(rightIndex++)); // ajouter la liste de droite
    }
    return result; // retourner la liste
  }

  // TRI JAVA
  public void triJava(String s) { // tri java
    if (s.equals("titre")) {
      Collections.sort(films, (f1, f2) -> f1.getTitre().compareTo(f2.getTitre())); 
    } else if (s.equals("anneeRea")) {
      Collections.sort(films, (f1, f2) -> f1.getAnneeRea() - f2.getAnneeRea());
    } else if (s.equals("Genre")) {
      Collections.sort(films, (f1, f2) -> f1.getGenre().compareTo(f2.getGenre()));
    } else if (s.equals("duree")) {
      Collections.sort(films, (f1, f2) -> f1.getDuree() - f2.getDuree());
    } else if (s.equals("PaysProd")) {
      Collections.sort(films, (f1, f2) -> f1.getPaysProd().compareTo(f2.getPaysProd()));
    } else if (s.equals("langue")) {
      Collections.sort(films, (f1, f2) -> f1.getLangue().compareTo(f2.getLangue()));
    } else if (s.equals("Realisateur")) {
      Collections.sort(films, (f1, f2) -> f1.getRealisateur().compareTo(f2.getRealisateur()));
    } else if (s.equals("Acteurs")) {
      Collections.sort(films, (f1, f2) -> f1.getActeurs().compareTo(f2.getActeurs()));
    } else if (s.equals("desc")) {
      Collections.sort(films, (f1, f2) -> f1.getDesc().compareTo(f2.getDesc()));
    } else if (s.equals("nbVotesParSpec")) {
      Collections.sort(films, (f1, f2) -> Float.compare(f1.getNbVotesParSpec(), f2.getNbVotesParSpec()));
    } else if (s.equals("moyVotes")) {
      Collections.sort(films, (f1, f2) -> f1.getMoyVotes() - f2.getMoyVotes());
    }
  }

  // ==================== AFFICHAGE ====================

  public void displayData(int n) { // Affiche les données
    if (films.size() == 0)
      return;
    if (n <= 0 || n > films.size()) { // Si n est inférieur ou égal à 0 ou supérieur à la taille de la liste
      n = films.size(); // On affiche tous les films
    }
    for (int i = 0; i < films.size(); i += (films.size() / n)) { // On affiche 1/n des films
      System.out.println(films.get(i).toString()); // On affiche le film
    }
  }

  // ====================recherche======================

  // RECHERCHE LINÉAIRE
  public LinkedList<Film> rechercheLinéaireTitre(String title) { // Recherche linéaire sur le titre
    LinkedList<Film> list = new LinkedList<Film>(); // On crée une liste de films
    for (Film film : films) { // On parcourt la liste de films
      if (film.getTitre().contains(title)) { // Si le titre a une parti de la recherche
        list.add(film); // On ajoute le film à la liste
      }
    }
    return list; // On retourne la liste
  }

  // RECHERCHE DICHOTOMIQUE
  public Film rechercheDichotomiqueTitre(String title) {
    // On trie la liste par titre de film avant de lancer la recherche dichotomique
    films.sort(Film.compareTitre);

    int left = 0; // Indice de gauche
    int right = films.size() - 1; // Indice de droite
    while (left <= right) { // Tant que l'indice de gauche est inférieur ou égal à l'indice de droite
      int mid = left + (right - left) / 2; // On récupère l'indice du milieu
      Film film = films.get(mid); // On récupère le film du milieu
      if (title.compareToIgnoreCase(film.getTitre()) < 0) { // On compare le titre recherché avec le titre du film
        right = mid - 1; // On décale l'indice de droite
      } else if (title.compareToIgnoreCase(film.getTitre()) > 0) { // On compare le titre recherché avec le titre du film
        left = mid + 1; // On décale l'indice de gauche
      } else { // Si le titre recherché est égal au titre du film
        return film; // On retourne le film
      }
    }
    return null; // Film non trouvé
  }

  // ==================== SUPPRESSION ===============

  // SUPPRESSION UN A UN
  public void suppressionUnAUn() { // Suppression un à un
    for (int i = 0; i < films.size(); i++) { // On parcourt la liste de films
      films.remove(i); // On supprime le film
    } // On recommence jusqu'à ce que la liste soit vide
  }
}