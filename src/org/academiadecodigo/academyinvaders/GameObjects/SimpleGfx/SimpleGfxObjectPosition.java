package org.academiadecodigo.academyinvaders.GameObjects.SimpleGfx;

import org.academiadecodigo.academyinvaders.GameObjects.Grid.Position.AbstractGridPosition;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class SimpleGfxObjectPosition extends AbstractGridPosition {

    private Rectangle object;

    private SimpleGfxGrid grid;

    /**
     * Simple graphics object position constructor
     * It will construct an object at given position
     * @param grid Simple graphics grid
     */
    public SimpleGfxObjectPosition(int width, int height, int sizeX, int sizeY, SimpleGfxGrid grid) {

        super(width, height, grid);

        this.grid = grid;

        object = new Rectangle(width + grid.getGridX(), height + grid.getGridY(), sizeX, sizeY);
        show();

    }

    @Override
    public void show() {
        object.fill();
    }

    @Override
    public void hide() {
        object.delete();
    }
}
