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

    /**
     * Collision Logic BulletToPlayer
     */
    public boolean collisionDetector(Player player) {
        if (
                player.getPlayerPosition().getWidth() < bulletPosition.getWidth() + bulletPosition.getObjectWidth() &&
                player.getPlayerPosition().getWidth() + player.getPlayerPosition().getObjectWidth() > bulletPosition.getWidth() &&
                player.getPlayerPosition().getHeight() < bulletPosition.getHeight() + bulletPosition.getObjectHeight() &&
                player.getPlayerPosition().getObjectHeight() + player.getPlayerPosition().getHeight() > bulletPosition.getHeight()
        ) {
            // Collision detected!
            System.out.println("Collided");
            //bulletPosition.hide();
            return true;
        }
        // No collision
        System.out.println("Not Collided");
        return false;
    }

    /**
     * Collision Logic BulletToPlayer
     */
    public boolean collisionDetector(Enemy enemy) {
        if (
                enemy.getEnemyPosition().getWidth() < bulletPosition.getWidth() + bulletPosition.getObjectWidth() &&
                enemy.getEnemyPosition().getWidth() + enemy.getEnemyPosition().getObjectWidth() > bulletPosition.getWidth() &&
                enemy.getEnemyPosition().getHeight() < bulletPosition.getHeight() + bulletPosition.getObjectHeight() &&
                enemy.getEnemyPosition().getObjectHeight() + enemy.getEnemyPosition().getHeight() > bulletPosition.getHeight()
        ) {
            // Collision detected!
            System.out.println("Collided");
            //bulletPosition.hide();
            return true;
        }

        // No collision
        System.out.println("Not Collided");
        return false;
    }

    public GridPosition getBulletPosition() {
        return bulletPosition;
    }
}

