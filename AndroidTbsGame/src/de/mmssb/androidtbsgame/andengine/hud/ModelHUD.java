package de.mmssb.androidtbsgame.andengine.hud;

import org.andengine.engine.camera.hud.HUD;

import de.mmssb.androidtbsgame.andengine.Model;

/**
 * @author Manu
 * 
 */
public class ModelHUD extends HUD {
	private Model model;

	/**
	 * Creates an instance of {@link ModelHUD}
	 * 
	 * @param model
	 *            {@link Model} reference
	 */
	public ModelHUD(Model model) {
		this.setModel(model);
		initialize();
	}

	/**
	 * Initialize the {@link ModelHUD}
	 */
	private void initialize() {
		// Adds two test-buttons to the HUD
		ImageButtonSprite buttonSettings = new ImageButtonSprite(0, 0, model
				.getMainActivity().getSmoothCamera().getWidth() * 0.2f, model
				.getMainActivity().getSmoothCamera().getHeight() * 0.2f, model
				.getResourceManager().getTiledTextureRegionButton(), model
				.getResourceManager().getTextureRegionButtonSettings(), this,
				model.getMainActivity().getVertexBufferObjectManager());
		attachChild(buttonSettings);
		ImageButtonSprite buttonMenu = new ImageButtonSprite(0,
				buttonSettings.getHeight(), model.getMainActivity()
						.getSmoothCamera().getWidth() * 0.2f,
				model.getMainActivity().getSmoothCamera().getHeight() * 0.2f,
				model.getResourceManager().getTiledTextureRegionButton(), model
						.getResourceManager().getTextureRegionButtonMenu(),
				this, model.getMainActivity().getVertexBufferObjectManager());
		attachChild(buttonMenu);
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}
}
