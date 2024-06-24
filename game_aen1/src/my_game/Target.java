package my_game;

import base.Game;
import base.GameCanvas;
import shapes.Image;
import ui_elements.ScreenPoint;

public class Target {

        private int width = 50;
        private int height = 70;
        private String imageID;
        private String image;
        private ScreenPoint location;


    public String getImage() {
            return image;
        }

    public Target(String imagePath, String imageId, ScreenPoint initPosition) {
        this.imageID = imageId;
        this.image = imagePath;
        this.location = initPosition;
    }

    public int getWidth() {
    	return width;
    }

    public int getHeight() {
    	return height;
    }

    public String getImageID() {
        return this.imageID;
    }

    public void setImageID(String imageID) {
        this.imageID = imageID;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ScreenPoint getLocation() {
        return location;
    }

    public void setLocation(ScreenPoint location) {
        this.location = location;
    }

    public void addToCanvas() {
        GameCanvas canvas = Game.UI().canvas();
        Image image = new Image(getImageID(), getImage(), width, height, this.location.x, this.location.y);
//        image.setShapeListener(this);
//        image.setzOrder(3);
        canvas.addShape(image);
    }

    public void removeFromCanvas(String id) {
        GameCanvas canvas = Game.UI().canvas();
        canvas.deleteShape(id);
    }

    public void move(int dx, int dy) {
        setLocation(new ScreenPoint(this.location.x+dx, this.location.y+dy));
        GameCanvas canvas = Game.UI().canvas();
        canvas.moveShapeToLocation(getImageID(), this.location.x, this.location.y);
    }

    public void showExplosion() {
        Image image = new Image(getExplosionImageID(), getExplosionImage(), 70,90, location.x, location.y);
        GameCanvas canvas = Game.UI().canvas();
        if(canvas.getShape(getExplosionImageID()) == null) {
            canvas.addShape(image);
        }

        canvas.moveShapeToLocation(getExplosionImageID(), location.x, location.y);
        canvas.showShape(getExplosionImageID());
    }

    private String getExplosionImageID() {
        return "explosion";
    }

    private String getExplosionImage() {
        return "resources/Explosion.jpg";
    }

    public void removeExplosion() {
        GameCanvas canvas = Game.UI().canvas();
        canvas.deleteShape(getExplosionImageID());
    }

}
