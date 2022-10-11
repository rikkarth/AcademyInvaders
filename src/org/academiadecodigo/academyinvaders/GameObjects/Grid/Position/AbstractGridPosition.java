package org.academiadecodigo.academyinvaders.GameObjects.Grid.Position;

import org.academiadecodigo.academyinvaders.GameObjects.Grid.GridColor;
import org.academiadecodigo.academyinvaders.GameObjects.Grid.Grid;
import org.academiadecodigo.academyinvaders.GameObjects.Grid.GridDirection;

public abstract class AbstractGridPosition implements GridPosition {

    //PROPERTIES

    private int width;
    private int height;
    private GridColor color;
    private Grid grid;

    public AbstractGridPosition(int width, int height, Grid grid) {

        this.width = width;
        this.height = height;
        this.grid = grid;
        this.color = GridColor.NOCOLOR;
    }

    public Grid getGrid() {
        return grid;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public void setPos(int width, int height) {
        this.width = width;
        this.height = height;
        show();
    }

    @Override
    public GridColor getColor() {
        return color;
    }

    @Override
    public void setColor(GridColor color) {
        this.color = color;
        show();
    }

    @Override
    public void moveInDirection(GridDirection direction, int distance) {
        switch (direction) {

            case UP:
                moveUp(distance);
                break;
            case DOWN:
                moveDown(distance);
                break;
            case LEFT:
                moveLeft(distance);
                break;
            case RIGHT:
                moveRight(distance);
                break;
        }
    }

    /**
     * @see GridPosition
     */
    @Override
    public boolean equals(GridPosition position) {
        return this.width == position.getWidth() && this.height == position.getHeight() ? true : false;
    }

    // movimentos em gridposition para apoiar o switch movedirection;
    // permite o movimento consoante a distancia até o maximo imposto pela Grid no Down and Right
    // permite o movimento consoante a distancia até o maximo imposto pela relaçao do get da position no Up e Left

    public void moveUp(int distance) {

        int maxUpHeight = distance < getHeight() ? distance : getHeight();

        setPos(getWidth(), this.height - maxUpHeight);
    }

    public void moveDown(int distance) {

        int maxDownHeight = distance > getGrid().getGRID_HEIGHT() - (getHeight() + 1) ? getGrid().getGRID_HEIGHT() - (getHeight() + 1) : distance;

        setPos(getWidth(), getHeight() + maxDownHeight);
    }

    public void moveLeft(int distance) {

        int maxLeftWidth = distance < getWidth() ? distance : getWidth();

        setPos(getWidth() - maxLeftWidth, getWidth());
    }

    public void moveRight(int distance) {

        int maxRightWidth = distance > getGrid().getGRID_WIDTH() - (getWidth() + 1) ? getGrid().getGRID_WIDTH() - (getWidth() + 1) : distance;

        setPos(getWidth() + maxRightWidth, getWidth());
    }
}
