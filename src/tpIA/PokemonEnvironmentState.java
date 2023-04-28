package tpIA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import frsf.cidisi.faia.state.EnvironmentState;

public class PokemonEnvironmentState extends EnvironmentState {
	
	
	ArrayList<Nodo> listaNodos = new ArrayList<>();
	ArrayList<enemigoGenerico> listaEnemigos = new ArrayList<enemigoGenerico>();
	HashMap<Nodo,enemigoGenerico> mapaEnemigos = new HashMap<>();
	ArrayList<Integer> pokebolas;
	int nodoActualAgente = 1;
	int contadorSatelite;
	
	@Override
	public void initState() {
		listaNodos = new ArrayList<Nodo>();
		listaNodos.add(new Nodo(0));
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
		
		generarEnemigos();
		pokebolas = new ArrayList<Integer>(5);
		System.out.println(pokebolas.toString());
		for(int i=0;i<5;i++) {
			int newInt = new Random().nextInt(1,30);
			if(!pokebolas.contains(newInt)) {
				pokebolas.add(newInt);
			}
			else {
				i--;
			}
			
		}
		System.out.println(pokebolas.toString());
		int iteradorEnemigos = 0;
		for(int i=0;i<29;i++) {
			if(pokebolas.contains((Integer) i)) {
				listaNodos.get(i).setHayPokebola(true);
			}
			else {
				System.out.println("Iterador enemigos "+iteradorEnemigos+"\n i: "+i);
				listaNodos.get(i).setOcupante(listaEnemigos.get(iteradorEnemigos));
				
				listaEnemigos.get(iteradorEnemigos).setUbicacionActualEnemigo(listaNodos.get(i));
				System.out.println("Nodo "+i+"  "+listaNodos.get(i).getOcupante()+"\n");
				mapaEnemigos.put(listaNodos.get(i),listaEnemigos.get(iteradorEnemigos));
				iteradorEnemigos++;
			}
		}
		
	}

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("Estado del environment ");
		/*
		 * str.append(listaNodos.toString()); for (enemigoGenerico enemigoGenerico :
		 * listaEnemigos) { str.append(enemigoGenerico.toString()+"\n"); } for(int
		 * i=0;i<5;i++) { str.append("Pokebola "+(i+1)+" :"+pokebolas.get(i)+"\n"); }
		 * str.append("Cant nodos: \n"); str.append(listaNodos.size());
		 * str.append("\nCant enemigos: \n"); str.append(listaEnemigos.size());
		 */
		for (Nodo nodo : listaNodos) {
			str.append(nodo.toString()+"\n");
		}
		return str.toString();
	}
	
	public Nodo getAgentPosition() {
		return listaNodos.get(nodoActualAgente);
	}
	
	public void generarEnemigos() {
		for(int i=0;i<25;i++) {
			listaEnemigos.add(new enemigoGenerico(i,Math.abs(new Random().nextInt()%20)));
			listaEnemigos.get(i).setUbicacionActualEnemigo(new Nodo(-1));
		}
		Collections.shuffle(listaEnemigos);
		
	}

}
