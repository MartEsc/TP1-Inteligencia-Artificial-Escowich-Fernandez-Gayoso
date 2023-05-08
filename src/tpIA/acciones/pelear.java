package tpIA.acciones;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import tpIA.PokemonAgentState;
import tpIA.enemigoGenerico;

public class pelear extends SearchAction{

	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		// TODO Auto-generated method stub
		
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
		PokemonAgentState estado = (PokemonAgentState) s;
		if(estado.getEnergiaDisponible() > estado.getUbicacionActual().getOcupante().getEnergia()) {
			enemigoGenerico enemigo = estado.getUbicacionActual().getOcupante();
			estado.setEnergiaDisponible(estado.getEnergiaDisponible()+enemigo.getEnergia()*0.2f);
			estado.getUbicacionActual().getOcupante().setEnergia(0);
			estado.getDerrotados().add(estado.getUbicacionActual().getOcupante());
			estado.getUbicacionActual().getOcupante().setDefeated(true);
		}
		else if(this.utilizarHabilidades(estado)) { //escribir la funcion que evalua si se pueden usar poderes
			enemigoGenerico enemigo = estado.getUbicacionActual().getOcupante();
			estado.setEnergiaDisponible(estado.getEnergiaDisponible()+enemigo.getEnergia()*0.2f);
			estado.getUbicacionActual().getOcupante().setEnergia(0);
			estado.getDerrotados().add(estado.getUbicacionActual().getOcupante());
			estado.getUbicacionActual().getOcupante().setDefeated(true);
		}
		if(estado.getEnergiaDisponible() > estado.getEnergiaInicial()*1.25) {
			estado.setPoder1Disponible(true);
		}
		else if(estado.getEnergiaDisponible() > estado.getEnergiaInicial()*1.75) {
			estado.setPoder2Disponible(true);
		}
		else if(estado.getEnergiaDisponible() > estado.getEnergiaInicial()*2.2) {
			estado.setPoder3Disponible(true);
		}
		return null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Pelear";
	}
	private boolean utilizarHabilidades(PokemonAgentState estado) {
		enemigoGenerico enemigo = estado.getUbicacionActual().getOcupante();
		if(estado.isPoder1Disponible() && estado.getContadorPoder1() > 3){
			if(estado.getEnergiaDisponible()*1.2 > enemigo.getEnergia()) {
				estado.setEnergiaDisponible(estado.getEnergiaDisponible()*1.2f);
				estado.setContadorPoder1(0);
				estado.setPoder1Disponible(false);
				return true;
			}
		}
		if(estado.isPoder2Disponible() && estado.getContadorPoder2() > 3){
			if(estado.getEnergiaDisponible()*1.3 > enemigo.getEnergia()) {
				estado.setEnergiaDisponible(estado.getEnergiaDisponible()*1.3f);
				estado.setContadorPoder2(0);
				estado.setPoder2Disponible(false);
				return true;
			}
		}
		if(estado.isPoder3Disponible() && estado.getContadorPoder3() > 3){
			if(estado.getEnergiaDisponible()*1.5 > enemigo.getEnergia()) {
				estado.setEnergiaDisponible(estado.getEnergiaDisponible()*1.5f);
				estado.setContadorPoder3(0);
				estado.setPoder3Disponible(false);
				return true;
			}
		}
		if(estado.isPoder1Disponible() && estado.getContadorPoder1() > 3 && 
				estado.isPoder2Disponible() && estado.getContadorPoder2() > 3){
			if(estado.getEnergiaDisponible()*1.5 > enemigo.getEnergia()) {
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
