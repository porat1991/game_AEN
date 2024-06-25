package my_game;

import base.Game;
import base.GameCanvas;
import my_ui_elements.LivesButton;
import my_ui_elements.ScoreButton;
import shapes.Image;

public class GameManager {

    private int score = 30;

    private int level;

    private int lives;

    private final TargetsManager targetsManager;

    public void decreaseLife() {
        lives--;
        livesChanged();
    }

    public GameManager() {
        this.lives = 3;
        this.level = 1;
        this.targetsManager = new TargetsManager();
    }

    public TargetsManager getTargetsManager() {
        return targetsManager;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLives() {
        return lives;
    }

    public int getLevel() {
        return level;
    }

    public void decreaseScore (int score) {
        this.score -= score;
        scoreChanged();
    }

    public void setLowLevel () {
        this.level = 1;
    }
    public void setMediumLevel () {
        this.level = 2;
    }
    public void setHighLevel () {
        this.level = 3;
    }


    public void restartGame () {
        this.score = 30;
        this.lives = 3;
        targetsManager.removeAllTargets();
        scoreChanged();
        livesChanged();
    }

    public void gameOver() {

        System.out.println("Game Over");
        targetsManager.removeAllTargets();
        showGameOverImage();
        Game.endGame();
    }

    private void showGameOverImage() {
        String imageID = "gameOver";
        String imagePath = "resources/game-over.jpg";
        Image image = new Image(imageID, imagePath, 1800, 800, 1000, 400);
        GameCanvas canvas = Game.UI().canvas();
        canvas.addShape(image);

    }

    private void scoreChanged() {
        ((ScoreButton)Game.UI().dashboard().getUIElement("btnScore")).setText(this.score);
    }
    private void livesChanged() {
        ((LivesButton)Game.UI().dashboard().getUIElement("btnLives")).setText(this.lives);
    }
}
