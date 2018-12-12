package de.cogsys.ai.kcell;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import de.cogsys.ai.game.Agent;
import de.cogsys.ai.game.Game;

/**
 * Implementation of a simple command-line interface for human players
 */
public class KCellHumanPlayer implements Agent<Integer> {

    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
	private int inputMove(final Game<Integer> game) {
        System.out.println(
            "Please enter your move Player" + 
            (game.getCurrentPlayer() + 1) + ":"
        );

        try {
            final int move = Integer.parseInt(in.readLine());
            return move - 1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}
	
	@Override
	public Integer computeMove(Game<Integer> game) {

		int move = KCell.EMPTY;

		while (!game.isValidMove(move)) {
			move = inputMove(game);
		}
			
		return move;
	}
	
}