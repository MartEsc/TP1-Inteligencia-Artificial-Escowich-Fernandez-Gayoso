package juegoPokemon;

public class EnemigoGenerico {
	int identificador;
	int energia;
	int ubicacionActualEnemigo;
	int ciclosParaMoverse;
	boolean defeated;
	boolean esBoss;
	public EnemigoGenerico(int identificador, int energia, int ubicacionActualEnemigo, boolean defeated,
			boolean esBoss) {
		super();
		this.identificador = identificador;
		this.energia = energia;
		this.ubicacionActualEnemigo = ubicacionActualEnemigo;
		this.defeated = defeated;
		this.esBoss = esBoss;
	}
	
	public EnemigoGenerico(int identificador, int energia, boolean defeated, boolean esBoss) {
		super();
		this.identificador = identificador;
		this.energia = energia;
		this.defeated = defeated;
		this.esBoss = esBoss;
	}

	public EnemigoGenerico(int identificador, boolean isDefetead) {
		super();
		this.identificador = identificador;
		this.defeated = isDefetead;
	}

	public EnemigoGenerico clone() {
		int newIdentificador = this.getIdentificador();
		int newEnergia = this.getEnergia();
		int newUbicacionActualEnemigo = this.getUbicacionActualEnemigo();
		boolean newDefeated = this.isDefeated();
		boolean newEsBoss = this.isEsBoss();
		EnemigoGenerico newEnemigo = new EnemigoGenerico(newIdentificador, newEnergia, newUbicacionActualEnemigo, newDefeated, newEsBoss);
		return newEnemigo;
	}
	
	public EnemigoGenerico() {
		super();
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
	public boolean isDefeated() {
		return defeated;
	}
	public void setDefeated(boolean defeated) {
		this.defeated = defeated;
	}
	public boolean isEsBoss() {
		return esBoss;
	}
	public void setEsBoss(boolean esBoss) {
		this.esBoss = esBoss;
	}
	
	public int getCiclosParaMoverse() {
		return ciclosParaMoverse;
	}

	public void setCiclosParaMoverse(int ciclosParaMoverse) {
		this.ciclosParaMoverse = ciclosParaMoverse;
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
