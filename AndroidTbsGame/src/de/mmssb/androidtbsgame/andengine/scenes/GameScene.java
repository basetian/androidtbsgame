package de.mmssb.androidtbsgame.andengine.scenes;

import java.util.ArrayList;
import java.util.List;

import org.andengine.entity.scene.IOnSceneTouchListener;
import org.andengine.entity.scene.Scene;
import org.andengine.input.touch.TouchEvent;
import org.andengine.util.color.Color;

import de.mmssb.androidtbsgame.andengine.Model;
import de.mmssb.androidtbsgame.andengine.entities.board.Board;
import de.mmssb.androidtbsgame.andengine.entities.board.Mark;

/**
 * @author Manu
 * 
 */
public class GameScene extends ModelScene implements IOnSceneTouchListener {
	private Board board;

	/**
	 * Creates an instance of {@link GameScene}
	 * 
	 * @param model
	 *            {@link Model} reference
	 */
	public GameScene(Model model) {
		super(model);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.mmssb.aweproject.scenes.ModelScene#initialize()
	 */
	@Override
	public void initialize() {
		setOnSceneTouchListener(this);
	}

	private Mark testMark;

	/*
	 * XXX TEST
	 * 
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.andengine.entity.scene.IOnSceneTouchListener#onSceneTouchEvent(org
	 * .andengine.entity.scene.Scene, org.andengine.input.touch.TouchEvent)
	 */
	@Override
	public boolean onSceneTouchEvent(final Scene pScene,
			final TouchEvent pTouchEvent) {
		if (pTouchEvent.isActionUp()) {
			if (testMark != null) {
				testMark.detachSelf();
				testMark = null;
			}
		} else if (pTouchEvent.isActionDown()) {
			getModel().handleGameSceneSwipe(pTouchEvent.getX(),
					pTouchEvent.getY());
			int[] columnAndRow = board.getClickedColumnAndRow(
					pTouchEvent.getX(), pTouchEvent.getY());
			List<int[]> list = new ArrayList<int[]>();
			list.add(new int[] { columnAndRow[0], columnAndRow[1] });
			list.add(new int[] { columnAndRow[0] - 1, columnAndRow[1] });
			list.add(new int[] { columnAndRow[0] + 1, columnAndRow[1] });
			list.add(new int[] { columnAndRow[0], columnAndRow[1] - 1 });
			list.add(new int[] { columnAndRow[0] - 1, columnAndRow[1] - 1 });
			list.add(new int[] { columnAndRow[0] + 1, columnAndRow[1] - 1 });
			list.add(new int[] { columnAndRow[0], columnAndRow[1] + 1 });
			list.add(new int[] { columnAndRow[0] - 1, columnAndRow[1] + 1 });
			list.add(new int[] { columnAndRow[0] + 1, columnAndRow[1] + 1 });
			testMark = new Mark(getModel(), board, list, Color.RED, 0.6f,
					0.25f, 0.5f);
			board.attachChild(testMark);
		}
		return true;
	}

	public void setBoard(Board board) {
		if (board != null) {
			board.detachSelf();
		}
		this.board = board;
		attachChild(board);
	}

	public Board getBoard() {
		return board;
	}
}
