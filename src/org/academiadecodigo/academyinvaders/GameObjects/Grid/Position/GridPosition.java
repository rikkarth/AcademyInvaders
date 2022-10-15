package org.academiadecodigo.academyinvaders.GameObjects.Grid.Position;
import org.academiadecodigo.academyinvaders.GameObjects.Grid.GridColor;
import org.academiadecodigo.academyinvaders.GameObjects.Grid.GridDirection;
public interface GridPosition {

    public int getWidth();

    public int getHeight();

    void setHeight(int i);
    void setWidth(int i);

    public void setPos(int width, int height);

    public int setHeight();

    public GridColor getColor();

    public void setColor(GridColor color);

    public void show();

    public void hide();

    public int getObjectHeight();

    public int getObjectWidth();

    public void moveInDirection(GridDirection direction, int distance);

    /**
     * Verifies if Grid Position is in same position than other Grid Position
     */
    public boolean equals(GridPosition position);
}
