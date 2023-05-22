package juegoPokemon.accionnes;

import java.io.FileWriter;
import java.io.IOException;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import juegoPokemon.Nodo;
import juegoPokemon.PokemonAgentState;
import juegoPokemon.PokemonEnvironmentState;

public class moverANodoN extends SearchAction{

	private int nuevaUbicacion;
	private int nodoViejo;
	
	public moverANodoN(int nuevaUbicacion) {
		super();
		this.nuevaUbicacion = nuevaUbicacion;
	}
	
	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		// TODO Auto-generated method stub
		PokemonAgentState estado = (PokemonAgentState) s;
		
		boolean esVecino = false;
		nodoViejo = estado.getUbicacionActual().getIdentificador();
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
		nodoViejo = estado.getUbicacionActual().getIdentificador();
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
		return ("a"+String.valueOf(this.nuevaUbicacion)+"\n");
	}
//	public void logAction(String nodoPrevio) {
//		FileWriter myWriter;
//		try {
//		myWriter = new FileWriter("logAcciones.txt",true);
//		myWriter.write("de"+nodoPrevio+"a"+String.valueOf(this.nuevaUbicacion)+"\n");
//		myWriter.close();
//		//System.out.println("Logueó movimiento de"+nodoPrevio+" a "+String.valueOf(this.nuevaUbicacion));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}

}
