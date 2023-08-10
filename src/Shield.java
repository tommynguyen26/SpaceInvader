import javax.swing.ImageIcon;

public class Shield {

	private int x, y;
	private ImageIcon pic;
	
	public Shield() {
		x=0;
		y=0;
		pic = new ImageIcon();
	}
	
	public Shield (int xV, int yV) {
		x=xV;
		y=yV;
		pic = new ImageIcon("shield.png");
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int a) {	
		x = a;
	}
	
	public void setY(int b) {	
		y = b;
	}

	public int getY() {
		return y;
	}
	
	public ImageIcon getPic() {	
		return pic;
	}
	
}
