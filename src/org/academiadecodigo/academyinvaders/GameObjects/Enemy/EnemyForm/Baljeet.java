package org.academiadecodigo.academyinvaders.GameObjects.Enemy.EnemyForm;

import org.academiadecodigo.academyinvaders.GameObjects.Enemy.Enemy;
import org.academiadecodigo.academyinvaders.GameObjects.Grid.GridDirection;
import org.academiadecodigo.academyinvaders.GameObjects.Grid.Position.GridPosition;
import org.academiadecodigo.academyinvaders.GameObjects.System.Game;


public class Baljeet extends Enemy {

    int movementCounter = 0;
    boolean loop = true;

    public Baljeet(GridPosition enemyPosition) {
        super(enemyPosition);
    }

    @Override
    public void move() {

        while (loop) {
            if (movementCounter >= 0 && movementCounter <= 100) {
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                movement(GridDirection.LEFT, 1);
                movementCounter++;
            }
            if (movementCounter > 100 && movementCounter <= 200) {
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                movement(GridDirection.RIGHT, 1);

                movementCounter++;
            }

            if(movementCounter == 200){
                loop = false;
                movementCounter = 0;
            }
            loop = true;

        }

        System.out.println(movementCounter);
    }
}

