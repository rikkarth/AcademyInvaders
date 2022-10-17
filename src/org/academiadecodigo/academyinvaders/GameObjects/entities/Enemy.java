package org.academiadecodigo.academyinvaders.GameObjects.entities;

import org.academiadecodigo.academyinvaders.GameObjects.bullets.EnemyBullet;
import org.academiadecodigo.academyinvaders.GameObjects.Grid.Grid;
import org.academiadecodigo.academyinvaders.GameObjects.Grid.GridDirection;
import org.academiadecodigo.academyinvaders.GameObjects.Grid.Position.GridPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public abstract class Enemy implements Runnable {

    private GridPosition enemyPosition;

    private EnemyBullet enemyBullet;
    private Grid grid;
    private boolean destroyed;
    private int health;
    private Player player;

    public Enemy(GridPosition enemyPosition, Player player) {

        this.player = player;
        this.enemyPosition = enemyPosition;
        this.destroyed = false;
        this.health = 150;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public GridPosition getEnemyPosition() {
        return enemyPosition;
    }

    public void setEnemyPosition(GridPosition enemyPosition) {
        this.enemyPosition = enemyPosition;
    }


    public boolean isDestroyed() {
        return destroyed;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void setDestroyed() {

        this.destroyed = true;
        System.out.println(isDestroyed());
    }

    abstract public void move();

    public void movement(GridDirection direction, int distance) {

        getEnemyPosition().moveInDirection(direction, distance);
    }

    public void linearMovement(GridDirection direction, int distance, int speed) {
        if (!isDestroyed()) {
            for (int i = 0; i < distance; i++) {
                checkIfDestroyed();
                if (isDestroyed()) break;
                try {
                    Thread.sleep(speed);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                getEnemyPosition().moveInDirection(direction, 1);

            }
        }
    }

    public void upRightMovement(int distance, int speed) {
        if (!isDestroyed()) {
            for (int i = 0; i < distance; i++) {
                checkIfDestroyed();
                if (isDestroyed()) break;
                try {
                    Thread.sleep(speed);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                getEnemyPosition().moveInDirection(GridDirection.UP, 1);
                getEnemyPosition().moveInDirection(GridDirection.RIGHT, 1);
            }
        }
    }

    public void upLeftMovement(int distance, int speed) {
        if (!isDestroyed()) {
            for (int i = 0; i < distance; i++) {
                checkIfDestroyed();
                if (isDestroyed()) break;
                try {
                    Thread.sleep(speed);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                getEnemyPosition().moveInDirection(GridDirection.UP, 1);
                getEnemyPosition().moveInDirection(GridDirection.LEFT, 1);
            }
        }
    }

    public void downRightMovement(int distance, int distanceD, int distanceR, int speed) {
        if (!isDestroyed()) {
            for (int i = 0; i < distance; i++) {
                checkIfDestroyed();
                if (isDestroyed()) break;
                try {
                    Thread.sleep(speed);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                getEnemyPosition().moveInDirection(GridDirection.DOWN, distanceD);
                getEnemyPosition().moveInDirection(GridDirection.RIGHT, distanceR);
            }
        }
    }

    public void downLeftMovement(int distance, int speed) {
        if (!isDestroyed()) {
            for (int i = 0; i < distance; i++) {
                checkIfDestroyed();
                if (isDestroyed()) break;
                try {
                    Thread.sleep(speed);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                getEnemyPosition().moveInDirection(GridDirection.DOWN, 1);
                getEnemyPosition().moveInDirection(GridDirection.LEFT, 1);
            }
        }
    }

    public void shake() {
        if (!isDestroyed()) {
            for (int i = 0; i < 5; i++) {
                if (isDestroyed()) break;
                checkIfDestroyed();
                linearMovement(GridDirection.LEFT, 30, 5);
                linearMovement(GridDirection.RIGHT, 30, 5);
            }
        }
    }

    public void shakeHard() {
        if (!isDestroyed()) {
            for (int i = 0; i < 5; i++) {
                if (isDestroyed()) break;
                checkIfDestroyed();
                linearMovement(GridDirection.LEFT, 20, 3);
                linearMovement(GridDirection.RIGHT, 20, 3);
            }
        }
    }

    public void shakeHarder() {
        if (!isDestroyed()) {
            for (int i = 0; i < 20; i++) {
                if (isDestroyed()) break;
                checkIfDestroyed();
                linearMovement(GridDirection.LEFT, 10, 1);
                linearMovement(GridDirection.RIGHT, 10, 1);
            }
        }
    }

    public void checkIfDestroyed() {
        int delay = 150;
        if (isDestroyed()) {
            this.getEnemyPosition().getObject().delete();
            this.getEnemyPosition().setObject(new Picture(getEnemyPosition().getWidth(), getEnemyPosition().getHeight(), "org/academiadecodigo/academyinvaders/GameObjects/assets/ExplosionEffects/exp.1.png"));
            this.getEnemyPosition().getObject().draw();
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.getEnemyPosition().getObject().delete();
            this.getEnemyPosition().setObject(new Picture(getEnemyPosition().getWidth(), getEnemyPosition().getHeight(), "org/academiadecodigo/academyinvaders/GameObjects/assets/ExplosionEffects/exp.2.png"));
            this.getEnemyPosition().getObject().draw();
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.getEnemyPosition().getObject().delete();
            this.getEnemyPosition().setObject(new Picture(getEnemyPosition().getWidth(), getEnemyPosition().getHeight(), "org/academiadecodigo/academyinvaders/GameObjects/assets/ExplosionEffects/exp.3.png"));
            this.getEnemyPosition().getObject().draw();
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.getEnemyPosition().getObject().delete();
            this.getEnemyPosition().setObject(new Picture(getEnemyPosition().getWidth(), getEnemyPosition().getHeight(), "org/academiadecodigo/academyinvaders/GameObjects/assets/ExplosionEffects/exp.4.png"));
            this.getEnemyPosition().getObject().draw();
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.getEnemyPosition().getObject().delete();
            this.getEnemyPosition().setObject(new Picture(getEnemyPosition().getWidth(), getEnemyPosition().getHeight(), "org/academiadecodigo/academyinvaders/GameObjects/assets/ExplosionEffects/exp.5.png"));
            this.getEnemyPosition().getObject().draw();
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.getEnemyPosition().getObject().delete();
            this.getEnemyPosition().setObject(new Picture(getEnemyPosition().getWidth(), getEnemyPosition().getHeight(), "org/academiadecodigo/academyinvaders/GameObjects/assets/ExplosionEffects/exp.6.png"));
            this.getEnemyPosition().getObject().draw();
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.getEnemyPosition().getObject().delete();
            this.getEnemyPosition().setObject(new Picture(getEnemyPosition().getWidth(), getEnemyPosition().getHeight(), "org/academiadecodigo/academyinvaders/GameObjects/assets/ExplosionEffects/exp.7.png"));
            this.getEnemyPosition().getObject().draw();
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.getEnemyPosition().getObject().delete();
            this.getEnemyPosition().setObject(new Picture(getEnemyPosition().getWidth(), getEnemyPosition().getHeight(), "org/academiadecodigo/academyinvaders/GameObjects/assets/ExplosionEffects/exp.8.png"));
            this.getEnemyPosition().getObject().draw();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.getEnemyPosition().getObject().delete();

            Picture gameOver = new Picture(300, 300, "org/academiadecodigo/academyinvaders/GameObjects/assets/ExplosionEffects/victory_title.png");
            gameOver.draw();
        }
    }

}
