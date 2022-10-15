package org.academiadecodigo.academyinvaders.GameObjects.System;

import org.academiadecodigo.academyinvaders.GameObjects.Bullets.EnemyBullet;
import org.academiadecodigo.academyinvaders.GameObjects.Enemy.*;
import org.academiadecodigo.academyinvaders.GameObjects.Enemy.EnemyForm.*;
import org.academiadecodigo.academyinvaders.GameObjects.Grid.*;
import org.academiadecodigo.academyinvaders.GameObjects.Player.Player;

/**
 * The game logic
 */
public class Game implements Runnable {

    //PARAMETERS

    /**
     * Graphical Grid
     */
    public static final Grid GAME_GRID = GridFactory.makeGrid(1024, 768);
    private Player player;
    private Enemy baljeet;

    private Thread thread;
    private Thread threadTwo;

    private EnemyBullet enemyBullet;
    /**
     * Animation delay
     */
    public static int DELAY;
    private boolean running = true;


    public synchronized void start() {
        if (running)
            return;

        running = true;
        thread = new Thread(this);

        thread.start();
        threadTwo.start();
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
     *d
     * @param delay animation delay
     */
    public Game(int delay) {
        //GAME_GRID = GridFactory.makeGrid(1024, 768);
        this.DELAY = delay;
        init();

    }

    /**
     * Initializes Game Grid
     * Creates Enemies for the level
     */
    public void init() {


        GAME_GRID.init();

        baljeet = new Baljeet(GAME_GRID.makeGridPosition(500, 50, 50, 50));


        player = new Player(GAME_GRID.makeGridPosition(500, 700, 50, 50), baljeet);
    }



    /**
     * Starts the game
     *
     * @throws InterruptedException
     */
    public void run() {
        long lastTime = System.nanoTime();
        final double amountOfTicks = 60;
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
                tick();
                /*============================*/






                updates++;
                delta--;
            }
            render();
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
            baljeet.move();







        }
        stop();
    }

    private void tick(){
        player.tick();



    }

    private void render(){

    }
}

