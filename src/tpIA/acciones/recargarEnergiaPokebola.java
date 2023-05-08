package tpIA.acciones;

import java.util.Random;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import tpIA.Nodo;
import tpIA.PokemonAgentState;
import tpIA.PokemonEnvironmentState;

public class recargarEnergiaPokebola extends SearchAction {

	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		// TODO Auto-generated method stub
		PokemonAgentState estado = (PokemonAgentState) s;
		if(estado.getUbicacionActual().getHayPokebola()) {
			estado.setEnergiaDisponible(estado.getEnergiaDisponible()+ new Random().nextInt(5, 10));
		}
		return estado;
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
		if(ambiente.getAgentPosition().getHayPokebola()) {
			estado.setEnergiaDisponible(estado.getEnergiaDisponible()+ new Random().nextInt(5, 10));
			for(Nodo nodo : ambiente.getListaNodos()) {
				if(nodo.equals(ambiente.getAgentPosition())) {
					nodo.setHayPokebola(false);			
				}
			}
		}
		return ambiente;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Recargando energia con Pokebola";
	}

}
