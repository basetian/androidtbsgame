package de.mmssb.androidtbsgame.model.units.movementbehaviours;

import de.mmssb.androidtbsgame.model.scenery.SceneryTile;

public interface MovementBehaviour {

	public void moveTo(SceneryTile tile);
	
	public int getMaxMovementRange();

	public int getCostsOfMoving();
	
}
