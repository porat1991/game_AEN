package my_base;




import base.*;
import my_game.*;
import ui_elements.ScreenPoint;

import java.util.ArrayList;
import java.util.List;
//import javafx.scene.effect.Light.Point;


public class MyContent extends GameContent{
//	private Pokimon pokimon;
//	private MyPolygon myPolygon;
	//TODO
	//Declare your own character
	private MySpaceship mySpaceship;

	private Weapon weapon;
	private boolean isSpaceKeyPressed = false;

	private GameManager gameManager;

	@Override
	public void initContent() {
		this.mySpaceship = new MySpaceship(new ScreenPoint(800, 600));
		this.weapon = new LaserWeapon();
		this.gameManager = new GameManager();
		//GameCanvascanvas.moveShapeToLocation(getImageID(), this.location.x, this.location.y);

//		this.target = new Target();

//		pokimon = new Pokimon();
//		pokimon.setLocation(new ScreenPoint(100,100));
//		ScreenPoint[] points = {
//			new ScreenPoint(100, 100),
//			new ScreenPoint(130, 50),
//			new ScreenPoint(170, 50),
//			new ScreenPoint(200, 100),
//			new ScreenPoint(220, 170),
//			new ScreenPoint(170, 150),
//			new ScreenPoint(130, 150)
//		};
//
//		myPolygon = new MyPolygon(points);
	}	

//	public Pokimon pokimon() {
//		return pokimon;
//	}
//
//	public MyPolygon polygon() {
//		return myPolygon;
//	}
	public MySpaceship MySpaceship() {
		return mySpaceship;
	}
//
	
//
	public void fire() {

		if(isSpaceKeyPressed) {
			ScreenPoint location = mySpaceship.getLocation();
			weapon.showFire(location);
			List<Target> gotHittedList = new ArrayList<>();
			for (Target target : gameManager.getTargetsManager().getTargets()) {
				target.removeExplosion();
				int laserXPosition =  mySpaceship.getLocation().x+weapon.getOffsetX();

				if(hitTarget(laserXPosition, target.getLocation().x)) {
					gameManager.decreaseScore(1);
					gotHittedList.add(target);
					System.out.println("Hit target: " + target.getImageID());
					System.out.println("laser x position: " + laserXPosition);
				}
			}
			gotHittedList.forEach(target -> {
				target.showExplosion();
				gameManager.getTargetsManager().removeTarget(target);
			});
		}
	}
	private boolean hitTarget(int laserXPosition, int targetLocationX) {
		int Width = 50;


		return laserXPosition > targetLocationX && laserXPosition < targetLocationX+Width;
	}
	
	public void addSpaceship() {
		mySpaceship.addToCanvas();
//		target.addToCanvas();

		//TODO
		//Create an instance of your character and set its properties with
		//initial values
		
		
		//TODO
		//Add your character visual representation to the canvas using its addToCanvas() method.

	}



	public boolean isSpaceKeyPressed() {
		return isSpaceKeyPressed;
	}

	public void setSpaceKeyPressed() {
		isSpaceKeyPressed = true;
	}
	public void setSpaceKeyReleased() {
		isSpaceKeyPressed = false;
		weapon.hideFire();
	}

	public GameManager getGameManager() {
		return gameManager;
	}


	public boolean isSpaceshipHit(Target target) {
//		ScreenPoint spaceshipLocation = MySpaceship().getLocation();
//		int spaceshipMaxY = spaceshipLocation.y - MySpaceship().getHeight();
//		int spaceshipMaxX = spaceshipLocation.x + MySpaceship().getWidth();
//		int spaceshipMinX = spaceshipLocation.x;
//
//		int targetMaxY = target.getLocation().y;
//		int targetMinX = target.getLocation().x;
//		int targetMaxX = target.getLocation().x + target.getWidth();
//
//		if(spaceshipMaxY < targetMaxY) {
//			return spaceshipMaxX > targetMinX && targetMaxX > spaceshipMinX;
//		}
		return false;
	}


	//TODO
	//create a method with the name myCharacter which returns
	//your character for others to use.

	
	//TODO
	//create a changeCharacter method and change inside all the properties you like.
}
