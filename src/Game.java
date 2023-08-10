import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Game extends JPanel implements Runnable, KeyListener, MouseListener, MouseMotionListener {

	private BufferedImage back;
	private int rand, key, col, row, aX, aY, aX1, aY1, sx, sy, pX, pY, random, playernum, pmX, pmY, amX, amY, aliennum,
			wallhit, count, lives;
	private ImageIcon bground;
	private ArrayList<AlienSpaceship> AliensList;
	private ArrayList<PMissile> PMList;
	private ArrayList<AMissile> AMList;
	private Shield shield;
	private PlayerSpaceship player1;
	private boolean hit, phit, shieldhit, alienswitch, wall, spress, spacep, win, lose;
	private Audio play;

	public Game() {
		new Thread(this).start();
		back = null;
		this.addKeyListener(this);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		key = -1;
		alienswitch = false;
		AliensList = new ArrayList<AlienSpaceship>();
		bground = new ImageIcon("Background.png");
		PMList = new ArrayList<PMissile>();
		AMList = new ArrayList<AMissile>();
		wallhit = 0;
		lives = 1;
		win = false;
		lose = false;
		play = new Audio();

		makeAliens();
		setPlayers();
		makeShield();

		play.playmusic("Battle Music.wav");

	}

	public void run() {
		try {
			while (true) {
				Thread.currentThread().sleep(aliennum);
				repaint();
			}
		} catch (Exception e) {
		}
	}

	public void makeAliens() {

		row = 3;
		col = 10;
		aX = 250;
		aX1 = 250;
		aY = 30;
		aY1 = 30;
		aY = aY1;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				rand = (int) ((Math.random() * (2 - 0 + 1)) + 0);
				AliensList.add(new AlienSpaceship(aX, aY, rand));
				aX = aX + 55;
			}
			aY = aY + 50;
			aX = aX1;
		}
	}

	public void setPlayers() {

		playernum = 1;
		pX = 400;
		pY = 450;

		player1 = new PlayerSpaceship(pX, pY);

	}

	public void makeShield() {

		sx = player1.getX();
		sy = player1.getY();
		shield = new Shield(sx, sy);

	}

	public void respawn() {

		player1.setX(400);
		player1.setY(450);

	}

	public void makePMissiles() {

		pmX = player1.getX() + 30;
		pmY = player1.getY() - 10;

		PMList.add(new PMissile(pmX, pmY));

	}

	public void makeAMissiles() {
		random = (int) (Math.random() * AliensList.size());
		amX = AliensList.get(random).getX() + 50;
		amY = AliensList.get(random).getY() - 20;

		AMList.add(new AMissile(amX, amY));

	}

	public boolean checkwall() {
		for (AlienSpaceship a : AliensList) {

			if (a.getX() + a.getW() >= 900) {
				wall = true;
				alienswitch = true;
				return true;
			} else if (a.getX() <= -40) {
				alienswitch = false;
				wall = true;
				return true;

			}
		}
		wall = false;
		return false;
	}

	public void moveDown() {
		if (wall) {
			wallhit += 3;

			wall = false;
		} else {
			wallhit = 0;

		}
	}

	public void paint(Graphics g) {
		Graphics2D twoDgraph = (Graphics2D) g;
		if (back == null) {
			back = (BufferedImage) (createImage(getWidth(), getHeight()));
		}

		Graphics g2d = back.createGraphics();

		g2d.clearRect(0, 0, getSize().width, getSize().height);

		g2d.drawImage(bground.getImage(), 0, 0, 900, 565, this);

		if (AliensList.isEmpty()) {
			win = true;
			g2d.setColor(new Color(0, 100, 0));

			g2d.setFont(new Font("Arial", Font.BOLD, 50));
			g2d.drawString("CONGRATS YOU WIN!!!", 200, 200);

		}
		if (lives == 0 || lose) {
			lose = true;
			g2d.setColor(new Color(100, 0, 0));

			g2d.setFont(new Font("Arial", Font.BOLD, 50));
			g2d.drawString("DANG YOU LOST!!!", 200, 200);

		}

		if (AliensList.size() >= 21) {
			aliennum = (AliensList.size() / 4);
		}
		if (AliensList.size() >= 9 && AliensList.size() <= 20) {
			aliennum = (AliensList.size() / 3);
		}

		if (checkwall()) {
			moveDown();
			for (AlienSpaceship a : AliensList) {
				if (alienswitch) {
					a.setdx(-1);
					a.setdy(wallhit);
				} else {
					a.setdx(1);
				}
			}
		} else {
			for (AlienSpaceship a : AliensList) {
				a.setdy(0);
			}

		}

		for (AlienSpaceship a : AliensList) {
			a.move();

		}
		if (!win && !lose) {

			if (spacep) {
				g2d.drawImage(shield.getPic().getImage(), player1.getX(), player1.getY() - 50, player1.getW(),
						player1.getH(), this);
			}
			g2d.drawImage(player1.getPic().getImage(), player1.getX(), player1.getY(), player1.getW(), player1.getH(),
					this);

			if (PMList.size() > 0) {
				for (PMissile pm : PMList) {
					g2d.drawImage(pm.getPic().getImage(), pm.getX(), pm.getY(), pm.getW(), pm.getH(), this);
					pm.setdy(-2);
				}
			}

			if (AMList.size() > 0) {
				for (AMissile am : AMList) {
					g2d.drawImage(am.getPic().getImage(), am.getX(), am.getY(), am.getW(), am.getH(), this);
					am.setdy(2);
				}
			}
		}

		for (PMissile pm : PMList) {
			for (int i = 0; i < AliensList.size(); i++) {
				if (pm.aCol(AliensList.get(i))) {
					if (hit) {
						AliensList.remove(i);
						hit = false;
					}
					PMList.remove(pm);
				}

			}
		}
		for (AMissile am : AMList) {
			if (!spacep) {
				if (am.pCol(player1)) {

					if (phit) {
						if (lives > 0) {
							respawn();
						}
						lives -= 1;
						phit = false;

					}
					AMList.remove(am);

				}
			} else {
				if (am.sCol(player1)) {
					if (shieldhit) {
						shieldhit = false;
					}
					AMList.remove(am);

				}
			}
		}

		hit = true;
		phit = true;
		shieldhit = true;
		count++;

		if (count == 300 && !lose && !win) {
			if (!AliensList.isEmpty()) {
				makeAMissiles();
				count = 0;
			}
		}

		if (!win && !lose) {
			for (AlienSpaceship a : AliensList) {

				if (a.playCol(player1)) {
					lose = true;

				}

				a.setPic("alienship.png");

				g2d.drawImage(a.getPic().getImage(), a.getX(), a.getY(), a.getW(), a.getH(), this);
			}

		}
		twoDgraph.drawImage(back, 0, 0, null);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		key = e.getKeyCode();

		if (key == 39) {
			player1.setdx(10);
		}
		if (key == 37) {
			player1.setdx(-10);
		}
		if (key == 32) {
			spacep = !spacep;
		}
		if (key == 83) {
			spress = !spress;
		}
		if (key == 38) {
			for (int i = 0; i < AliensList.size(); i++) {
				AliensList.remove(i);
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		makePMissiles();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
