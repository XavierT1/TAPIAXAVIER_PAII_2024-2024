package ui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import entities.Bullet;
import game_logic.GameStateManager;

public class InputHandler extends KeyAdapter {
    private GameStateManager gameStateManager;

    public InputHandler(GameStateManager manager) {
        this.gameStateManager = manager;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                gameStateManager.moveShip(-10, 0);
                break;
            case KeyEvent.VK_RIGHT:
                gameStateManager.moveShip(10, 0);
                break;
            case KeyEvent.VK_UP:
                gameStateManager.moveShip(0, -10);
                break;
            case KeyEvent.VK_DOWN:
                gameStateManager.moveShip(0, 10);
                break;
            case KeyEvent.VK_SPACE:
                gameStateManager.addBullet(new Bullet(gameStateManager.getShipX() + gameStateManager.getShipWidth() / 2 - 2, gameStateManager.getShipY()));
                break;
        }
    }
}
//    @Override
//    public void keyPressed(KeyEvent e) {
//        int speed = 10;
//        switch (e.getKeyCode()) {
//        case KeyEvent.VK_LEFT:
//            shipX = Math.max(0, shipX - speed);
//            break;
//        case KeyEvent.VK_RIGHT:
//            shipX = Math.min(gameStateManager.getGameWidth() - shipWidth, shipX + speed);
//            break;
//        case KeyEvent.VK_UP:
//            shipY = Math.max(gameStateManager.getGameHeight(), shipY - speed);
//            break;
//        case KeyEvent.VK_DOWN:
//            shipY = Math.min(gameStateManager.getGameHeight() + gameStateManager.getGameHeight() - shipHeight, shipY + speed);
//            break;
//        case KeyEvent.VK_SPACE:
//            gameStateManager.addBullet(new Bullet(shipX + shipWidth / 2 - 2, shipY - 9));
//            break;
//        }
//        
//    }
//}
