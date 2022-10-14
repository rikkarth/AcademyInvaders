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
    public static final Grid GAME_GRID = GridFactory.makeGrid(1024, 768);
    private Player player;
    private Enemy enemy;

    private EnemyBullet enemyBullet;
    /**
     * Animation delay
     */
    public static int DELAY;
    private boolean running = false;

    private Thread thread;

    public synchronized void start() {
        if (running)
            return;
        running = true;
    }

    private synchronized void stop() {
        if (!running)
            return;

        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.exit(1);
    }

    /**
     * Constructs a new game
     *
     * @param delay animation delay
     */
    public Game(int delay) {
        //GAME_GRID = GridFactory.makeGrid(1024, 768);
        this.DELAY = delay;

    }

    /**
     * Initializes Game Grid
     * Creates Enemies for the level
     */
    public void init() {

        GAME_GRID.init();

        enemy = new Baljeet(GAME_GRID.makeGridPosition(500, 50, 50, 50));

        player = new Player(GAME_GRID.makeGridPosition(500, 700, 50, 50), enemy);
    }

    /**
     * Starts the game
     *
     * @throws InterruptedException
     */
    public void run() throws InterruptedException {
        init();
        long lastTime = System.nanoTime();
        final double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        int updates = 0;
        int frames = 0;
        long timer = System.currentTimeMillis();

        while (running) {

            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1) {
                updates++;
                delta--;
            }
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println(updates + " Ticks, Fps " + frames);
                updates = 0;
                frames = 0;
            }
            /*
             * Insert Game Loop here
             */
            player.shoot();

            //enemy.move();
            //System.out.println(enemyBullet.collisionDetector(player));
        }
        stop();
    }
}

