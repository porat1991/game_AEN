package my_game;

import base.Game;
import base.GameCanvas;
import shapes.Image;
import ui_elements.ScreenPoint;

public class MySpaceship {
    private final int width = 250;
    private final int height = 360;

    public MySpaceship(ScreenPoint initPosition) {
        this.imageID = "spaceship";
        this.location = initPosition;
    }

    private ScreenPoint location;



    private String imageID;

    public String getImage() {
        return image;
    }

    private final String image = "resources/spaceShip1.jpg";

    public void move(int dx, int dy) {
        setLocation(new ScreenPoint(this.location.x+dx, this.location.y+dy));
        GameCanvas canvas = Game.UI().canvas();
        canvas.moveShapeToLocation(getImageID(), this.location.x, this.location.y);
        System.out.println("x: " + this.location.x);
        System.out.println("y: " + this.location.y);
//        canvas.moveShape(getImageID(), dx, dy);
//        Image image = (Image) canvas.getShape(getImageID());
//        System.out.println("x: " + image.getPosX());
//        System.out.println("y: " + image.getPosY());
    }

    public void setImageID(String id) {
        this.imageID = id;
    }

    public String getImageID() {
        return this.imageID;
    }

    public ScreenPoint getLocation() {
        return location;
    }

    public int getWidth() {
    	return width;
    }

    public int getHeight() {
    	return height;
    }

    public void setLocation(ScreenPoint location) {
        this.location = location;
    }

    public void addToCanvas() {
        GameCanvas canvas = Game.UI().canvas();
        Image image = new Image(getImageID(), getImage(), width,height, this.location.x, this.location.y);
        System.out.println("x: " + this.location.x);
        System.out.println("y: " + this.location.y);
        System.out.println("x: " + image.getPosX());
        System.out.println("y: " + image.getPosY());
//        image.setShapeListener(this);
//        image.setzOrder(3);
        canvas.addShape(image);
        
    }


}
