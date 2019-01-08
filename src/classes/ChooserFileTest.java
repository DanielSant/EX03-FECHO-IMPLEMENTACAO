package classes;

public class ChooserFileTest
{
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		System.out.printf("%n%s%n", "Abrir arquivo 1");
		ChooserFile application = new ChooserFile();
		AbrirArquivo arq1 = new AbrirArquivo();
		arq1.openFile(application.getFilePath().toString());
		arq1.readFile();
		arq1.closeFile();
		System.out.printf("%n%s%n", "Abrir arquivo 2");
		ChooserFile app = new ChooserFile();
		AbrirArquivo arq2 = new AbrirArquivo();
		arq2.openFile(app.getFilePath().toString());
		arq2.readFile();
		arq2.closeFile();
	}
}
