
public class Ticket {
	private String nom;
	private double tarif;
	private int nombre_vendu;
	
	public Ticket(String nom, double tarif){
		this.nom = nom;
		this.tarif = tarif;
		this.nombre_vendu = 0;
	}

	public int getNombre_vendu() {
		return nombre_vendu;
	}

	public void setNombre_vendu(int nombre_vendu) {
		this.nombre_vendu = nombre_vendu;
	}

	public void reset_nombre_vendu()
	{
		this.nombre_vendu = 0;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getTarif() {
		return tarif;
	}

	public void setTarif(int tarif) {
		this.tarif = tarif;
	}
	
	public void vendu()
	{
		this.setNombre_vendu(nombre_vendu+1);
		System.out.println("Vendu +1 "+this.getNom());
	}

}
