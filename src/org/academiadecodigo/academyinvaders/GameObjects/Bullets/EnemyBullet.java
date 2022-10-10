package org.academiadecodigo.academyinvaders.GameObjects.Bullets;

import org.academiadecodigo.academyinvaders.GameObjects.Grid.Grid;
import org.academiadecodigo.academyinvaders.GameObjects.Grid.GridDirection;
import org.academiadecodigo.academyinvaders.GameObjects.Grid.Position.GridPosition;

public class EnemyBullet extends Bullets {

    private GridPosition bulletPosition;

    public EnemyBullet(GridPosition bulletPosition) {
        super(bulletPosition);
    }

    @Override
    public void bulletMovement() {
        bulletPosition.moveInDirection(GridDirection.DOWN, 1);
    }

    @Override
    public boolean hit() {
//        if(bulletP)
        return false;
    }
}
