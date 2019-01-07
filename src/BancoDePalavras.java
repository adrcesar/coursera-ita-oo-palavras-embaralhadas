import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BancoDePalavras {
	
	private ArrayList<String> palavras = new ArrayList<>();

	public void buscaPalavras(){
		try {
			FileReader arq = new FileReader("C:/ITA/palavras.txt"); 
			BufferedReader lerArq = new BufferedReader(arq);
			
			String linha = lerArq.readLine(); // lê a primeira linha 
			
			while (linha != null) { 
				palavras.add(linha);
				linha = lerArq.readLine(); // lê da segunda até a última linha
			} 
			
			arq.close();
				
		}catch (IOException e) { 
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage()); 
		}

	}
	
	public ArrayList<String> getPalavras() {
		ArrayList<String> palavrasCopia = new ArrayList<>();
		palavrasCopia.addAll(palavras);
		return palavrasCopia;
	}
		
}
