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
	Integer energiaPokebola = new Random().nextInt(5, 10);
	
	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		// TODO Auto-generated method stub
		PokemonAgentState estado = (PokemonAgentState) s;
		System.out.println("a: "+ estado.getEnergiaDisponible());
		if(estado.getUbicacionActual().getHayPokebola() && !estado.getUbicacionActual().isPokebolaTomada()) {
			System.out.println("ENTRE Y SE DA QUE "+ estado.getUbicacionActual().getHayPokebola());
			System.out.println("energia extra:" + energiaPokebola);
			estado.setEnergiaDisponible(estado.getEnergiaDisponible() + energiaPokebola);
			estado.setEnergiaGanada(estado.getEnergiaGanada() + energiaPokebola);
			estado.getUbicacionActual().setPokebolaTomada(true);
			System.out.println("energia total dps de recarga: "+ estado.getEnergiaDisponible());
			System.out.println("RECARGANDO ENERGIA EN: " + estado.getUbicacionActual());
			return estado;
		}
		return null;
	}

	@Override
	public Double getCost() {
		// TODO Auto-generated method stub
		return 1.0;
	}

	@Override
	public EnvironmentState execute(AgentState ast, EnvironmentState est) {
		// TODO Auto-generated method stub
		PokemonAgentState estado = (PokemonAgentState) ast;
		PokemonEnvironmentState ambiente = (PokemonEnvironmentState) est;
		if(estado.getUbicacionActual().getHayPokebola() && !estado.getUbicacionActual().isPokebolaTomada()) {
			estado.setEnergiaDisponible(estado.getEnergiaDisponible() + energiaPokebola);
			estado.setEnergiaGanada(estado.getEnergiaGanada() + energiaPokebola);
			ambiente.setEnergiaPokemon(ambiente.getEnergiaPokemon()+ energiaPokebola);
			ambiente.getAgentPosition().setPokebolaTomada(true);
			System.out.println("ME MUEVO A " + estado.getUbicacionActual());
			return ambiente;
		}
		return null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Recargando energia con Pokebola";
	}

}
