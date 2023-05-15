package tpIA;

import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;

public class PokemonSearchMain {
	public static void main(String[] args) throws PrologConnectorException{
		PokemonAgent pokemonAgent = new PokemonAgent();
		PokemonEnvironment pokemonEnvironment = new PokemonEnvironment();
		SearchBasedAgentSimulator pokemonSimulator = new SearchBasedAgentSimulator(pokemonEnvironment, pokemonAgent);
		
		pokemonEnvironment.getEnvironmentState().initState();
		//System.out.println(pokemonEnvironment.toString());
		((PokemonAgentState) pokemonAgent.getAgentState()).initState();
		((PokemonAgentState)pokemonAgent.getAgentState()).setUbicacionActual(((PokemonEnvironmentState)pokemonEnvironment.getEnvironmentState()).getAgentPosition());
		pokemonSimulator.start();
	}
}
