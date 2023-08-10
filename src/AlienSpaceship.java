import javax.swing.ImageIcon;

public class AlienSpaceship extends Spaceship {

	public AlienSpaceship() {
		super();
	}

	public AlienSpaceship(int xV, int yV, int as) {
		super(xV, yV, 75, 75, new ImageIcon("AlienShip.png"));
		super.setdx(1);
		super.setdy(0);
	}

	public void setY() {
		super.setdy(-1); // just demo code for now
	}

	public boolean playCol(PlayerSpaceship p) {
		if (((getY() + getH() >= p.getY() - 50) && (getX() <= (p.getX() + (p.getW())))
				&& (getX() + getW() >= p.getX()))) {
			return true;
		}
		return false;
	}

}
