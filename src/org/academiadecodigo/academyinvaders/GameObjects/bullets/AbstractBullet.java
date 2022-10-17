package org.academiadecodigo.academyinvaders.GameObjects.bullets;

import org.academiadecodigo.academyinvaders.GameObjects.entities.Enemy;
import org.academiadecodigo.academyinvaders.GameObjects.Grid.Position.GridPosition;
import org.academiadecodigo.academyinvaders.GameObjects.entities.Player;

public abstract class AbstractBullet {
    protected final int DAMAGE;
    private GridPosition bulletPosition;

    public AbstractBullet(GridPosition bulletPosition, int bulletDamage) {
        this.DAMAGE = bulletDamage;
        this.bulletPosition = bulletPosition;
    }

    /**
     * Collision Logic BulletToPlayer
     */
    public boolean ifCollided(Player player) {
        if (
                player.getPlayerPosition().getWidth() < bulletPosition.getWidth() + bulletPosition.getObjectWidth() &&
                player.getPlayerPosition().getWidth() + player.getPlayerPosition().getObjectWidth() > bulletPosition.getWidth() &&
                player.getPlayerPosition().getHeight() < bulletPosition.getHeight() + bulletPosition.getObjectHeight() &&
                player.getPlayerPosition().getObjectHeight() + player.getPlayerPosition().getHeight() > bulletPosition.getHeight()
        ) {
            // Collision detected!
            //System.out.println("Collided");
            return true;
        }
        // No collision
        //System.out.println("Not Collided");
        return false;
    }

    /**
     * Collision Logic BulletToEnemy
     */
    public boolean ifCollided(Enemy enemy) {
        if (
                enemy.getEnemyPosition().getWidth() < bulletPosition.getWidth() + bulletPosition.getObjectWidth() &&
                enemy.getEnemyPosition().getWidth() + enemy.getEnemyPosition().getObjectWidth() > bulletPosition.getWidth() &&
                enemy.getEnemyPosition().getHeight() < bulletPosition.getHeight() + bulletPosition.getObjectHeight() &&
                enemy.getEnemyPosition().getObjectHeight() + enemy.getEnemyPosition().getHeight() > bulletPosition.getHeight()
        ) {
            // Collision detected!
            //System.out.println("Collided");
            return true;
        }

        // No collision
        //System.out.println("Not Collided");
        return false;
    }



    public GridPosition getBulletPosition() {
        return bulletPosition;
    }


    public int getDAMAGE() {
        return DAMAGE;
    }
}

