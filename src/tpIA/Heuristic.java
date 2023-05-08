package tpIA;

import frsf.cidisi.faia.solver.search.IEstimatedCostFunction;
import frsf.cidisi.faia.solver.search.NTree;

public class Heuristic implements IEstimatedCostFunction{

	@Override
	public double getEstimatedCost(NTree node) {
		// TODO Auto-generated method stub
		PokemonAgentState agState = (PokemonAgentState) node.getAgentState();
		double nodos = agState.getMapaMundiHeroe().getListaNodos().size();
		return nodos;
	}

}
