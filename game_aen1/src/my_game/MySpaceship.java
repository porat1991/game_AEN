package my_game;

import base.Game;
import base.GameCanvas;
import base.ShapeListener;
import shapes.Image;
import ui_elements.ScreenPoint;

public class MySpaceship {

    public MySpaceship() {
        this.imageID = "spaceship";
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

    public void addToCanvas() {
        GameCanvas canvas = Game.UI().canvas();
        Image image = new Image(getImageID(), getImage(), 250,360, 650, 500);
//        image.setShapeListener(this);
//        image.setzOrder(3);
        canvas.addShape(image);
        
    }


}
