package tpIA.acciones;

import java.util.Random;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import tpIA.PokemonAgentState;
import tpIA.PokemonEnvironmentState;

public class recargarEnergia extends SearchAction{
	Integer energiaPokebola = new Random().nextInt(5, 10);
	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		// TODO Auto-generated method stub
		PokemonAgentState estado = (PokemonAgentState) s;
		if(estado.getUbicacionActual().getHayPokebola() && !estado.getUbicacionActual().isPokebolaTomada()) {
			//System.out.println("Recargando energia...");
			estado.setEnergiaDisponible(estado.getEnergiaDisponible()+energiaPokebola);
			estado.setEnergiaGanada(estado.getEnergiaGanada()+energiaPokebola);
			estado.getUbicacionActual().setPokebolaTomada(true);
			//estado.setBossDerrotado(true);
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
		if(ambiente.getAgentPosition().getHayPokebola() && !ambiente.getAgentPosition().isPokebolaTomada()) {
			estado.setEnergiaDisponible(estado.getEnergiaDisponible()+energiaPokebola);
			estado.setEnergiaGanada(estado.getEnergiaGanada()+energiaPokebola);
			estado.getUbicacionActual().setPokebolaTomada(true);
			ambiente.setEnergiaPokemon(ambiente.getEnergiaPokemon()+energiaPokebola);
			ambiente.getAgentPosition().setPokebolaTomada(true);
			//estado.setBossDerrotado(false);
			//ambiente.setBossDerrotado(false);
			return ambiente;
		}
		return null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub 
		return "recargando energia";
	}

}
