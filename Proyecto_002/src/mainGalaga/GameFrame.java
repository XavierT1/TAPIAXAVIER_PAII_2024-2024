package mainGalaga;

import javax.swing.JFrame;

import game_galaga.GamePanel;

public class GameFrame extends JFrame {

	/**
	 * @author XavierTapia Title: Juego Galaga
	 */

	private static final long serialVersionUID = 1L;

	public GameFrame() {
		initUI();
	}

	private void initUI() {
		setTitle("Galaga Game");
		setSize(800, 600); // Tamaño de la ventana
		setLocationRelativeTo(null);
		setResizable(false); // Impide que la ventana sea redimensionable
		setDefaultCloseOperation(EXIT_ON_CLOSE); // Termina el programa cuando se cierra la ventana
		add(new GamePanel());
	}

	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(() -> {
			GameFrame game = new GameFrame();
			game.setVisible(true);
		});
	}
}
