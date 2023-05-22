package juegoPokemon;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;


public class PokemonSearchMain {
	public static File archivoLog;
	private static FileWriter writerLog;
	public static void main(String[] args) throws PrologConnectorException{
		  PokemonAgent pokemonAgent = new PokemonAgent();
		  PokemonEnvironment pokemonEnvironment = new PokemonEnvironment();
		  SearchBasedAgentSimulator pokemonSimulator = new SearchBasedAgentSimulator(pokemonEnvironment, pokemonAgent);
		  Random random = new Random();
		  float energiaInicial = 10f + random.nextFloat()*(20f-10f);
		  PokemonAgentState pokemonAgentState = (PokemonAgentState)pokemonAgent.getAgentState();
		  PokemonEnvironmentState pokemonEnvironmentState = (PokemonEnvironmentState)pokemonEnvironment.getEnvironmentState();
		  pokemonEnvironmentState.setEnergiaAgente(energiaInicial);
		  pokemonEnvironmentState.initState();
		  pokemonAgentState.setEnergiaInicial(energiaInicial);
		  pokemonAgentState.initState();

		  
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
