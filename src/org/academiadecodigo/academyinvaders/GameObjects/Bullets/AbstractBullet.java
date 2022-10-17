package org.academiadecodigo.academyinvaders.GameObjects.Bullets;

import org.academiadecodigo.academyinvaders.GameObjects.Enemy.Enemy;
import org.academiadecodigo.academyinvaders.GameObjects.Grid.Position.GridPosition;
import org.academiadecodigo.academyinvaders.GameObjects.Player.Player;

public abstract class AbstractBullet {
    private final int DAMAGE;
    Player player;
    private GridPosition bulletPosition;

    public AbstractBullet(GridPosition bulletPosition, int bulletDamage) {
        this.DAMAGE = bulletDamage;
        this.bulletPosition = bulletPosition;
        this.player = player;
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
            //System.out.println("Collided");
            //bulletPosition.hide();
            return true;
        }
        // No collision
        //System.out.println("Not Collided");
        return false;
    }

    /**
     * Collision Logic BulletToEnemy
     */
    public boolean collisionDetector(Enemy enemy) {
        if (
                enemy.getEnemyPosition().getWidth() < bulletPosition.getWidth() + bulletPosition.getObjectWidth() &&
                enemy.getEnemyPosition().getWidth() + enemy.getEnemyPosition().getObjectWidth() > bulletPosition.getWidth() &&
                enemy.getEnemyPosition().getHeight() < bulletPosition.getHeight() + bulletPosition.getObjectHeight() &&
                enemy.getEnemyPosition().getObjectHeight() + enemy.getEnemyPosition().getHeight() > bulletPosition.getHeight()
        ) {
            // Collision detected!
            //System.out.println("Collided");
            //bulletPosition.hide();
            return true;
        }

        // No collision
        //System.out.println("Not Collided");
        return false;
    }



    public GridPosition getBulletPosition() {
        return bulletPosition;
    }

    public Player getPlayer() {
        return player;
    }

    public int getDAMAGE() {
        return DAMAGE;
    }
}

