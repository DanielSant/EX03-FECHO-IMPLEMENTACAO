package classes;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class ChooserFile extends JFrame
{
	/**
	 * Janela para escolher o arquivo
	 */
	private static final long serialVersionUID = 1L;

	// permite que o usu�rio especifique o nome de arquivo ou diret�rio
	protected File getFile()
	{
		// configura o di�logo permitindo a sele��o de um arquivo
		JFileChooser arquivoEscolhido = new JFileChooser();
		arquivoEscolhido.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int result = arquivoEscolhido.showOpenDialog(this);

		// se o usu�rio clicou no bot�o cancelar no di�logo, retorna.
		if (result == JFileChooser.CANCEL_OPTION)
			System.exit(1);

		// retorna o File representando o arquivo selecionado
		return arquivoEscolhido.getSelectedFile();
	}
} // fim da classe ChooserFile
