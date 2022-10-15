package org.academiadecodigo.academyinvaders.GameObjects;

import org.academiadecodigo.academyinvaders.GameObjects.Bullets.EnemyBullet;
import org.academiadecodigo.academyinvaders.GameObjects.Enemy.Enemy;
import org.academiadecodigo.academyinvaders.GameObjects.Enemy.EnemyForm.Baljeet;
import org.academiadecodigo.academyinvaders.GameObjects.Grid.Grid;
import org.academiadecodigo.academyinvaders.GameObjects.Grid.GridFactory;
import org.academiadecodigo.academyinvaders.GameObjects.Player.Player;
import org.academiadecodigo.academyinvaders.GameObjects.SimpleGfx.SimpleGfxFaceMapper;
import org.academiadecodigo.academyinvaders.GameObjects.System.Game;


public class Main implements Runnable {

    //PROPERTIES
    private boolean running = false;
    private Thread gameThread;
    private Thread playerThread;
    private Thread baljeetThread;
    private Game game;

    /**
     * Graphical Grid
     */
    public static final Grid GAME_GRID = GridFactory.makeGrid(1024, 768, SimpleGfxFaceMapper.GAME);
    private Player player;
    private Enemy baljeet;

    private EnemyBullet enemyBullet;

    //SYNCED START
    private synchronized void start() {
        if (running) return;

        running = true;
        gameThread = new Thread(this);
        //playerThread = new Thread(player);
        baljeetThread = new Thread(baljeet);
        gameThread.start();
        //playerThread.start();
        baljeetThread.start();

    }

    //SYNCED STOP
    private synchronized void stop() {
        if (!running)
            return;

        running = false;
        try {
            gameThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.exit(1);
    }

    public void init() {
        GAME_GRID.init();
        baljeet = new Baljeet(GAME_GRID.makeGridPosition(500, 50, 50, 50, SimpleGfxFaceMapper.BALJEET));

        player = new Player(GAME_GRID.makeGridPosition(500, 750, 50, 50, SimpleGfxFaceMapper.PLAYER), baljeet);
    }

    //GAME LOOP
    @Override
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
                //*============================*//*
                tick();

                //*============================*//*
                updates++;
                delta--;
            }
            frames++;
            //tick();

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                //System.out.println(updates + " Ticks, Fps " + frames);
                updates = 0;
                frames = 0;
            }
        }
        stop();
    }

    private void tick() {
        //player.run();
        player.shoot();
    }

    public static void main(String[] args) {

        Main main = new Main();

        main.init();
        main.start();

    }


}