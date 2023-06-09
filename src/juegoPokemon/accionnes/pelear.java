package juegoPokemon.accionnes;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import juegoPokemon.Nodo;
import juegoPokemon.PokemonAgentState;
import juegoPokemon.PokemonEnvironmentState;

public class pelear extends SearchAction{

	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		// TODO Auto-generated method stub
		PokemonAgentState estado = (PokemonAgentState) s;
		Nodo ubicacionActual = estado.getUbicacionActual();
		if(!ubicacionActual.isHayPokebola() && !estado.isNoPelea() 
				&& estado.getEnergiaDisponible() > ubicacionActual.getOcupante().getEnergia() && !ubicacionActual.getOcupante().isDefeated()) {
			if(ubicacionActual.getIdentificador()==25) {
				estado.setBossDerrotado(true);
			}
			estado.setEnergiaDisponible(estado.getEnergiaDisponible()-ubicacionActual.getOcupante().getEnergia()+(ubicacionActual.getOcupante().getEnergia()*0.2f));
			estado.setEnergiaGanada(estado. getEnergiaGanada()+ ubicacionActual.getOcupante().getEnergia()*0.2f);
			ubicacionActual.getOcupante().setDefeated(true);
			
			if(estado.getEnergiaGanada() >= estado.getEnergiaInicial()*0.25f && !estado.isPoder1Disponible()) {
				//System.out.println("Poder 1 Desbloquedo");
				estado.setPoder1Disponible(true);
			}
			else if(estado.getEnergiaGanada() >= estado.getEnergiaInicial()*0.75f && !estado.isPoder2Disponible()) {
				//System.out.println("Poder 2 Desbloquedo");

				estado.setPoder2Disponible(true);
			}
			else if(estado.getEnergiaGanada() >= estado.getEnergiaInicial()*1.2f && !estado.isPoder3Disponible()) {
				//System.out.println("Poder 3 Desbloquedo");
				estado.setPoder3Disponible(true);
			}
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
		Nodo ubicacionActualAgente = estado.getUbicacionActual();
		Nodo ubicacionActualAmbiente = ambiente.getAgentPosition();
		if(!ubicacionActualAgente.isHayPokebola() && !estado.isNoPelea() 
				&& estado.getEnergiaDisponible() > ubicacionActualAgente.getOcupante().getEnergia() && !ubicacionActualAgente.getOcupante().isDefeated()) {
			if(ubicacionActualAgente.getIdentificador()==25) {
				estado.setBossDerrotado(true);
			}
			estado.setEnergiaDisponible(estado.getEnergiaDisponible()-ubicacionActualAgente.getOcupante().getEnergia()+(ubicacionActualAgente.getOcupante().getEnergia()*0.2f));
			estado.setEnergiaGanada(estado. getEnergiaGanada()+ ubicacionActualAgente.getOcupante().getEnergia()*0.2f);
			ubicacionActualAgente.getOcupante().setDefeated(true);
			
			if(estado.getEnergiaGanada() >= estado.getEnergiaInicial()*0.25f && !estado.isPoder1Disponible()) {
				estado.setPoder1Disponible(true);
			}
			else if(estado.getEnergiaGanada() >= estado.getEnergiaInicial()*0.75f && !estado.isPoder2Disponible()) {
				estado.setPoder2Disponible(true);
			}
			else if(estado.getEnergiaGanada() >= estado.getEnergiaInicial()*1.2f && !estado.isPoder3Disponible()) {
				estado.setPoder3Disponible(true);
			}
			ubicacionActualAmbiente.getOcupante().setDefeated(true);
			return ambiente;
		}
		return null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "peleando";
	}

}
