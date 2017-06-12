
public class Module {
	private int x,y,xsize,ysize;
	private String type;
	public Module(int x, int y, int xsize, int ysize, String type) {
		this.x = x;
		this.y = y;
		this.xsize = xsize;
		this.ysize = ysize;
		this.type = type;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getXsize() {
		return xsize;
	}
	public void setXsize(int xsize) {
		this.xsize = xsize;
	}
	public int getYsize() {
		return ysize;
	}
	public void setYsize(int ysize) {
		this.ysize = ysize;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public boolean possibilite_Placement(Quadrillage q){
		boolean valide=true;
		for(int i=x;i<x+xsize;i++){
			for(int j=y;j<y+ysize;j++){
				if(q.isOccupe(i, j)){
					valide=false;
				}
			}
		}
		if(!valide){
			System.out.println("### Erreur : Placement impossible, présence");
		}
		return valide;
	}
	
	public void placement(Quadrillage q){
		if(possibilite_Placement(q)){
			for(int i=x;i<x+xsize;i++){
				for(int j=y;j<y+ysize;j++){
					q.setOccupe(i, j);
					//complétion du type de la case par le type du module
				}
			}
		}
	}
}
