package de.mmssb.androidtbsgame.andengine;

import de.mmssb.androidtbsgame.andengine.entities.board.Board;
import de.mmssb.androidtbsgame.andengine.managers.SharedPreferencesManager;

/**
 * Holds Data for all cells, which are shown on a {@link Board}
 * 
 * @author Manu
 * 
 */
public class BoardMap implements Comparable<BoardMap> {
	private int columns;
	private int rows;
	private String boardString;

	/**
	 * @param raw
	 *            string from {@link SharedPreferencesManager}
	 */
	public BoardMap(String raw) {
		this.columns = Integer.valueOf(raw.substring(raw.indexOf('[') + 1,
				raw.indexOf('/')));
		this.rows = Integer.valueOf(raw.substring(raw.indexOf('/') + 1,
				raw.indexOf(']')));
		this.boardString = raw.substring(raw.indexOf(']') + 1);
	}

	public int getColumns() {
		return columns;
	}

	public int getRows() {
		return rows;
	}

	public String getBoardString() {
		return boardString;
	}

	@Override
	public String toString() {
		return "[" + columns + "/" + rows + "]" + boardString;
	}

	@Override
	public int compareTo(BoardMap another) {
		return this.getColumns() * this.getRows() - another.getColumns()
				* another.getRows();
	}
}
