package org.academiadecodigo.academyinvaders.GameObjects.entities;

import org.academiadecodigo.academyinvaders.GameObjects.System.PlayerKeyboard;
import org.academiadecodigo.academyinvaders.GameObjects.bullets.PlayerBullet;
import org.academiadecodigo.academyinvaders.GameObjects.Grid.GridDirection;
import org.academiadecodigo.academyinvaders.GameObjects.Grid.Position.GridPosition;
import org.academiadecodigo.academyinvaders.GameObjects.Main;
import org.academiadecodigo.academyinvaders.GameObjects.SimpleGfx.SimpleGfxFaceMapper;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;

public class Player implements KeyboardHandler, Runnable {

    //Properties
    private LinkedList<PlayerBullet> bulletList = new LinkedList<>();
    private GridPosition playerPosition;
    private PlayerBullet playerBullet;
    DestroyedAnimation destroyedAnimation;
    private Enemy enemy;
    private int velX = 0;
    private int velY = 0;
    private boolean destroyed;
    private int health;
    private int livesLeft;
    private boolean spaceHeld;


    /**
     * Player Constructor
     *
     * @param playerPosition provides instance with position in grid
     */
    public Player(GridPosition playerPosition, Enemy enemy) {

        PlayerKeyboard playerKeyboard = new PlayerKeyboard(this);
        this.enemy = enemy;
        this.playerPosition = playerPosition;
        this.destroyed = false;
        this.health = 100;
        this.livesLeft = 3;
        this.spaceHeld = false;
        playerKeyboard.initKeyboard();
        this.destroyedAnimation = new DestroyedAnimation(this);
    }

    //GETTERS

    public GridPosition getPlayerPosition() {
        return playerPosition;
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
        //System.out.println(isDestroyed());
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
     * Player gets bullet list then shoots bullet through the tick method in PlayerBullet
     *
     * @see PlayerBullet
     * Checks if bullet has collided with enemy or top edge of the grid: if yes, hides bullet graphically and removes it from linked list
     * chekcs if enemy health is different from 0, if yes, sets health to new value
     */
    public void shoot() {

        for (int i = 0; i < bulletList.size(); i++) {
            playerBullet = bulletList.get(i);

            playerBullet.tick();

            if (playerBullet.ifCollided(enemy)) {

                playerBullet.getBulletPosition().hide();

                bulletList.remove(i);

                if (enemy.getHealth() != 0) {

                    enemy.setHealth(enemy.getHealth() - playerBullet.getDAMAGE());
                }

                //System.out.println(enemy.getHealth());

                if (enemy.getHealth() == 0) {

                    enemy.setDestroyed();
                }
            }

            if (playerBullet.getBulletPosition().getHeight() == 0) {

                playerBullet.getBulletPosition().hide();

                bulletList.remove(i);
            }
        }
    }

    /**
     * Plays a frame by frame animation if destroyed
     * @see DestroyedAnimation
     */
    private void playDestroyedAnimationIfDestroyed() {
            System.out.println();
        if (isDestroyed()) {

            int delay = 150;

            destroyedAnimation.playPlayerAnimation("org/academiadecodigo/academyinvaders/GameObjects/assets/ExplosionEffects/exp.1.png", delay);

            destroyedAnimation.playPlayerAnimation("org/academiadecodigo/academyinvaders/GameObjects/assets/ExplosionEffects/exp.2.png", delay);

            destroyedAnimation.playPlayerAnimation("org/academiadecodigo/academyinvaders/GameObjects/assets/ExplosionEffects/exp.3.png", delay);

            destroyedAnimation.playPlayerAnimation("org/academiadecodigo/academyinvaders/GameObjects/assets/ExplosionEffects/exp.4.png", delay);

            destroyedAnimation.playPlayerAnimation("org/academiadecodigo/academyinvaders/GameObjects/assets/ExplosionEffects/exp.5.png", delay);

            destroyedAnimation.playPlayerAnimation("org/academiadecodigo/academyinvaders/GameObjects/assets/ExplosionEffects/exp.6.png", delay);

            destroyedAnimation.playPlayerAnimation("org/academiadecodigo/academyinvaders/GameObjects/assets/ExplosionEffects/exp.7.png", delay);

            destroyedAnimation.playPlayerAnimation("org/academiadecodigo/academyinvaders/GameObjects/assets/ExplosionEffects/exp.8.png", 1000);

            this.getPlayerPosition().getObject().delete();

            Picture gameOver = new Picture(300, 300, "org/academiadecodigo/academyinvaders/GameObjects/assets/TitlesAndSubtitles/game_over_title.png");

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
     * Player Keyboard Logic
     * Controls movement and shooting
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
            if (!spaceHeld) {
                spaceHeld = true;
                if (!isDestroyed()) {

                    addBullet(new PlayerBullet(Main.GAME_GRID.makeGridPosition(playerPosition.getWidth() + 25, playerPosition.getHeight() - 150, 7, 10, SimpleGfxFaceMapper.BULLET)));
                }
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

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            spaceHeld = false;
        }
    }

    //@Override
    public void run() {

        while (!isDestroyed()) {

            playDestroyedAnimationIfDestroyed();
        }
    }
}



