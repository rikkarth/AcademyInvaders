package org.academiadecodigo.academyinvaders.GameObjects.bullets;

import org.academiadecodigo.academyinvaders.GameObjects.entities.Enemy;
import org.academiadecodigo.academyinvaders.GameObjects.Main;
import org.academiadecodigo.academyinvaders.GameObjects.entities.Player;
import org.academiadecodigo.academyinvaders.GameObjects.SimpleGfx.SimpleGfxFaceMapper;

import java.util.LinkedList;

public class EnemyShootController implements Runnable {

    private LinkedList<EnemyBullet> bulletList = new LinkedList<>();
    Enemy enemy;

    Player player;

    private EnemyBullet enemyBullet;

    public EnemyShootController(Enemy enemy, Player player) {
        this.enemy = enemy;
        this.player = player;
    }

    public boolean lineOfSight(Player player) {
        if (
                        player.getPlayerPosition().getWidth() < enemy.getEnemyPosition().getWidth() + enemy.getEnemyPosition().getObjectWidth() &&
                        player.getPlayerPosition().getWidth() + player.getPlayerPosition().getObjectWidth() > enemy.getEnemyPosition().getWidth()
        ) {
            // Collision detected!
            //System.out.println("LoS");

            //bulletPosition.hide();
            return true;
        }
        // No collision
        //System.out.println("Not LoS");
        return false;
    }

    public void fire() {
        if(!enemy.isDestroyed()) {
            if (lineOfSight(player)) {
                //System.out.println("Test");
                addBullet(new EnemyBullet(Main.GAME_GRID.makeGridPosition(enemy.getEnemyPosition().getWidth() + 90, enemy.getEnemyPosition().getHeight() + 200, 7, 10, SimpleGfxFaceMapper.BULLETGREEN)));
            }
        }
    }

    public void addBullet(EnemyBullet block) {
        getBulletList().add(block);
    }

    public LinkedList<EnemyBullet> getBulletList() {
        return bulletList;
    }

    public void shoot() {

        for (int i = 0; i < bulletList.size(); i++) {

            enemyBullet = bulletList.get(i);

            enemyBullet.move();


            if (enemyBullet.ifCollided(player)) {

                enemyBullet.getBulletPosition().hide();

                bulletList.remove(i);

                if (player.getHealth() != 0) {

                    player.setHealth(player.getHealth() - enemyBullet.DAMAGE);
                }

                //System.out.println("Player Health: " + player.getHealth());

                if (player.getHealth() == 0) {

                    player.setDestroyed();
                }
            }

            if (enemyBullet.getBulletPosition().getHeight() >= 800) {

                enemyBullet.getBulletPosition().hide();

                bulletList.remove(i);
            }

        }
    }

    @Override
    public void run() {

        while (true) {

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            int randomChance = (int) Math.floor((Math.random() * 100) + 1);
            //System.out.println(randomChance);


                if (randomChance > 95) {
                    fire();
                }
                shoot();

        }
    }
}
