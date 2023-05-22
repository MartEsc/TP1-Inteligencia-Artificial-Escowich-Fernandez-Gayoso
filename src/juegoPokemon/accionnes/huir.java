package juegoPokemon.accionnes;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import juegoPokemon.EnemigoGenerico;
import juegoPokemon.PokemonAgentState;
import juegoPokemon.PokemonEnvironmentState;

public class huir extends SearchAction{
	float vida= 0f;
	double costo = 0.0;
	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		// TODO Auto-generated method stub
		PokemonAgentState estado = (PokemonAgentState) s;
		if(!estado.getUbicacionActual().isHayPokebola()) {
			EnemigoGenerico enemigo = estado.getUbicacionActual().getOcupante();
			if(estado.getEnergiaDisponible() < enemigo.getEnergia() && !enemigo.isDefeated()) {
				//System.out.println("Enemigo fuerte, escapando...");
				estado.setEnergiaDisponible(estado.getEnergiaDisponible()-estado.getEnergiaDisponible()/4);
				vida = estado.getEnergiaDisponible();
				estado.setNoPelea(true);
				//estado.setBossDerrotado(true);
				//logAction();
				return estado;
			}
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
		if(!estado.getUbicacionActual().isHayPokebola()) {
			EnemigoGenerico enemigo = estado.getUbicacionActual().getOcupante();
			if(estado.getEnergiaDisponible() < enemigo.getEnergia() && !enemigo.isDefeated()) {
				//System.out.println("Enemigo fuerte, escapando...");
				estado.setEnergiaDisponible(estado.getEnergiaDisponible()-estado.getEnergiaDisponible()/4);
				vida = estado.getEnergiaDisponible();
				estado.setNoPelea(true);
				ambiente.setEnergiaAgente(ambiente.getEnergiaAgente()-ambiente.getEnergiaAgente()/4);
				//estado.setBossDerrotado(true);
				//logAction();
				return ambiente;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Huyendo";
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}

	
}
