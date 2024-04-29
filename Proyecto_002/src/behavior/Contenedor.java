package behavior;
import java.awt.Graphics;

import interface_galaga.*;

public class Contenedor {
    private Drawable drawable;
    private Movable movable;
    private Deadable deadable;
    private Shootable shootable;

    public Contenedor(Drawable drawable, Movable movable, Deadable deadable, Shootable shootable) {
        this.drawable = drawable;
        this.movable = movable;
        this.deadable = deadable;
        this.shootable = shootable;
    }

    public void draw(Graphics g) {
        drawable.draw(g);
    }

    public void move() {
        movable.move();
    }

    public void shoot() {
        shootable.shoot();
    }

    public void checkDeath() {
        if (deadable.isDead()) {
            
        }
    }
}
