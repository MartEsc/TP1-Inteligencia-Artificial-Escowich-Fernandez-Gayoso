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
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
    public String toString() {
        return environmentState.toString();
    }
	
	public void getVecinos() {
		
	}
	
	
}
