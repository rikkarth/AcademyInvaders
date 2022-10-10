package org.academiadecodigo.academyinvaders.GameObjects.Bullets;


import org.academiadecodigo.academyinvaders.GameObjects.Grid.GridDirection;
import org.academiadecodigo.academyinvaders.GameObjects.Grid.Position.GridPosition;


public class PlayerBullet extends Bullets {

    private GridPosition bulletPosition;

    public PlayerBullet(GridPosition bulletPosition) {
        super(bulletPosition);
    }

    @Override
    public void bulletMovement() {
        bulletPosition.moveInDirection(GridDirection.UP, 1);
    }

    @Override
    public boolean hit() {
        return false;
    }
}
