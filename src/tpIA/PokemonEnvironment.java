package tpIA;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class PokemonEnvironment extends Environment {
	
	
	
	public PokemonEnvironment() {
		this.environmentState = new PokemonEnvironmentState();
	}
	
	@Override
	public PokemonEnvironmentState getEnvironmentState() {
		return (PokemonEnvironmentState) super.getEnvironmentState();
		
	}
	
	@Override
	public Perception getPercept() {
		PokemonPerception pokemonPerception = new PokemonPerception();
		int nodoActual = ((PokemonEnvironmentState) this.environmentState).nodoActualAgente;
		pokemonPerception.setVecinos(((PokemonEnvironmentState) this.environmentState).getNodosVecinosAgente(nodoActual));
		return pokemonPerception;
	}
	
	@Override
    public String toString() {
        return environmentState.toString();
    }
	

	
	
}
