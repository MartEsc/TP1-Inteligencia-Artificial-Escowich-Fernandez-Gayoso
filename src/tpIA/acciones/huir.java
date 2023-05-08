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
			if(estado.getEnergiaDisponible() < estado.getUbicacionActual().getOcupante().getEnergia()
					&& !utilizarHabilidades(estado)) {
				estado.setEnergiaDisponible(estado.getEnergiaDisponible()-(estado.getEnergiaDisponible()/4));
				estado.setNoPelea(true);
			}
		}
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
		if(estado.getUbicacionActual().getOcupante()!=null) {
			if(estado.getEnergiaDisponible() < ambiente.getAgentPosition().getOcupante().getEnergia()
					&& !ambiente.getAgentPosition().getHayPokebola() && !utilizarHabilidades(estado)) {
				estado.setEnergiaDisponible(estado.getEnergiaDisponible()-(estado.getEnergiaDisponible()/4));
				estado.setNoPelea(true);
			}
		}
		System.out.println(this.toString());
		return ambiente;
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
