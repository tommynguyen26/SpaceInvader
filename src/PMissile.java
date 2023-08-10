import java.util.ArrayList;
import javax.swing.ImageIcon;

public class PMissile extends Missile {

	public PMissile() {
		super();
	}

	public PMissile(int xV, int yV) {
		super(xV, yV, 8, 25, new ImageIcon("PMissile.png")); // add imageicon when you find one
	}

	public void setY() {
		super.setdy(-5); // just demo code for now
	}

	public void setX() {
		super.setdx(-5); // just demo code for now
	}

	public boolean aCol(AlienSpaceship a) {
		if (((getY() + getH() <= a.getY() + 20) && (getX() <= (a.getX() + (a.getW()))) && (getX() + getW() >= a.getX()))) {
			return true;
		}
		return false;
	}

	public int aCollide(ArrayList<AlienSpaceship> aliensList) {
		for (int i = 0; i < aliensList.size(); i++) {
			if (getY() <= (aliensList.get(i).getY() + 20) && (super.getX() <= (aliensList.get(i).getX() + 125) && super.getX() + 20 >= aliensList.get(i).getX())) {
				return i;
			}
		}
		return 1000;

	}

}
