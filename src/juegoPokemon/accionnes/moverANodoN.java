package juegoPokemon.accionnes;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import juegoPokemon.Nodo;
import juegoPokemon.PokemonAgentState;
import juegoPokemon.PokemonEnvironmentState;

public class moverANodoN extends SearchAction{

	private int nuevaUbicacion;
	
	public moverANodoN(int nuevaUbicacion) {
		super();
		this.nuevaUbicacion = nuevaUbicacion;
	}
	
	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		// TODO Auto-generated method stub
		PokemonAgentState estado = (PokemonAgentState) s;
		
		boolean esVecino = false;
		Nodo nuevoNodo = null;
		for(Nodo nodo : estado.getUbicacionActual().getNodosVecinos()){
			if(nodo.getIdentificador()==this.nuevaUbicacion){
				esVecino = true;
				nuevoNodo = nodo;
			//	System.out.println("Encontre nodo en los vecinos");
			}
		}
		if((estado.getUbicacionActual().getOcupante().isDefeated()|| estado.isNoPelea()) 
					&& esVecino){
				//System.out.println("ME MUEVO A " + nuevoNodo.getIdentificador());
				estado.setUbicacionActual(nuevoNodo);
				estado.setNoPelea(false);
			//	System.out.println("Me movi al nuevo nodo");
			//	estado.setBossDerrotado(true);
				//System.out.println("ME MOVI A " + estado.getUbicacionActual());
				//logAction("de " + ubicacionVieja.toString()+" a "+ estado.getUbicacionActual().getIdentificador());
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
		boolean esVecino = false;
		Nodo nuevoNodo = null;
		for(Nodo nodo : estado.getUbicacionActual().getNodosVecinos()){
			if(nodo.getIdentificador()==this.nuevaUbicacion){
				esVecino = true;
				nuevoNodo = nodo;
			}
		}
		if ((estado.getUbicacionActual().getOcupante().isDefeated() || estado.isNoPelea()) && esVecino) {
				// System.out.println("ME MUEVO A " + nuevoNodo.getIdentificador());
				estado.setUbicacionActual(nuevoNodo);
				estado.setNoPelea(false);
				ambiente.setNodoActualAgent(nuevoNodo.getIdentificador());
				// estado.setBossDerrotado(true);
				// System.out.println("ME MOVI A " + estado.getUbicacionActual());
				// logAction("de " + ubicacionVieja.toString()+" a "+
				// estado.getUbicacionActual().getIdentificador());
				return ambiente;
		}
		return null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Moviendose al nodo "+ this.nuevaUbicacion;
	}

}
