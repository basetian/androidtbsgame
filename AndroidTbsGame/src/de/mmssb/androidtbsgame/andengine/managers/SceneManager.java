package de.mmssb.androidtbsgame.andengine.managers;

import org.andengine.entity.scene.Scene;

import de.mmssb.androidtbsgame.andengine.Model;
import de.mmssb.androidtbsgame.andengine.scenes.GameScene;

/**
 * @author Manu
 * 
 */
public class SceneManager extends Manager {
	public static enum SceneType {
		SPLASH, MENU, GAME
	}

	private SceneType actualSceneType;
	private GameScene gameScene;

	/**
	 * Creates an instance of {@link SceneManager}
	 * 
	 * @param activity
	 * @param engine
	 * @param camera
	 * @param resourceManager
	 */
	public SceneManager(Model model) {
		super(model);
	}

	/**
	 * Creates all Scenes. Call from SplashScene(!)
	 */
	public void load() {
		gameScene = new GameScene(getModel());
	}

	/**
	 * @return the actual selected {@link Scene}
	 */
	public Scene getActualScene() {
		switch (actualSceneType) {
		case GAME:
			return gameScene;
		case MENU:
			return null;
		case SPLASH:
			return null;
		default:
			return null;
		}
	}

	public GameScene getGameScene() {
		return gameScene;
	}

	/**
	 * Sets the actual {@link Scene}
	 * 
	 * @param actualSceneType
	 *            the actualSceneType to set
	 */
	public Scene setActualSceneType(SceneType actualSceneType) {
		this.actualSceneType = actualSceneType;
		Scene actualScene = getActualScene();
		if (actualScene != null) {
			getModel().getMainActivity().getEngine().setScene(actualScene);
		}
		return actualScene;
	}

	public SceneType getActualSceneType() {
		return actualSceneType;
	}

}
