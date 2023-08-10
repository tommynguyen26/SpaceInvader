import javax.swing.ImageIcon;

public class Spaceship {

	private int x, y, width, height, dx, dy;
	private ImageIcon pic;
	
	public Spaceship() {
		x=0;
		y=0;
		dy=0;
		dx=0;
		width=0;
		height=0;
		pic = new ImageIcon();
	}
	
	public Spaceship(int xV, int yV, int w, int h, ImageIcon i) {	
		x=xV;
		y=yV;
		dy=0;
		dx=0;
		width=w;
		height=h;
		pic = i;
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
	
	public void setDX(int a) {
		x+=a;
	}
	
	public void setDY(int b) {
		y+=b;	
	}
	
	public int getY() {
		return y;
	}
	
	public int getW() {
		return width;
	}
	
	public int getH() {
		return height;
	}
	
	public void setPic(String picname) {
		pic = new ImageIcon(picname);
	}
	
	public ImageIcon getPic() {
		return pic;
	}
	
	public void setdx(int dx1) {
		dx=dx1;
	}
	
	public void setdy(int dy1) {
		dy=dy1;
	}
	
	public void move() {
		x+=dx;
		y+=dy;
	}
	
}
