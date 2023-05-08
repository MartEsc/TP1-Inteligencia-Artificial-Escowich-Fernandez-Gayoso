package tpIA;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgent;
import frsf.cidisi.faia.solver.search.Search;
import tpIA.acciones.huir;
import tpIA.acciones.moverANodoAdyacente;
import tpIA.acciones.pelear;
import tpIA.acciones.recargarEnergiaPokebola;
import frsf.cidisi.faia.agent.search.Problem;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PokemonAgent extends SearchBasedAgent {

	public PokemonAgent() {
		ObjetivoPokemonAgent objetivo = new ObjetivoPokemonAgent();
		PokemonAgentState estado = new PokemonAgentState();
		this.setAgentState(estado);
		//operadores
		Vector<SearchAction> operadores = new Vector<SearchAction>();
		operadores.addElement(new moverANodoAdyacente());
		operadores.addElement(new pelear());
		operadores.addElement(new huir());
		operadores.addElement(new recargarEnergiaPokebola());;
		Problem problem = new Problem(objetivo, estado, operadores);
        this.setProblem(problem);
	}
	@Override
	public Action selectAction() {
		// TODO Auto-generated method stub
		DepthFirstSearch estrategia = new DepthFirstSearch();
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
	@Override
	public void see(Perception p) {
        this.getAgentState().updateState(p);
    }

}
