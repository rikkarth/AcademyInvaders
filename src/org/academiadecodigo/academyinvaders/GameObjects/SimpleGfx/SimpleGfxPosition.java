package org.academiadecodigo.academyinvaders.GameObjects.SimpleGfx;

import org.academiadecodigo.academyinvaders.GameObjects.Grid.Position.AbstractGridPosition;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class SimpleGfxPosition extends AbstractGridPosition {

    private Rectangle object;

    private SimpleGfxGrid grid;

    public SimpleGfxPosition(int width, int height, SimpleGfxGrid grid) {

        super(width, height, grid);

        this.grid = grid;

        object = new Rectangle(width + grid.getGridX(), height + grid.getGridY(), 50, 50);
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
