package my_base;

import my_game.MySpaceship;
import my_game.Pokimon;
import my_ui_elements.DirectionCombo;

import java.awt.event.KeyEvent;

import base.Game;
import base.KeyboardListener;

public class MyKeyboardListener extends KeyboardListener{

	private MyContent myContent;
	
	public MyKeyboardListener() {
		super();
		myContent = (MyContent) this.content;
	}

	@Override
	public void directionalKeyPressed(Direction direction) {
		switch (direction) {
		  case RIGHT:
//			  myContent.pokimon().setDirectionPolicy(Pokimon.Direction.RIGHT);
			  myContent.MySpaceship().setDirectionPolicy(MySpaceship.Direction.RIGHT);
			  ((DirectionCombo) (Game.UI().dashboard().getUIElement("directionCombo"))).setDirection("Right");
			  break;
		  case LEFT:
//			  myContent.pokimon().setDirectionPolicy(Pokimon.Direction.LEFT);
			  myContent.MySpaceship().setDirectionPolicy(MySpaceship.Direction.LEFT);
			  ((DirectionCombo) (Game.UI().dashboard().getUIElement("directionCombo"))).setDirection("Left");
			  break;
		  case UP:
			  myContent.MySpaceship().setDirectionPolicy(MySpaceship.Direction.UP);
//
			  break;
		  case DOWN:
			  myContent.MySpaceship().setDirectionPolicy(MySpaceship.Direction.DOWN);
//			  myContent.pokimon().setRotation(myContent.pokimon().getRotation() - 20);
			  break;
		}
	}
	
	@Override
	public void characterTyped(char c) {
		System.out.println("key character = '" + c + "'" + " pressed.");
	}
	
	@Override
	public void enterKeyPressed() {
		System.out.println("enter key pressed.");
	}
	
	@Override
	public void backSpaceKeyPressed() {
		System.out.println("backSpace key pressed.");
	}
	
	@Override
	public void spaceKeyPressed() {
		System.out.println("space key pressed.");
	}
	
	public void otherKeyPressed(KeyEvent e) {
		System.out.println("other key pressed. type:" + e);
	}
}
