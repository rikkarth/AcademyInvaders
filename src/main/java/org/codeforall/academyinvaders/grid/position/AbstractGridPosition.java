package org.codeforall.academyinvaders.grid.position;

import org.codeforall.academyinvaders.grid.Grid;
import org.codeforall.academyinvaders.grid.GridColor;
import org.codeforall.academyinvaders.grid.GridDirection;

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
  public void setHeight(int height) {
    this.height = height;
  }

  @Override
  public void setWidth(int width) {
    this.width = width;
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

  /**
   * Move logic
   *
   * @param distance should always be 1;
   */
  public void moveUp(int distance) {

    int maxUpHeight = distance < getHeight() ? distance : getHeight();

    setPos(getWidth(), this.height - maxUpHeight);
  }

  public void moveDown(int distance) {

    int maxDownHeight =
        distance > getGrid().getGRID_HEIGHT() - getHeight() + 40 ? getGrid().getGRID_HEIGHT() - getHeight() + 40
            : distance;

    setPos(getWidth(), this.getHeight() + maxDownHeight);
  }

  public void moveLeft(int distance) {

    int maxLeftWidth = distance < getWidth() - 210 ? distance : getWidth() - 210;

    setPos(getWidth() - maxLeftWidth, getHeight());
  }

  public void moveRight(int distance) {

    int maxRightWidth =
        distance > getGrid().getGRID_WIDTH() - getWidth() + 130 ? getGrid().getGRID_WIDTH() - getWidth() + 130
            : distance;

    setPos(getWidth() + maxRightWidth, getHeight());
  }
}
