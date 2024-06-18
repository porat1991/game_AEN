package my_base;

import my_game.MySpaceship;
import my_game.Pokimon;
import my_ui_elements.DirectionCombo;

import java.awt.event.KeyEvent;

import base.Game;
import base.KeyboardListener;
import shapes.Shape;

public class MyKeyboardListener extends KeyboardListener{

	private MyContent myContent;
	protected Shape draggedShape;
	
	public MyKeyboardListener() {
		super();
		myContent = (MyContent) this.content;
	}

	@Override
	public void directionalKeyPressed(Direction direction) {
		switch (direction) {
			case RIGHT:
				myContent.MySpaceship().move(10, 0);
				break;
			case LEFT:
				myContent.MySpaceship().move(-10, 0);
				break;
//			case UP:
//				myContent.MySpaceship().move(0, -10);
//				break;
//			case DOWN:
//				myContent.MySpaceship().move(0, 10);
//				break;
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
		myContent.setSpaceKeyPressed();
		System.out.println("space key pressed.");
	}

	public void spaceKeyReleased() {
		System.out.println("space key released.");
		myContent.setSpaceKeyReleased();
	}
	
	public void otherKeyPressed(KeyEvent e) {
		System.out.println("other key pressed. type:" + e);
	}
}
