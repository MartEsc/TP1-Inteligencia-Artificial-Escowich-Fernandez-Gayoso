package tpIA;

import java.util.ArrayList;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class PokemonPerception extends Perception {
	
	ArrayList<Nodo> nodosVecinos;
	int nodoActualAgente;
	@Override
	public void initPerception(Agent agent, Environment environment) {
		PokemonAgent pokemonAgent = (PokemonAgent) agent;
		PokemonEnvironment pokemonEnvironment = (PokemonEnvironment) environment;
		PokemonEnvironmentState pokemonEnvironmentState = pokemonEnvironment.getEnvironmentState();
		nodoActualAgente = pokemonEnvironmentState.getAgentPosition().identificador;
		nodosVecinos = pokemonEnvironmentState.getNodosVecinosAgente(nodoActualAgente);
		
	};
	
	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("Estado percepcion pokemon");
		str.append("; ");
		str.append(nodoActualAgente);
		return str.toString();
	}
	
	
}
