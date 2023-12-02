package org.academiadecodigo.academyinvaders.grid.position;

import org.academiadecodigo.academyinvaders.grid.GridColor;
import org.academiadecodigo.academyinvaders.grid.GridDirection;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public interface GridPosition {

  public int getWidth();

  public int getHeight();

  public void setHeight(int i);

  public void setWidth(int i);

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

  public Picture getObject();

  public void setObject(Picture picture);
}
