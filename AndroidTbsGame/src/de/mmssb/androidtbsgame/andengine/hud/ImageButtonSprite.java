package de.mmssb.androidtbsgame.andengine.hud;

import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

/**
 * @author Manu
 */
public class ImageButtonSprite extends ButtonSprite {
	private float imageX;
	private float imageY;
	private Sprite buttonImage;
	private boolean selected;

	/**
	 * Creates an instance of {@link ImageButtonSprite}
	 * 
	 * @param pX
	 *            local x translation
	 * @param pY
	 *            local y translation
	 * @param width
	 *            ImageButtonSprite's width
	 * @param height
	 *            ImageButtonSprite's height
	 * @param pTiledTextureRegion
	 *            three tiled region used for: pressed, not pressed, disabled
	 * @param textureRegion
	 *            button icon
	 * @param parent
	 *            parent scene
	 * @param pVertexBufferObjectManager
	 *            {@link VertexBufferObjectManager} used to initialize the
	 *            sprites
	 */
	public ImageButtonSprite(float pX, float pY, float width, float height,
			ITiledTextureRegion pTiledTextureRegion,
			ITextureRegion textureRegion, Scene parent,
			VertexBufferObjectManager pVertexBufferObjectManager) {
		super(pX, pY, pTiledTextureRegion, pVertexBufferObjectManager);
		setWidth(width);
		setHeight(height);
		buttonImage = new Sprite(0, 0, textureRegion,
				pVertexBufferObjectManager);
		// Initialize bounds to fit every device
		float resizeFactor = this.getHeight() * 0.5f / buttonImage.getHeight();
		buttonImage.setWidth(buttonImage.getWidth() * resizeFactor);
		buttonImage.setHeight(buttonImage.getHeight() * resizeFactor);
		imageX = (this.getWidth() - buttonImage.getWidth()) / 2;
		imageY = (this.getHeight() - buttonImage.getHeight()) / 2;
		buttonImage.setPosition(imageX, imageY);
		this.attachChild(buttonImage);
		parent.registerTouchArea(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.andengine.entity.sprite.ButtonSprite#onAreaTouched(org.andengine.
	 * input.touch.TouchEvent, float, float)
	 */
	@Override
	public boolean onAreaTouched(TouchEvent pSceneTouchEvent,
			float pTouchAreaLocalX, float pTouchAreaLocalY) {
		if (pSceneTouchEvent.isActionDown()) {
			onSelected();
		} else if (pSceneTouchEvent.isActionUp()) {
			onUnselected();
		}
		return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX,
				pTouchAreaLocalY);
	}

	/**
	 * Visual reaction on selection
	 */
	public void onSelected() {
		selected = true;
		setCurrentTileIndex(1);
		if (this.buttonImage != null) {
			buttonImage.setX(imageX + 5);
			buttonImage.setY(imageY + 5);
		}
	}

	/**
	 * Visual reaction on unselect
	 */
	public void onUnselected() {
		selected = false;
		setCurrentTileIndex(0);
		if (this.buttonImage != null) {
			buttonImage.setX(imageX);
			buttonImage.setY(imageY);
		}
	}

	/**
	 * @return the selected
	 */
	public boolean isSelected() {
		return selected;
	}

	/**
	 * @param selected
	 *            the selected to set
	 */
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
}