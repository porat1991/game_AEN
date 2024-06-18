package my_base;




import base.Game;
import base.GameCanvas;
import my_game.Target;
import my_game.MySpaceship;
import base.GameContent;
import my_game.TargetsManager;
import shapes.Image;
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
	private boolean isSpaceKeyPressed = false;

	int offstX = 120;
	int offstY = -750;

	private final TargetsManager targetsManager = new TargetsManager();

	@Override
	public void initContent() {
		this.mySpaceship = new MySpaceship(new ScreenPoint(833, 650));
//		canvas.moveShapeToLocation(getImageID(), this.location.x, this.location.y);

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
			showLazer(location);

			List<Target> gotHittedList = new ArrayList<>();
			for (Target target : targetsManager.getTargets()) {
				if(hitTarget(mySpaceship, target)) {

				}
			}
		}
	}
	private boolean hitTarget(MySpaceship mySpaceship, Target target) {
		return true;
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
	//	public void setDirectionPolicy(Target.Direction direction) {
//		directionPolicy = direction;
//	}

	private void showLazer(ScreenPoint location) {



		Image image = new Image(getLazerImageID(), getLazerImage(), 6,800, location.x, location.y);
		GameCanvas canvas = Game.UI().canvas();
		if(canvas.getShape(getLazerImageID()) == null) {
			canvas.addShape(image);
		}

  		canvas.moveShapeToLocation(getLazerImageID(), location.x+offstX, location.y+offstY);
		canvas.showShape(getLazerImageID());
	}

	public void hideLazer() {
		GameCanvas canvas = Game.UI().canvas();
		canvas.hideShape(getLazerImageID());
	}


		private String getLazerImage() {
		 return "resources/Lazer.jpg";
	}

	private String getLazerImageID() {
		 return "lazer";
	}

	public boolean isSpaceKeyPressed() {
		return isSpaceKeyPressed;
	}

	public void setSpaceKeyPressed() {
		isSpaceKeyPressed = true;
	}
	public void setSpaceKeyReleased() {
		isSpaceKeyPressed = false;
		hideLazer();
	}

	//TODO
	//create a method with the name myCharacter which returns
	//your character for others to use.

	
	//TODO
	//create a changeCharacter method and change inside all the properties you like.
}
