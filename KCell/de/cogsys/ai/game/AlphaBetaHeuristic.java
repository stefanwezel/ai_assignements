package de.cogsys.ai.game;


public interface AlphaBetaHeuristic<M> {
	/**
	 * Should the search be cut off, i.e. not be continued in the current branch
	 * @param game A state
	 * @param depth The current depth in the tree
	 * @return <b>true</b>, if the searchtree should be cut off
	 */
	boolean cutoff(final Game<M> game, final int depth);
	
	/**
	 * Assign a score to the given state.
	 * @note The result must be in the range [-1,1]
	 * @param game a state
	 * @return a value between [-1, 1], -1 is complete loss, +1 victory
	 */
	double eval(final Game<M> game);
}
