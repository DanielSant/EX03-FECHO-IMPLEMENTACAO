package classes;

import java.util.ArrayList;

public class AutomatonDados
{
	// atributos
	ArrayList<Estado> estado = new ArrayList<>(); // objetos da classe Estado
	ArrayList<Transicao> transicao = new ArrayList<>(); // objetos da classe Transicao

	// getters e setters
	public ArrayList<Estado> getEstado()
	{
		return estado;
	}

	public void setEstado(ArrayList<Estado> estado)
	{
		this.estado = estado;
	}

	public ArrayList<Transicao> getTransicao()
	{
		return transicao;
	}

	public void setTransicao(ArrayList<Transicao> transicao)
	{
		this.transicao = transicao;
	}
}
