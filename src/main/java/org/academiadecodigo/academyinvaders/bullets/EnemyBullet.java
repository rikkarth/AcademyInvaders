package org.academiadecodigo.academyinvaders.bullets;

import main.java.org.academiadecodigo.academyinvaders.GameObjects.Grid.GridDirection;
import main.java.org.academiadecodigo.academyinvaders.GameObjects.Grid.Position.GridPosition;

public class EnemyBullet extends AbstractBullet {

    //Constructor
    public EnemyBullet(GridPosition bulletPosition) {
        super(bulletPosition,5);
    }



    public void move() {

        this.getBulletPosition().moveInDirection(GridDirection.DOWN, 5);
    }


}

