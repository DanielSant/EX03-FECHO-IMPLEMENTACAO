package classes;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ArquivoDismember
{
	protected void readAndLoadXML(File arquivo) throws SAXException, IOException, ParserConfigurationException
	{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document jflap = db.parse(arquivo.toString()); // recebe o endereço do arquivo
		
		NodeList listaEstados = jflap.getElementsByTagName("state");
		// AutomatonDados dados = new AutomatonDados();
		
		int qtdEstados = listaEstados.getLength();

		for (int i = 0; i < qtdEstados; i++)
		{
			Node noEstado = listaEstados.item(i);

			if (noEstado.getNodeType() == Node.ELEMENT_NODE)
			{
				Element elementoEstado = (Element) noEstado;
				Estado estados = new Estado();
				estados.setId(Integer.parseInt(elementoEstado.getAttribute("id")));
				System.out.println(estados.getId());
				estados.setNome(elementoEstado.getAttribute("name"));
				System.out.println(estados.getNome());
				
				NodeList listaFilhosEstado = elementoEstado.getChildNodes();

				int qtdFilhosEstados = listaFilhosEstado.getLength();

				for (int j = 0; j < qtdFilhosEstados; j++)
				{
					Node noFilhoState = listaFilhosEstado.item(j);

					if (noFilhoState.getNodeType() == Node.ELEMENT_NODE)
					{
						Element elementoFilhoEstado = (Element) noFilhoState;
						
						switch(elementoFilhoEstado.getTagName())
						{
							case "x":
								estados.setCoordenaX(Double.parseDouble(elementoFilhoEstado.getTextContent()));
								System.out.println(estados.getCoordenaX());
								break;
							case "y":
								estados.setCoordenaY(Double.parseDouble(elementoFilhoEstado.getTextContent()));
								System.out.println(estados.getCoordenaY());
								break;
							case "initial":
								estados.setInicial(true);
								System.out.println(estados.isInicial());
								break;
							case "final":
								estados.setFinal(true);
								System.out.println(estados.isFinal());
								break;
						}
					}
				}
			}
		}
	}
}
