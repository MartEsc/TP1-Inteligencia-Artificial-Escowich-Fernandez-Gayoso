package tpIA;


public class enemigoGenerico {
	
	int identificador;
	int energia;
	int ubicacionActualEnemigo;
	Boolean defeated;
	
	
	
	
	public enemigoGenerico(int identificador, int energia) {
		super();
		this.identificador = identificador;
		this.energia = energia;
		this.defeated = false;
		
	}
	public enemigoGenerico(int identificador, int energia,Boolean defeated) {
		super();
		this.identificador = identificador;
		this.energia = energia;
		this.defeated = defeated;
		
	}
	
	public enemigoGenerico() {
		// TODO Auto-generated constructor stub
	}

	public enemigoGenerico clone(){
		enemigoGenerico newEnemigoGenetico = new enemigoGenerico();
		newEnemigoGenetico.setIdentificador(this.getIdentificador());
		newEnemigoGenetico.setEnergia(this.getEnergia());
		newEnemigoGenetico.setUbicacionActualEnemigo(this.getUbicacionActualEnemigo());
		newEnemigoGenetico.setDefeated(this.getDefeated());		
		return newEnemigoGenetico;
	}
	
	public int getIdentificador() {
		return identificador;
	}
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
	public int getEnergia() {
		return energia;
	}
	public void setEnergia(int energia) {
		this.energia = energia;
	}
	public int getUbicacionActualEnemigo() {
		return ubicacionActualEnemigo;
	}
	public void setUbicacionActualEnemigo(int ubicacionActualEnemigo) {
		this.ubicacionActualEnemigo = ubicacionActualEnemigo;
	}
	public Boolean getDefeated() {
		return defeated;
	}
	public void setDefeated(Boolean defeated) {
		this.defeated = defeated;
	}
	
	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("Id: ");
		str.append(this.identificador);
		str.append("  /  ");
		str.append("Energia: ");
		str.append(this.energia);
		str.append("  /  ");
		str.append("Posicion: ");
		str.append(this.ubicacionActualEnemigo + "\n");
		return str.toString();
	}
	
	
}
