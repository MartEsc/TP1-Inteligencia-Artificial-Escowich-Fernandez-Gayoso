package tpIA.acciones;

import java.util.Random;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import tpIA.Nodo;
import tpIA.PokemonAgentState;
import tpIA.PokemonEnvironmentState;

public class moverANodoAdyacente extends SearchAction{

	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		// TODO Auto-generated method stub
		PokemonAgentState estado = (PokemonAgentState) s;
		System.out.println("MIS VECINOS SON "+estado.getUbicacionActual().getNodosVecinos());
		Nodo nodoConEnemigoMasDebil = estado.getUbicacionActual().getNodosVecinos().get(0);
		for(Nodo proxUbicacion : estado.getUbicacionActual().getNodosVecinos()) {
			if(proxUbicacion.getHayPokebola()) {
				System.out.println("Hay pokebola en nodo: " + proxUbicacion);
				estado.setUbicacionActual(proxUbicacion);
				estado.getUbicacionActual().setNodosVecinos(proxUbicacion.getNodosVecinos());
				estado.setNoPelea(false);
				System.out.println("ME MUEVO A " + estado.getUbicacionActual());
				estado.setEnergiaDisponible(estado.getEnergiaDisponible()+ new Random().nextInt(5, 10));
				estado.getUbicacionActual().setHayPokebola(false);
				return estado;
				
			}
			if(!proxUbicacion.getOcupante().getDefeated() && (proxUbicacion.getIdentificador() != 26 || estado.getDerrotados().size()==22)) {
				//el if de arriba evalua que el enemigo no este derrotado, y que ademas si es el nodo del boss, no pueda acceder hasta haber derrotado a los otros enemigos
				if(proxUbicacion.getOcupante().getEnergia() < nodoConEnemigoMasDebil.getOcupante().getEnergia() 
						|| nodoConEnemigoMasDebil.getOcupante().getDefeated()) {
					nodoConEnemigoMasDebil = proxUbicacion;
				}
			}
		}
		estado.setUbicacionActual(nodoConEnemigoMasDebil);
		estado.getUbicacionActual().setNodosVecinos(nodoConEnemigoMasDebil.getNodosVecinos());
		estado.setNoPelea(false);
		System.out.println("ME MUEVO A " + estado.getUbicacionActual());
		return estado;
	}

	@Override
	public Double getCost() {
		return null;
	}

	@Override
	public EnvironmentState execute(AgentState ast, EnvironmentState est) {
		// TODO Auto-generated method stub
		
		PokemonAgentState estado = (PokemonAgentState) ast;
		PokemonEnvironmentState ambiente = (PokemonEnvironmentState) est;
		Nodo nodoConEnemigoMasDebil = ambiente.getAgentPosition().getNodosVecinos().get(0);
		for(Nodo proxUbicacion : ambiente.getAgentPosition().getNodosVecinos()) {
			if(proxUbicacion.getHayPokebola()) {
				estado.setUbicacionActual(proxUbicacion);
				estado.setNoPelea(false);
				ambiente.setNodoActualAgente(proxUbicacion.getIdentificador());
				return ambiente;
			}
			if(!proxUbicacion.getOcupante().getDefeated() && (proxUbicacion.getIdentificador() != 26 || estado.getDerrotados().size()==22)) {
				//el if de arriba evalua que el enemigo no este derrotado, y que ademas si es el nodo del boss, no pueda acceder hasta haber derrotado a los otros enemigos
				if(proxUbicacion.getOcupante().getEnergia() < nodoConEnemigoMasDebil.getOcupante().getEnergia() 
						|| nodoConEnemigoMasDebil.getOcupante().getDefeated()) {
					nodoConEnemigoMasDebil = proxUbicacion;
				}
			}
		}
		estado.setUbicacionActual(nodoConEnemigoMasDebil);
		estado.setNoPelea(false);
		ambiente.setNodoActualAgente(nodoConEnemigoMasDebil.getIdentificador());
		
		System.out.println("ME MUEVO A " + estado.getUbicacionActual());
		return ambiente;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Ir al siguiente nodo";
	}
	
}
