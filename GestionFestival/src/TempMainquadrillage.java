
public class TempMainquadrillage {

	public static void main(String[] args) {
		Quadrillage q = new Quadrillage(10,10);
		Scene s = new Scene(1,1);
		Scene s2 = new Scene(2,2);
		s.placement(q);
		s2.placement(q);
		q.afficheConsole();
	}
}
