
public class TempMainquadrillage {

	public static void main(String[] args) {
		Quadrillage q = new Quadrillage(20,10);
		
		Eau e1 = new Eau(2,9);
		Scene s1 = new Scene(2,2);
		
		e1.placement(q);
		s1.placement(q);
		q.afficheConsole();
	}
}
