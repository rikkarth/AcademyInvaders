package org.academiadecodigo.academyinvaders.GameObjects.SimpleGfx;

import org.academiadecodigo.academyinvaders.GameObjects.Grid.Grid;
import org.academiadecodigo.academyinvaders.GameObjects.Grid.Position.AbstractGridPosition;

import java.awt.*;

public class SimpleGfxPosition extends AbstractGridPosition {

    private Rectangle object;

    private SimpleGfxGrid grid;


    public SimpleGfxPosition(int width, int height, SimpleGfxGrid grid) {
        super(width, height, grid);
        this.grid = grid;

    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }
}
