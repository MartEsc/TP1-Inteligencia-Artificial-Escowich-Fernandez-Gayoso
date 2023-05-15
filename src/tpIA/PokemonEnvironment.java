package tpIA;

import frsf.cidisi.faia.agent.Action;
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
		pokemonPerception.setNodosVecinos(((PokemonEnvironmentState) this.environmentState).getNodosVecinosAgente(nodoActual));
		for(Nodo nodo : ((PokemonEnvironmentState)this.environmentState).listaNodos) {
			if(nodo.getIdentificador()==nodoActual){
				pokemonPerception.setNodoActualAgente(nodo);
			}
		}		//pokemonPerception.setMapaHeroe(((PokemonEnvironmentState)this.environmentState).mapaEnemigos);
		return pokemonPerception;
	}
	
	@Override
    public String toString() {
        return environmentState.toString();
    }
	
    @Override
    public boolean agentFailed(Action actionReturned) {
        float agentEnergy = this.getEnvironmentState().getEnergiaPokemon();
        if (agentEnergy < 1)
            return true;
        return false;
    }	
}
