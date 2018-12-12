package de.cogsys.ai.kcell;

import java.util.List;

import de.cogsys.ai.game.Agent;
import de.cogsys.ai.game.Game;
import de.cogsys.ai.game.MiniMaxAgent;

public class KCell extends Game<Integer> {
	
	// -1 should represent the passing move, which is only legal if there are no other moves
	public static final int EMPTY = -1; 

	public static void main(final String[] args) {
		//
		// TODO: (a) Run the game with 2 human/MiniMax players and 7 cells with 2 Stones 		
		//
		final Agent<Integer> player1 = new KCellHumanPlayer();
		//final Agent<Integer> player1 = new MiniMaxAgent<Integer,List<Integer>>();
		final Agent<Integer> player2 = new MiniMaxAgent<Integer>();
		//
		// TODO: (b) Run the game without heuristic and 7 cells with 2 Stones
		//
		//AlphaBetaAgent<Integer> player1 = new AlphaBetaAgent<Integer,List<Integer>>();
		//AlphaBetaAgent<Integer> player2 = new AlphaBetaAgent<Integer,List<Integer>>();
		//
		// TODO: (c) Run the game with heuristics and 15 cells with 3 Stones	
		//
		// AlphaBetaAgent<Integer> player1 = new AlphaBetaAgent<Integer,List<Integer>>([Your heuristic]);
		// AlphaBetaAgent<Integer> player2 = new AlphaBetaAgent<Integer,List<Integer>>(new RandomKCellHeuristic());
		//
		Game.play(
			new KCell(7, 2),
			player1,
            player2
		);
	}
	
	private final int size;
	private final int stones;
	
	// the current game state, an array of ints of size `size' indicating whose stone is at each position
	private int[] state;
	
	// the current player, 0 for player 1, 1 for player 2
	private int player;
	
	/**
	 * Constructor
	 */
	public KCell(final int size, final int stones) {
		this.size = size;
		this.stones = stones;
		this.state = state;
		//
		// TODO: implement me
		//
		for(int i = 0; i < size; i++){
			if(i < stones)
				state[i] == 0;
			if(i > (size - stones))
				state[i] == 1;
		}
	}

	/**
	 * Evaluates from the perspective of the current player.
	 * Will only be called after the game has ended:
	 *  1 - Current player wins
	 *  0 - Draw
	 * -1 - Other player wins
	 */
	@Override
	public double evaluate() {
		int[] state = getGameState();
		int counter = 0;
		for(int i = 0; i < state.length; i++) {
			if(state[i] != 1)
				break;
			counter++;
		}
		for(int i = state.length; i > 0; i--) {
			if(state[i] != 0)
				break;
			counter--;
		}
		if (counter > 0)
			return 1;

		if (counter < 0)
			return -1;

		return 0;
	}

	@Override
	public int getCurrentPlayer() {
		return player;
	}

	@Override
	public int getOtherPlayer() {
		return 1 - player;
	}

	@Override
	public boolean wins(final int player) {
		//
		// TODO: implement me
		//
		int[] state = getGameState();
		int counterplayer1 = 0;
		int counterplayer2 = 0;

		boolean player1finished = false;
		boolean player2finished = false;
		if (generateValidMoves() == null)
			return true;

		for (int i = 0; i < state.length; i++) {
			if(state[i] != 1)
				player2finished = true;
			if(!player2finished)AlphaBetaAgent
				counterplayer1++;
			if(state[state.length-1-i] != 0)
				player1finished = true;
			if(!player1finished)
				counterplayer2++;
			if(player1finished && player2finished)
				break;
		}

		if(counterplayer1 == stones)
			return true;
		if(counterplayer2 == stones)
			return  true;


		return false;
	}

	@Override
	public boolean ends() {
		//
		// TODO: implement me
		//
		return false;
	}

	@Override
	public boolean isValidMove(final Integer move) {
		//
		// TODO: implement me
		//
		return false;
	}
	
	@Override
	public List<Integer> generateValidMoves() {
		//
		// TODO: implement me
		//
		return null;
	}
	
	public int[] getGameState() {
		//
		// TODO: implement me
		//
		return null;
	}

	
	@Override
	public Game<Integer> performMove(final Integer move) {
		//
		// TODO: implement me
		//
		return null;
	}

	@Override
	public String computeStringRepresentation() {
		//
		// TODO: implement me
		//
		return "";
	}

}