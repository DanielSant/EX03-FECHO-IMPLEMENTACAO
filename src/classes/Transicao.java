package classes;

public class Transicao
{
	// atributos
	private String simbolLeitura; // Identificador do simbolo de leitura
	private int origem;
	private int destino;

	// getters e setters
	public String getSimbolLeitura()
	{
		return simbolLeitura;
	}

	public void setSimbolLeitura(String simbolLeitura)
	{
		this.simbolLeitura = simbolLeitura;
	}

	public int getOrigem()
	{
		return origem;
	}

	public void setOrigem(int origem)
	{
		this.origem = origem;
	}

	public int getDestino()
	{
		return destino;
	}

	public void setDestino(int destino)
	{
		this.destino = destino;
	}
}
