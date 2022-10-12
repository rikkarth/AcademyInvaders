package org.academiadecodigo.academyinvaders.GameObjects.Enemy.EnemyForm;

import org.academiadecodigo.academyinvaders.GameObjects.Enemy.Enemy;
import org.academiadecodigo.academyinvaders.GameObjects.Grid.GridDirection;
import org.academiadecodigo.academyinvaders.GameObjects.Grid.Position.GridPosition;
import org.academiadecodigo.academyinvaders.GameObjects.System.Game;


public class Baljeet extends Enemy {
    public Baljeet(GridPosition enemyPosition) {
        super(enemyPosition);
    }

    @Override
    public void move() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            movement(GridDirection.RIGHT, 1);


        }





    }
}
