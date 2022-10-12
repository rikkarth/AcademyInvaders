package org.academiadecodigo.academyinvaders.GameObjects.Bullets;

import org.academiadecodigo.academyinvaders.GameObjects.Enemy.Enemy;
import org.academiadecodigo.academyinvaders.GameObjects.Grid.Position.GridPosition;
import org.academiadecodigo.academyinvaders.GameObjects.Player.Player;

public abstract class AbstractBullet {
    private final int DAMAGE;
    private final int SPEED;
    private GridPosition bulletPosition;

    public AbstractBullet(GridPosition bulletPosition) {
        this.SPEED = 5; // passível de alteração
        this.DAMAGE = 10;
        this.bulletPosition = bulletPosition;
    }

    public abstract boolean collisionDetector(Player player);

    public abstract boolean collisionDetector(Enemy enemy);

    public GridPosition getBulletPosition() {
        return bulletPosition;
    }

    public abstract void bulletMovement();

    /*public boolean intersects(//whatever goes here) {
        int tw = this.bulletPosition.getWidth();
        int th = this.bulletPosition.getHeight();
        int rw = r.width;
        int rh = r.height;

        if (rw <= 0 || rh <= 0 || tw <= 0 || th <= 0) {
            return false;
        }

        int bulletX = this.x;
        int bulletY = this.y;
        int objectX = r.x;
        int objectY = r.y;

        rw += objectX;
        rh += objectY;
        tw += bulletX;
        th += bulletY;

        //      overflow || intersect
        return ((rw <objectX || rw > bulletX) &&
                (rh <objectY || rh > bulletY) &&
                (tw < bulletX || tw > objectX) &&
                (th < bulletY || th > objectY));

        //TRUE OR FALSE

    }*/
}

