package juegoPokemon.accionnes;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import juegoPokemon.PokemonAgentState;
import juegoPokemon.PokemonEnvironmentState;

public class usarPoder2 extends SearchAction{
	double costo = 0.0;
	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		// TODO Auto-generated method stub
		PokemonAgentState estado = (PokemonAgentState) s;
		if(estado.isPoder2Disponible()  && estado.getContadorPoder2()>=3) {
			//System.out.println("Poder 2 Desbloqueado...");
			estado.setEnergiaDisponible(estado.getEnergiaDisponible()*1.3f);
			estado.setContadorPoder2(0);

			return estado;
		}
		return null;
	}

	@Override
	public Double getCost() {
		// TODO Auto-generated method stub
		return costo;
	}

	@Override
	public EnvironmentState execute(AgentState ast, EnvironmentState est) {
		// TODO Auto-generated method stub
		PokemonAgentState estado = (PokemonAgentState) ast;
		PokemonEnvironmentState ambiente = (PokemonEnvironmentState) est;
		if(estado.isPoder2Disponible() && estado.getContadorPoder2()>=3) {
			estado.setEnergiaDisponible(estado.getEnergiaDisponible()*1.3f);
			ambiente.setEnergiaAgente(ambiente.getEnergiaAgente()*1.3f);
			estado.setContadorPoder2(0);

			return ambiente;
		}
		return null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
}
