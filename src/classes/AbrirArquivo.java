package classes;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class AbrirArquivo
{
	private Scanner input;

	public Scanner getInput()
	{
		return input;
	}

	public void setInput(Scanner input)
	{
		this.input = input;
	}

	// abre o arquivo do jflap passado pela janela ChooserFile
	protected void openFile(String arquivo)
	{
		try
		{
			setInput(new Scanner(Paths.get(arquivo)));
		}
		catch (IOException ioException)
		{
			System.err.println("ERROR ao abrir arquivo. Finalizando.");
			System.exit(1);
		}
	} // fim do método openFile
	
	// lê a estrutura no arquivo
	protected void readFile()
	{
		try
		{
			while (getInput().hasNext()) // enquanto houver mais para ler
			{
		 		// exibe o conteúdo do arquivo
				System.out.printf("%s%n", getInput().nextLine());
			}
		}
		catch (IllegalStateException stateException)
		{
			System.err.println("ERROR na leitura do arquivo. Finalizando.");
			System.exit(1);
		}
	} // fim do método readFile
	
	// fecha o arquivo e termina o aplicativo
	protected void closeFile()
	{
		if (input != null)
			input.close();
	}
} // fim da classe AbrirArquivo
