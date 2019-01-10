package classes;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import classes.ArquivoDismember;

public class ChooserFileTest
{
	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException
	{
		// TODO Auto-generated method stub
		System.out.printf("%n%s%n", "Abrir o 1º arquivo");
		ChooserFile application = new ChooserFile();
		ArquivoDismember arq = new ArquivoDismember();
		AutomatonDados auto = new AutomatonDados();
		arq.readAndLoadXML(application.getFile(), auto);
		
		for (Estado est : auto.getEstado())
		{
			System.out.println(est.getNome());
		}
		
		System.out.printf("%n%s%n", "Abrir o 2º arquivo");
		ChooserFile app = new ChooserFile();
		ArquivoDismember arq1 = new ArquivoDismember();
		AutomatonDados auto1 = new AutomatonDados();
		arq1.readAndLoadXML(app.getFile(), auto1);
		
		int qtdEstados2 = auto1.getEstado().size();
		
		for (int i = 0; i < qtdEstados2; i++)
		{
			System.out.println(auto1.getEstado().get(i));
		}
		
		/*AbrirArquivo arq1 = new AbrirArquivo();
		arq1.openFile(application.getFile().toString());
		arq1.readFile();
		arq1.closeFile();
		System.out.printf("%n%s%n", "Abrir arquivo 2");
		ChooserFile app = new ChooserFile();
		AbrirArquivo arq2 = new AbrirArquivo();
		arq2.openFile(app.getFile().toString());
		arq2.readFile();
		arq2.closeFile();*/
	}
}
