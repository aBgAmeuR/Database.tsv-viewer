package Film;

import java.io.Serializable;
import java.util.Comparator;

public class Film implements Serializable {
// classe pour stocker les informations sur un jeu vid�o
  private int id;
	private  String titre;
	private int anneeRea;
	private String genre;
	private int duree;
	private String paysProd;
	private String langue;
	private String realisateur;
	private String acteurs;
	private String desc;
	private Float nbVotesParSpec;
	private int moyVotes;

  // Comparateurs
  static public Comparator<Film> compareId = new Comparator<Film>() {
		public int compare(Film Film1, Film Film2) {return Film1.id - Film2.id;}
	};
	static public Comparator<Film> compareTitre = new Comparator<Film>() {
    public int compare(Film Film1, Film Film2) {return Film1.titre.compareToIgnoreCase(Film2.titre);}
	};
	static public Comparator<Film> compareAnneeRea = new Comparator<Film>() {
		public int compare(Film Film1, Film Film2) {return Film1.anneeRea - Film2.anneeRea;}
	};
    static public Comparator<Film> compareGenre = new Comparator<Film>() {
    public int compare(Film Film1, Film Film2) {return Film1.genre.compareToIgnoreCase(Film2.genre);}
  };
  static public Comparator<Film> compareDuree = new Comparator<Film>() {
    public int compare(Film Film1, Film Film2) {return Film1.duree - Film2.duree;}
  };
  static public Comparator<Film> comparePaysProd = new Comparator<Film>() {
    public int compare(Film Film1, Film Film2) {return Film1.paysProd.compareToIgnoreCase(Film2.paysProd);}
  };
  static public Comparator<Film> compareLangue = new Comparator<Film>() {
    public int compare(Film Film1, Film Film2) {return Film1.langue.compareToIgnoreCase(Film2.langue);}
  };
  static public Comparator<Film> compareRealisateur = new Comparator<Film>() {
    public int compare(Film Film1, Film Film2) {return Film1.realisateur.compareToIgnoreCase(Film2.realisateur);}
  };
  static public Comparator<Film> compareActeurs = new Comparator<Film>() {
    public int compare(Film Film1, Film Film2) {return Film1.acteurs.compareToIgnoreCase(Film2.acteurs);}
  };
  static public Comparator<Film> compareDesc = new Comparator<Film>() {
    public int compare(Film Film1, Film Film2) {return Film1.desc.compareToIgnoreCase(Film2.desc);}
  };
  static public Comparator<Film> compareNbVotesParSpec = new Comparator<Film>() {
    public int compare(Film Film1, Film Film2) {return Float.compare(Film1.nbVotesParSpec, Film2.nbVotesParSpec);}
  };
  static public Comparator<Film> compareMoyVotes = new Comparator<Film>() {
    public int compare(Film Film1, Film Film2) {return Film1.moyVotes - Film2.moyVotes;}
  };
  
  // Constructeur
	public Film(int i, String t, int a, String g, int d, String p, String l, String r, String ac, String de, Float n, int m) {
    id = i;
    titre = t;
    anneeRea = a;
    genre = g;
    duree = d;
    paysProd = p;
    langue = l;
    realisateur = r;
    acteurs = ac;
    desc = de;
    nbVotesParSpec = n;
    moyVotes = m;
	}

    // fonction utile pour l'affichage
    public String toString() { 
      return (f(id + "", 7) + "Titre du Film: " + f(titre + ";", 70) + "Année de réalisation: " + f(anneeRea + ";", 10) + "Genre: " + f(genre + ";", 40) + "Durée: "
          + f(duree + ";", 10) + "Pays de production: " + f(paysProd + ";", 35) + "Langue: " + f(langue + ";", 40) + "Réalisateur: " + f(realisateur + ";", 60)
          + "Acteurs: " + f(acteurs + ";", 40) + "Nombre de votes par spécialité: " + f(nbVotesParSpec + ";", 10)
          + "Moyenne des votes: " + f(moyVotes + ";", 10) + "Description: " + desc.substring(0, Math.min(desc.length(), 250)));
    }

    public static String f(String s, int n) { // fonction pour aligner les colonnes
      return String.format("%-" + n + "s", s); 
    }
  
  public int getId() {return id;}
  public String getTitre() {return titre;}
  public int getAnneeRea() {return anneeRea;}
  public String getGenre() {return genre;}
  public int getDuree() {return duree;}
  public String getPaysProd() {return paysProd;}
  public String getLangue() {return langue;}
  public String getRealisateur() {return realisateur;}
  public String getActeurs() {return acteurs;}
  public String getDesc() {return desc;}
  public Float getNbVotesParSpec() {return nbVotesParSpec;}
  public int getMoyVotes() {return moyVotes;}

  public Object getValue(String s) { // fonction pour récupérer la valeur d'un attribut
    switch (s) { 
      case "id":
        return id;
      case "titre":
        return titre;
      case "anneeRea":
        return anneeRea;
      case "genre":
        return genre;
      case "duree":
        return duree;
      case "paysProd":
        return paysProd;
      case "langue":
        return langue;
      case "realisateur":
        return realisateur;
      case "acteurs":
        return acteurs;
      case "desc":
        return desc;
      case "nbVotesParSpec":
        return nbVotesParSpec;
      case "moyVotes":
        return moyVotes;
      default:
        return null;
    }
  }

}
