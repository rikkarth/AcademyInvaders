package org.academiadecodigo.academyinvaders.bullets;

import org.academiadecodigo.academyinvaders.grid.GridDirection;
import org.academiadecodigo.academyinvaders.grid.position.GridPosition;

public class EnemyBullet extends AbstractBullet {

  //Constructor
  public EnemyBullet(GridPosition bulletPosition) {
    super(bulletPosition, 5);
  }


  public void move() {

    this.getBulletPosition().moveInDirection(GridDirection.DOWN, 5);
  }


}

