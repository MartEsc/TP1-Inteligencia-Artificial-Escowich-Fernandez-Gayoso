package tpIA;

import frsf.cidisi.faia.agent.search.GoalTest;
import frsf.cidisi.faia.state.AgentState;

public class ObjetivoPokemonAgent extends GoalTest{

	@Override
	public boolean isGoalState(AgentState agentState) {
		// TODO Auto-generated method stub
		PokemonAgentState estado = (PokemonAgentState) agentState;
		
		if(estado.getDerrotados().size()==23 ) {
			for (enemigoGenerico e : estado.getDerrotados()){
				if(e.getIdentificador()==26) {
					return true;
				}
			}
			return false;
		}
		else
			return false;
	}
	
}
