import java.util.ArrayList;

public class Quadrillage {
	private Case[][] quadrillage;
	private int taillex,tailley;
	
	public Quadrillage(int x, int y){
		taillex=x;
		tailley=y;
		quadrillage = new Case[x*2][y*2];
		for(int i =1;i<=x;i++){
			for(int j =1;j<=y;j++){
				quadrillage[j][i] = new Case(i,j,"",false);
			}
		}
	}
	public void setOccupe(int x,int y){
		quadrillage[y][x].setOccupe(true);
	}
	
	public boolean isOccupe(int x,int y){
		return false;
		
	}
	
	public boolean zoneOccupe(int x, int y, int sizex, int sizey){
		x+=1;
		y+=1;
		sizex-=1;
		sizey-=1;
		boolean result = false;
		for(int i =x;i<=x+sizex;i++){
			for(int j =y;j<=y+sizey;j++){
				if(quadrillage[j][i].isOccupe()){
					result = true;
				}
			}
		}
		return result;
	}
	
	public void zoneSetOccupe(int x, int y, int sizex, int sizey){
		x+=1;
		y+=1;
		sizex-=1;
		sizey-=1;
		for(int i =x;i<=x+sizex;i++){
			for(int j =y;j<=y+sizey;j++){
				this.setOccupe(i, j);
			}
		}
	}
	
	public void affiche(){
		for(int i =1;i<=tailley;i++){
			for(int j =1;j<=taillex;j++){
				if(quadrillage[i][j].isOccupe()){
					System.out.print("x ");
				}else{
					System.out.print(". ");
				}
			}
			System.out.println("");
		}
	}
}