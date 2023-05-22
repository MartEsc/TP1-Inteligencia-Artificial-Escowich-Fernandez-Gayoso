package juegoPokemon.accionnes;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import juegoPokemon.PokemonAgentState;
import juegoPokemon.PokemonEnvironmentState;

public class usarPoder1 extends SearchAction{

	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		// TODO Auto-generated method stub
		PokemonAgentState estado = (PokemonAgentState) s;
		if(estado.isPoder1Disponible() && estado.getContadorPoder1()>=3) {
		//	System.out.println("Usando poder 1");
			estado.setEnergiaDisponible(estado.getEnergiaDisponible()*1.2f);
			estado.setContadorPoder1(0);
			return estado;
		}
		return null;
	}

	@Override
	public Double getCost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EnvironmentState execute(AgentState ast, EnvironmentState est) {
		// TODO Auto-generated method stub
		PokemonAgentState estado = (PokemonAgentState) ast;
		PokemonEnvironmentState ambiente = (PokemonEnvironmentState) est;
		if(estado.isPoder1Disponible() && estado.getContadorPoder1()>=3) {
			estado.setEnergiaDisponible(estado.getEnergiaDisponible()*1.2f);
			ambiente.setEnergiaAgente(ambiente.getEnergiaAgente()*1.2f);
			estado.setContadorPoder1(0);
			return ambiente;
		}
		return null;
	}

	@Override
	public String toString() {
		return "evolucion1\n";
	}
	
}
