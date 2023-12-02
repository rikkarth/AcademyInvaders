package org.academiadecodigo.academyinvaders.system;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class PlayerKeyboard {

  KeyboardHandler player;

  public PlayerKeyboard(KeyboardHandler player) {
    this.player = player;
  }

  /**
   * Initializes keyboard
   */
  public void initKeyboard() {

    Keyboard keyboard = new Keyboard(player);

    KeyboardEvent rightPressed = new KeyboardEvent();
    rightPressed.setKey(KeyboardEvent.KEY_D);
    rightPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

    KeyboardEvent leftPressed = new KeyboardEvent();
    leftPressed.setKey(KeyboardEvent.KEY_A);
    leftPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

    KeyboardEvent shootPressed = new KeyboardEvent();
    shootPressed.setKey(KeyboardEvent.KEY_SPACE);
    shootPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

    KeyboardEvent shootReleased = new KeyboardEvent();
    shootReleased.setKey(KeyboardEvent.KEY_SPACE);
    shootReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

    KeyboardEvent leftReleased = new KeyboardEvent();
    leftReleased.setKey(KeyboardEvent.KEY_A);
    leftReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

    KeyboardEvent rightReleased = new KeyboardEvent();
    rightReleased.setKey(KeyboardEvent.KEY_D);
    rightReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

    keyboard.addEventListener(leftPressed);
    keyboard.addEventListener(rightPressed);
    keyboard.addEventListener(shootPressed);
    keyboard.addEventListener(rightReleased);
    keyboard.addEventListener(leftReleased);
    keyboard.addEventListener(shootReleased);
  }
}
