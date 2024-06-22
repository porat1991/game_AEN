package my_base;




import my_game.*;
import base.GameCanvas;
import base.GameContent;
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



	private final TargetsManager targetsManager = new TargetsManager();

	@Override
	public void initContent() {
		this.mySpaceship = new MySpaceship(new ScreenPoint(800, 600));
		this.weapon = new LaserWeapon();
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
			for (Target target : targetsManager.getTargets()) {
				target.removeExplosion();
				int laserXPosition =  mySpaceship.getLocation().x+weapon.getOffsetX();

				if(hitTarget(laserXPosition, target.getLocation().x)) {
					gotHittedList.add(target);
					System.out.println("Hit target: " + target.getImageID());
					System.out.println("laser x position: " + laserXPosition);
				}
			}
			gotHittedList.forEach(target -> {
				target.showExplosion();
				targetsManager.destroyTarget(target);
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

	public TargetsManager getTargetsManager() {
		return targetsManager;
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

	//TODO
	//create a method with the name myCharacter which returns
	//your character for others to use.

	
	//TODO
	//create a changeCharacter method and change inside all the properties you like.
}
