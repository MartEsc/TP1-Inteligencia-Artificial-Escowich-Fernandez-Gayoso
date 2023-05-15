package tpIA;

import java.util.ArrayList;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class PokemonPerception extends Perception {
	
	ArrayList<Nodo> nodosVecinos;
	Nodo nodoActualAgente;
	Mapa mapaHeroe;
	float energiaActual;
	
	
	public PokemonPerception(Agent agent, Environment environment) {
		super(agent, environment);
	}
	
	public PokemonPerception() {
		energiaActual = 30;
	}

	@Override
	public void initPerception(Agent agent, Environment environment) {
		PokemonAgent pokemonAgent = (PokemonAgent) agent;
		PokemonEnvironment pokemonEnvironment = (PokemonEnvironment) environment;
		PokemonEnvironmentState pokemonEnvironmentState = pokemonEnvironment.getEnvironmentState();
		nodoActualAgente = pokemonEnvironmentState.getAgentPosition();
		nodosVecinos = pokemonEnvironmentState.getNodosVecinosAgente(nodoActualAgente.getIdentificador());
		//mapaHeroe = new Mapa(pokemonEnvironmentState.getListaNodos(), pokemonEnvironmentState.getMapaEnemigos(), pokemonEnvironmentState.getContadorSatelite());
		//System.out.println("Init Perception");
	};
	
	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("Estado percepcion pokemon");
		str.append("; ");
		str.append(nodoActualAgente);
		return str.toString();
	}


	public ArrayList<Nodo> getNodosVecinos() {
		return nodosVecinos;
	}

	public void setNodosVecinos(ArrayList<Nodo> nodosVecinos) {
		this.nodosVecinos = nodosVecinos;
	}

	public Nodo getNodoActualAgente() {
		return nodoActualAgente;
	}

	public void setNodoActualAgente(Nodo nodoActualAgente) {
		this.nodoActualAgente = nodoActualAgente;
	}

	public Mapa getMapaHeroe() {
		return mapaHeroe;
	}

	public void setMapaHeroe(Mapa mapaHeroe) {
		this.mapaHeroe = mapaHeroe;
	}

	public float getEnergiaActual() {
		return energiaActual;
	}

	public void setEnergiaActual(float energiaActual) {
		this.energiaActual = energiaActual;
	}
	
}
