package de.cogsys.ai.game;

import java.util.List;


/**
 * Class for implementing a MiniMax Agent.
 */
public class MiniMaxAgent<M> implements Agent<M> {

	@Override
	public M computeMove(final Game<M> game) {

	    List<M> moves     = game.generateValidMoves();
	    M      best       = null;
	    double best_value = Double.NEGATIVE_INFINITY;

	    for (M m : moves) {
	        final double value = min_value(game.performMove(m));
	        if (value > best_value) {
	            best_value = value;
	            best = m;
	        }
	    }

		return best;
	}
	
	
	public double max_value(final Game<M> game) {
	    if (game.ends()) {
	    	return game.evaluate();            
	    }
	    double v = Double.NEGATIVE_INFINITY;
        List<M> moves = game.generateValidMoves();

        for (M m : moves) {
            final double value = min_value(game.performMove(m));
            if (value > v) {
                v = value;
            }
        }
        return v;
    
	}
	
	public double min_value(final Game<M> game) {
	    if (game.ends()) {
	    	// we need to be sure to evaluate from the perspective of the MiniMax Agent
	    	return -game.evaluate();            
	    }
	    double v = Double.POSITIVE_INFINITY;
        List<M> moves = game.generateValidMoves();

        for (M m : moves) {
            final double value = max_value(game.performMove(m));
            if (value < v) {
                v = value;
            }
        }
	    return v;
	}
	
	
	
}