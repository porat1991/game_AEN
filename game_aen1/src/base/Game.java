package base;

import DB.ExcelDB;
import my_base.MyContent;
import my_game.GameManager;
import my_ui_elements.EndButton;
import my_ui_elements.LowLevelButton;
import ui_elements.GameButton;

public abstract class Game {
	protected static GameContent gameContent;
	protected static GameUI gameUI;
	protected static MouseHandler mouseHandler;
	private static KeyboardListener keyboardListener;
	private static PeriodicScheduler scheduler;
	private static AudioPlayer audioPlayer;
	private static ExcelDB excelDB;
	
	public Game() {
		scheduler = new PeriodicScheduler();
		excelDB = ExcelDB.getInstance();
		audioPlayer = new AudioPlayer();
	}

	/*
	 * Make  sure to set the game content and periodic loop before calling initGame, since it is probable
	 * that you will need the content to initialize the UI and the scheduler should know what loop
	 * to run.
	 */
	public void setGameContent(GameContent content) {
		gameContent = content;
	}
	
	public void setPeriodicLoop(PeriodicLoop periodicLoop) {
		scheduler.setPeriodicLoop(periodicLoop);
	}
	
	public void setMouseHandler(MouseHandler myMouseHandler) {
		mouseHandler = myMouseHandler;
	}
		
	public void setKeyboardListener(KeyboardListener myKeyboardListener) {
		keyboardListener = myKeyboardListener;
	}

	public void initGame() {
		initContent();
		initUI();
		if (keyboardListener != null)
			gameUI.frame().addKeyListener(keyboardListener.keyListener);
		scheduler.start();
	}
	
	public void initUI() {
		gameUI = new GameUI("My Game", 1000, 1000);
		initCanvas();
		initDashboard();
		gameUI.setFocusable(true);
		gameUI.setVisible(true);
	}
	
	public static void endGame() {
		scheduler.end();
	}
	
	protected abstract void initCanvas();
	
	protected void initContent() {
		gameContent.initContent();

	};

	protected void initDashboard() {
		GameManager gameManager = ((MyContent)gameContent).getGameManager();
		EndButton endButton = new EndButton("btnEND", "END", 200, 60, 400, 20);
		endButton.setGameManager(gameManager);
		LowLevelButton lowLevelButton = new LowLevelButton("btnLOW", "LOW", 200, 60, 400, 100);
		lowLevelButton.setGameManager(gameManager);

		gameUI.dashboard().addUIElement(endButton);
		gameUI.dashboard().addUIElement(lowLevelButton);
	}
	
	//You can refer to the game UI from anywhere by Game.UI()
	public static GameUI UI() {
		return gameUI;
	}

	
	public static MouseHandler MouseHandler() {
		return mouseHandler;
	}
	
	public static KeyboardListener keybListener() {
		return keyboardListener;
	}
	
	public static GameContent Content() {
		return gameContent;
	}

	public static ExcelDB excelDB() {
		return excelDB;
	}

	public static AudioPlayer audioPlayer() {
		return audioPlayer;
	}

	
}
