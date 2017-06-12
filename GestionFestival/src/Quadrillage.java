import java.util.ArrayList;

public class Quadrillage {
	private Case[][] quadrillage;
	private int taillex,tailley;
	
	public Quadrillage(int x, int y) {
		taillex=x;
		tailley=y;
		quadrillage = new Case[x][y];
		for(int a = 0;a<x;a++){
			for(int b = 0;b<y;b++){
				quadrillage[a][b] = new Case(a,b,"void",false);
			}
		}
	}
	
	public Case found(int x, int y){
		x=x-1;
		y=y-1;
		Case result = quadrillage[x][y];
		return result;
	}
	
	public void setOccupe(int x, int y){
		this.found(x, y).setOccupe(true);
	}
	public void setNotOccupe(int x, int y){
		this.found(x, y).setOccupe(false);
	}
	
	public void afficheConsole(){
		for(int a = 0;a<taillex;a++){
			for(int b = 0;b<tailley;b++){
				if(quadrillage[a][b].isOccupe()){
					System.out.print("x ");
				}else {
					System.out.print("o ");
				}
			}
			System.out.println("");
		}
	}
}