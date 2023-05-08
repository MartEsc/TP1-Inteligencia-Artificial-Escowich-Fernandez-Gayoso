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
				listaNodos.get(i).setOcupante(new enemigoGenerico(i+10000, 1,true));
				listaNodos.get(i).getOcupante().setUbicacionActualEnemigo(listaNodos.get(i));
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
		linkearNodos();
	}

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("Estado del environment ");

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
			listaEnemigos.add(new enemigoGenerico(i,(Math.abs(new Random().nextInt()%20)+1)));
			listaEnemigos.get(i).setUbicacionActualEnemigo(new Nodo(-1));
		}
		Collections.shuffle(listaEnemigos);
		
	}
	public void linkearNodos() {
		//nodo 1
		listaNodos.get(0).addVecino(listaNodos.get(1));
		listaNodos.get(0).addVecino(listaNodos.get(3));
		//nodo 2
		listaNodos.get(1).addVecino(listaNodos.get(0));
		listaNodos.get(1).addVecino(listaNodos.get(2));
		//nodo 3
		listaNodos.get(2).addVecino(listaNodos.get(1));
		listaNodos.get(2).addVecino(listaNodos.get(3));
		//nodo 4
		listaNodos.get(3).addVecino(listaNodos.get(0));
		listaNodos.get(3).addVecino(listaNodos.get(2));
		listaNodos.get(3).addVecino(listaNodos.get(4));
		listaNodos.get(3).addVecino(listaNodos.get(6));
		//nodo 5
		listaNodos.get(4).addVecino(listaNodos.get(3));
		listaNodos.get(4).addVecino(listaNodos.get(5));
		listaNodos.get(4).addVecino(listaNodos.get(7));
		//nodo 6
		listaNodos.get(5).addVecino(listaNodos.get(4));
		listaNodos.get(5).addVecino(listaNodos.get(6));
		//nodo 7
		listaNodos.get(6).addVecino(listaNodos.get(3));
		listaNodos.get(6).addVecino(listaNodos.get(5));
		listaNodos.get(6).addVecino(listaNodos.get(9));
		listaNodos.get(6).addVecino(listaNodos.get(28));
		//nodo 8
		listaNodos.get(7).addVecino(listaNodos.get(4));
		listaNodos.get(7).addVecino(listaNodos.get(8));
		listaNodos.get(7).addVecino(listaNodos.get(9));
		//nodo 9
		listaNodos.get(8).addVecino(listaNodos.get(7));
		//nodo 10
		listaNodos.get(9).addVecino(listaNodos.get(6));
		listaNodos.get(9).addVecino(listaNodos.get(7));
		listaNodos.get(9).addVecino(listaNodos.get(10));
		listaNodos.get(9).addVecino(listaNodos.get(11));
		//nodo 11
		listaNodos.get(10).addVecino(listaNodos.get(9));
		listaNodos.get(10).addVecino(listaNodos.get(11));
		listaNodos.get(10).addVecino(listaNodos.get(14));
		//nodo 12
		listaNodos.get(11).addVecino(listaNodos.get(9));
		listaNodos.get(11).addVecino(listaNodos.get(10));
		listaNodos.get(11).addVecino(listaNodos.get(12));
		//nodo 13
		listaNodos.get(12).addVecino(listaNodos.get(11));
		listaNodos.get(12).addVecino(listaNodos.get(13));
		listaNodos.get(12).addVecino(listaNodos.get(27));
		//nodo 14
		listaNodos.get(13).addVecino(listaNodos.get(12));
		listaNodos.get(13).addVecino(listaNodos.get(14));
		listaNodos.get(13).addVecino(listaNodos.get(15));
		listaNodos.get(13).addVecino(listaNodos.get(23));
		listaNodos.get(13).addVecino(listaNodos.get(27));
		//nodo 15
		listaNodos.get(14).addVecino(listaNodos.get(10));
		listaNodos.get(14).addVecino(listaNodos.get(13));
		//nodo 16
		listaNodos.get(15).addVecino(listaNodos.get(13));
		listaNodos.get(15).addVecino(listaNodos.get(16));
		listaNodos.get(15).addVecino(listaNodos.get(17));
		//nodo 17
		listaNodos.get(16).addVecino(listaNodos.get(15));
		//nodo 18
		listaNodos.get(17).addVecino(listaNodos.get(15));
		listaNodos.get(17).addVecino(listaNodos.get(18));
		//nodo 19
		listaNodos.get(18).addVecino(listaNodos.get(17));
		listaNodos.get(18).addVecino(listaNodos.get(19));
		listaNodos.get(18).addVecino(listaNodos.get(23));
		//nodo 20
		listaNodos.get(19).addVecino(listaNodos.get(18));
		listaNodos.get(19).addVecino(listaNodos.get(20));
		//nodo 21
		listaNodos.get(20).addVecino(listaNodos.get(19));
		listaNodos.get(20).addVecino(listaNodos.get(21));
		//nodo 22
		listaNodos.get(21).addVecino(listaNodos.get(20));
		listaNodos.get(21).addVecino(listaNodos.get(22));
		listaNodos.get(21).addVecino(listaNodos.get(25));
		//nodo 23
		listaNodos.get(22).addVecino(listaNodos.get(21));
		listaNodos.get(22).addVecino(listaNodos.get(23));
		//nodo 24
		listaNodos.get(23).addVecino(listaNodos.get(13));
		listaNodos.get(23).addVecino(listaNodos.get(18));
		listaNodos.get(23).addVecino(listaNodos.get(22));
		listaNodos.get(23).addVecino(listaNodos.get(24));
		//nodo 25
		listaNodos.get(24).addVecino(listaNodos.get(23));
		listaNodos.get(24).addVecino(listaNodos.get(25));
		//nodo 26
		listaNodos.get(25).addVecino(listaNodos.get(21));
		listaNodos.get(25).addVecino(listaNodos.get(24));
		listaNodos.get(25).addVecino(listaNodos.get(26));
		//nodo 27
		listaNodos.get(26).addVecino(listaNodos.get(25));
		listaNodos.get(26).addVecino(listaNodos.get(27));
		//nodo 28
		listaNodos.get(27).addVecino(listaNodos.get(12));
		listaNodos.get(27).addVecino(listaNodos.get(13));
		listaNodos.get(27).addVecino(listaNodos.get(26));
		listaNodos.get(27).addVecino(listaNodos.get(28));
		//nodo 29
		listaNodos.get(28).addVecino(listaNodos.get(6));
		listaNodos.get(28).addVecino(listaNodos.get(27));
	}
	public ArrayList<Nodo> getNodosVecinosAgente(int nodoActualAgente){
		return listaNodos.get(nodoActualAgente-1).getNodosVecinos();
	}

	public ArrayList<Nodo> getListaNodos() {
		return listaNodos;
	}

	public void setListaNodos(ArrayList<Nodo> listaNodos) {
		this.listaNodos = listaNodos;
	}

	public ArrayList<enemigoGenerico> getListaEnemigos() {
		return listaEnemigos;
	}

	public void setListaEnemigos(ArrayList<enemigoGenerico> listaEnemigos) {
		this.listaEnemigos = listaEnemigos;
	}

	public int getNodoActualAgente() {
		return nodoActualAgente;
	}

	public void setNodoActualAgente(int nodoActualAgente) {
		this.nodoActualAgente = nodoActualAgente;
	}

	public HashMap<Nodo, enemigoGenerico> getMapaEnemigos() {
		return mapaEnemigos;
	}

	public void setMapaEnemigos(HashMap<Nodo, enemigoGenerico> mapaEnemigos) {
		this.mapaEnemigos = mapaEnemigos;
	}

	public int getContadorSatelite() {
		return contadorSatelite;
	}

	public void setContadorSatelite(int contadorSatelite) {
		this.contadorSatelite = contadorSatelite;
	}
	

}
