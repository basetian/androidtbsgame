package de.mmssb.androidtbsgame.andengine.entities.board;

import java.util.LinkedList;
import java.util.List;

import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.entity.Entity;
import org.andengine.entity.IEntity;
import org.andengine.entity.modifier.AlphaModifier;
import org.andengine.entity.modifier.DelayModifier;
import org.andengine.entity.modifier.IEntityModifier.IEntityModifierListener;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.util.color.Color;
import org.andengine.util.modifier.IModifier;

import de.mmssb.androidtbsgame.andengine.Model;

/**
 * @author Manu
 * 
 */
public class Mark extends Entity {
	private Model model;
	private List<Rectangle> markRectangles;
	private Board board;
	private List<int[]> markedCells;
	private Color markColor;
	private float maxAlpha;
	private float minAlpha;
	private float blinkDuration;

	/**
	 * Creates an instance of {@link Mark}
	 * 
	 * @param model
	 *            {@link Model} reference
	 * @param board
	 *            {@link Board} which will be the {@link Mark}'s parent
	 * @param cellsToMark
	 *            List, which contains the coordinates {column;row} which have
	 *            to be marked
	 * @param markColor
	 *            the mark's color
	 * @param alpha
	 *            the mark's alpha
	 */
	public Mark(Model model, Board board, List<int[]> cellsToMark,
			Color markColor, float alpha, float minAlpha, float blinkDuration) {
		this.model = model;
		this.board = board;
		this.markedCells = cellsToMark;
		this.markColor = markColor;
		this.maxAlpha = alpha;
		this.minAlpha = minAlpha;
		this.blinkDuration = blinkDuration;
		initialize();
	}

	/**
	 * Initializes the {@link Mark}
	 */
	private void initialize() {
		markRectangles = new LinkedList<Rectangle>();
		for (int[] cellCoordinates : markedCells) {
			markCell(cellCoordinates);
		}
		registerEntityModifier(getUpdateHandler());
	}

	/**
	 * Creates the UpdateHandler to create a blink effect
	 * 
	 * @return {@link IUpdateHandler} to register
	 */
	private DelayModifier getUpdateHandler() {
		return new DelayModifier(blinkDuration, new IEntityModifierListener() {

			@Override
			public void onModifierStarted(IModifier<IEntity> pModifier,
					IEntity pItem) {
				for (Rectangle markRectangle : markRectangles) {
					markRectangle.registerEntityModifier(new AlphaModifier(
							blinkDuration, markRectangle.getAlpha(),
							markRectangle.getAlpha() > minAlpha ? minAlpha
									: maxAlpha));
				}
			}

			@Override
			public void onModifierFinished(IModifier<IEntity> pModifier,
					IEntity pItem) {
				registerEntityModifier(getUpdateHandler());
			}
		});
	}

	/**
	 * Attaches a {@link Rectangle} at the cells location to the {@link Mark}
	 * 
	 * @param cellCoordinates
	 *            the cell's location {column;row}
	 */
	private void markCell(int[] cellCoordinates) {
		float pX = board.getCellWidth() * cellCoordinates[0];
		float pY = board.getCellHeight() * cellCoordinates[1];
		float paddingX = board.getCellWidth() * 0.05f;
		float paddingY = board.getCellHeight() * 0.05f;
		Rectangle markRectangle = new Rectangle(pX + paddingX, pY + paddingY,
				board.getCellWidth() - 2 * paddingX, board.getCellHeight() - 2
						* paddingY, model.getMainActivity()
						.getVertexBufferObjectManager());
		markRectangle.setColor(markColor);
		markRectangle.setAlpha(maxAlpha);
		markRectangles.add(markRectangle);
		attachChild(markRectangle);
	}
}
