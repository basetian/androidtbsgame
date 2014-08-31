package de.mmssb.androidtbsgame.andengine;

import org.andengine.engine.camera.SmoothCamera;

import de.mmssb.androidtbsgame.andengine.entities.board.Board;
import de.mmssb.androidtbsgame.andengine.managers.CellControl;
import de.mmssb.androidtbsgame.andengine.managers.ResourceManager;
import de.mmssb.androidtbsgame.andengine.managers.SceneManager;
import de.mmssb.androidtbsgame.andengine.managers.SharedPreferencesManager;

/**
 * @author Manu
 * 
 */
public class Model {
	private MainActivity mainActivity;
	// -----------------------------------------------------
	// Manager Classes
	// Initialized once
	// -----------------------------------------------------
	private SceneManager sceneManager;
	private ResourceManager resourceManager;
	private SharedPreferencesManager sharedPrefManager;
	// -----------------------------------------------------
	// Control Classes
	// Initialized once per game
	// -----------------------------------------------------
	private CellControl cellControl;
	private GameControl gameControl;

	/**
	 * Creates an instance of {@link Model}
	 * 
	 * Do never change the initialization-order!
	 * 
	 * @param mainActivity
	 *            {@link MainActivity} reference
	 */
	public Model(MainActivity mainActivity) {
		this.setMainActivity(mainActivity);
		// Creates a ResourceManager for loading and storing resources such as
		// Fonts and ITextureRegions
		this.setResourceManager(new ResourceManager(this));
		// Creates a SceneManager for creating and storing scenes. Has to be
		// done after creating the ResourceManager(!)
		this.setSceneManager(new SceneManager(this));
		// Creates a SharedPreferencesManager for loading and storing
		// Data using SharedPreferences
		this.setSharedPrefManager(new SharedPreferencesManager(this));
		// Displays the GameScene - GUI 'setVisible(true)'. Has to be done after
		// creating the SharedPreferencesManager(!)
		this.displayBoard(getRandomMap());
	}

	public void displayBoard(BoardMap boardMap) {
		// Creates a CellControl, needs at least one stored BoardMap to work.
		// Has to be done after creating the SharedPreferencesManager(!)
		this.setCellControl(new CellControl(boardMap));
		// Creates a GameControl for defining the settings for ONE game. Has to
		// be done after creating the CellControl(!)
		this.setGameControl(new GameControl(this, 2));
	}

	/**
	 * @return a random {@link BoardMap} from the
	 *         {@link SharedPreferencesManager}
	 */
	public BoardMap getRandomMap() {
		return sharedPrefManager
				.getMapStorage()
				.values()
				.toArray(
						new BoardMap[sharedPrefManager.getMapStorage().values()
								.size()])[(int) (Math.random() * sharedPrefManager
				.getMapStorage().size())];
	}

	/**
	 * Sets limits to the {@link SmoothCamera}
	 * 
	 * @param board
	 *            the actual {@link Board}
	 */
	public void limitCameraBoundsToBoard(Board board) {
		mainActivity.getSmoothCamera().setBounds(0, 0, board.getWidth(),
				board.getHeight());
	}

	/**
	 * Creates intuitive map swiping
	 * 
	 * @param pX
	 *            actual touch x location
	 * @param pY
	 *            actual touch y location
	 */
	public void handleGameSceneSwipe(float pX, float pY) {
		SmoothCamera smoothCamera = mainActivity.getSmoothCamera();
		smoothCamera.setCenter(pX, pY);
	}

	public MainActivity getMainActivity() {
		return mainActivity;
	}

	public void setMainActivity(MainActivity mainActivity) {
		this.mainActivity = mainActivity;
	}

	public SceneManager getSceneManager() {
		return sceneManager;
	}

	public void setSceneManager(SceneManager sceneManager) {
		this.sceneManager = sceneManager;
	}

	public ResourceManager getResourceManager() {
		return resourceManager;
	}

	public void setResourceManager(ResourceManager resourceManager) {
		this.resourceManager = resourceManager;
	}

	public SharedPreferencesManager getSharedPrefManager() {
		return sharedPrefManager;
	}

	public void setSharedPrefManager(SharedPreferencesManager sharedPrefManager) {
		this.sharedPrefManager = sharedPrefManager;
	}

	public GameControl getGameControl() {
		return gameControl;
	}

	public void setGameControl(GameControl gameControl) {
		this.gameControl = gameControl;
	}

	/**
	 * @return the cellControl
	 */
	public CellControl getCellControl() {
		return cellControl;
	}

	/**
	 * @param cellControl
	 *            the cellControl to set
	 */
	public void setCellControl(CellControl cellControl) {
		this.cellControl = cellControl;
	}
}
