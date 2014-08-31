package de.mmssb.androidtbsgame.andengine;

import de.mmssb.androidtbsgame.andengine.entities.board.Board;

/**
 * @author Manu
 * 
 */
public class GameControl {
	private Model model;
	private int playerCount;

	/**
	 * Creates an instance of {@link GameControl}
	 * 
	 * @param model
	 *            {@link Model} - reference
	 * @param playerCount
	 */
	public GameControl(Model model, int playerCount) {
		this.model = model;
		float cellSideLength = model.getMainActivity().getSmoothCamera()
				.getWidth()
				* Board.DEFAULT_CELL_BOUNDS_FACTOR;
		model.getSceneManager()
				.getGameScene()
				.setBoard(
						new Board(model, model.getCellControl().getColumns(),
								model.getCellControl().getRows(),
								cellSideLength, cellSideLength));
	}

	public int getPlayerCount() {
		return playerCount;
	}

	public void setPlayerCount(int playerCount) {
		this.playerCount = playerCount;
	}
}
