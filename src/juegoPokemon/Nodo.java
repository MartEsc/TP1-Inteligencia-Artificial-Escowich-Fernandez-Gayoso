package juegoPokemon;

import java.util.ArrayList;



public class Nodo {
	
	int identificador;
	EnemigoGenerico ocupante;
	boolean hayPokebola;
	boolean pokebolaTomada;
	ArrayList<Nodo> nodosVecinos;
	
	
	public Nodo() {
		super();
	}
	
	
	public Nodo(int identificador) {
		super();
		this.identificador = identificador;
		this.hayPokebola=false;
		this.pokebolaTomada=false;
		this.nodosVecinos = new ArrayList<Nodo>();
	}


	public Nodo(int identificador, EnemigoGenerico ocupante, boolean hayPokebola, boolean pokebolaTomada,
			ArrayList<Nodo> nodosVecinos) {
		super();
		this.identificador = identificador;
		this.ocupante = ocupante;
		this.hayPokebola = hayPokebola;
		this.pokebolaTomada = pokebolaTomada;
		this.nodosVecinos = nodosVecinos;
	}


	public Nodo clone() {
		int newIdentificador = this.getIdentificador();
		EnemigoGenerico newEnemigo = this.getOcupante().clone();
		boolean newHayPokebola = this.isHayPokebola();
		boolean newPokebolaTomada = this.isPokebolaTomada();
		ArrayList<Nodo> newNodosVecinos = this.getNodosVecinos();
		Nodo newNodo = new Nodo(newIdentificador, newEnemigo, newHayPokebola, newPokebolaTomada, newNodosVecinos);
		return newNodo;
	}


	public int getIdentificador() {
		return identificador;
	}


	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}


	public EnemigoGenerico getOcupante() {
		return ocupante;
	}


	public void setOcupante(EnemigoGenerico ocupante) {
		this.ocupante = ocupante;
	}


	public boolean isHayPokebola() {
		return hayPokebola;
	}


	public void setHayPokebola(boolean hayPokebola) {
		this.hayPokebola = hayPokebola;
	}


	public boolean isPokebolaTomada() {
		return pokebolaTomada;
	}


	public void setPokebolaTomada(boolean pokebolaTomada) {
		this.pokebolaTomada = pokebolaTomada;
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
	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
//		str.append("Nodo numero : "+ identificador +
//					"  /  Hay pokebola?: "+ hayPokebola);
//		if(!this.hayPokebola) {
//			str.append("  /  Ocupante: "+ocupante);
//		}
//		else {
//			str.append("  /  No hay ocupante\n");
//		}
		str.append(identificador);
		return str.toString();
	}
	
}
