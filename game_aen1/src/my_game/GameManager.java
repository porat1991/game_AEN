package my_game;

import shapes.Image;

public class GameManager {

    private int score = 30;

    private int level;

    private int lives;

    private final TargetsManager targetsManager;

    public void decreaseLife() {
        lives--;
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

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void decreaseScore (int score) {
        this.score -= score;
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
    }

    public void gameOver() {

        System.out.println("Game Over");

        String imageID = "gameOver";
        String imagePath = "resources/spaceShip1.jpg";
        Image image = new Image(imageID, imagePath, 300,100, 400, 400);

    }
}
