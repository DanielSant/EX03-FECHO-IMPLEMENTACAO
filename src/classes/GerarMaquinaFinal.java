package classes;

import java.util.ArrayList;

public class GerarMaquinaFinal extends Estado
{
	private int transMaquinaFinalOrigem;
	private int transMaquinaFinalDestino;
	private int idMaquinaFinal;
	private int transicaoAuto1Origem;
	private int transicaoAuto2Origem;
	private int transicaoAuto1Destino;
	private int transicaoAuto2Destino;
	private String simboloDeLeitura;
	private boolean isFinalAnto1AndAuto2;
	private boolean readAandB;
	private String ids;

	public int getTransMaquinaFinalOrigem()
	{
		return transMaquinaFinalOrigem;
	}

	public void setTransMaquinaFinalOrigem(int transMaquinaFinal)
	{
		this.transMaquinaFinalOrigem = transMaquinaFinal;
	}

	public int getTransMaquinaFinalDestino()
	{
		return transMaquinaFinalDestino;
	}

	public void setTransMaquinaFinalDestino(int transMaquinaFinalDestino)
	{
		this.transMaquinaFinalDestino = transMaquinaFinalDestino;
	}

	public int getIdMaquinaFinal()
	{
		return idMaquinaFinal;
	}

	public void setIdMaquinaFinal(int idMaquinaFinal)
	{
		this.idMaquinaFinal = idMaquinaFinal;
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

	public boolean isFinalAnto1AndAuto2()
	{
		return isFinalAnto1AndAuto2;
	}

	public void setFinalAnto1AndAuto2(boolean isFinalAnto1AndAuto2)
	{
		this.isFinalAnto1AndAuto2 = isFinalAnto1AndAuto2;
	}

	public boolean isReadAandB()
	{
		return readAandB;
	}

	public void setReadAandB(boolean readAandB)
	{
		this.readAandB = readAandB;
	}

	public String getIds()
	{
		return ids;
	}

	public void setIds(String ids)
	{
		this.ids = ids;
	}

	public void manipularTransicoes(AutomatonDados dadosAuto1, AutomatonDados dadosAuto2,
			ArrayList<GerarMaquinaFinal> maqFinal, ArrayList<GerarMaquinaFinal> transicoes)
	{
		GerarMaquinaFinal maquinaLast;
		// for's() Gerar os estados da maquinaFinal
		int ids = 0;
		for (Estado estAuto1 : dadosAuto1.getEstado())
		{
			for (Estado estAuto2 : dadosAuto2.getEstado())
			{
				maquinaLast = new GerarMaquinaFinal();
				maquinaLast.setIdMaquinaFinal(ids++);
				maquinaLast.setIds(estAuto1.getId() + "," + estAuto2.getId());
				maquinaLast.setNome(estAuto1.getNome() + "," + estAuto2.getNome());
				maquinaLast.setCoordenaX(estAuto1.getCoordenaX() + estAuto2.getCoordenaX());
				maquinaLast.setCoordenaY(estAuto1.getCoordenaY() + estAuto2.getCoordenaY());

				if (estAuto1.isInicial() && estAuto2.isInicial())
				{
					maquinaLast.setInicial(true);
					maquinaLast.setTransicaoAuto1Origem(estAuto1.getId());
					maquinaLast.setTransicaoAuto2Origem(estAuto2.getId());
				}

				if (estAuto1.isFinal() || estAuto2.isFinal())
					maquinaLast.setFinal(true);

				if (estAuto1.isFinal() && estAuto2.isFinal())
					maquinaLast.setFinalAnto1AndAuto2(true);

				maqFinal.add(maquinaLast);
			} // fim for() auto2
		} // fim for() auto1

		// for() para pegar as transições
		for (Transicao transAuto1 : dadosAuto1.transicao)
		{
			for (Transicao transAuto2 : dadosAuto2.transicao)
			{
				if (transAuto1.getSimbolLeitura().equals(transAuto2.getSimbolLeitura()))
				{
					GerarMaquinaFinal aux = new GerarMaquinaFinal();
					aux.setIds(transAuto1.getOrigem() + "," + transAuto2.getOrigem());
					for (GerarMaquinaFinal trans : maqFinal)
					{
						if (trans.getIds().equals(aux.getIds())) // origem
							aux.setTransMaquinaFinalOrigem(trans.idMaquinaFinal);
					}

					aux.setIds(transAuto1.getDestino() + "," + transAuto2.getDestino());
					for (GerarMaquinaFinal trans : maqFinal)
					{
						if (trans.getIds().equals(aux.getIds())) // destino
						{
							aux.setTransMaquinaFinalDestino(trans.getIdMaquinaFinal());
							aux.setSimboloDeLeitura(transAuto1.getSimbolLeitura());
						}
					}
					transicoes.add(aux);
				}
			} // fim do for() auto2
		} // fim do for() auto1

		// retirar os estados sem transições
		ArrayList<GerarMaquinaFinal> auxEstado = new ArrayList<GerarMaquinaFinal>();
		ArrayList<GerarMaquinaFinal> auxTransi = new ArrayList<GerarMaquinaFinal>();
		GerarMaquinaFinal p = new GerarMaquinaFinal();
		for (int i = 0; i < maqFinal.size(); i++)
		{
			int cont = 0;
			for (int j = 0; j < transicoes.size(); j++)
			{
				if ((maqFinal.get(i).getIdMaquinaFinal() == transicoes.get(j).getTransMaquinaFinalDestino()) || maqFinal.get(i).getIdMaquinaFinal() == 0)
					continue;
				
				cont++;
				if (cont >= (transicoes.size()-1))
				{
					cont = 0;
					System.out.println("id Estado maqFinal: " + maqFinal.get(i).getIdMaquinaFinal());
					p = maqFinal.get(i);
					auxEstado.add(p);
				}
			}
		}
		
		for (GerarMaquinaFinal otimize : auxEstado)
			maqFinal.remove(otimize);
		
		GerarMaquinaFinal y = new GerarMaquinaFinal();
		for (int i = 0; i < transicoes.size(); i++)
		{
			for (int j = 0; j < maqFinal.size(); j++)
			{
				if (transicoes.get(i).getTransMaquinaFinalOrigem() == maqFinal.get(j).getIdMaquinaFinal())
				{
					y = transicoes.get(i);
					auxTransi.add(y);
				}
			}
		}
		transicoes.clear();
		
		for (GerarMaquinaFinal otimize : auxTransi)
			transicoes.add(otimize);

		for (GerarMaquinaFinal imprimir : maqFinal)
		{
			System.out.println(imprimir.getIdMaquinaFinal());
			System.out.println(imprimir.getIds());
			System.out.println(imprimir.getNome());
			System.out.println(imprimir.getCoordenaX());
			System.out.println(imprimir.getCoordenaY());
			System.out.println(imprimir.isInicial());
			System.out.println(imprimir.isFinal());
			System.out.println(imprimir.isFinalAnto1AndAuto2());

		}
		System.out.println("Estados a serem excluídos");
		for (GerarMaquinaFinal print : transicoes)
		{
			System.out.print(print.getTransMaquinaFinalOrigem());
			System.out.print(print.getSimboloDeLeitura());
			System.out.print(print.getTransMaquinaFinalDestino());
			System.out.println();
		}

	} // fim do método manipularTransicoes();

} // fim da classe GerarMaquinaFinal;
