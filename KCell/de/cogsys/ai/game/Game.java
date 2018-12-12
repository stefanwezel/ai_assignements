package de.cogsys.ai.game;

import java.util.List;

/**
 * 
 * @param <M> The generic parameter determining the type of moves in the game
 */
public abstract class Game<M> {
	
	public static final int DRAW = -1;
	public static final int PLAYER1 = 0;
	public static final int PLAYER2 = 1;
	
	/**
	 * Generate a string representation of the current game state.
	 */
	public abstract String computeStringRepresentation();
	
	/**
	 * Evaluate the current game state. Should be symmetric,
	 * i.e. evaluate(P1) = - evaluate(P2)
	 */
	public abstract double evaluate();
	
	/**
	 * Returns the player whose turn it currently is.
	 */
	public abstract int getCurrentPlayer();
	
	/**
	 * Returns the currently inactive player.
	 */
	public abstract int getOtherPlayer();
	
	/**
	 * Returns whether the given player wins the game.
	 */
	public abstract boolean wins(final int player);
	
	/**
	 * Checks whether the game is over, i.e. whether either player wins or no more moves are possible.
	 */
	public abstract boolean ends();
	
	/**
	 * Checks whether the given move is valid for the current player.
	 * Note that an empty move may also be valid.
	 */
	public abstract boolean isValidMove(final M move);
	
	/**
	 * Generates a list of all valid moves for the current player in the current game state.
	 */
	public abstract List<M> generateValidMoves();
	
	/**
	 * Performs the given move for the current player
	 * @return a Game Object with the new state as a copy of the original Game object
	 */
	public abstract Game<M> performMove(final M move);
	
	/**
	 * This method implements a minimal version of the game-loop, alternately running 
	 * the player agents and updating the game state.
	 * @return the number of the player who has won the game or the constant DRAW
	 */
	public static <M,S> int play(
		final Game<M> game,
		final Agent<M> player1,
		final Agent<M> player2
	) {
		Game<M> g = game;

		while (!g.ends()) {

	        System.out.println("P" + (g.getCurrentPlayer() + 1) + ": " + g.computeStringRepresentation());
		    
			M move;
			if (g.getCurrentPlayer() == Game.PLAYER1) {
				move = player1.computeMove(g);
			} else {
				move = player2.computeMove(g);
			}
			
			if (!g.isValidMove(move)) {
				throw new RuntimeException("Invalid move");
			}

			g = g.performMove(move);
		}

		System.out.println();
		System.out.println(g.computeStringRepresentation());
		
		if (g.wins(Game.PLAYER1)) {
		    System.out.println("Player1 wins.");
		    return Game.PLAYER1; 
		} else if (g.wins(Game.PLAYER2)) {
		    System.out.println("Player2 wins.");
		    return Game.PLAYER2; 
	    } else {
	        System.out.println("Draw.");
	        return DRAW;
	    }
	}
	
}