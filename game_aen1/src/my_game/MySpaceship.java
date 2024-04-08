package my_game;

import base.Game;
import base.GameCanvas;
import base.ShapeListener;
import shapes.Image;
import ui_elements.ScreenPoint;

public class MySpaceship {

    public MySpaceship() {
        this.imageID = "spaceship1";
        this.location = new ScreenPoint(50, 50);
    }


    private ScreenPoint location;
    private String imageID;

    public String getImage() {
        return image;
    }

    private final String image = "resources/spaceShip1.jpg";


    public ScreenPoint getLocation() {
        return this.location;
    }

    public void setLocation(ScreenPoint location) {
        this.location = location;
    }

    public void setImageID(String id) {
        this.imageID = id;
    }

    public String getImageID() {
        return this.imageID;
    }

    public enum Direction{
        RIGHT (10,0),
        LEFT(-10,0),
        UP (0,-10),
        DOWN(0,10);

        private final int xVec, yVec;
        private Direction(int xVec, int yVec) {
            this.xVec = xVec;
            this.yVec = yVec;
        }
        public int xVec() {
            return xVec;
        }
        public int yVec() {
            return yVec;
        }
    }

    private MySpaceship.Direction directionPolicy = MySpaceship.Direction.RIGHT;
    private MySpaceship.Direction direction = MySpaceship.Direction.RIGHT;

    public void setDirectionPolicy(MySpaceship.Direction direction) {
        directionPolicy = direction;
    }

    public MySpaceship.Direction getDirection() {
        return direction;
    }

    public MySpaceship.Direction getPolicy() {
        return directionPolicy;
    }


    public void addToCanvas() {
        GameCanvas canvas = Game.UI().canvas();
        Image image = new Image(getImageID(), getImage(), 250,360, 650, 500);
//        image.setShapeListener(this);
//        image.setzOrder(3);
        canvas.addShape(image);
        
    }


}
