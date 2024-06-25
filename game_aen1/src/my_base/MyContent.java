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
		this.weapon = new LaserWeapon(7);
		this.gameManager = new GameManager();

	}

	public MySpaceship MySpaceship() {
		return mySpaceship;
	}
//
	
//
	public void fire() {
		if(isSpaceKeyPressed) {
  			if(weapon.getStack() == 0) {
				  weapon.hideFire();
				  return;
			}
			weapon.decreaseStack();

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
		} else {
			weapon.increaseStack();
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

	public Weapon getWeapon() {
		return weapon;
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
		ScreenPoint spaceshipLocation = MySpaceship().getLocation();
		int spaceshipMaxY = spaceshipLocation.y;
		int spaceshipMaxX = spaceshipLocation.x + MySpaceship().getWidth()/2;
		int spaceshipMinX = spaceshipLocation.x;

		int targetMaxY = target.getLocation().y;
		int targetMinX = target.getLocation().x;
		int targetMaxX = target.getLocation().x + target.getWidth()/2;

		if(spaceshipMaxY < targetMaxY) {
			if (spaceshipMaxX > targetMinX && targetMaxX > spaceshipMinX) {
				System.out.println("spaceship hit: " + "target min X:" + targetMinX + " " + "target max X:" + targetMaxX + "target max Y:" + targetMaxY
						+ " " + "spaceship min X:" + spaceshipMinX + " " + "spaceship max X:" + spaceshipMaxX + "spaceship max Y:" + spaceshipMaxY);
				return true;
			}
		}
		return false;
	}


	//TODO
	//create a method with the name myCharacter which returns
	//your character for others to use.

	
	//TODO
	//create a changeCharacter method and change inside all the properties you like.
}
