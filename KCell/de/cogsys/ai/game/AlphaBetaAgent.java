package de.cogsys.ai.game;

import java.util.List;



public class AlphaBetaAgent<M> implements Agent<M> {

	private AlphaBetaHeuristic<M> heuristic;
	
	public AlphaBetaAgent(AlphaBetaHeuristic<M> heuristic) {
		this.heuristic = heuristic;
	}

	public AlphaBetaAgent() {
		this(null);
	}
	
	@Override
	public M computeMove(final Game<M> game) {	
	    // TODO: Implement minimax search with alpha-beta-pruning here
	    //       Below you can see an example how to use the game class.
		//       Instead of returning the first possible move you have to implement
		//       the algorithm!
		//
	    //       Please check whether there is a valid heuristic given. In the
	    //       case this.heuristic is null, then there is no heuristic, i.e., no
		//       cut-off test.
		//
	    //       You can also look at the provided MiniMax implementation to get the 
		//       basic structure of the algorithm
		//
		
		//
		// list possible moves.
		//
		final List<M> moves = game.generateValidMoves();
	    
		//
		// Performs the ith move and switches the player.
		//
		// Game<M> newgame = game.performMove(moves.get(i);
		//
		// ...
		//
	    

	    
	    
	    return moves.get(0);
	}
	
}