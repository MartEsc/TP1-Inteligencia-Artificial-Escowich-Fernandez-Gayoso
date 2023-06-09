package juegoPokemon.accionnes;

import java.util.Random;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import juegoPokemon.PokemonAgentState;
import juegoPokemon.PokemonEnvironmentState;

public class tomarPokebolas extends SearchAction{
	int energiaPokebola = new Random().nextInt(5, 10);

	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		// TODO Auto-generated method stub
		PokemonAgentState estado = (PokemonAgentState) s;
//		System.out.println("Energia ganda inicial: "+ estado.getEnergiaGanada());
		if(estado.getUbicacionActual().isHayPokebola() && !estado.getUbicacionActual().isPokebolaTomada()) {
			estado.setEnergiaGanada(estado.getEnergiaGanada()+energiaPokebola);
		//	System.out.println("Energia ganada aumentada. Total: "+ estado.getEnergiaGanada());
			estado.setEnergiaDisponible(estado.getEnergiaDisponible()+energiaPokebola);
			estado.getUbicacionActual().setPokebolaTomada(true);
		//	System.out.println("Recargando energia: "+ energiaPokebola);
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
		if(estado.getUbicacionActual().isHayPokebola() && !estado.getUbicacionActual().isPokebolaTomada()) {
			estado.setEnergiaGanada(estado.getEnergiaGanada()+energiaPokebola);
			estado.setEnergiaDisponible(estado.getEnergiaDisponible()+energiaPokebola);
			ambiente.setEnergiaAgente(ambiente.getEnergiaAgente()+energiaPokebola);
			ambiente.getAgentPosition().setPokebolaTomada(true);
			estado.setUbicacionActual(ambiente.getAgentPosition());
			return ambiente;
		}
		return null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Tomando pokebola. Energia recargada: "+energiaPokebola;
	}

}
