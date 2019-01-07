import java.util.ArrayList;
import java.util.Random;

public class Randomica implements Embaralhador {

	
	private String palavra;
	private ArrayList<String> letras = new ArrayList<>();
	
	public Randomica(String palavra) {
		super();
		this.palavra = palavra;
	}
	
	
	//salva a palavra correta num array de caracteres
	//busca aleatoriamente os dados destes array correto
	//e insere em sequencia no array de embaralhamento 
	//exemplo: array com a palavra correta: uva
	//         a busca de forma aleatoria poderia buscar no array correto:
	//         a terceira letra(a) e inserí-la na primeira posicao do array de embaralhamento;
	//         a primeira letra(u) e inserí-la na segubnda posicao do array de embaralhamento;
	//         a segunda  letra(v) e inserí-la na terceira posicao do array de embaralhamento;
	// formando assim a palavra embaralhada: auv
	@Override
	public String embaralhar() {
				
		this.setLetras();
		
		ArrayList<String> letrasAux = new ArrayList<>();
		letrasAux.addAll(getLetras());
		
		Random randomNum = new Random();  
		String palavraEmbaralhada = "";
		int tamanho = getLetras().size();
		int x;
		
		for (int i=0; i<getLetras().size(); i++) { 
			
			x = randomNum.nextInt(tamanho); 
			palavraEmbaralhada = palavraEmbaralhada + (letrasAux.get(x));  
			letrasAux.remove(x);
			tamanho--;
			
		}
		
		return palavraEmbaralhada;
	}
	
	@Override
	public int pontuacao() {
		int pontos;
		if (getLetras().size() < 4){
			pontos = 10;
		} else if (getLetras().size() < 7) {
			pontos = 20;
		} else if (getLetras().size() < 10){
			pontos = 30;
		} else {
			pontos = 40;
		}
		return pontos;
	}
	
	@Override
	public String palavraCorreta() {
		return palavra;
	}
	
	public void setLetras() {
		int tamanho = palavraCorreta().length();
		for (int i=0; i<tamanho; i++) { 
			String letra = palavra.substring(i, i+1);
			letras.add(letra);
		}
	}
	
	public ArrayList<String> getLetras() {
		ArrayList<String> copia = new ArrayList<>();
		copia.addAll(this.letras);
		return copia;
	}
	
}
