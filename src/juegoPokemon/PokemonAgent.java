package juegoPokemon;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgent;
import frsf.cidisi.faia.solver.search.BreathFirstSearch;
import frsf.cidisi.faia.solver.search.Search;
import juegoPokemon.accionnes.huir;
import juegoPokemon.accionnes.moverANodoN;
import juegoPokemon.accionnes.pelear;
import juegoPokemon.accionnes.tomarPokebolas;
import juegoPokemon.accionnes.usarPoder1;
import juegoPokemon.accionnes.usarPoder2;
import juegoPokemon.accionnes.usarPoder3;
import frsf.cidisi.faia.agent.search.Problem;

public class PokemonAgent extends SearchBasedAgent{

	public PokemonAgent() {
		ObjetivoPokemonAgent objetivo = new ObjetivoPokemonAgent();
		PokemonAgentState estado = new PokemonAgentState();
		this.setAgentState(estado);
		Vector<SearchAction> operadores = new Vector<SearchAction>();
		//Definir operadores aca
		operadores.addElement(new tomarPokebolas());
		operadores.addElement(new usarPoder1());
		operadores.addElement(new usarPoder2());
		operadores.addElement(new usarPoder3());
		operadores.addElement(new pelear());
		for(int i=0; i<29; i++) {
			operadores.addElement(new moverANodoN(i));	
		}
		operadores.addElement(new huir());
		Problem problem = new Problem(objetivo, estado, operadores);
		this.setProblem(problem);
	}
	
	@Override
	public void see(Perception p) {
		// TODO Auto-generated method stub
        this.getAgentState().updateState(p);
	}

	@Override
	public Action selectAction() {
		// TODO Auto-generated method stub
		BreathFirstSearch estrategia = new BreathFirstSearch();
		Search searcSolver = new Search(estrategia);
		searcSolver.setVisibleTree(Search.GRAPHVIZ_TREE);
		this.setSolver(searcSolver);
		Action accionSeleccionada = null;
		try {
			accionSeleccionada = this.getSolver().solve(new Object[] {this.getProblem()});
			} catch (Exception e) {
				// TODO: handle exception
				Logger.getLogger(PokemonAgent.class.getName()).log(Level.SEVERE, null, e);
			}
		return accionSeleccionada;	
	}

}
