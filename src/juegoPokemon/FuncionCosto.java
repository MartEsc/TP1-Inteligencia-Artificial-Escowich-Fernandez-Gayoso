package juegoPokemon;

import frsf.cidisi.faia.solver.search.IStepCostFunction;
import frsf.cidisi.faia.solver.search.NTree;
import frsf.cidisi.faia.state.AgentState;

public class FuncionCosto implements IStepCostFunction{

	public double calculateCost(AgentState estado) {
		return ((PokemonAgentState) estado).getCosto();
	}
	
	@Override
	public double calculateCost(NTree node) {
		// TODO Auto-generated method stub
		return 0;
	}

}
