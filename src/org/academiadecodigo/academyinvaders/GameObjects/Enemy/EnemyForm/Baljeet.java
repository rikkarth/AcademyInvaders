package org.academiadecodigo.academyinvaders.GameObjects.Enemy.EnemyForm;

import org.academiadecodigo.academyinvaders.GameObjects.Enemy.Enemy;
import org.academiadecodigo.academyinvaders.GameObjects.Grid.GridDirection;
import org.academiadecodigo.academyinvaders.GameObjects.Grid.Position.GridPosition;
import org.academiadecodigo.academyinvaders.GameObjects.System.Game;
import sun.security.mscapi.CPublicKey;


public class Baljeet extends Enemy implements Runnable {

    int movementCounter = 0;
    boolean stepOne = true;
    boolean stepTwo = false;
    boolean stepThree = false;

    public Baljeet(GridPosition enemyPosition) {
        super(enemyPosition);
    }

    @Override
    public void move() {

        if (stepOne) {
            if (this.getEnemyPosition().getHeight() < 150) {

                movement(GridDirection.DOWN, 5);
                return;
            }
            if (this.getEnemyPosition().getWidth() > 400) {

                movement(GridDirection.LEFT, 5);
                return;
            }
            stepOne = false;
            stepTwo = true;
        }
        if (stepTwo) {
            if (this.getEnemyPosition().getHeight() < 300) {

                movement(GridDirection.DOWN, 1);
                return;
            }
            if (this.getEnemyPosition().getWidth() > 300) {

                movement(GridDirection.RIGHT, 1);
                return;
            }
            stepTwo = false;
            stepThree = true;
        }
        if (stepTwo) {
            if (this.getEnemyPosition().getHeight() < 300) {

                movement(GridDirection.DOWN, 1);
                return;
            }
            if (this.getEnemyPosition().getWidth() > 300) {

                movement(GridDirection.RIGHT, 1);
                return;
            }
            stepTwo = false;
            stepThree = true;
        }

        if (stepThree) {
            if (this.getEnemyPosition().getHeight() < 300) {

                movement(GridDirection.DOWN, 1);
                return;
            }
            if (this.getEnemyPosition().getWidth() > 300) {

                movement(GridDirection.LEFT, 1);
                return;
            }
            stepThree = false;
        }
    }

    public void test() {

        for (int i = 0; i < 50; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.getEnemyPosition().moveInDirection(GridDirection.DOWN, 1);
        }

        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.getEnemyPosition().moveInDirection(GridDirection.LEFT, 1);
        }

        for(int i = 0; i < 50; i++){
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.getEnemyPosition().moveInDirection(GridDirection.UP, 1);
            this.getEnemyPosition().moveInDirection(GridDirection.RIGHT, 1);
        }
        test();
    }


        /*while (loop) {
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
    }*/

    @Override
    public void run() {
        test();
    }
}

