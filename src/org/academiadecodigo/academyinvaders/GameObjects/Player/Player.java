package org.academiadecodigo.academyinvaders.GameObjects.Player;

import org.academiadecodigo.academyinvaders.GameObjects.Bullets.PlayerBullet;
import org.academiadecodigo.academyinvaders.GameObjects.Enemy.Enemy;
import org.academiadecodigo.academyinvaders.GameObjects.Grid.Grid;
import org.academiadecodigo.academyinvaders.GameObjects.Grid.GridDirection;
import org.academiadecodigo.academyinvaders.GameObjects.Grid.Position.GridPosition;
import org.academiadecodigo.academyinvaders.GameObjects.Main;
import org.academiadecodigo.academyinvaders.GameObjects.SimpleGfx.SimpleGfxFaceMapper;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;

public class Player implements KeyboardHandler, Runnable {

    //Properties
    private LinkedList<PlayerBullet> bulletList = new LinkedList<>();
    private GridPosition playerPosition;

    private PlayerBullet playerBullet;
    private PlayerBullet tempBullet;
    private Grid grid;
    private Enemy enemy;
    private int velX = 0;
    private int velY = 0;
    private boolean destroyed;
    private int health;
    private int livesLeft;
    boolean fire = false;


    /**
     * Player Constructor
     *
     * @param playerPosition provides instance with position in grid
     */
    public Player(GridPosition playerPosition, Enemy enemy) {

        this.enemy = enemy;
        this.playerPosition = playerPosition;
        this.destroyed = false;
        this.health = 100;
        this.livesLeft = 3;
        initKeyboard();
    }

    //GETTERS

    public GridPosition getPlayerPosition() {
        return playerPosition;
    }

    public PlayerBullet getPlayerBullet() {
        return playerBullet;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public int getHealth() {
        return health;
    }

    //SETTERS

    public void setDestroyed() {

        this.destroyed = true;
        System.out.println(isDestroyed());
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setVelX(int velX) {
        this.velX += velX;
    }

    public void setVelY(int velY) {
        this.velY += velY;
    }

    //METHODS

    /**
     * Where all bullet behaviours come together
     */

    public void shoot() {

        for (int i = 0; i < bulletList.size(); i++) {
            tempBullet = bulletList.get(i);

            tempBullet.tick();
            if (tempBullet.collisionDetector(enemy)) {

                tempBullet.getBulletPosition().hide();

                bulletList.remove(i);

                if (enemy.getHealth() != 0) {

                    enemy.setHealth(enemy.getHealth() - tempBullet.getDAMAGE());
                }

                //System.out.println(enemy.getHealth());

                if (enemy.getHealth() == 0) {

                    enemy.setDestroyed();
                }
            }

            if (tempBullet.getBulletPosition().getHeight() == 0) {

                tempBullet.getBulletPosition().hide();

                bulletList.remove(i);
            }
        }
    }

    public void checkIfDestroyed() {
        int delay = 150;
        if (isDestroyed()) {
            this.getPlayerPosition().getObject().delete();
            this.getPlayerPosition().setObject(new Picture(getPlayerPosition().getWidth(), getPlayerPosition().getHeight(), "org/academiadecodigo/academyinvaders/GameObjects/Assets/ExplosionEffects/exp.1.png"));
            this.getPlayerPosition().getObject().draw();
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.getPlayerPosition().getObject().delete();
            this.getPlayerPosition().setObject(new Picture(getPlayerPosition().getWidth(), getPlayerPosition().getHeight(), "org/academiadecodigo/academyinvaders/GameObjects/Assets/ExplosionEffects/exp.2.png"));
            this.getPlayerPosition().getObject().draw();
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.getPlayerPosition().getObject().delete();
            this.getPlayerPosition().setObject(new Picture(getPlayerPosition().getWidth(), getPlayerPosition().getHeight(), "org/academiadecodigo/academyinvaders/GameObjects/Assets/ExplosionEffects/exp.3.png"));
            this.getPlayerPosition().getObject().draw();
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.getPlayerPosition().getObject().delete();
            this.getPlayerPosition().setObject(new Picture(getPlayerPosition().getWidth(), getPlayerPosition().getHeight(), "org/academiadecodigo/academyinvaders/GameObjects/Assets/ExplosionEffects/exp.4.png"));
            this.getPlayerPosition().getObject().draw();
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.getPlayerPosition().getObject().delete();
            this.getPlayerPosition().setObject(new Picture(getPlayerPosition().getWidth(), getPlayerPosition().getHeight(), "org/academiadecodigo/academyinvaders/GameObjects/Assets/ExplosionEffects/exp.5.png"));
            this.getPlayerPosition().getObject().draw();
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.getPlayerPosition().getObject().delete();
            this.getPlayerPosition().setObject(new Picture(getPlayerPosition().getWidth(), getPlayerPosition().getHeight(), "org/academiadecodigo/academyinvaders/GameObjects/Assets/ExplosionEffects/exp.6.png"));
            this.getPlayerPosition().getObject().draw();
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.getPlayerPosition().getObject().delete();
            this.getPlayerPosition().setObject(new Picture(getPlayerPosition().getWidth(), getPlayerPosition().getHeight(), "org/academiadecodigo/academyinvaders/GameObjects/Assets/ExplosionEffects/exp.7.png"));
            this.getPlayerPosition().getObject().draw();
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.getPlayerPosition().getObject().delete();
            this.getPlayerPosition().setObject(new Picture(getPlayerPosition().getWidth(), getPlayerPosition().getHeight(), "org/academiadecodigo/academyinvaders/GameObjects/Assets/ExplosionEffects/exp.8.png"));
            this.getPlayerPosition().getObject().draw();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.getPlayerPosition().getObject().delete();

            Picture gameOver = new Picture(300, 300, "org/academiadecodigo/academyinvaders/GameObjects/Assets/TitlesAndSubtitles/game_over_title.png");
            gameOver.draw();
        }
    }


    /**
     * Adds bullet to LinkedList
     *
     * @param block requires a bullet instance
     */
    private void addBullet(PlayerBullet block) {
        bulletList.add(block);
    }

    /**
     * Initializes keyboard
     */
    private void initKeyboard() {

        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent rightPressed = new KeyboardEvent();
        rightPressed.setKey(KeyboardEvent.KEY_D);
        rightPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent leftPressed = new KeyboardEvent();
        leftPressed.setKey(KeyboardEvent.KEY_A);
        leftPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent shootPressed = new KeyboardEvent();
        shootPressed.setKey(KeyboardEvent.KEY_SPACE);
        shootPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent leftReleased = new KeyboardEvent();
        leftReleased.setKey(KeyboardEvent.KEY_A);
        leftReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent rightReleased = new KeyboardEvent();
        rightReleased.setKey(KeyboardEvent.KEY_D);
        rightReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        keyboard.addEventListener(leftPressed);
        keyboard.addEventListener(rightPressed);
        keyboard.addEventListener(shootPressed);
        keyboard.addEventListener(rightReleased);
        keyboard.addEventListener(leftReleased);
    }

    /**
     * Moves player left and right
     */
    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {


        if (keyboardEvent.getKey() == KeyboardEvent.KEY_A) {

            if (!isDestroyed()) {
                setVelX(2);
                getPlayerPosition().moveInDirection(GridDirection.LEFT, 10 + velX);
            }
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_D) {
            if (!isDestroyed()) {
                setVelX(2);
                getPlayerPosition().moveInDirection(GridDirection.RIGHT, 10 + velX);
            }
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {

            if (!isDestroyed()) {
                fire = true;
                addBullet(new PlayerBullet(Main.GAME_GRID.makeGridPosition(playerPosition.getWidth() + 25, playerPosition.getHeight() - 150, 7, 10, SimpleGfxFaceMapper.BULLET)));
            }
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_A) {
            velX = 0;
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_D) {
            velX = 0;

        }
    }

    //@Override
    public void run() {
        while (!isDestroyed()) {
            checkIfDestroyed();
        }
    }
}



