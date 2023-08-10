import javax.swing.ImageIcon;

public class AMissile extends Missile {

	public AMissile() {
		super();
	}

	public AMissile(int xV, int yV) {
		super(xV, yV, 10, 20, new ImageIcon("AMissile.png")); // add imageicon when you find one
	}

	public void setY() {
		super.setdy(1); // just demo code for now
	}

	public void setX() {
		super.setdx(0); // just demo code for now
	}

	public boolean pCol(PlayerSpaceship p) {
		if (((getY() + getH() >= p.getY()) && (getX() <= (p.getX() + (p.getW()))) && (getX() + getW() >= p.getX()))) {
			return true;
		}
		return false;
	}

	public boolean sCol(PlayerSpaceship p) {
		if (((getY() + getH() >= p.getY() - 50) && (getX() <= (p.getX() + (p.getW()))) && (getX() + getW() >= p.getX()))) {
			return true;
		}
		return false;
	}

}
