package my_game;

import base.Game;
import base.GameCanvas;
import shapes.Image;
import ui_elements.ScreenPoint;

public class EnemySpaceship {


        public EnemySpaceship() {
            this.imageID = "senemyspaceship1";
            this.location = new ScreenPoint(50, 10);
        }


        private ScreenPoint location;
        private String imageID;

        public String getImage() {
            return image;
        }

        private final String image = "resources/enemyspaceship1.jpg";


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

        private my_game.EnemySpaceship.Direction directionPolicy = my_game.EnemySpaceship.Direction.RIGHT;
        private my_game.EnemySpaceship.Direction direction = my_game.EnemySpaceship.Direction.RIGHT;

        public void setDirectionPolicy(my_game.EnemySpaceship.Direction direction) {
            directionPolicy = direction;
        }

        public my_game.EnemySpaceship.Direction getDirection() {
            return direction;
        }

        public my_game.EnemySpaceship.Direction getPolicy() {
            return directionPolicy;
        }


        public void addToCanvas() {
            GameCanvas canvas = Game.UI().canvas();
            Image image = new Image(getImageID(), getImage(), 150,260, 650, 100);
//        image.setShapeListener(this);
//        image.setzOrder(3);
            canvas.addShape(image);

        }




}
