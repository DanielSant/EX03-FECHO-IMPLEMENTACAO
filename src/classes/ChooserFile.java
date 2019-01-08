package classes;

import java.nio.file.Path;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class ChooserFile extends JFrame
{
	/**
	 * Janela para escolher o arquivo
	 */
	private static final long serialVersionUID = 1L;

	// permite que o usuário especifique o nome de arquivo ou diretório
	protected Path getFilePath()
	{
		// configura o diálogo permitindo a seleção de um arquivo
		JFileChooser arquivoEscolhido = new JFileChooser();
		arquivoEscolhido.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int result = arquivoEscolhido.showOpenDialog(this);

		// se o usuário clicou no botão cancelar no diálogo, retorna.
		if (result == JFileChooser.CANCEL_OPTION)
			System.exit(1);

		// retorna o Path representando o arquivo selecionado
		return arquivoEscolhido.getSelectedFile().toPath();
	}
} // fim da classe ChooserFile
