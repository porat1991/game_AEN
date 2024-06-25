package my_ui_elements;

import my_game.GameManager;
import ui_elements.GameComboBox;


public class ComboBoxLevel extends GameComboBox {
        GameManager gameManager;

        public ComboBoxLevel(String id, String name, int width, int height, int posX, int posY, GameManager gameManager) {
            super(id, name, width, height, posX, posY, new String[]{"Low", "Medium", "High"});
            this.gameManager = gameManager;

        }


        @Override
        public void action() {
            // The basic buttonAction prints the id of the button to the console.
            // Keep the call to super to preserve this behavior or remove it if you don't want the printing.
            super.action();
            String option = getOption();

            switch(option) {
                case "Low":
                    gameManager.setLowLevel();
                    System.out.println("LowLevelButton action");
                    break;
                case "Medium":
                    gameManager.setMediumLevel();
                    System.out.println("MediumLevelButton action");
                    break;
                case "High":
                    gameManager.setHighLevel();
                    System.out.println("HighLevelButton action");
                    break;
            }

            System.out.println("ComboBoxLevel action");
        }


}
