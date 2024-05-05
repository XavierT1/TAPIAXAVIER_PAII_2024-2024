package main_package;

import views_package.GameFrame;
import java.awt.EventQueue;

public class Main {
	public static void main(String[] args) {
		Main m1 = new Main();
		m1.run();

	}

	private void run() {
		try {
			GameFrame game = new GameFrame("Galaga Game");
			game.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
