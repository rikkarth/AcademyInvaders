package org.academiadecodigo.academyinvaders.GameObjects.Bullets;

import org.academiadecodigo.academyinvaders.GameObjects.Enemy.Enemy;
import org.academiadecodigo.academyinvaders.GameObjects.Grid.GridDirection;
import org.academiadecodigo.academyinvaders.GameObjects.Grid.Position.GridPosition;
import org.academiadecodigo.academyinvaders.GameObjects.Player.Player;

public class EnemyBullet extends AbstractBullet {

    public EnemyBullet(GridPosition bulletPosition) {
        super(bulletPosition);
    }

    @Override
    public boolean collisionDetector(Player player) {
        /**
         * Collision Logic BulletToPlayer
         */
        if (
                        player.getPlayerPosition().getWidth() < getBulletPosition().getWidth() + getBulletPosition().getObjectWidth() &&
                        player.getPlayerPosition().getWidth() + player.getPlayerPosition().getObjectWidth() > getBulletPosition().getWidth() &&
                        player.getPlayerPosition().getHeight() < getBulletPosition().getHeight() + getBulletPosition().getObjectHeight() &&
                        player.getPlayerPosition().getObjectHeight() + player.getPlayerPosition().getHeight() > getBulletPosition().getHeight()

        ) {
            // Collision detected!
            System.out.println("Collided");
            getBulletPosition().hide();
            return true;
        }

        // No collision
        System.out.println("Not Collided");
        return false;
    }

    @Override
    public boolean collisionDetector(Enemy enemy) {
        return false;
    }

    @Override
    public void bulletMovement() {
        getBulletPosition().moveInDirection(GridDirection.DOWN, 1);
    }
}

