package tpIA;

import java.util.ArrayList;
import java.util.List;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

public class PokemonAgentState extends SearchBasedAgentState{
	
	private int identificador;
	private float energiaDisponible;
	private float energiaInicial;
	private int contadorPoder1;
	private int contadorPoder2;
	private int contadorPoder3;
	private boolean poder1Disponible;
	private boolean poder2Disponible;
	private boolean poder3Disponible;
	private Nodo ubicacionActual;
	private ArrayList<enemigoGenerico> derrotados;
	private boolean noPelea;
	private Mapa mapaMundiHeroe;
	
	
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public SearchBasedAgentState clone() {
		// TODO Auto-generated method stub
		PokemonAgentState nuevoEstadoPokemon = new PokemonAgentState();
		nuevoEstadoPokemon.setIdentificador(this.getIdentificador());
		nuevoEstadoPokemon.setEnergiaDisponible(this.getEnergiaDisponible());
		nuevoEstadoPokemon.setEnergiaInicial(this.getEnergiaInicial());
		nuevoEstadoPokemon.setContadorPoder1(this.getContadorPoder1());
		nuevoEstadoPokemon.setContadorPoder2(this.getContadorPoder2());
		nuevoEstadoPokemon.setContadorPoder3(this.getContadorPoder3());
		nuevoEstadoPokemon.setPoder1Disponible(this.isPoder1Disponible());
		nuevoEstadoPokemon.setPoder2Disponible(this.isPoder2Disponible());
		nuevoEstadoPokemon.setPoder3Disponible(this.isPoder3Disponible());
		ArrayList<enemigoGenerico> newDerrotados = new ArrayList<enemigoGenerico>();
		for(enemigoGenerico e : this.getDerrotados()) {
			newDerrotados.add((enemigoGenerico) e.clone());
		}
		nuevoEstadoPokemon.setDerrotados(newDerrotados);
		Nodo newUbicacion = this.getUbicacionActual().clone();
		nuevoEstadoPokemon.setUbicacionActual(newUbicacion);
		Mapa newMapa = this.getMapaMundiHeroe().clone();
		nuevoEstadoPokemon.setMapaMundiHeroe(newMapa);
		return null;
	}

	@Override
	public void updateState(Perception p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void initState() {
		// TODO Auto-generated method stub
		
	}

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	public float getEnergiaDisponible() {
		return energiaDisponible;
	}

	public void setEnergiaDisponible(float energiaDisponible) {
		this.energiaDisponible = energiaDisponible;
	}

	public int getContadorPoder1() {
		return contadorPoder1;
	}

	public void setContadorPoder1(int contadorPoder1) {
		this.contadorPoder1 = contadorPoder1;
	}

	public int getContadorPoder2() {
		return contadorPoder2;
	}

	public void setContadorPoder2(int contadorPoder2) {
		this.contadorPoder2 = contadorPoder2;
	}

	public int getContadorPoder3() {
		return contadorPoder3;
	}

	public void setContadorPoder3(int contadorPoder3) {
		this.contadorPoder3 = contadorPoder3;
	}

	public boolean isPoder1Disponible() {
		return poder1Disponible;
	}

	public void setPoder1Disponible(boolean poder1Disponible) {
		this.poder1Disponible = poder1Disponible;
	}

	public boolean isPoder2Disponible() {
		return poder2Disponible;
	}

	public void setPoder2Disponible(boolean poder2Disponible) {
		this.poder2Disponible = poder2Disponible;
	}

	public boolean isPoder3Disponible() {
		return poder3Disponible;
	}

	public void setPoder3Disponible(boolean poder3Disponible) {
		this.poder3Disponible = poder3Disponible;
	}

	public Nodo getUbicacionActual() {
		return ubicacionActual;
	}

	public void setUbicacionActual(Nodo ubicacionActual) {
		this.ubicacionActual = ubicacionActual;
	}

	public ArrayList<enemigoGenerico> getDerrotados() {
		return derrotados;
	}

	public void setDerrotados(ArrayList<enemigoGenerico> derrotados) {
		this.derrotados = derrotados;
	}

	public boolean isNoPelea() {
		return noPelea;
	}

	public void setNoPelea(boolean noPelea) {
		this.noPelea = noPelea;
	}

	public Mapa getMapaMundiHeroe() {
		return mapaMundiHeroe;
	}

	public void setMapaMundiHeroe(Mapa mapaMundiHeroe) {
		this.mapaMundiHeroe = mapaMundiHeroe;
	}

	public float getEnergiaInicial() {
		return energiaInicial;
	}

	public void setEnergiaInicial(float energiaInicial) {
		this.energiaInicial = energiaInicial;
	}
	
}
