package tpIA;

public class enemigoGenerico {
	
	int identificador;
	int energia;
	Nodo ubicacionActualEnemigo;
	Boolean defeated;
	
	
	
	
	public enemigoGenerico(int identificador, int energia) {
		super();
		this.identificador = identificador;
		this.energia = energia;
		this.defeated = false;
		
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
	public Nodo getUbicacionActualEnemigo() {
		return ubicacionActualEnemigo;
	}
	public void setUbicacionActualEnemigo(Nodo ubicacionActualEnemigo) {
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
		str.append(this.ubicacionActualEnemigo.getIdentificador() + "\n");
		return str.toString();
	}
	
	
}
