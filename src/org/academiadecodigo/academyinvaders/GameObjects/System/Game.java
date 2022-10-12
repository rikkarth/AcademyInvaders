package org.academiadecodigo.academyinvaders.GameObjects.System;

import org.academiadecodigo.academyinvaders.GameObjects.Bullets.EnemyBullet;
import org.academiadecodigo.academyinvaders.GameObjects.Enemy.*;
import org.academiadecodigo.academyinvaders.GameObjects.Enemy.EnemyForm.*;
import org.academiadecodigo.academyinvaders.GameObjects.Grid.*;
import org.academiadecodigo.academyinvaders.GameObjects.Player.Player;

/**
 * The game logic
 */
public class Game {

    //PARAMETERS

    /**
     * Graphical Grid
     */
    private final Grid GAME_GRID;
    private Player player;

    /**
     * Container of Enemies
     */
    private Enemy enemy;

    private EnemyBullet enemyBullet;

    /**
     * Animation delay
     */
    public static int DELAY;

    /**
     * Constructs a new game
     *
     * @param delay animation delay
     */
    public Game(int delay) {
        GAME_GRID = GridFactory.makeGrid(1024, 768);
        this.DELAY = delay;

    }

    /**
     * Initializes Game Grid
     * Creates Enemies for the level
     */
    public void init() {

        GAME_GRID.init();


        enemy = new Baljeet(GAME_GRID.makeGridPosition(500, 50, 50, 50));

        player = new Player(GAME_GRID.makeGridPosition(500, 700, 50, 50));

        enemyBullet = new EnemyBullet(GAME_GRID.makeGridPosition(525, 710, 10, 50));






    }


    /**
     * Starts the game
     *
     * @throws InterruptedException
     */
    public void start() throws InterruptedException {

        while (true) {

            // Pause for a while
            Thread.sleep(DELAY);

            /*
             * Insert Game Loop here
             */
            //enemy.move();
            System.out.println(enemyBullet.collisionDetector(player));








        }
    }
}

