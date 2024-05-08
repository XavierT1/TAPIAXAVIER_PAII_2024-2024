package game_galaga;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.Graphics;
import java.awt.Window;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Font;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class GamePanel extends JPanel implements Runnable {

	private static final long serialVersionUID = 1L;
	private Thread gameThread;
	private List<Villain> villains;
	private List<HeroBullet> heroBullets;
	private List<VillainBullet> enemyBullets;
	private Hero hero;
	private Score score;
	private Life life;
	private Line divisionLine;
	public boolean gameOver = false;
	public boolean villainsCrossedLimit = false;
	private int numVillainsToAdd = 1;

	public GamePanel() {
		setFocusable(true);
		setBackground(Color.BLACK);
		heroBullets = new ArrayList<>();
		enemyBullets = new ArrayList<>();
		villains = new ArrayList<>();
		initGame();
		setupKeyBindings();

	}

	private void initGame() {
		heroBullets = new ArrayList<>();
		enemyBullets = new ArrayList<>();
		villains = new ArrayList<>();
		hero = new Hero(385, 495, heroBullets);
		score = new Score();
		life = new Life(100);
		divisionLine = new Line(400);
		villains.add(new Villain(270, 60, enemyBullets));
		gameThread = new Thread(this);
		gameThread.start();
	}

	private void setupKeyBindings() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					hero.setMovingLeft(true);
					break;
				case KeyEvent.VK_RIGHT:
					hero.setMovingRight(true);
					break;
				case KeyEvent.VK_UP:
					hero.setMovingUp(true);
					break;
				case KeyEvent.VK_DOWN:
					hero.setMovingDown(true);
					break;
				case KeyEvent.VK_SPACE:
					hero.shoot();

					break;
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					hero.setMovingLeft(false);
					break;
				case KeyEvent.VK_RIGHT:
					hero.setMovingRight(false);
					break;
				case KeyEvent.VK_UP:
					hero.setMovingUp(false);
					break;
				case KeyEvent.VK_DOWN:
					hero.setMovingDown(false);
					break;

				}
			}
		});
	}

	@Override
	public void run() {
		while (true) {
			gameUpdate();
			repaint();
			try {
				Thread.sleep(16);
			} catch (InterruptedException e) {
				System.out.println("Thread interrupted: " + e.getMessage());
			}
		}

	}

	private void gameUpdate() {

		hero.move();
		for (HeroBullet bullet : heroBullets) {
			bullet.move();
		}
		for (VillainBullet bullet : enemyBullets) {
			bullet.move();
		}
		for (Villain villain : villains) {
			// Si algún villano ha cruzado la línea, se detiene su movimiento y disparo
			if (villain.getY() > divisionLine.getY()) {
				villainsCrossedLimit = true;
				villain.stopMoving(); // Detener el movimiento del villano
				villain.stopShooting(); // Detener el disparo del villano
			} else {
				villain.move();
				villain.shoot(); // Asumir que esto podría añadir balas a enemyBullets
			}
		}
		// Verificar si algún villano ha cruzado la línea
		for (Villain villain : villains) {
			if (villain.getY() > divisionLine.getY()) {
				villainsCrossedLimit = true;
				break;
			}
		}
		if (life.getLife() <= 0) {
			gameOver = true;
			stopGame();
			return;
		}

		// Agregar villanos solo si no se ha terminado el juego
		if (!gameOver && villains.isEmpty()) {
			addMoreVillainsRandom();
		}

		// Si la lista de villanos está vacía y la vida del héroe no es cero, agrega más
		// villanos
		if (villains.isEmpty() && hero.getLife() > 0) {
			addMoreVillainsRandom();
		}

		checkCollisions();
		repaint();

		int shipZoneHeight = (int) (getHeight() * 0.66);
		for (Villain villain : villains) {
			if (villain.getY() + villain.getHeight() > getHeight() - shipZoneHeight) {
				gameOver = true; // Cambia gameOver a true si los villanos cruzan el límite
				break;
			}
		}

		// Si la vida del héroe es cero, establece gameOver en true
		if (hero.getLife() <= 0) {
			gameOver = true;

		}
		if (villainsCrossedLimit) {
			gameOver = true;
			restartGame();
			stopGame();
		}
	}

	private void addNewVillainsRandom() {
		Random random = new Random();

		for (int i = 0; i < numVillainsToAdd; i++) {

			int randomX = random.nextInt(getWidth() - 50);
			int randomY = random.nextInt(getHeight() / 2);

			// Agregar el nuevo villano en una posición aleatoria
			villains.add(new Villain(randomX, randomY, enemyBullets));
		}
	}

	// Método para agregar más villanos después de eliminar a todos
	private void addMoreVillainsRandom() {
		numVillainsToAdd++;
		addNewVillainsRandom();
	}

	public void addHeroBullet(HeroBullet bullet) {
		heroBullets.add(bullet);
	}

	public void addEnemyBullet(VillainBullet bullet) {
		enemyBullets.add(bullet);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (hero != null)
			hero.draw(g);
		for (HeroBullet bullet : heroBullets)
			bullet.draw(g);
		for (Villain villain : villains)
			villain.draw(g);
		for (VillainBullet bullet : enemyBullets)
			bullet.draw(g);
		if (score != null)
			score.draw(g);
		if (life != null)
			life.draw(g);
		if (divisionLine != null)
			divisionLine.draw(g);

		for (Villain villain : villains) {
			if (villain.getY() > divisionLine.getY()) {
				villainsCrossedLimit = true;
				break;
			}
		}
		if (villainsCrossedLimit || hero.getLife() <= 0) {
			if (!gameOver) {
				gameOver = true;
				stopGame();
			}

			g.setColor(Color.RED);
			g.setFont(new Font("Arial", Font.BOLD, 36));
			String gameOverMsg = "Game Over";
			int x = (getWidth() - g.getFontMetrics().stringWidth(gameOverMsg)) / 2;
			int y = getHeight() / 2;
			g.drawString(gameOverMsg, x, y);
		}
	}

	private void clearVillains() {
		villains.clear(); // Elimina todos los villanos de la lista
	}

	private boolean gameStopped = false;

	private void stopGame() {
		if (!gameStopped) { // Verifica si el juego ya ha sido detenido
			gameStopped = true; // Marca el juego como detenido para evitar llamadas repetidas

			// Guardar la puntuación final
			int finalScore = score.getScore();

			String summaryMessage = "\nFinal Score: " + finalScore; // Mensaje de resumen con la puntuación final
			JButton restartButton = new JButton("Restart");
			restartButton.addActionListener(e -> {
				// Reiniciar el juego
				initGame(); // Vuelve a iniciar el juego
				gameStopped = false;
				Window window = SwingUtilities.getWindowAncestor(restartButton);
				window.dispose(); // Cerrar la ventana emergente

			});
			Object[] messageComponents = { summaryMessage, restartButton }; // Componentes de la ventana emergente
			JOptionPane.showMessageDialog(this, messageComponents, "Game Over", JOptionPane.PLAIN_MESSAGE);

			// Detener el hilo del juego actual si está en ejecución
			if (gameThread != null) {
				try {
					gameThread.join(); // Espera a que el hilo actual termine su ejecución
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			clearVillains();

		}
	}

	private void restartGame() {
		// Limpiar todas las listas
		heroBullets.clear();
		enemyBullets.clear();
		villains.clear();

		// Reiniciar el héroe, la puntuación y la vida
		hero = new Hero(385, 495, heroBullets);
		score.resetScore();
		life.resetLife();

		// Reiniciar otras variables de control
		gameOver = false;
		villainsCrossedLimit = false;
		numVillainsToAdd = 1;

		// Detener el hilo actual si está en ejecución
		if (gameThread != null) {
			try {
				gameThread.join(); // Espera a que el hilo actual termine su ejecución
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// Iniciar el juego nuevamente
		gameStopped = false;
		initGame();
	}

	public void checkCollisions() {
		List<HeroBullet> bulletsToRemove = new ArrayList<>();
		List<Villain> villainsToRemove = new ArrayList<>();
		List<VillainBullet> bulletsToRemoveFromVillains = new ArrayList<>();

		// Incrementa Score 25 y elimina a los villanos
		for (HeroBullet bullet : heroBullets) {
			for (Villain villain : villains) {
				if (Math.abs(bullet.getX() - villain.getX()) < 40 && Math.abs(bullet.getY() - villain.getY()) < 40
						&& bullet.isActive()) {
					villainsToRemove.add(villain);
					bulletsToRemove.add(bullet);
					score.increaseScore(25);
				}
			}
		}
		// Eliminar villanos y balas que colisionaron
		heroBullets.removeAll(bulletsToRemove);
		villains.removeAll(villainsToRemove);
		bulletsToRemove.clear();

		// Comprobación de colisiones de las balas de los villanos y el héroe
		for (VillainBullet bullet : enemyBullets) {
			if (Math.abs(bullet.getX() - hero.getX()) < 20 && Math.abs(bullet.getY() - hero.getY()) < 27
					&& bullet.isActive()) {
				hero.takeDamage(10); // Reducir la vida del héroe en 10 puntos por cada bala
				life.updateLife(-10);
				bulletsToRemoveFromVillains.add(bullet);
			}
		}
		heroBullets.removeAll(bulletsToRemove);
		villains.removeAll(villainsToRemove);
		enemyBullets.removeAll(bulletsToRemoveFromVillains);

		// Verificar si el héroe ha sido destruido
		if (hero.isDestroyed()) {
			gameOver = true;
			destroyHero();
		}
	}

	private void destroyHero() {
		hero.setLife(0); // Establecer la vida del héroe en cero
		gameOver = true; // Marcar el juego como terminado
	}

}
