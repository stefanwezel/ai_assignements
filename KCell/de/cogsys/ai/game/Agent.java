package de.cogsys.ai.game;

/**
 * This interface contains methods that every Agent needs to implement
 */
public interface Agent<M> {
	
	/**
	 * compute a valid move based on the current game state
	 */
	public M computeMove(final Game<M> game);

}