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

	// permite que o usuário especifique o arquivo para abrir
	protected File getFile(String msg)
	{
		// configura o diálogo permitindo a seleção de um arquivo
		JFileChooser arquivoEscolhido = new JFileChooser();
		arquivoEscolhido.setDialogTitle(msg);
		arquivoEscolhido.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int result = arquivoEscolhido.showOpenDialog(this);

		// se o usuário clicou no botão cancelar no diálogo, retorna.
		if (result == JFileChooser.CANCEL_OPTION)
			System.exit(1);

		// retorna o File representando o arquivo selecionado
		return arquivoEscolhido.getSelectedFile();
	}
	
	// permite que o cliente especifique o diretório para salvar os arquivos
	protected File setFiles()
	{
		// configura o diálogo permitindo a seleção de um diretório
		JFileChooser localEscolhido = new JFileChooser();
		localEscolhido.setDialogTitle("Onde deseja salvar os arquivos ?");
		localEscolhido.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int userSelecao = localEscolhido.showSaveDialog(this);
		
		// se o cliente clicou no botão cancelar no diálogo, retorna.
		if (userSelecao == JFileChooser.CANCEL_OPTION)
			System.exit(1);
		
		// retorna o diretório representando o caminho especificado.
		return localEscolhido.getSelectedFile();
	}
} // fim da classe ChooserFile
