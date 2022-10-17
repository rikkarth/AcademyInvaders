package org.academiadecodigo.academyinvaders.GameObjects.entities.enemies;

import org.academiadecodigo.academyinvaders.GameObjects.entities.Enemy;
import org.academiadecodigo.academyinvaders.GameObjects.Grid.GridDirection;
import org.academiadecodigo.academyinvaders.GameObjects.Grid.Position.GridPosition;
import org.academiadecodigo.academyinvaders.GameObjects.entities.Player;

public class Baljeet extends Enemy implements Runnable {

    private Player player;
    public Baljeet(GridPosition enemyPosition, Player player) {
        super(enemyPosition, player);
    }

    /**
     * Method move will run movement patterns recursively while enemy not destroyed
     */
    @Override
    public void move() {

        while (!isDestroyed()) {

            patternOne();

            move();

        }
    }

    public void patternOne() {

        linearMovement(GridDirection.LEFT, 200, 5);

        linearMovement(GridDirection.RIGHT, 200, 5);

        linearMovement(GridDirection.LEFT, 200, 5);

        linearMovement(GridDirection.RIGHT, 200, 5);

        linearMovement(GridDirection.LEFT, 200, 5);

        downRightMovement(200, 2, 1, 3);

        linearMovement(GridDirection.UP, 200, 2);

        shake();
        shakeHard();
        shakeHarder();

        linearMovement(GridDirection.UP, 200, 2);;
    }

    @Override
    public void run() {

        move();
    }
}

