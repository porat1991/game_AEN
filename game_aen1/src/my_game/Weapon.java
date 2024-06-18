package my_game;

import ui_elements.ScreenPoint;

public interface Weapon {

    void showFire(ScreenPoint location);

    void hideFire();

    int getOffsetX();

    int getOffsetY();
}
