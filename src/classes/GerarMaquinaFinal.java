package classes;

import java.util.ArrayList;

public class GerarMaquinaFinal
{
	private Estado estadosMaqFinal;
	private Transicao transicoesMaqFinal;
	private int transicaoAuto1Origem;
	private int transicaoAuto2Origem;
	private int transicaoAuto1Destino;
	private int transicaoAuto2Destino;
	private String simboloDeLeitura;
	private boolean isFinalAnto1AndAuto12;
	private boolean readAandB;

	public Estado getEstadosMaqFinal()
	{
		return estadosMaqFinal;
	}

	public void setEstadosMaqFinal(Estado estadosMaqFinal)
	{
		this.estadosMaqFinal = estadosMaqFinal;
	}

	public Transicao getTransicoesMaqFinal()
	{
		return transicoesMaqFinal;
	}

	public void setTransicoesMaqFinal(Transicao transicoesMaqFinal)
	{
		this.transicoesMaqFinal = transicoesMaqFinal;
	}

	public int getTransicaoAuto1Origem()
	{
		return transicaoAuto1Origem;
	}

	public void setTransicaoAuto1Origem(int transicaoAuto1Origem)
	{
		this.transicaoAuto1Origem = transicaoAuto1Origem;
	}

	public int getTransicaoAuto2Origem()
	{
		return transicaoAuto2Origem;
	}

	public void setTransicaoAuto2Origem(int transicaoAuto2Origem)
	{
		this.transicaoAuto2Origem = transicaoAuto2Origem;
	}

	public int getTransicaoAuto1Destino()
	{
		return transicaoAuto1Destino;
	}

	public void setTransicaoAuto1Destino(int transicaoAuto1Destino)
	{
		this.transicaoAuto1Destino = transicaoAuto1Destino;
	}

	public int getTransicaoAuto2Destino()
	{
		return transicaoAuto2Destino;
	}

	public void setTransicaoAuto2Destino(int transicaoAuto2Destino)
	{
		this.transicaoAuto2Destino = transicaoAuto2Destino;
	}

	public String getSimboloDeLeitura()
	{
		return simboloDeLeitura;
	}

	public void setSimboloDeLeitura(String simboloDeLeitura)
	{
		this.simboloDeLeitura = simboloDeLeitura;
	}

	public boolean isFinalAnto1AndAuto12()
	{
		return isFinalAnto1AndAuto12;
	}

	public void setFinalAnto1AndAuto12(boolean isFinalAnto1AndAuto12)
	{
		this.isFinalAnto1AndAuto12 = isFinalAnto1AndAuto12;
	}

	public boolean isReadAandB()
	{
		return readAandB;
	}

	public void setReadAandB(boolean readAandB)
	{
		this.readAandB = readAandB;
	}

	public void manipularTransicoes(AutomatonDados dadosAuto1, AutomatonDados dadosAuto2, AutomatonDados maquinaFinal)
	{
		ArrayList<GerarMaquinaFinal> MaqFinal = new ArrayList<GerarMaquinaFinal>();
		int contParaIds = 0;
		int contParaIdsInicialAux = 0; // usar no auto2 para ficar a informações no mesmo id
		int contParaIdsFinalAux = 0; // usar no auto2 para ficar a informações no mesmo id
		
		// for() para pegar os estados iniciais e final do auto1 e setar para o da maquinaresultante.
		for (Estado estAuto1 : dadosAuto1.getEstado())
		{
			if (estAuto1.isInicial())
			{
				estadosMaqFinal.setId(contParaIds);
				contParaIdsInicialAux = contParaIds;
				setTransicaoAuto1Origem(estAuto1.getId());
				System.out.println(estAuto1.getId());
				estadosMaqFinal.setNome(estAuto1.getNome());
				System.out.println(estAuto1.getNome());
				estadosMaqFinal.setInicial(true);
				
				contParaIds++;
			}
			
			if (estAuto1.isFinal())
			{
				estadosMaqFinal.setId(contParaIds);
				setTransicaoAuto1Origem(estAuto1.getId());
			}
		} // fim do for() para o auto1 
		
		// for() para pegar os estados iniciais e final do auto2 e setar para o da maquinaresultante.
		for (Estado estAuto2 : dadosAuto2.getEstado())
		{
			if (estAuto2.isInicial())
			{
				setTransicaoAuto1Origem(estAuto2.getId());
				System.out.println(estAuto2.getId());
				estadosMaqFinal.setNome(estadosMaqFinal.getNome() + "," + estAuto2.getNome());
				System.out.println(estAuto2.getNome());
				estadosMaqFinal.setInicial(true);						
			}
		} // fim do for() para o auto2
	
	} // fim do método manipularTransicoes();

} // fim da classe GerarMaquinaFinal;
