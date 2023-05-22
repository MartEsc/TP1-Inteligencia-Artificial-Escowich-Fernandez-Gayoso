package juegoPokemon;

import java.util.ArrayList;
import java.util.Map;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class PokemonPercepcion extends Perception{

	public ArrayList<Nodo> nodosVecinos;
	public Nodo nodoActualAgente;

	
	
	public PokemonPercepcion(Agent agent, Environment environment) {
		super(agent, environment);
	}
	
	
	public PokemonPercepcion() {
		super();
	}


	@Override
	public void initPerception(Agent agent, Environment environment) {
		// TODO Auto-generated method stub
		PokemonAgent pokemonAgent = (PokemonAgent) agent;
		PokemonEnvironment pokemonEnvironment = (PokemonEnvironment) environment;
		PokemonEnvironmentState pokemonEnvironmentState = pokemonEnvironment.getEnvironmentState();
		nodoActualAgente = pokemonEnvironmentState.getAgentPosition();
		nodosVecinos = pokemonEnvironmentState.getNodosVecinosAgente(nodoActualAgente.getIdentificador());
		
	}
	
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

	
}
