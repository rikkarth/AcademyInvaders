package org.academiadecodigo.academyinvaders;

import org.academiadecodigo.academyinvaders.grid.Grid;
import org.academiadecodigo.academyinvaders.grid.GridFactory;
import org.academiadecodigo.academyinvaders.simplegfx.SimpleGfxFaceMapper;
import org.academiadecodigo.academyinvaders.system.Sound;
import org.academiadecodigo.academyinvaders.bullets.EnemyShootController;
import org.academiadecodigo.academyinvaders.entities.Enemy;
import org.academiadecodigo.academyinvaders.entities.Player;
import org.academiadecodigo.academyinvaders.entities.enemies.Baljeet;

public class Main implements Runnable {

  //PROPERTIES
  private boolean running = false;
  private Thread gameThread;
  private Thread playerThread;
  private Thread baljeetThread;
  private Thread enemyShootController;
  private static Sound sound;
  //private ExecutorService soundThreadPool = Executors.newCachedThreadPool();

  /**
   * Graphical Grid
   */
  public static final Grid GAME_GRID = GridFactory.makeGrid(1024, 768, SimpleGfxFaceMapper.GAME);
  private Player player;
  private Enemy baljeet;
  private EnemyShootController baljeetShootController;


  //SYNCED START
  private synchronized void start() {
    if (running) {
      return;
    }

    running = true;
    gameThread = new Thread(this);
    playerThread = new Thread(player);
    baljeetThread = new Thread(baljeet);
    enemyShootController = new Thread(baljeetShootController);

    gameThread.start();
    playerThread.start();
    baljeetThread.start();
    enemyShootController.start();
  }

  //SYNCED STOP
  private synchronized void stop() {
    if (!running) {
      return;
    }

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

    baljeet = new Baljeet(GAME_GRID.makeGridPosition(650, 50, 50, 50, SimpleGfxFaceMapper.BALJEET), player);

    player = new Player(GAME_GRID.makeGridPosition(700, 750, 50, 50, SimpleGfxFaceMapper.PLAYER), baljeet);

    baljeetShootController = new EnemyShootController(baljeet, player);

    Sound sound = new Sound("src/org/academiadecodigo/academyinvaders/GameObjects/Assets/Sound/8bit_musiclow.wav");
    sound.setLoop(20);
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
    player.playDestroyedAnimationIfDestroyed();
    player.shoot();

  }

  public static void main(String[] args) {

    Main main = new Main();

    main.init();

    main.start();
  }
}