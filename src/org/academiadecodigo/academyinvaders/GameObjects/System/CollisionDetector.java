package org.academiadecodigo.academyinvaders.GameObjects.System;

import org.academiadecodigo.academyinvaders.GameObjects.Bullets.EnemyBullet;
import org.academiadecodigo.academyinvaders.GameObjects.Bullets.PlayerBullet;
import org.academiadecodigo.academyinvaders.GameObjects.Enemy.Enemy;
import org.academiadecodigo.academyinvaders.GameObjects.Grid.Position.GridPosition;
import org.academiadecodigo.academyinvaders.GameObjects.Player.Player;

public class CollisionDetector {

    private Player player;
    private Enemy enemy;

    private EnemyBullet enemyBullet;

    private PlayerBullet playerBullet;

    public CollisionDetector(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    public CollisionDetector(EnemyBullet enemyBullet, Player player) {
        this.enemyBullet = enemyBullet;
        this.player = player;

    }

    public CollisionDetector(PlayerBullet playerBullet, Enemy enemy) {
        this.playerBullet = playerBullet;
        this.enemy = enemy;
    }

    public boolean isCollided() {

        if (
                player.getPlayerPosition().getWidth() < enemy.getEnemyPosition().getWidth() + enemy.getEnemyPosition().getObjectWidth() &&
                        player.getPlayerPosition().getWidth() + player.getPlayerPosition().getObjectWidth() > enemy.getEnemyPosition().getWidth() &&
                        player.getPlayerPosition().getHeight() < enemy.getEnemyPosition().getHeight() + enemy.getEnemyPosition().getObjectHeight() &&
                        player.getPlayerPosition().getObjectHeight() + player.getPlayerPosition().getHeight() > enemy.getEnemyPosition().getHeight()

        ) {
            // Collision detected!
            System.out.println("Collided");
            return true;
        }
        // No collision
        System.out.println("Not Collided");
        return false;
    }
}


