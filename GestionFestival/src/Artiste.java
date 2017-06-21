
public class Artiste {
	private String nom;
	private String genre;
	private String duree;
	public Artiste(String nom, String genre, String duree) {
		super();
		this.nom = nom;
		this.genre = genre;
		this.duree = duree;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getDuree() {
		return duree;
	}
	public void setDuree(String duree) {
		this.duree = duree;
	}
}
