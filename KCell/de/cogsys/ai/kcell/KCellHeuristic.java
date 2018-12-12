package de.cogsys.ai.kcell;


import de.cogsys.ai.game.AlphaBetaHeuristic;
import de.cogsys.ai.game.Game;

public class KCellHeuristic implements AlphaBetaHeuristic<Integer> {
	@Override
	public boolean cutoff(Game<Integer> game, int depth) {
		//
		// implement me
		//
		return false;
	}
	@Override
	public double eval(Game<Integer> game) {
		//
		// implement me
		//		
		return 0;
	}
}
