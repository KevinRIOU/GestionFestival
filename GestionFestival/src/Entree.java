
public class Entree {
	public String nom;
	private int tarif;
	private static int nombre_vendu;
	
	public Entree(String nom, int tarif) {
		this.nom = nom;
		this.tarif = tarif;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getTarif() {
		return tarif;
	}

	public void setTarif(int tarif) {
		this.tarif = tarif;
	}
	
	public void ajouter_entree(String new_nom, int new_tarif)
	{
			
	}
	
}
