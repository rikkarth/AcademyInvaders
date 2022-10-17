package org.academiadecodigo.academyinvaders.GameObjects.bullets;

import org.academiadecodigo.academyinvaders.GameObjects.Grid.GridDirection;
import org.academiadecodigo.academyinvaders.GameObjects.Grid.Position.GridPosition;

public class PlayerBullet extends AbstractBullet {

    //Constructor
    public PlayerBullet(GridPosition bulletPosition) {
        super(bulletPosition, 5);
    }

    public void tick() {

            this.getBulletPosition().moveInDirection(GridDirection.UP, 5);
    }


}
