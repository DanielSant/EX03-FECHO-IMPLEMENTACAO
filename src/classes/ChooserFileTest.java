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
		System.out.printf("%n%s%n", "Abrir arquivo 1");
		ChooserFile application = new ChooserFile();
		ArquivoDismember arq = new ArquivoDismember();
		arq.readAndLoadXML(application.getFile());
		
		System.out.printf("%n%s%n", "Abrir arquivo 2");
		ChooserFile app = new ChooserFile();
		ArquivoDismember arq1 = new ArquivoDismember();
		arq1.readAndLoadXML(app.getFile());
		
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
