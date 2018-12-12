package de.cogsys.ai.kcell;

import java.util.Random;

import de.cogsys.ai.game.AlphaBetaHeuristic;
import de.cogsys.ai.game.Game;

/**
 * This is a random heuristic as a classic example.
 */
public class RandomKCellHeuristic implements AlphaBetaHeuristic<Integer> {
	final Random rand;

	public RandomKCellHeuristic() {
		this.rand = new Random(System.currentTimeMillis());
	}
	
	@Override	
	public boolean cutoff(final Game<Integer> game, final int depth) {
	    return depth > 0;
	}
	
	@Override
	public double eval(final Game<Integer> game) {
	    @SuppressWarnings("unused")
		KCell kcellgame = (KCell) game;
	    //
	    // One could now use some information from the game instance here....
	    // ...
	    //
	    return (this.rand.nextDouble() * 2.0) - 1.0;
	}
}
