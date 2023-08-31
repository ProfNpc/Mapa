package belval.mapa;

import java.util.Scanner;

public class Mapa {
	
	private Local inicio;
	
	private Local fim;
	
	public Mapa(Local inicio, Local fim) {
		this.inicio = inicio;
		this.fim = fim;
	}
	
	public Local getInicio() {
		return this.inicio;
	}
}