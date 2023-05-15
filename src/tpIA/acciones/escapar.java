package tpIA.acciones;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import tpIA.PokemonAgentState;
import tpIA.PokemonEnvironmentState;
import tpIA.enemigoGenerico;

public class escapar extends SearchAction{
	float vida= 0f;
	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		// TODO Auto-generated method stub
		PokemonAgentState estado = (PokemonAgentState) s;
		if(!estado.getUbicacionActual().getHayPokebola()) {
			enemigoGenerico enemigo = estado.getUbicacionActual().getOcupante();
			if(estado.getEnergiaDisponible() < enemigo.getEnergia() && !enemigo.getDefeated()) {
				//System.out.println("Enemigo fuerte, escapando...");
				estado.setEnergiaDisponible(estado.getEnergiaDisponible()-estado.getEnergiaDisponible()/4);
				vida = estado.getEnergiaDisponible();
				estado.setNoPelea(true);
				//estado.setBossDerrotado(true);
				return estado;
			}
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
		if(!ambiente.getAgentPosition().getHayPokebola()) {
			enemigoGenerico enemigo = estado.getUbicacionActual().getOcupante();
			if(ambiente.getEnergiaPokemon() < enemigo.getEnergia() && !enemigo.getDefeated()) {
				System.out.println("Enemigo fuerte, escapando...");
				estado.setEnergiaDisponible(estado.getEnergiaDisponible()-estado.getEnergiaDisponible()/4);
				estado.setNoPelea(true);
				vida = estado.getEnergiaDisponible();
				ambiente.setEnergiaPokemon(ambiente.getEnergiaPokemon()-estado.getEnergiaDisponible()/4);
				//estado.setBossDerrotado(false);
				//ambiente.setBossDerrotado(false);
				return ambiente;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str ="escapando " + vida;
		return str;
	}

}
