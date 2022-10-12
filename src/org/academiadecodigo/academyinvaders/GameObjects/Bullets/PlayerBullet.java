package org.academiadecodigo.academyinvaders.GameObjects.Bullets;


import org.academiadecodigo.academyinvaders.GameObjects.Enemy.Enemy;
import org.academiadecodigo.academyinvaders.GameObjects.Grid.GridDirection;
import org.academiadecodigo.academyinvaders.GameObjects.Grid.Position.GridPosition;
import org.academiadecodigo.academyinvaders.GameObjects.Player.Player;


public class PlayerBullet extends AbstractBullet {

    public PlayerBullet(GridPosition bulletPosition) {
        super(bulletPosition);
    }

    @Override
    public boolean collisionDetector(Player player) {
        return false;
    }

    @Override
    public boolean collisionDetector(Enemy enemy) {
        return false;
    }

    @Override
    public void bulletMovement() {
        getBulletPosition().moveInDirection(GridDirection.UP, 1);
    }

}
