package my_ui_elements;

import my_game.GameManager;
import ui_elements.GameButton;

public class HighLevelButton extends GameButton {

    GameManager gameManager;
    public HighLevelButton(String id, String name, int width, int height, int posX, int posY) {
        super(id, name, width, height, posX, posY);
    }

    public void setGameManager(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @Override
    public void action() {
        // The basic buttonAction prints the id of the button to the console.
        // Keep the call to super to preserve this behavior or remove it if you don't want the printing.
        super.action();
        gameManager.setHighLevel();
        System.out.println("HighLevelButton action");
    }
}
