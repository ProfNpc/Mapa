package belval.mapa;

import java.util.Scanner;

public class Local {
	
	private String descricao;
	
	private Local norte;
	
	private Local sul;
	
	private Local leste;
	
	private Local oeste;
	
	public Local(String descricao) {
		this.descricao = descricao;
	}
	
	public String Descricao() {
		return descricao;
	}
	
	public Local irNorte(){
		if (norte == null) {
			return this;
		}
		return norte;
	}
	
	public Local irSul(){
		if (sul == null) {
			return this;
		}
		return sul;
	}
	
	public Local irLeste(){
		if (leste == null) {
			return this;
		}
		return leste;
	}
	
	public Local irOeste(){
		if (oeste == null) {
			return this;
		}
		return oeste;
	}

	public void addNorte(Local local) {
		this.norte = local;
		if (local.sul != this) {
			local.addSul(this);
		}
	}

	public void addSul(Local local) {
		this.sul = local;
		if (local.norte != this) {
			local.addNorte(this);
		}
	}

	public void addLeste(Local local) {
		this.leste = local;
		if (local.oeste != this) {
			local.addOeste(this);
		}
	}

	public void addOeste(Local local) {
		this.oeste = local;
		if (local.leste != this) {
			local.addLeste(this);
		}
	}

	public String getDescricao() {
		return this.descricao;
	}
	
	
}