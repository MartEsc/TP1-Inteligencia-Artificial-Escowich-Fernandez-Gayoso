package tpIA;

import java.util.ArrayList;
import java.util.Map;

public class Mapa {
	private ArrayList<Nodo> listaNodos;
	private Map<Nodo, enemigoGenerico> enemigosEnElMapa;
	int contadorSatelite;
	
	public Mapa(ArrayList<Nodo> listaNodos, Map<Nodo, enemigoGenerico> enemigosEnElMapa, int contadorSatelite) {
		super();
		this.listaNodos = listaNodos;
		this.enemigosEnElMapa = enemigosEnElMapa;
		this.contadorSatelite = contadorSatelite;
	}

	public Mapa() {
		// TODO Auto-generated constructor stub
	}

	public Mapa clone(){
		Mapa newMapa = new Mapa();
		
		newMapa.setListaNodos(this.getListaNodos());
		newMapa.setEnemigosEnElMapa(this.getEnemigosEnElMapa());
		newMapa.setContadorSatelite(this.getContadorSatelite());

		return newMapa;
	}
	public ArrayList<Nodo> getListaNodos() {
		return listaNodos;
	}

	public void setListaNodos(ArrayList<Nodo> listaNodos) {
		this.listaNodos = listaNodos;
	}

	public Map<Nodo, enemigoGenerico> getEnemigosEnElMapa() {
		return enemigosEnElMapa;
	}

	public void setEnemigosEnElMapa(Map<Nodo, enemigoGenerico> enemigosEnElMapa) {
		this.enemigosEnElMapa = enemigosEnElMapa;
	}

	public int getContadorSatelite() {
		return contadorSatelite;
	}

	public void setContadorSatelite(int contadorSatelite) {
		this.contadorSatelite = contadorSatelite;
	}
	
	
	
}
