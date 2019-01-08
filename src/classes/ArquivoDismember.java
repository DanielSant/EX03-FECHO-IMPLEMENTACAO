package classes;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

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

		AutomatonDados dados = new AutomatonDados();
		ArrayList<Estado> states = new ArrayList<Estado>();
		ArrayList<Transicao> transitions = new ArrayList<Transicao>();

		NodeList listaEstados = jflap.getElementsByTagName("state");

		int qtdEstados = listaEstados.getLength();

		// for para separar os estados
		for (int i = 0; i < qtdEstados; i++)
		{
			Node noEstado = listaEstados.item(i);

			if (noEstado.getNodeType() == Node.ELEMENT_NODE)
			{
				Element elementoEstado = (Element) noEstado;
				Estado estados = new Estado();
				estados.setId(Integer.parseInt(elementoEstado.getAttribute("id")));
				System.out.println("id: " + estados.getId());
				estados.setNome(elementoEstado.getAttribute("name"));
				System.out.println("nome: " + estados.getNome());

				NodeList listaFilhosEstado = elementoEstado.getChildNodes();

				int qtdFilhosEstados = listaFilhosEstado.getLength();

				// for() para pegar as tags mais internas dos estados, <x>,<y> e
				// <initial>/<final>
				for (int j = 0; j < qtdFilhosEstados; j++)
				{
					Node noFilhoState = listaFilhosEstado.item(j);

					if (noFilhoState.getNodeType() == Node.ELEMENT_NODE)
					{
						Element elementoFilhoEstado = (Element) noFilhoState;

						switch (elementoFilhoEstado.getTagName())
						{
						case "x":
							estados.setCoordenaX(Double.parseDouble(elementoFilhoEstado.getTextContent()));
							System.out.println("x: " + estados.getCoordenaX());
							break;
						case "y":
							estados.setCoordenaY(Double.parseDouble(elementoFilhoEstado.getTextContent()));
							System.out.println("y: " + estados.getCoordenaY());
							break;
						case "initial":
							estados.setInicial(true);
							System.out.println("isInicial: " + estados.isInicial());
							break;
						case "final":
							estados.setFinal(true);
							System.out.println("isFinal: " + estados.isFinal());
							break;
						}
					}
				}
				states.add(estados);
			}
			dados.setEstado(states);
		} // fim do for() para separar os atributos dos estados

		NodeList listaTransicoes = jflap.getElementsByTagName("transition");

		int qtdTransicoes = listaTransicoes.getLength();

		// for() para separar os atributos das transições
		for (int i = 0; i < qtdTransicoes; i++)
		{
			Node noTransicao = listaTransicoes.item(i);

			if (noTransicao.getNodeType() == Node.ELEMENT_NODE)
			{
				Element elementoTransicao = (Element) noTransicao;
				Transicao transicoes = new Transicao();

				NodeList listaFilhosTrans = elementoTransicao.getChildNodes();

				int qtdFilhosTrans = listaFilhosTrans.getLength();

				// for() para pegar as tags mais internas das transições, <from>,<to> e <read>
				for (int j = 0; j < qtdFilhosTrans; j++)
				{
					Node noFilhoTrans = listaFilhosTrans.item(j);

					if (noFilhoTrans.getNodeType() == Node.ELEMENT_NODE)
					{
						Element elementoFilhoTrans = (Element) noFilhoTrans;

						switch (elementoFilhoTrans.getTagName())
						{
						case "from":
							transicoes.setOrigem(Integer.parseInt(elementoFilhoTrans.getTextContent()));
							System.out.println("from: " + transicoes.getOrigem());
							break;
						case "to":
							transicoes.setDestino(Integer.parseInt(elementoFilhoTrans.getTextContent()));
							System.out.println("to: " + transicoes.getDestino());
							break;
						case "read":
							transicoes.setSimbolLeitura(elementoFilhoTrans.getTextContent());
							System.out.println("read: " + transicoes.getSimbolLeitura());
							break;
						}
					}
				} // fim do for() para pegar as tags mais internas
				transitions.add(transicoes);
			}
			dados.setTransicao(transitions);
		} // fim do for() para separar as transicoes por atributos

	} // fim do método readAndLoadXML
} // fim da classe ArquivoDismember
