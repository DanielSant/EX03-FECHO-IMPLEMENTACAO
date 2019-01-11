package classes;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import classes.ArquivoDismember;

public class ChooserFileTest
{
	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException
	{
		// TODO Auto-generated method stub
		ChooserFile application = new ChooserFile();
		ArquivoDismember arq = new ArquivoDismember();
		AutomatonDados auto = new AutomatonDados();
		arq.readAndLoadXML(application.getFile("Abra o 1º arquivo"), auto);
		
		ChooserFile app = new ChooserFile();
		ArquivoDismember arq1 = new ArquivoDismember();
		AutomatonDados auto1 = new AutomatonDados();
		arq1.readAndLoadXML(app.getFile("Abra o 2º arquivo"), auto1);
		
		ArrayList<GerarMaquinaFinal> finalEstado = new ArrayList<GerarMaquinaFinal>();
		ArrayList<GerarMaquinaFinal> finalTransicao = new ArrayList<GerarMaquinaFinal>();
		GerarMaquinaFinal result = new GerarMaquinaFinal();
		result.manipularTransicoes(auto, auto1, finalEstado, finalTransicao);

		System.out.printf("%n%s%n", "Local para salvar os arquivos");
		ChooserFile a = new ChooserFile();
		ArquivoJoin maquinaResultante = new ArquivoJoin();
		maquinaResultante.escreverAutomatoFinal(finalEstado, finalTransicao, a.setFiles().toString());
	}
}
