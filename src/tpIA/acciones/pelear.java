package tpIA.acciones;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import tpIA.PokemonAgentState;
import tpIA.PokemonEnvironmentState;
import tpIA.enemigoGenerico;

public class pelear extends SearchAction{

	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		// TODO Auto-generated method stub		
		//System.out.println("Quiero pelear");		
		PokemonAgentState estado = (PokemonAgentState) s;
		//System.out.println(estado.getEnergiaDisponible());
		//try {
		//    Thread.sleep(2000); // espera 10 segundos
		//} catch (InterruptedException e) {
		//    e.printStackTrace();
		//}
		if(estado.getEnergiaGanada() > estado.getEnergiaInicial()*0.25 && !estado.isPoder1Disponible()) {
			estado.setPoder1Disponible(true);
			//System.out.println("Desbloqueado poder 1");
		}
		else if(estado.getEnergiaGanada() > estado.getEnergiaInicial()*0.75 && !estado.isPoder2Disponible()) {
			estado.setPoder2Disponible(true);
			//System.out.println("Desbloqueado poder 2");
		}
		else if(estado.getEnergiaGanada() > estado.getEnergiaInicial()*1.2 && !estado.isPoder3Disponible()) {
			estado.setPoder3Disponible(true);
			//System.out.println("Desbloqueado poder 3");
		}
		//System.out.println("Energia ganada inicial: "+estado.getEnergiaGanada());
		if(!estado.getUbicacionActual().getHayPokebola()) {
			//System.out.println("Energia enemigo: " + estado.getUbicacionActual().getOcupante().getEnergia());
			//System.out.println("Energia propia"+ estado.getEnergiaDisponible());
			//System.out.println("enemigo derrotado: "+ estado.getUbicacionActual().getOcupante().getDefeated());
			if(estado.getEnergiaDisponible() > estado.getUbicacionActual().getOcupante().getEnergia() && !estado.getUbicacionActual().getOcupante().getDefeated()) {
				enemigoGenerico enemigo = estado.getUbicacionActual().getOcupante();
				estado.setEnergiaDisponible(estado.getEnergiaDisponible()-enemigo.getEnergia()+enemigo.getEnergia()*0.2f);
				estado.setEnergiaGanada(estado.getEnergiaGanada()+enemigo.getEnergia()*0.2f);
				//System.out.println("Mas energia ganada"+ estado.getEnergiaGanada());
				estado.getUbicacionActual().getOcupante().setEnergia(0);
				estado.getDerrotados().add(estado.getUbicacionActual().getOcupante());
				estado.getUbicacionActual().getOcupante().setDefeated(true);
				if(enemigo.getUbicacionActualEnemigo()==26) {
					estado.setBossDerrotado(true);
				}else estado.setBossDerrotado(false);
				//System.out.println("DERROTADO ENEMIGO EN "+estado.getUbicacionActual()+"   ENERGIA RESTANTE:  "+estado.getEnergiaDisponible());
				estado.toString();
				return estado;
			}
			else if(this.utilizarHabilidades(estado)) { //funcion que evalua y usa habilidades
				enemigoGenerico enemigo = estado.getUbicacionActual().getOcupante();
				estado.setEnergiaDisponible(estado.getEnergiaDisponible()-enemigo.getEnergia()+enemigo.getEnergia()*0.2f);
				estado.setEnergiaGanada(estado.getEnergiaGanada() + enemigo.getEnergia()*0.2f);
				//System.out.println("Mas energia ganada "+ estado.getEnergiaGanada());
				estado.getUbicacionActual().getOcupante().setEnergia(0);
				estado.getDerrotados().add(estado.getUbicacionActual().getOcupante());
				estado.getUbicacionActual().getOcupante().setDefeated(true);
				if(enemigo.getUbicacionActualEnemigo()==26) {
					estado.setBossDerrotado(true);
				}else estado.setBossDerrotado(false);
	
				//System.out.println("DERROTADO ENEMIGO EN "+estado.getUbicacionActual()+"   ENERGIA RESTANTE:  "+estado.getEnergiaDisponible());
				return estado;
			}	
		}
		return null;
	}

	@Override
	public Double getCost() {
		// TODO Auto-generated method stub
		return 0.0;
	}

	@Override
	public EnvironmentState execute(AgentState ast, EnvironmentState est) {
		// TODO Auto-generated method stub
		PokemonAgentState estado = (PokemonAgentState) ast;
		PokemonEnvironmentState ambiente = (PokemonEnvironmentState) est;
		//System.out.println("Energia ganada: "+estado.getEnergiaGanada());
		if(estado.getEnergiaGanada() > estado.getEnergiaInicial()*0.25 && !estado.isPoder1Disponible()) {
			estado.setPoder1Disponible(true);
			//System.out.println("Desbloqueado poder 1");
		}
		else if(estado.getEnergiaGanada() > estado.getEnergiaInicial()*0.75 && !estado.isPoder2Disponible()) {
			estado.setPoder2Disponible(true);
			//System.out.println("Desbloqueado poder 2");
		}
		else if(estado.getEnergiaGanada() > estado.getEnergiaInicial()*1.2 && !estado.isPoder3Disponible()) {
			estado.setPoder3Disponible(true);
			//System.out.println("Desbloqueado poder 3");
		}
		if(estado.getUbicacionActual().getHayPokebola()==false) {
			if(estado.getEnergiaDisponible() > ambiente.getAgentPosition().getOcupante().getEnergia() && !estado.getUbicacionActual().getOcupante().getDefeated()) {
				enemigoGenerico enemigo = estado.getUbicacionActual().getOcupante();
				estado.setEnergiaDisponible(estado.getEnergiaDisponible()-enemigo.getEnergia()+enemigo.getEnergia()*0.2f);
				estado.setEnergiaGanada(estado.getEnergiaGanada()+enemigo.getEnergia()*0.2f);
				//System.out.println("Mas energia ganada "+ estado.getEnergiaGanada());
				ambiente.setEnergiaPokemon(ambiente.getEnergiaPokemon()-enemigo.getEnergia()+enemigo.getEnergia()*0.2f);
				estado.getDerrotados().add(estado.getUbicacionActual().getOcupante());
				ambiente.getAgentPosition().getOcupante().setDefeated(true);
				if(enemigo.getUbicacionActualEnemigo()==26) {
					estado.setBossDerrotado(true);
				}else estado.setBossDerrotado(false);
				if(enemigo.getUbicacionActualEnemigo()==26) {
					ambiente.setBossDerrotado(true);
				}else ambiente.setBossDerrotado(false);	
				return ambiente;
			}
			else if(this.utilizarHabilidades(estado)) { //funcion que evalua y usa habilidades
				enemigoGenerico enemigo = estado.getUbicacionActual().getOcupante();
				estado.setEnergiaDisponible(estado.getEnergiaDisponible()-enemigo.getEnergia()+enemigo.getEnergia()*0.2f);
				estado.setEnergiaGanada(estado.getEnergiaGanada()+enemigo.getEnergia()*0.2f);
				//System.out.println("Mas energia ganada "+ estado.getEnergiaGanada());
				ambiente.setEnergiaPokemon(ambiente.getEnergiaPokemon()-enemigo.getEnergia()+enemigo.getEnergia()*0.2f);
				estado.getDerrotados().add(estado.getUbicacionActual().getOcupante());
				ambiente.getAgentPosition().getOcupante().setDefeated(true);
				if(enemigo.getUbicacionActualEnemigo()==26) {
					estado.setBossDerrotado(true);
				}else estado.setBossDerrotado(false);
				if(enemigo.getUbicacionActualEnemigo()==26) {
					ambiente.setBossDerrotado(true);
				}else ambiente.setBossDerrotado(false);
				return ambiente;
			}	
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
			//	System.out.println("Uso poder 1");
				estado.setEnergiaDisponible(estado.getEnergiaDisponible()*1.2f);
				estado.setContadorPoder1(0);
				estado.setPoder1Disponible(false);
				return true;
			}
		}
		if(estado.isPoder2Disponible() && estado.getContadorPoder2() > 3){
			if(estado.getEnergiaDisponible()*1.3 > enemigo.getEnergia()) {
			//	System.out.println("Uso poder 2");
				estado.setEnergiaDisponible(estado.getEnergiaDisponible()*1.3f);
				estado.setContadorPoder2(0);
				estado.setPoder2Disponible(false);
				return true;
			}
		}
		if(estado.isPoder3Disponible() && estado.getContadorPoder3() > 3){
			if(estado.getEnergiaDisponible()*1.5 > enemigo.getEnergia()) {
			//	System.out.println("Uso poder 3");
				estado.setEnergiaDisponible(estado.getEnergiaDisponible()*1.5f);
				estado.setContadorPoder3(0);
				estado.setPoder3Disponible(false);
				return true;
			}
		}
		if(estado.isPoder1Disponible() && estado.getContadorPoder1() > 3 && 
				estado.isPoder2Disponible() && estado.getContadorPoder2() > 3){
			if(estado.getEnergiaDisponible()*1.5 > enemigo.getEnergia()) {
			//	System.out.println("Uso poder 1 y 2");
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
			//	System.out.println("Uso poder 1 y 3");
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
			//	System.out.println("Uso poder 2 y 3");
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
			//	System.out.println("Uso poder 1, 2 y 3");
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
