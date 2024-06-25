package my_game;

import base.Game;
import base.GameCanvas;
import my_ui_elements.StackCapacity;
import shapes.Image;
import ui_elements.ScreenPoint;

public class LaserWeapon implements Weapon{

    private final int offstX = 120;
    private final int offstY = -750;

    private int stack;

    private final int capacity;

    public LaserWeapon(int capacity) {
        this.capacity = capacity;
        this.stack = capacity;
    }
    @Override
    public void showFire(ScreenPoint location) {
        Image image = new Image(getLaserImageID(), getLaserImage(), 5 ,800, location.x, location.y);
        GameCanvas canvas = Game.UI().canvas();
        if(canvas.getShape(getLaserImageID()) == null) {
            canvas.addShape(image);
        }

        canvas.moveShapeToLocation(getLaserImageID(), location.x+offstX, location.y+offstY);
        canvas.showShape(getLaserImageID());
    }

    private String getLaserImageID() {
        return "laser";
    }

    private String getLaserImage() {
        return "resources/laser.jpg";
    }

    public void hideFire() {
        GameCanvas canvas = Game.UI().canvas();
        canvas.hideShape(getLaserImageID());
    }

    public int getStack() {
        return this.stack;
    }

    public void decreaseStack() {
        if(this.stack > 0) {
            this.stack--;
            stackChanged();
        }
    }

    public void increaseStack() {
        if(this.stack < this.capacity) {
            this.stack++;
            stackChanged();
        }
    }

    @Override
    public int getOffsetX() {
        return this.offstX;
    }

    @Override
    public int getOffsetY() {
        return this.offstY;
    }

    private void stackChanged() {
        ((StackCapacity)Game.UI().dashboard().getUIElement("btnStack")).setText(this.stack);
    }
}
