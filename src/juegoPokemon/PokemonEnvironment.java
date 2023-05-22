package juegoPokemon;
import java.util.ArrayList;
import java.util.Random;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class PokemonEnvironment extends Environment{

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
		this.ciclosPokemones();
		PokemonPercepcion pokemonPerception = new PokemonPercepcion();
		int nodoActual = ((PokemonEnvironmentState) this.environmentState).nodoActualAgent;
		pokemonPerception.setNodosVecinos(((PokemonEnvironmentState) this.environmentState).getNodosVecinosAgente(nodoActual));
		for(Nodo nodo : ((PokemonEnvironmentState)this.environmentState).listaNodos) {
			if(nodo.getIdentificador()==nodoActual){
				pokemonPerception.setNodoActualAgente(nodo);
			}
		}		//pokemonPerception.setMapaHeroe(((PokemonEnvironmentState)this.environmentState).mapaEnemigos);
		return pokemonPerception;
	}
	
	private void ciclosPokemones() {
		for(Nodo n : ((PokemonEnvironmentState )this.environmentState).getListaNodos()) { //para cada nodo
				if(!n.hayPokebola  && n.getIdentificador() != 25) { // si tiene pokemon y no es el pokemon maestro
					if(n.getOcupante().getCiclosParaMoverse() > 0) //si todav no se tiene q mover, resto uno
						n.getOcupante().setCiclosParaMoverse(n.getOcupante().getCiclosParaMoverse()-1);
					else { //si se tiene que mover
						Integer s =this.moverPokemones(n); //lo muevo a un nodo vecino
						Random r = new Random(); 
						if(s != -1) { //si pudo mover seteo entre 1 y 3 la cant de ciclos y lo saco de donde estaba
							n.getOcupante().setCiclosParaMoverse(r.nextInt(3)+1);//seteo un random entre 1 y 3
						}
					}
				}
		}
	
	}
	

	private int moverPokemones(Nodo n) {
		int respuesta=-1;
		for(Nodo nodo : ((PokemonEnvironmentState) this.environmentState).getListaNodos()){
			if(nodo.getIdentificador() == n.getIdentificador()) {
				ArrayList<Nodo> vecinos = nodo.getNodosVecinos();
				Random r = new Random();
				ArrayList<Nodo> vecinosSinPokemones = new ArrayList<>();
				for(Nodo vecino : vecinos) {
					if(nodo.getOcupante().isDefeated() && !vecino.isHayPokebola())
						vecinosSinPokemones.add(vecino);
					if(vecinosSinPokemones.size() == 0) {
						respuesta= -1; //si no se puede mover a ninguno, salgo sin hacer nada
					}
					else {
						Nodo elegido = vecinosSinPokemones.get(r.nextInt(vecinosSinPokemones.size()));
						EnemigoGenerico enemigoAux = elegido.getOcupante();
						elegido.setOcupante(n.getOcupante());
						n.setOcupante(enemigoAux);
						respuesta = 1;
					}
				}
			}	
		}
		return respuesta;
	}

	@Override
    public boolean agentFailed(Action actionReturned) {
        float agentEnergy = this.getEnvironmentState().getEnergiaAgente();
        if (agentEnergy < 1f)
            return true;
        return false;
    }	
	@Override
    public String toString() {
        return environmentState.toString();
    }
}
