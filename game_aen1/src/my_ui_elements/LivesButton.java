package my_ui_elements;

import my_game.GameManager;
import ui_elements.GameButton;


public class LivesButton extends GameButton {

    GameManager gameManager;

    public LivesButton(String id, String name, int width, int height, int posX, int posY, GameManager gameManager) {
        super(id, name, width, height, posX, posY);
        this.gameManager = gameManager;
    }

    public void setText(int lives) {
        this.setText("Lives: " + lives);
    }

    @Override
    public void action() {
        // The basic buttonAction prints the id of the button to the console.
        // Keep the call to super to preserve this behavior or remove it if you don't want the printing.
        super.action();
        System.out.println("The lives are: " + gameManager.getLives());
    }
}
