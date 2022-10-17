package org.academiadecodigo.academyinvaders.GameObjects.Bullets;

import org.academiadecodigo.academyinvaders.GameObjects.Grid.GridDirection;
import org.academiadecodigo.academyinvaders.GameObjects.Grid.Position.GridPosition;
import org.academiadecodigo.academyinvaders.GameObjects.Player.Player;

public class EnemyBullet extends AbstractBullet {

    //Constructor
    public EnemyBullet(GridPosition bulletPosition) {
        super(bulletPosition,5);
    }



    public void tick() {

        this.getBulletPosition().moveInDirection(GridDirection.DOWN, 5);
    }


}

