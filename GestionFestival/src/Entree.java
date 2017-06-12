import java.util.ArrayList;

public class Entree {

	
	private ArrayList<Ticket> ticket_data;
	
	

	public Entree(ArrayList<Ticket> ticket_data) {
		this.ticket_data = ticket_data;
	}


	public void creer_ticket(String new_nom, double new_tarif)
	{
			Ticket tick = new Ticket(new_nom, new_tarif);
			this.getTicket_data().add(tick);
	}
	
	
	public void supprimer_ticket(String nom_ticket_a_supp)
	{
		boolean bool = false;
		int i = 0;
		while(bool == false && i < this.ticket_data.size())
		{
			if (this.ticket_data.get(i).getNom().equals(nom_ticket_a_supp))
			{
				this.ticket_data.remove(i);
				bool = true;
			}
			i++;
		}
	}
	
	public void afficher_tout_les_tickets(int i)
	{
		System.out.println("> Nom : "+this.getTicket_data().get(i).getNom()+" Tarif : "+this.getTicket_data().get(i).getTarif()+" Vendu : "+this.getTicket_data().get(i).getNombre_vendu());
	}


	public int recuperer_index_ticket(String ticket_recherche)
	{
		boolean bool = false;
		int i = 0;
		while(bool == false && i < this.ticket_data.size())
		{
			if (this.ticket_data.get(i).getNom().equals(ticket_recherche))
			{
				bool = true;
			}
			else
			{
				i++;
			}
		}
		return i;
	}
	
	
	
	
	public ArrayList<Ticket> getTicket_data() {
		return ticket_data;
	}


	public void setTicket_data(ArrayList<Ticket> ticket_data) {
		this.ticket_data = ticket_data;
	}
	
	
	public static void main(String [] args)
	{
		ArrayList ticket_data = new ArrayList<Ticket>();
		Entree e = new Entree(ticket_data);
		
		e.creer_ticket("Test n_111", 9.99);
		e.creer_ticket("Test n_222", 19.99);
		e.creer_ticket("Test n_333", 15.49);
		
		e.getTicket_data().get(e.recuperer_index_ticket("Test n_111")).vendu();;
		
		e.getTicket_data().get(e.recuperer_index_ticket("Test n_222")).vendu();;
		e.getTicket_data().get(e.recuperer_index_ticket("Test n_222")).vendu();;
		e.getTicket_data().get(e.recuperer_index_ticket("Test n_222")).vendu();;
		
		
		e.afficher_tout_les_tickets(e.recuperer_index_ticket("Test n_111"));
		e.afficher_tout_les_tickets(e.recuperer_index_ticket("Test n_222"));
		e.afficher_tout_les_tickets(e.recuperer_index_ticket("Test n_333"));
	}
	

}
