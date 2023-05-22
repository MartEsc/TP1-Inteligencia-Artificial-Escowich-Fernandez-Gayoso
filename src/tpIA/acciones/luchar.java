package tpIA.acciones;

import java.io.FileWriter;
import java.io.IOException;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import tpIA.PokemonAgentState;
import tpIA.PokemonEnvironmentState;
import tpIA.enemigoGenerico;

public class luchar extends SearchAction{
 
	float vida = 0f;
	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		// TODO Auto-generated method stub
		PokemonAgentState estado = (PokemonAgentState) s;
		//System.out.println("Energia del agente: "+ estado.getEnergiaDisponible() );
		if(!estado.getUbicacionActual().getHayPokebola()){
			enemigoGenerico enemigo = estado.getUbicacionActual().getOcupante();
			if(estado.getEnergiaDisponible() > enemigo.getEnergia() && !enemigo.getDefeated()) {
				//System.out.println("Enemigo vencido");
				estado.setEnergiaDisponible(estado.getEnergiaDisponible()-enemigo.getEnergia()+enemigo.getEnergia()*0.2f);
				estado.setEnergiaGanada(estado.getEnergiaGanada()+enemigo.getEnergia()*0.2f);
				enemigo.setDefeated(true);
				vida=estado.getEnergiaDisponible();
				if(enemigo.getUbicacionActualEnemigo()==2){
					estado.setBossDerrotado(true);
					//ambiente.setBossDerrotado(true);
				}
				//estado.setBossDerrotado(true);
				System.out.println(estado.getEnergiaDisponible()+ "ACAAAAAAAA");
				if(estado.getEnergiaGanada() >= estado.getEnergiaInicial()*0.25f) {
					estado.setPoder1Disponible(true);
				}
				else if(estado.getEnergiaGanada() >= estado.getEnergiaInicial()*0.75f) {
					estado.setPoder2Disponible(true);
				}
				else if(estado.getEnergiaGanada() >= estado.getEnergiaInicial()*1.2f) {
					estado.setPoder3Disponible(true);
				}
				//logAction();
				return estado;
			}
		}
		return null;
	}

	
	@Override
	public EnvironmentState execute(AgentState ast, EnvironmentState est) {
		// TODO Auto-generated method stub
		PokemonAgentState estado = (PokemonAgentState) ast;
		PokemonEnvironmentState ambiente = (PokemonEnvironmentState) est;
		if(!ambiente.getAgentPosition().getHayPokebola()){
			enemigoGenerico enemigo = estado.getUbicacionActual().getOcupante();
			//System.out.println(ambiente.getEnergiaPokemon()+ "ACAAAAAAAA");
			if(ambiente.getEnergiaPokemon() > enemigo.getEnergia() && !enemigo.getDefeated()) {
				System.out.println("Enemigo vencido");
				estado.setEnergiaDisponible(estado.getEnergiaDisponible()-enemigo.getEnergia()+enemigo.getEnergia()*0.2f);
				estado.setEnergiaGanada(estado.getEnergiaGanada()+enemigo.getEnergia()*0.2f);
				vida=estado.getEnergiaDisponible();
				enemigo.setDefeated(true);
				if(enemigo.getUbicacionActualEnemigo()==2) {
					estado.setBossDerrotado(true);
					ambiente.setBossDerrotado(true);
				}
				else {
					estado.setBossDerrotado(false);
					ambiente.setBossDerrotado(false);
				}
				if(estado.getEnergiaGanada() >= estado.getEnergiaInicial()*0.25f) {
					estado.setPoder1Disponible(true);
				}
				else if(estado.getEnergiaGanada() >= estado.getEnergiaInicial()*0.75f) {
					estado.setPoder2Disponible(true);
				}
				else if(estado.getEnergiaGanada() >= estado.getEnergiaInicial()*1.2f) {
					estado.setPoder3Disponible(true);
				}
				//System.out.println(ambiente.getEnergiaPokemon()+ "///////////////////");
				ambiente.setEnergiaPokemon(ambiente.getEnergiaPokemon()-enemigo.getEnergia()+enemigo.getEnergia()*0.2f);
				ambiente.getAgentPosition().getOcupante().setDefeated(true);
				//logAction();
				return ambiente;
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
	public String toString() {
		// TODO Auto-generated method stub
		String str = "Luchando, vida restante: "+ vida;
		return str;
	}
	public void logAction() {
		try {
		      FileWriter myWriter = new FileWriter("logAcciones.txt",true);
		      myWriter.write(this.toString()+"\n");
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
}
