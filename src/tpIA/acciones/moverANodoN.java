package tpIA.acciones;

import java.io.FileWriter;
import java.io.IOException;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import tpIA.Nodo;
import tpIA.PokemonAgentState;
import tpIA.PokemonEnvironmentState;

public class moverANodoN extends SearchAction{

	private Integer nuevaUbicacion;
	private Integer ubicacionVieja;
	public moverANodoN(Integer nuevaUbicacion) {
		super();
		this.nuevaUbicacion = nuevaUbicacion;
	}

	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		// TODO Auto-generated method stub
		PokemonAgentState estado = (PokemonAgentState) s;
		boolean esVecino = false;
		Nodo nuevoNodo = null;
		ubicacionVieja = estado.getUbicacionActual().getIdentificador();
		//System.out.println("MIS VECINOS SON "+estado.getUbicacionActual().getNodosVecinos());
		for(Nodo nodo : estado.getUbicacionActual().getNodosVecinos()) {
			if(nodo.getIdentificador()==this.nuevaUbicacion){
				esVecino = true;
				nuevoNodo = nodo;
			}
		}
		if(!estado.getUbicacionActual().getHayPokebola()) {
			if((estado.getUbicacionActual().getOcupante().getDefeated() || estado.isNoPelea()) 
					&& esVecino){
				//System.out.println("ME MUEVO A " + nuevoNodo.getIdentificador());
				estado.setUbicacionActual(nuevoNodo);
				estado.setNoPelea(false);
			//	estado.setBossDerrotado(true);
				//System.out.println("ME MOVI A " + estado.getUbicacionActual());
				logAction("de " + ubicacionVieja.toString()+" a "+ estado.getUbicacionActual().getIdentificador());
				return estado;
			}
		}
		return null;
	}

	@Override
	public Double getCost() {
		return 1.0;
	}

	@Override
	public EnvironmentState execute(AgentState ast, EnvironmentState est) {
		// TODO Auto-generated method stub
		
		PokemonAgentState estado = (PokemonAgentState) ast;
		PokemonEnvironmentState ambiente = (PokemonEnvironmentState) est;
		ubicacionVieja = estado.getUbicacionActual().getIdentificador();
		boolean esVecino = false;
		Nodo nuevoNodo = null;
		for(Nodo nodo : estado.getUbicacionActual().getNodosVecinos()) {
			if(nodo.getIdentificador()==this.nuevaUbicacion){
				esVecino = true;
				nuevoNodo = nodo;
			}
		}
		if((estado.getUbicacionActual().getOcupante().getDefeated() || estado.isNoPelea()) 
				&& esVecino) {
			estado.setUbicacionActual(nuevoNodo);
			estado.setNoPelea(false);
			//estado.setBossDerrotado(false);
			//ambiente.setBossDerrotado(false);
			ambiente.setNodoActualAgente(nuevoNodo.getIdentificador());		
			//System.out.println("ME MUEVO A " + nuevoNodo.getIdentificador());
			logAction("Desde " + ubicacionVieja.toString()+" hacia "+ estado.getUbicacionActual().getIdentificador());
			return ambiente;
		}
		return null;
	}

	@Override
	public String toString() {
		
		return "Ir al siguiente nodo";
	}
	public void logAction(String string) {
		try {
		      FileWriter myWriter = new FileWriter("logAcciones.txt",true);
		      myWriter.write(string+"\n");
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
}
