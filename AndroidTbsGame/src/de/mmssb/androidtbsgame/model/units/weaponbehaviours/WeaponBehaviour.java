package de.mmssb.androidtbsgame.model.units.weaponbehaviours;

public interface WeaponBehaviour {

	public int attack(int armamentStrength);

	public int getMaxAttackRange();

	public int getCostsOfAttacking();
	
}
