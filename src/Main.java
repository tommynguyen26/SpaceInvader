import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
	
	private static final int WIDTH = 900;
	private static final int HEIGHT = 600;
	
	public Main () {
		super("SpaceInvaders");
		setSize(WIDTH, HEIGHT);
		Game play = new Game();
		((Component) play).setFocusable(true);
		setBackground(Color.WHITE);
		getContentPane().add(play);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		Main run = new Main();
	}
	
}
