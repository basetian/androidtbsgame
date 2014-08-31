package de.mmssb.androidtbsgame.andengine.managers;

import de.mmssb.androidtbsgame.andengine.BoardMap;
import de.mmssb.androidtbsgame.andengine.entities.board.Cell;
import de.mmssb.androidtbsgame.andengine.entities.board.Cell.CellType;

/**
 * @author Manu
 * 
 */
public class CellControl {
	private Cell[][] cells;
	private int columns;
	private int rows;

	/**
	 * Creates an instance of {@link CellManager}
	 * 
	 * @param columns
	 *            column count
	 * @param row
	 *            count
	 */
	public CellControl(BoardMap boardMap) {
		this.columns = boardMap.getColumns();
		this.rows = boardMap.getRows();
		this.setCells(createCellArray(convertStringToCellTypeArray(boardMap
				.getBoardString())));
	}

	/**
	 * Converts a String to an array of CellTypes
	 * 
	 * @param baseString
	 *            String-pattern for creating an array of cells
	 * @return {@link CellType} - array
	 */
	private CellType[][] convertStringToCellTypeArray(String baseString) {
		CellType[][] cellTypes = new CellType[columns][rows];
		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				cellTypes[column][row] = convertCharToCellType(baseString
						.charAt(row * columns + column));
			}
		}
		return cellTypes;
	}

	/**
	 * Converts a char to a {@link CellType}
	 * 
	 * @param character
	 *            base-char
	 * @return {@link CellType}
	 */
	private CellType convertCharToCellType(char character) {
		switch (character) {
		case 'P':
			return CellType.PLAIN;
		case 'F':
			return CellType.FOREST;
		case 'M':
			return CellType.MOUNTAIN;
		case 'R':
			return CellType.RIVER;
		default:
			return null;
		}
	}

	private Cell[][] createCellArray(CellType[][] cellTypes) {
		Cell[][] cells = new Cell[columns][rows];
		for (int column = 0; column < columns; column++) {
			for (int row = 0; row < rows; row++) {
				cells[column][row] = new Cell(cellTypes[column][row]);
			}
		}
		return cells;
	}

	public Cell[][] getCells() {
		return cells;
	}

	public void setCells(Cell[][] cells) {
		this.cells = cells;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}
}
