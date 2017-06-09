
public class Case {
	private int x;
	private int y;
	
	private String type;
	
	private boolean occupe;

	public Case(int x, int y, String type, boolean occupe) {
		this.x = x;
		this.y = y;
		this.type = type;
		this.occupe = occupe;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isOccupe() {
		return occupe;
	}

	public void setOccupe(boolean occupe) {
		this.occupe = occupe;
	}
	
	
	

}
