package juegoPokemon;

import java.util.ArrayList;
import java.util.HashMap;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

public class PokemonAgentState extends SearchBasedAgentState{
	private float energiaDisponible;
	private float energiaInicial;
	private float energiaGanada;
	private int contadorPoder1;
	private int contadorPoder2;
	private int contadorPoder3;
	private boolean poder1Disponible;
	private boolean poder2Disponible;
	private boolean poder3Disponible;
	private Nodo ubicacionActual;
	private boolean noPelea;
	private HashMap<Nodo, EnemigoGenerico> mapaMundiHeroe;
	private boolean bossDerrotado;
	
	public PokemonAgentState(float energiaDisponible, float energiaInicial, float energiaGanada, int contadorPoder1,
			int contadorPoder2, int contadorPoder3, boolean poder1Disponible, boolean poder2Disponible,
			boolean poder3Disponible, Nodo ubicacionActual, boolean noPelea,
			boolean bossDerrotado) {
		super();
		this.energiaDisponible = energiaDisponible;
		this.energiaInicial = energiaInicial;
		this.energiaGanada = energiaGanada;
		this.contadorPoder1 = contadorPoder1;
		this.contadorPoder2 = contadorPoder2;
		this.contadorPoder3 = contadorPoder3;
		this.poder1Disponible = poder1Disponible;
		this.poder2Disponible = poder2Disponible;
		this.poder3Disponible = poder3Disponible;
		this.ubicacionActual = ubicacionActual;
		this.noPelea = noPelea;
		this.bossDerrotado = bossDerrotado;
	}

	public PokemonAgentState() {
		super();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		PokemonAgentState estadoComparado = (PokemonAgentState) obj;
		boolean mismaEnergia = estadoComparado.getEnergiaDisponible()==this.getEnergiaDisponible();
		boolean mismaEnergiaGanada = estadoComparado.getEnergiaGanada()==this.getEnergiaGanada();
		boolean mismaUbicacion = estadoComparado.getUbicacionActual().equals(this.getUbicacionActual());
		boolean sigueSinPelear = (this.noPelea && estadoComparado.isNoPelea());
		return (mismaEnergia && mismaUbicacion && mismaEnergiaGanada && sigueSinPelear);
	}

	@Override
	public SearchBasedAgentState clone() {
		// TODO Auto-generated method stub
		float nuevaEnergiaDisponible = this.getEnergiaDisponible();
		float nuevaEnergiaInicial = this.getEnergiaInicial();
		float nuevaEnergiaGanada = this.getEnergiaGanada();
		int nuevoContadorPoder1 = this.getContadorPoder1();
		int nuevoContadorPoder2 = this.getContadorPoder2();
		int nuevoContadorPoder3 = this.getContadorPoder3();
		boolean nuevoSetPoder1Disponible = this.isPoder1Disponible();
		boolean nuevoSetPoder2Disponible = this.isPoder2Disponible();
		boolean nuevoSetPoder3Disponible = this.isPoder3Disponible();
		boolean nuevoNoPelea = this.isNoPelea();
		boolean nuevoBossDerrotado = this.isBossDerrotado();
		Nodo nuevaUbicacion = this.getUbicacionActual().clone();
		PokemonAgentState nuevoEstadoPokemon = new PokemonAgentState(nuevaEnergiaDisponible, nuevaEnergiaInicial, nuevaEnergiaGanada, nuevoContadorPoder1, nuevoContadorPoder2, 
				nuevoContadorPoder3, nuevoSetPoder1Disponible, nuevoSetPoder2Disponible, nuevoSetPoder3Disponible, nuevaUbicacion,
				nuevoNoPelea, nuevoBossDerrotado);
		return nuevoEstadoPokemon;
	}

	@Override
	public void updateState(Perception p) {
		// TODO Auto-generated method stub
		PokemonPercepcion percepcion = (PokemonPercepcion) p;
		this.setUbicacionActual(percepcion.getNodoActualAgente());
		this.getUbicacionActual().setNodosVecinos(percepcion.getNodosVecinos());
		if(this.getContadorPoder1()>=3) {
			this.setContadorPoder1(0);
		}
		else {
			this.setContadorPoder1(getContadorPoder1()+1);
		}
		if(this.getContadorPoder2()>=3) {
			this.setContadorPoder2(0);
		}
		else {
			this.setContadorPoder2(getContadorPoder2()+1);
		}
		if(this.getContadorPoder3()>=3) {
			this.setContadorPoder3(0);
		}
		else {
			this.setContadorPoder3(getContadorPoder3()+1);
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str = ""; 
        str = str + "\nPosicion = "+ this.getUbicacionActual()  +"\n"; 
        str = str + "Energia = " + this.getEnergiaDisponible() + "\n"; 
        return str;
	}

	@Override
	public void initState() {
		// TODO Auto-generated method stub
		energiaInicial= 30f;
		energiaDisponible = energiaInicial;
		energiaGanada = 0f;
		contadorPoder1=0;
		contadorPoder2=0;
		contadorPoder3=0;
		poder1Disponible=false;
		poder2Disponible=false;
		poder3Disponible=false;
		noPelea=false;
		bossDerrotado=false;
		mapaMundiHeroe = new HashMap<Nodo, EnemigoGenerico>();
	}

	public float getEnergiaDisponible() {
		return energiaDisponible;
	}

	public void setEnergiaDisponible(float energiaDisponible) {
		this.energiaDisponible = energiaDisponible;
	}

	public float getEnergiaInicial() {
		return energiaInicial;
	}

	public void setEnergiaInicial(float energiaInicial) {
		this.energiaInicial = energiaInicial;
	}

	public float getEnergiaGanada() {
		return energiaGanada;
	}

	public void setEnergiaGanada(float energiaGanada) {
		this.energiaGanada = energiaGanada;
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

	public boolean isNoPelea() {
		return noPelea;
	}

	public void setNoPelea(boolean noPelea) {
		this.noPelea = noPelea;
	}

	public HashMap<Nodo, EnemigoGenerico> getMapaMundiHeroe() {
		return mapaMundiHeroe;
	}

	public void setMapaMundiHeroe(HashMap<Nodo, EnemigoGenerico> mapaMundiHeroe) {
		this.mapaMundiHeroe = mapaMundiHeroe;
	}

	public boolean isBossDerrotado() {
		return bossDerrotado;
	}

	public void setBossDerrotado(boolean bossDerrotado) {
		this.bossDerrotado = bossDerrotado;
	}

}
