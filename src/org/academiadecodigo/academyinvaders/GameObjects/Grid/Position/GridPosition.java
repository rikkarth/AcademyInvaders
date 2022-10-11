package org.academiadecodigo.academyinvaders.GameObjects.Grid.Position;
import org.academiadecodigo.academyinvaders.GameObjects.Grid.GridColor;
import org.academiadecodigo.academyinvaders.GameObjects.Grid.GridDirection;
public interface GridPosition {

    public int getWidth();

    public int getHeight();

    public void setPos(int width, int height);

    public GridColor getColor();

    public void setColor(GridColor color);

    public void show();

    public void hide();

    public void moveInDirection(GridDirection direction, int distance);

    /**
     * Verifies if Grid Position is in same position than other Grid Position
     */
    public boolean equals(GridPosition position);
}
