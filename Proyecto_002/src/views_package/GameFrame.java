package views_package;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import controlador_package.Container;



public class GameFrame extends JFrame implements KeyListener{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Container container;
	
	public GameFrame(String title) throws HeadlessException{
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		
		container = new Container();
		contentPane= new JPanel();
		contentPane.setBackground(Color.black);
		setContentPane(contentPane);
		addKeyListener(this);
		
		
			Timer timer = new Timer(100, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					container.updateBullets();
					container.moveDown(1);
					repaint();
				}
			});
			timer.start();
	
	}
	
	public void paint (Graphics g) {
		super.paint(g);
		container.draw(g);
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		setFocusable(true);
		switch (e.getKeyCode()) {
		case KeyEvent.VK_A: 
			container.moveLeft(10);
			break;
		
		case KeyEvent.VK_D: 
			container.moveRigth(10);
			break;
			
		case KeyEvent.VK_SPACE:
            container.fireBullet(); // Disparar una bala cuando se presiona espacio
            break;
		}
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
