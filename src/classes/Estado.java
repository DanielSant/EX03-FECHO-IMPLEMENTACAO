package classes;

public class Estado
{
	// atributos
	private String nome;
	private int id;
	private boolean isInicial;
	private boolean isFinal;
	// private boolean leuAeB;
	private double coordenaX;
	private double coordenaY;

	// construtor
	public Estado()
	{
	}

	public Estado(String name, int id, double coordX, double coordY)
	{
		this.nome = name;
		this.id = id;
		this.coordenaX = coordX;
		this.coordenaY = coordY;
	}

	// getters e setters
	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public boolean isInicial()
	{
		return isInicial;
	}

	public void setInicial(boolean isInicial)
	{
		this.isInicial = isInicial;
	}

	public boolean isFinal()
	{
		return isFinal;
	}

	public void setFinal(boolean isFinal)
	{
		this.isFinal = isFinal;
	}

	public double getCoordenaX()
	{
		return coordenaX;
	}

	public void setCoordenaX(double coordenaX)
	{
		this.coordenaX = coordenaX;
	}

	public double getCoordenaY()
	{
		return coordenaY;
	}

	public void setCoordenaY(double coordenaY)
	{
		this.coordenaY = coordenaY;
	}
}
