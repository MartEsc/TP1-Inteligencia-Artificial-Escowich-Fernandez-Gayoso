package tpIA;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgent;
import frsf.cidisi.faia.solver.search.BreathFirstSearch;
import frsf.cidisi.faia.solver.search.DepthFirstSearch;
import frsf.cidisi.faia.solver.search.Search;
import tpIA.acciones.escapar;
import tpIA.acciones.luchar;
import tpIA.acciones.moverANodoN;
import tpIA.acciones.recargarEnergia;
import tpIA.acciones.recargarEnergiaPokebola;
import tpIA.acciones.usarPoder1;
import tpIA.acciones.usarPoder2;
import tpIA.acciones.usarPoder3;
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
		operadores.addElement(new recargarEnergia());
		operadores.addElement(new luchar());
		operadores.addElement(new usarPoder1());
		operadores.addElement(new usarPoder2());
		operadores.addElement(new usarPoder3());
		operadores.addElement(new moverANodoN(26));
		operadores.addElement(new moverANodoN(1));
		operadores.addElement(new moverANodoN(2));
		operadores.addElement(new moverANodoN(3));
		operadores.addElement(new moverANodoN(4));
		operadores.addElement(new moverANodoN(5));
		operadores.addElement(new moverANodoN(6));
		operadores.addElement(new moverANodoN(7));
		operadores.addElement(new moverANodoN(8));
		operadores.addElement(new moverANodoN(9));
		operadores.addElement(new moverANodoN(10));
		operadores.addElement(new moverANodoN(11));
		operadores.addElement(new moverANodoN(12));
		operadores.addElement(new moverANodoN(13));
		operadores.addElement(new moverANodoN(14));
		operadores.addElement(new moverANodoN(15));
		operadores.addElement(new moverANodoN(16));
		operadores.addElement(new moverANodoN(17));
		operadores.addElement(new moverANodoN(18));
		operadores.addElement(new moverANodoN(19));
		operadores.addElement(new moverANodoN(20));
		operadores.addElement(new moverANodoN(21));
		operadores.addElement(new moverANodoN(22));
		operadores.addElement(new moverANodoN(23));
		operadores.addElement(new moverANodoN(24));
		operadores.addElement(new moverANodoN(25));
		
		operadores.addElement(new moverANodoN(27));
		operadores.addElement(new moverANodoN(28));
		operadores.addElement(new moverANodoN(29));
		operadores.addElement(new escapar());

		
		Problem problem = new Problem(objetivo, estado, operadores);
        this.setProblem(problem);
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
	@Override
	public void see(Perception p) {
        this.getAgentState().updateState(p);
    }

}
