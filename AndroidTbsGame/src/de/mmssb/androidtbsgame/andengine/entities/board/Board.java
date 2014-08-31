package de.mmssb.androidtbsgame.andengine.entities.board;

import org.andengine.entity.Entity;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.region.ITextureRegion;

import de.mmssb.androidtbsgame.andengine.Model;
import de.mmssb.androidtbsgame.andengine.entities.board.Cell.CellType;

/**
 * @author Manu
 * 
 */
public class Board extends Entity {
	public static final float DEFAULT_CELL_BOUNDS_FACTOR = 0.05f;
	private Model model;
	private float cellWidth;
	private float cellHeight;

	/**
	 * Creates an instance of {@link Board}
	 * 
	 * @param columns
	 *            the board's column count
	 * @param rows
	 *            the board's row count
	 * @param cellWidth
	 *            each cell's width
	 * @param cellHeight
	 *            each cell's height
	 * @param cellControl
	 *            .getCells() {@link Cell} - array
	 */
	public Board(Model model, int columns, int rows, float cellWidth,
			float cellHeight) {
		this.model = model;
		this.cellWidth = cellWidth;
		this.cellHeight = cellHeight;
		initialize(model.getCellControl().getCells());
	}

	/**
	 * Initializes the board
	 */
	private void initialize(Cell[][] cells) {
		initializeBackgroundSprite();
		initializeCellSprites(cells);
		model.limitCameraBoundsToBoard(this);
	}

	/**
	 * Resets the board using another base-array
	 * 
	 * @param cells
	 *            {@link Cell} - array
	 */
	public void reset(Cell[][] cells) {
		reset(cells);
	}

	/**
	 * Puts a Sprite on the first Layer to simulate a background
	 */
	private void initializeBackgroundSprite() {
		Sprite backgroundSprite = new Sprite(0, 0, model.getResourceManager()
				.getTextureRegionBoardBackground(), model.getMainActivity()
				.getVertexBufferObjectManager());
		backgroundSprite.setWidth(model.getCellControl().getColumns()
				* cellWidth);
		backgroundSprite.setHeight(model.getCellControl().getRows()
				* cellHeight);
		attachChild(backgroundSprite);
	}

	/**
	 * Draws Sprites if a Cell has another {@link CellType} than CellType.PLAIN
	 * 
	 * @param cells
	 *            {@link Cell} - array
	 */
	private void initializeCellSprites(Cell[][] cells) {
		for (int column = 0; column < model.getCellControl().getColumns(); column++) {
			for (int row = 0; row < model.getCellControl().getRows(); row++) {
				createCellSpriteIfNeccessary(column, row, cells[column][row]);
			}
		}
	}

	/**
	 * If cell has another CellType than CellType.PLAIN, a Sprite is attached at
	 * the Cells location
	 * 
	 * @param column
	 *            the cell's column
	 * @param row
	 *            the cell's row
	 * @param cell
	 */
	private void createCellSpriteIfNeccessary(int column, int row, Cell cell) {
		ITextureRegion textureRegion = getTextureRegionFromCellType(cell
				.getCellType());
		if (textureRegion != null) {
			Sprite cellSprite = new Sprite(column * cellWidth,
					row * cellHeight, textureRegion, model.getMainActivity()
							.getVertexBufferObjectManager());
			cellSprite.setWidth(cellWidth);
			cellSprite.setHeight(cellHeight);
			attachChild(cellSprite);
		}
	}

	/**
	 * @param cellType
	 *            {@link CellType}
	 * @return {@link ITextureRegion}
	 */
	private ITextureRegion getTextureRegionFromCellType(CellType cellType) {
		switch (cellType) {
		case FOREST:
			return model.getResourceManager().getTextureRegionBoardForest();
		case MOUNTAIN:
			return model.getResourceManager().getTextureRegionBoardHill();
		case RIVER:
			return model.getResourceManager().getTextureRegionBoardRiver();
		default:
			return null;
		}
	}

	/**
	 * Calculates a cells start-coordinates
	 * 
	 * @param column
	 *            target cell's column;
	 * @param row
	 *            target cell's row;
	 * @return
	 */
	public float[] getCellStartCoordinates(int column, int row) {
		return new float[] { column * cellWidth, row * cellHeight };
	}

	/**
	 * Finds a {@link Cell} per click coordinates
	 * 
	 * @param pX
	 *            click x location on the {@link Board}
	 * @param pY
	 *            click y location on the {@link Board}
	 * @return clicked {@link Cell}
	 */
	public int[] getClickedColumnAndRow(float pX, float pY) {
		for (int column = 0; column < model.getCellControl().getColumns(); column++) {
			for (int row = 0; row < model.getCellControl().getRows(); row++) {
				if (pX >= column * cellWidth
						&& pX < cellWidth + column * cellWidth
						&& pY >= row * cellHeight
						&& pY < cellHeight + row * cellHeight) {
					return new int[] { column, row };
				}
			}
		}
		return null;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public float getCellWidth() {
		return cellWidth;
	}

	public void setCellWidth(float cellWidth) {
		this.cellWidth = cellWidth;
	}

	public float getCellHeight() {
		return cellHeight;
	}

	public void setCellHeight(float cellHeight) {
		this.cellHeight = cellHeight;
	}

	public float getWidth() {
		return model.getCellControl().getColumns() * cellWidth;
	}

	public float getHeight() {
		return model.getCellControl().getRows() * cellHeight;
	}
}
