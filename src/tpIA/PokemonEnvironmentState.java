package tpIA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

import frsf.cidisi.faia.state.EnvironmentState;

public class PokemonEnvironmentState extends EnvironmentState {
	
	
	ArrayList<Nodo> listaNodos;
	int nodoActualAgente = 1;
	HashMap<Nodo,enemigoGenerico> enemigosEnElMapa;
	int contadorSatelite;
	
	@Override
	public void initState() {
		listaNodos = new ArrayList<Nodo>();
		listaNodos.add(new Nodo(1));
		listaNodos.add(new Nodo(2));
		listaNodos.add(new Nodo(3));
		listaNodos.add(new Nodo(4));
		listaNodos.add(new Nodo(5));
		listaNodos.add(new Nodo(6));
		listaNodos.add(new Nodo(7));
		listaNodos.add(new Nodo(8));
		listaNodos.add(new Nodo(9));
		listaNodos.add(new Nodo(10));
		listaNodos.add(new Nodo(11));
		listaNodos.add(new Nodo(12));
		listaNodos.add(new Nodo(13));
		listaNodos.add(new Nodo(14));
		listaNodos.add(new Nodo(15));
		listaNodos.add(new Nodo(16));
		listaNodos.add(new Nodo(17));
		listaNodos.add(new Nodo(18));
		listaNodos.add(new Nodo(19));
		listaNodos.add(new Nodo(20));
		listaNodos.add(new Nodo(21));
		listaNodos.add(new Nodo(22));
		listaNodos.add(new Nodo(23));
		listaNodos.add(new Nodo(24));
		listaNodos.add(new Nodo(25));
		listaNodos.add(new Nodo(26));
		listaNodos.add(new Nodo(27));
		listaNodos.add(new Nodo(28));
		listaNodos.add(new Nodo(29));
		
		ArrayList<Integer> pokebolas = new ArrayList<Integer>(5);
		for(int i=0;i<5;i++) {
			pokebolas.add((ThreadLocalRandom.current().nextInt(1,30)));
			
		}
		for(int i=1;i<30;i++) {
			if(pokebolas.contains(i)) {
				listaNodos.get(i).setHayPokebola(true);
			}
			else {
				listaNodos.get(i).setOcupante(new enemigoGenerico());
			}
		}
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Nodo getAgentPosition() {
		return listaNodos.get(nodoActualAgente);
	}

}
