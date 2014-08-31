package de.mmssb.androidtbsgame.andengine.scenes;

import org.andengine.entity.scene.Scene;

import de.mmssb.androidtbsgame.andengine.Model;

/**
 * @author Manu
 * 
 */
public abstract class ModelScene extends Scene {
	private Model model;

	/**
	 * Creates an instance of the {@link ModelScene} subclass
	 * 
	 * @param model
	 *            {@link Model} reference
	 */
	public ModelScene(Model model) {
		this.model = model;
		initialize();
	}

	/**
	 * Initializes the {@link ModelScene} subclass
	 */
	public abstract void initialize();

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}
}
