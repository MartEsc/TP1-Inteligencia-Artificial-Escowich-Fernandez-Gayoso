package juegoPokemon;

import frsf.cidisi.faia.agent.search.GoalTest;
import frsf.cidisi.faia.state.AgentState;

public class ObjetivoPokemonAgent extends GoalTest{

	@Override
	public boolean isGoalState(AgentState agentState) {
		// TODO Auto-generated method stub
		PokemonAgentState estado = (PokemonAgentState) agentState;
		if(estado.isBossDerrotado() ) {
			//System.out.println("Boss derrotado");
			return true;
		}
		return false;
	}
}