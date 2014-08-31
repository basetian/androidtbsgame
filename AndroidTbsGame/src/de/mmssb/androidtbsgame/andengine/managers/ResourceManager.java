package de.mmssb.androidtbsgame.andengine.managers;

import org.andengine.opengl.font.Font;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.util.color.Color;

import android.graphics.Typeface;
import de.mmssb.androidtbsgame.andengine.Model;

/**
 * @author Manu
 * 
 */
public class ResourceManager extends Manager {
	// -----------------------------------------------------
	// Image-Resources
	// -----------------------------------------------------
	private ITextureRegion textureRegionBoardBackground;
	private ITextureRegion textureRegionBoardForest;
	private ITextureRegion textureRegionBoardHill;
	private ITextureRegion textureRegionBoardRiver;
	private ITextureRegion textureRegionButtonSettings;
	private ITextureRegion textureRegionButtonMenu;
	private ITiledTextureRegion tiledTextureRegionButton;
	private ITiledTextureRegion tiledTextureRegionTestUnitMove;

	// -----------------------------------------------------
	// Font-Resources
	// -----------------------------------------------------
	private Font fontButton;

	/**
	 * Creates an instance of {@link ResourceManager}
	 * 
	 * @param getModel
	 *            () getModel() reference
	 */
	public ResourceManager(Model model) {
		super(model);
	}

	@Override
	public void load() {
		textureRegionBoardBackground = loadImageResource(1280, 720,
				"background.png");
		textureRegionBoardForest = loadImageResource(40, 40, "tree.png");
		textureRegionBoardHill = loadImageResource(40, 40, "mountain.png");
		textureRegionBoardRiver = loadImageResource(40, 40, "waves.png");
		textureRegionButtonSettings = loadImageResource(80, 80, "settings.png");
		textureRegionButtonMenu = loadImageResource(120, 80, "menu.png");
		tiledTextureRegionButton = loadTiledImageResource(371, 600,
				"button.png", 1, 3);
		tiledTextureRegionTestUnitMove = loadTiledImageResource(72, 128,
				"player.png", 3, 4);
		fontButton = loadFont((int) (512 * getModel().getMainActivity()
				.getSmoothCamera().getWidth() / 720), (int) (512 * getModel()
				.getMainActivity().getSmoothCamera().getHeight() / 1280),
				"arial", Typeface.BOLD, getModel().getMainActivity()
						.getSmoothCamera().getHeight() / 20);
	}

	/**
	 * Creates an image from asset path
	 * 
	 * @param atlasWidth
	 *            the image's width
	 * @param atlasHeight
	 *            the image's height
	 * @param textureName
	 *            target asset path
	 * @return {@link ITextureRegion}
	 */
	private ITextureRegion loadImageResource(int atlasWidth, int atlasHeight,
			String textureName) {
		BitmapTextureAtlas textureAtlas = new BitmapTextureAtlas(getModel()
				.getMainActivity().getEngine().getTextureManager(), atlasWidth,
				atlasHeight, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		ITextureRegion textureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(textureAtlas, getModel().getMainActivity(),
						textureName, 0, 0);
		textureAtlas.load();
		return textureRegion;
	}

	/**
	 * Creates a tiled image from asset path
	 * 
	 * @param atlasWidth
	 *            the image's width
	 * @param atlasHeight
	 *            the image's height
	 * @param textureName
	 *            target asset path
	 * @return {@link ITiledTextureRegion}
	 */
	private ITiledTextureRegion loadTiledImageResource(int atlasWidth,
			int atlasHeight, String textureName, int columns, int rows) {
		BitmapTextureAtlas textureAtlas = new BitmapTextureAtlas(getModel()
				.getMainActivity().getTextureManager(), atlasWidth,
				atlasHeight, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		ITiledTextureRegion tiledTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(textureAtlas, getModel()
						.getMainActivity().getAssets(), textureName, 0, 0,
						columns, rows);
		textureAtlas.load();
		return tiledTextureRegion;
	}

	/**
	 * Creates a {@link Font}
	 * 
	 * @param atlasWidth
	 *            the fonts maximal width
	 * @param atlasHeight
	 *            the fonts maximal height
	 * @param familyName
	 *            font family
	 * @param style
	 *            font style
	 * @param size
	 *            font size
	 * @return {@link Font}
	 */
	private Font loadFont(int atlasWidth, int atlasHeight, String familyName,
			int style, float size) {
		BitmapTextureAtlas textureAtlas = new BitmapTextureAtlas(getModel()
				.getMainActivity().getEngine().getTextureManager(), atlasWidth,
				atlasHeight, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		Font font = new Font(getModel().getMainActivity().getEngine()
				.getFontManager(), textureAtlas, Typeface.create(familyName,
				style), size, true, Color.WHITE);
		getModel().getMainActivity().getEngine().getTextureManager()
				.loadTexture(textureAtlas);
		getModel().getMainActivity().getEngine().getFontManager()
				.loadFont(font);
		return font;
	}

	public ITextureRegion getTextureRegionBoardBackground() {
		return textureRegionBoardBackground;
	}

	public ITextureRegion getTextureRegionBoardForest() {
		return textureRegionBoardForest;
	}

	public ITextureRegion getTextureRegionBoardHill() {
		return textureRegionBoardHill;
	}

	public ITextureRegion getTextureRegionBoardRiver() {
		return textureRegionBoardRiver;
	}

	public ITextureRegion getTextureRegionButtonSettings() {
		return textureRegionButtonSettings;
	}

	public ITextureRegion getTextureRegionButtonMenu() {
		return textureRegionButtonMenu;
	}

	public ITiledTextureRegion getTiledTextureRegionButton() {
		return tiledTextureRegionButton;
	}

	public ITiledTextureRegion getTiledTextureRegionTestUnitMove() {
		return tiledTextureRegionTestUnitMove;
	}

	public Font getFontButton() {
		return fontButton;
	}

}
