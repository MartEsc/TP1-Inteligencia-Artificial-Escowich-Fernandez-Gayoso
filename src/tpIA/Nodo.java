package tpIA;

import java.util.ArrayList;

public class Nodo {
	
	int identificador;
	enemigoGenerico ocupante;
	Boolean hayPokebola;
	ArrayList<Nodo> nodosVecinos;
	public Nodo(int identificador) {
		super();
		this.identificador = identificador;
		this.hayPokebola=false;
	}
	public int getIdentificador() {
		return identificador;
	}
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
	public enemigoGenerico getOcupante() {
		return ocupante;
	}
	public void setOcupante(enemigoGenerico ocupante) {
		this.ocupante = ocupante;
	}
	public Boolean getHayPokebola() {
		return hayPokebola;
	}
	public void setHayPokebola(Boolean hayPokebola) {
		this.hayPokebola = hayPokebola;
	}
	public ArrayList<Nodo> getNodosVecinos() {
		return nodosVecinos;
	}
	public void setNodosVecinos(ArrayList<Nodo> nodosVecinos) {
		this.nodosVecinos = nodosVecinos;
	}
	
	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("Nodo numero : "+ identificador +
					"  /  Hay pokebola?: "+ hayPokebola);
		if(!this.hayPokebola) {
			str.append("  /  Ocupante: "+ocupante);
		}
		else {
			str.append("  /  No hay ocupante\n");
		}
		return str.toString();
	}
	
	
}
