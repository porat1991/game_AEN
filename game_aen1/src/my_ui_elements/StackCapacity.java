package my_ui_elements;

import my_game.Weapon;
import ui_elements.GameButton;

public class StackCapacity extends GameButton {

    Weapon weapon;
    public StackCapacity(String id, String name, int width, int height, int posX, int posY, Weapon weapon) {
        super(id, name, width, height, posX, posY);
        this.weapon = weapon;
    }

    public void setText(int count) {
        this.setText(Integer.toString(count));
    }

    @Override
    public void action() {
        // The basic buttonAction prints the id of the button to the console.
        // Keep the call to super to preserve this behavior or remove it if you don't want the printing.
        super.action();
    }

}
