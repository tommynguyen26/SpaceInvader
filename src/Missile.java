import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Missile {

	private int x, y, width, height, dx, dy;
	private ImageIcon pic;
	
	public Missile() {
		x=0;
		y=0;
		dy=0;
		dx=0;
		width=0;
		height=0;
		pic = new ImageIcon();
	}
	
	public Missile(int xV, int yV, int w, int h, ImageIcon i) {
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
	
	public int getY() {
		return y;
	}
	
	public int getW() {
		return width;
	}
	
	public int getH() {
		return height;
	}
	
	public ImageIcon getPic() {
		return pic;
	}
	
	public void setdx(int dx1) {
		x+=dx1;
	}
	
	public void setdy(int dy1) {
		y+=dy1;
	}
	
}
