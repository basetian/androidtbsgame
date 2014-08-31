package de.mmssb.androidtbsgame.andengine.units;

/**
 * @author Manu
 * 
 */
public class AnimationProperties {
	private long[] tileDuration;
	private int startTile;
	private int endTile;
	private boolean loop;

	/**
	 * Creates an instance of {@link AnimationProperties}
	 * 
	 * @param tileDuration
	 *            the duration for each tile
	 * @param startTile
	 *            first tile to show
	 * @param endTile
	 *            last tile to show
	 * @param loop
	 *            true = loop animation
	 */
	public AnimationProperties(long[] tileDuration, int startTile, int endTile,
			boolean loop) {
		this.tileDuration = tileDuration;
		this.startTile = startTile;
		this.endTile = endTile;
		this.loop = loop;
	}

	public long[] getTileDuration() {
		return tileDuration;
	}

	public void setTileDuration(long[] tileDuration) {
		this.tileDuration = tileDuration;
	}

	public int getStartTile() {
		return startTile;
	}

	public void setStartTile(int startTile) {
		this.startTile = startTile;
	}

	public int getEndTile() {
		return endTile;
	}

	public void setEndTile(int endTile) {
		this.endTile = endTile;
	}

	public boolean isLoop() {
		return loop;
	}

	public void setLoop(boolean loop) {
		this.loop = loop;
	}
}
