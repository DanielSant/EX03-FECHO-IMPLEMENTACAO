package classes;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ArquivoJoin
{
	private PrintWriter pw;

	public void escreverAutomatoFinal(ArrayList<GerarMaquinaFinal> finalEstados,
			ArrayList<GerarMaquinaFinal> finalTransicoes, String caminho)
	{
		// fecho sob operação de união or
		try
		{
			FileWriter fw = new FileWriter(caminho + "/autoFinalOr.jff");
			pw = new PrintWriter(fw);

			pw.println(
					"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><!--Created byDanielAndLiliane for JFLAP 6.4.--><structure>&#13;");
			pw.println("	<type>fa</type>&#13;");
			pw.println("	<automaton>&#13;");
			pw.println("		<!--The list of states.-->&#13;");
			for (GerarMaquinaFinal est : finalEstados)
			{
				pw.println("		<state id=\"" + est.getIdMaquinaFinal() + "\" name=\"" + est.getNome() + "\">&#13;");
				pw.println("			<x>" + est.getCoordenaX() + "</x>&#13;");
				pw.println("			<y>" + est.getCoordenaY() + "</y>&#13;");
				if (est.isInicial())
					pw.println("			<initial/>&#13;");

				if (est.isFinal())
					pw.println("			<final/>&#13;");

				pw.println("		</state>&#13;");
				pw.flush();
			}
			pw.println("		<!--The list of transitions.-->&#13;");
			for (GerarMaquinaFinal trans : finalTransicoes)
			{
				pw.println("		<transition>&#13;");
				pw.println("			<from>" + trans.getTransMaquinaFinalOrigem() + "</from>&#13;");
				pw.println("			<to>" + trans.getTransMaquinaFinalDestino() + "</to>&#13;");
				pw.println("			<read>" + trans.getSimboloDeLeitura() + "</read>&#13;");
				pw.println("		</transition>&#13;");
				pw.flush();
			}
			pw.println("	</automaton>&#13;");
			pw.println("</structure>");
			pw.flush();
			pw.close();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error ou gerar arquivos de saída, verifique o caminho especificado.");
			System.exit(1);
		}
		
		// fecho sob operação de intersecção and
		try
		{
			FileWriter fw = new FileWriter(caminho + "/autoFinalAnd.jff");
			pw = new PrintWriter(fw);

			pw.println(
					"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><!--Created byDanielAndLiliane for JFLAP 6.4.--><structure>&#13;");
			pw.println("	<type>fa</type>&#13;");
			pw.println("	<automaton>&#13;");
			pw.println("		<!--The list of states.-->&#13;");
			for (GerarMaquinaFinal est : finalEstados)
			{
				pw.println("		<state id=\"" + est.getIdMaquinaFinal() + "\" name=\"" + est.getNome() + "\">&#13;");
				pw.println("			<x>" + est.getCoordenaX() + "</x>&#13;");
				pw.println("			<y>" + est.getCoordenaY() + "</y>&#13;");
				if (est.isInicial())
					pw.println("			<initial/>&#13;");

				if (est.isFinalAnto1AndAuto2())
					pw.println("			<final/>&#13;");

				pw.println("		</state>&#13;");
				pw.flush();
			}
			pw.println("		<!--The list of transitions.-->&#13;");
			for (GerarMaquinaFinal trans : finalTransicoes)
			{
				pw.println("		<transition>&#13;");
				pw.println("			<from>" + trans.getTransMaquinaFinalOrigem() + "</from>&#13;");
				pw.println("			<to>" + trans.getTransMaquinaFinalDestino() + "</to>&#13;");
				pw.println("			<read>" + trans.getSimboloDeLeitura() + "</read>&#13;");
				pw.println("		</transition>&#13;");
				pw.flush();
			}
			pw.println("	</automaton>&#13;");
			pw.println("</structure>");
			pw.flush();
			pw.close();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error ou gerar arquivos de saída, verifique o caminho especificado.");
			System.exit(1);
		}
	}
}
