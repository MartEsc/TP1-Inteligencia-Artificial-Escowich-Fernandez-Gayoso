package tpIA;

import java.util.ArrayList;

public class Nodo {
	
	int identificador;
	enemigoGenerico ocupante;
	boolean hayPokebola;
	boolean pokebolaTomada;
	ArrayList<Nodo> nodosVecinos;
	public Nodo(int identificador) {
		super();
		this.identificador = identificador;
		this.hayPokebola=false;
		this.pokebolaTomada=false;
		this.nodosVecinos = new ArrayList<Nodo>();
	}
	
	public Nodo() {
		// TODO Auto-generated constructor stub
	}

	public Nodo clone(){
		Nodo newNodo = new Nodo();
		
		newNodo.setIdentificador(this.getIdentificador());
		newNodo.setOcupante(this.getOcupante());
		newNodo.setNodosVecinos(this.getNodosVecinos());;
		newNodo.setHayPokebola(this.getHayPokebola());
		newNodo.setPokebolaTomada(this.isPokebolaTomada());
		
		return newNodo;
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
	public boolean getHayPokebola() {
		return hayPokebola;
	}
	public void setHayPokebola(boolean hayPokebola) {
		this.hayPokebola = hayPokebola;
	}
	public ArrayList<Nodo> getNodosVecinos() {
		return nodosVecinos;
	}
	public void setNodosVecinos(ArrayList<Nodo> nodosVecinos) {
		this.nodosVecinos = nodosVecinos;
	}
	public void addVecino(Nodo nodoVecino) {
		this.nodosVecinos.add(nodoVecino);
	}
	
	public boolean isPokebolaTomada() {
		return pokebolaTomada;
	}

	public void setPokebolaTomada(boolean pokebolaTomada) {
		this.pokebolaTomada = pokebolaTomada;
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
