
public class Entree {
	public String nom;
	private int tarif;
	private static int nombre_vendu = 0;
	
	public Entree(String nom, int tarif) {
		this.nom = nom;
		this.tarif = tarif;
		this.nombre_vendu++;
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
			Entree e = new Entree("new_nom", new_tarif);
			System.out.println("Nouvelle entré créee.");
	}
	
	public void reset_nombre_vendu()
	{
		this.nombre_vendu = 0;
	}
}
