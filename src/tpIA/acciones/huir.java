package tpIA.acciones;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import tpIA.PokemonAgentState;
import tpIA.enemigoGenerico;
import tpIA.PokemonEnvironmentState;
public class huir extends SearchAction{

	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		// TODO Auto-generated method stub
		PokemonAgentState estado = (PokemonAgentState) s;
		if(estado.getUbicacionActual().getOcupante()!=null) {
			System.out.println("Energia actual antes de querer huir: "+ estado.getEnergiaDisponible());
			System.out.println("Es necesario huir? "+ !estado.getUbicacionActual().getOcupante().getDefeated());
			if(!estado.getUbicacionActual().getOcupante().getDefeated()){
				if((estado.getEnergiaDisponible() < estado.getUbicacionActual().getOcupante().getEnergia()
						&& utilizarHabilidades(estado)) || !estado.getUbicacionActual().getHayPokebola() ){
					estado.setEnergiaDisponible(estado.getEnergiaDisponible()-(estado.getEnergiaDisponible()/4));
					System.out.println("Energia despues de huir"+ estado.getEnergiaDisponible());
					estado.setNoPelea(true);
					return estado;
				}
			}
		}
		return null;
	}

	@Override
	public Double getCost() {
		return 2.0;
	}

	@Override
	public EnvironmentState execute(AgentState ast, EnvironmentState est) {
		// TODO Auto-generated method stub
		PokemonAgentState estado = (PokemonAgentState) ast;
		PokemonEnvironmentState ambiente = (PokemonEnvironmentState) est;
		if(estado.getUbicacionActual().getOcupante()!=null) {
			if(!estado.getUbicacionActual().getOcupante().getDefeated()){
				if((estado.getEnergiaDisponible() < ambiente.getAgentPosition().getOcupante().getEnergia()
						&& utilizarHabilidades(estado)) || !ambiente.getAgentPosition().getHayPokebola()){
					estado.setEnergiaDisponible(estado.getEnergiaDisponible()-(estado.getEnergiaDisponible()/4));
					ambiente.setEnergiaPokemon(ambiente.getEnergiaPokemon()-ambiente.getEnergiaPokemon()/4);
					estado.setNoPelea(true);
					return ambiente;
				}
			}
		}
		System.out.println(this.toString());
		return null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Huir";
	}
	private boolean utilizarHabilidades(PokemonAgentState estado) {
		enemigoGenerico enemigo = estado.getUbicacionActual().getOcupante();
		if(estado.isPoder1Disponible() && estado.getContadorPoder1() > 3){
			if(estado.getEnergiaDisponible()*1.2 > enemigo.getEnergia()) {
				System.out.println("Uso poder 1");
				estado.setEnergiaDisponible(estado.getEnergiaDisponible()*1.2f);
				estado.setContadorPoder1(0);
				estado.setPoder1Disponible(false);
				return true;
			}
		}
		if(estado.isPoder2Disponible() && estado.getContadorPoder2() > 3){
			if(estado.getEnergiaDisponible()*1.3 > enemigo.getEnergia()) {
				System.out.println("Uso poder 2");
				estado.setEnergiaDisponible(estado.getEnergiaDisponible()*1.3f);
				estado.setContadorPoder2(0);
				estado.setPoder2Disponible(false);
				return true;
			}
		}
		if(estado.isPoder3Disponible() && estado.getContadorPoder3() > 3){
			if(estado.getEnergiaDisponible()*1.5 > enemigo.getEnergia()) {
				System.out.println("Uso poder 3");
				estado.setEnergiaDisponible(estado.getEnergiaDisponible()*1.5f);
				estado.setContadorPoder3(0);
				estado.setPoder3Disponible(false);
				return true;
			}
		}
		if(estado.isPoder1Disponible() && estado.getContadorPoder1() > 3 && 
				estado.isPoder2Disponible() && estado.getContadorPoder2() > 3){
			if(estado.getEnergiaDisponible()*1.5 > enemigo.getEnergia()) {
				System.out.println("Uso poder 1 y 2");
				estado.setEnergiaDisponible(estado.getEnergiaDisponible()*1.5f);
				estado.setContadorPoder1(0);
				estado.setPoder1Disponible(false);
				estado.setContadorPoder2(0);
				estado.setPoder2Disponible(false);
				return true;
			}
		}
		if(estado.isPoder1Disponible() && estado.getContadorPoder1() > 3 && 
				estado.isPoder3Disponible() && estado.getContadorPoder3() > 3){
			if(estado.getEnergiaDisponible()*1.7 > enemigo.getEnergia()) {
				System.out.println("Uso poder 1 y 3");
				estado.setEnergiaDisponible(estado.getEnergiaDisponible()*1.7f);
				estado.setContadorPoder1(0);
				estado.setPoder1Disponible(false);
				estado.setContadorPoder3(0);
				estado.setPoder3Disponible(false);
				return true;
			}
		}
		if(estado.isPoder2Disponible() && estado.getContadorPoder2() > 3 && 
				estado.isPoder3Disponible() && estado.getContadorPoder3() > 3){
			if(estado.getEnergiaDisponible()*1.8 > enemigo.getEnergia()) {
				System.out.println("Uso poder 2 y 3");
				estado.setEnergiaDisponible(estado.getEnergiaDisponible()*1.8f);
				estado.setContadorPoder3(0);
				estado.setPoder3Disponible(false);
				estado.setContadorPoder2(0);
				estado.setPoder2Disponible(false);
				return true;
			}
		}
		if(estado.isPoder1Disponible() && estado.getContadorPoder1() > 3 && 
				estado.isPoder2Disponible() && estado.getContadorPoder2() > 3 &&
				estado.isPoder3Disponible() && estado.getContadorPoder3() > 3){
			if(estado.getEnergiaDisponible()*2 > enemigo.getEnergia()) {
				System.out.println("Uso poder 1, 2 y 3");
				estado.setEnergiaDisponible(estado.getEnergiaDisponible()*2f);
				estado.setContadorPoder1(0);
				estado.setPoder1Disponible(false);
				estado.setContadorPoder2(0);
				estado.setPoder2Disponible(false);
				estado.setContadorPoder3(0);
				estado.setPoder3Disponible(false);
				return true;
			}
		}
		return false;
	}
}
