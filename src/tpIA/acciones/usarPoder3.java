package tpIA.acciones;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import tpIA.PokemonAgentState;
import tpIA.PokemonEnvironmentState;

public class usarPoder3 extends SearchAction{
	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		// TODO Auto-generated method stub
		PokemonAgentState estado = (PokemonAgentState) s;
		if(estado.isPoder3Disponible()) {
			System.out.println("Poder 3 Desbloqueado...");
			estado.setEnergiaDisponible(estado.getEnergiaDisponible()*1.5f);
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
		if(estado.isPoder3Disponible()) {
			estado.setEnergiaDisponible(estado.getEnergiaDisponible()*1.5f);
			ambiente.setEnergiaPokemon(ambiente.getEnergiaPokemon()*1.5f);
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
