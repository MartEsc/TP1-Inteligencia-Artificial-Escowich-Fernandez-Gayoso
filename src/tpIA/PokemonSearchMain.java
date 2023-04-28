package tpIA;

import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;

public class PokemonSearchMain {
	public static void main(String[] args) {
		PokemonAgent pokemonAgent = new PokemonAgent();
		PokemonEnvironment pokemonEnvironment = new PokemonEnvironment();
		SearchBasedAgentSimulator pokemonSimulator = new SearchBasedAgentSimulator(pokemonEnvironment, pokemonAgent);
		
		pokemonEnvironment.getEnvironmentState().initState();
		System.out.println(pokemonEnvironment.toString());
		//pokemonSimulator.start();
	}
}
