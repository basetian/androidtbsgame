package de.mmssb.androidtbsgame.andengine.managers;

import de.mmssb.androidtbsgame.andengine.Model;

/**
 * @author Manu
 * 
 */
public abstract class Manager {
	private Model model;

	public Manager(Model model) {
		this.setModel(model);
		load();
	}

	public abstract void load();

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}
}
