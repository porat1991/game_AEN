package my_base;




import my_game.EnemySpaceship;
import my_game.MySpaceship;
import base.GameContent;
//import javafx.scene.effect.Light.Point;


public class MyContent extends GameContent{
//	private Pokimon pokimon;
//	private MyPolygon myPolygon;
//
	//TODO
	//Declare your own character
	private MySpaceship mySpaceship;
	private EnemySpaceship enemySpaceship1;

	@Override
	public void initContent() {
		this.mySpaceship = new MySpaceship();
		this.enemySpaceship1 = new EnemySpaceship();

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
	public EnemySpaceship enemySpaceship() {
		return enemySpaceship1;
	}

//
	public void addSpaceship() {
		mySpaceship.addToCanvas();
		enemySpaceship1.addToCanvas();

		//TODO
		//Create an instance of your character and set its properties with
		//initial values
		
		
		//TODO
		//Add your character visual representation to the canvas using its addToCanvas() method.

	}



	//TODO
	//create a method with the name myCharacter which returns
	//your character for others to use.

	
	//TODO
	//create a changeCharacter method and change inside all the properties you like.
}
