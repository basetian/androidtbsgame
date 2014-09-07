package de.mmssb.androidtbsgame.model.players;

import de.mmssb.androidtbsgame.model.gamegrid.Coordinate;

public interface Player {

	public String getName();

	public PlayerColor getColor();

	public Coordinate getStartingPosition();

	public int getBudget();

}
