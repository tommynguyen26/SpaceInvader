import javax.swing.ImageIcon;

public class PlayerSpaceship extends Spaceship {

	public PlayerSpaceship() {
		super();
	}

	public PlayerSpaceship(int xV, int yV) {
		super(xV, yV, 50, 50, new ImageIcon("PlayerShip.png")); // add imageicon when you find one
	}

	public void setdx(int dx) {
		super.setDX(dx); // add in real value later
	}

	public void setdy(int dy) {
		super.setDY(dy); // add in real value later
	}

}
