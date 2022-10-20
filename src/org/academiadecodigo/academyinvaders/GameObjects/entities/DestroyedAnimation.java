package org.academiadecodigo.academyinvaders.GameObjects.entities;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class DestroyedAnimation {

    Player player;
    Enemy enemy;

    public DestroyedAnimation(Player player) {
        this.player = player;
    }

    public DestroyedAnimation(Enemy enemy) {
        this.enemy = enemy;
    }

    public void playPlayerAnimation(String path, int delay) {

        player.getPlayerPosition().getObject().delete();

        player.getPlayerPosition().setObject(new Picture(player.getPlayerPosition().getWidth(), player.getPlayerPosition().getHeight(), path));

        player.getPlayerPosition().getObject().draw();

        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    public void playEnemyAnimation(String path, int delay) {

        enemy.getEnemyPosition().getObject().delete();

        enemy.getEnemyPosition().setObject(new Picture(enemy.getEnemyPosition().getWidth(), enemy.getEnemyPosition().getHeight(), path));

        enemy.getEnemyPosition().getObject().draw();

        try {

            Thread.sleep(delay);

        } catch (InterruptedException e) {

            throw new RuntimeException(e);
        }
    }
}
