package juegoPokemon;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;


public class PokemonSearchMain {
	public static File archivoLog;
	private static FileWriter writerLog;
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
			 writerLog = new FileWriter(archivoLog);
		      if (archivoLog.createNewFile()) {
		        System.out.println("File created: " + archivoLog.getName());
		      } else {
		        System.out.println("File already exists.");
		      }
		      writerLog.write("");
		      writerLog.write("intro\n");
		      writerLog.close();
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		pokemonSimulator.start();
	}
}
