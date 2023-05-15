package tpIA;

import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;
import java.io.File;
import java.io.IOException; 


public class PokemonSearchMain {
	public static File archivoLog;
	public static void main(String[] args) throws PrologConnectorException{
		PokemonAgent pokemonAgent = new PokemonAgent();
		PokemonEnvironment pokemonEnvironment = new PokemonEnvironment();
		SearchBasedAgentSimulator pokemonSimulator = new SearchBasedAgentSimulator(pokemonEnvironment, pokemonAgent);
		
		pokemonEnvironment.getEnvironmentState().initState();
		//System.out.println(pokemonEnvironment.toString());
		((PokemonAgentState) pokemonAgent.getAgentState()).initState();
		((PokemonAgentState)pokemonAgent.getAgentState()).setUbicacionActual(((PokemonEnvironmentState)pokemonEnvironment.getEnvironmentState()).getAgentPosition());
		 try {
			 archivoLog = new File("logAcciones.txt");
		      if (archivoLog.createNewFile()) {
		        System.out.println("File created: " + archivoLog.getName());
		      } else {
		        System.out.println("File already exists.");
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		pokemonSimulator.start();
	}
}
