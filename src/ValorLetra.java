import java.util.ArrayList;

public class ValorLetra implements Embaralhador {

	private String palavra;
	private ArrayList<String> letras = new ArrayList<>();
	
	public ValorLetra(String palavra) {
		this.palavra = palavra;
	}
	
	//salva a palavra correta num array de caracteres
	//busca na sequencia os dados deste array correto
	//salva de forma aleatória no array embaralhado
	//Exemplo: array com a palavra correta: uva
	//         busco a primeira letra no array correto, descubro o valor(20) e divido pelo tamanho da string(3)
	//           e busco o resto da divisão = 2 e jogo na terceira posicao do array embaralhado
	//         busco a segunda letra no array correto, descubro o valor(21) e divido pelo tamanho da string(3)
	//           e busco o resto da divisão = 0 e jogo na primeira posicao do array embaralhado
	//         busco a terceira letra no array correto, descubro o valor(0) e como é menor que o array, tento jogar 
	//         na primeira posição, mas como já está ocupada, jogo na próxima livre, ou seja, segunda
	//         retornando: vau
	// ranking das letras é calculado no método valorLetra
	@Override
	public String embaralhar() {
		
		this.setLetras();
		
		String[] embaralhado;
		embaralhado = new String[palavraCorreta().length()];
		
		int posicao = 0;
		int valorLetra = 0;
		for (int i=0; i<getLetras().size(); i++) { 
			valorLetra = this.valorLetra(getLetras().get(i));
			
			if (valorLetra < getLetras().size()){
				posicao = valorLetra;
			} else {
				posicao = (valorLetra % getLetras().size());
			}
			
			boolean letraUtilizada = false;
			while(!letraUtilizada){
				if (embaralhado[posicao] == null){
					embaralhado[posicao] = getLetras().get(i);
					letraUtilizada = true;
				} else {
					posicao++;
					if (posicao >= getLetras().size()){
						posicao = 0;
					}
				}
			}
			
		}
		
		String palavraEmbaralhada = "";
		for(int i=0; i<letras.size();i++){
			palavraEmbaralhada = palavraEmbaralhada + embaralhado[i];
		}
		
		
		return palavraEmbaralhada;
	}
	
	@Override
	public int pontuacao() {
		int pontos;
		if (getLetras().size() < 4){
			pontos = 1;
		} else if (getLetras().size() < 7) {
			pontos = 2;
		} else if (getLetras().size() < 10){
			pontos = 3;
		} else {
			pontos = 4;
		}
		return pontos;
	}
	
	@Override
	public String palavraCorreta() {
		return palavra;
	}
	
	public int valorLetra(String letra){
		String[] letras = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
						   "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "m"};
		
		int valorLetra = 0;
		for(int i=0; i<26; i++){
			//System.out.println(letras[i]);
			if (letras[i].equals(letra)) {
				valorLetra = i;
			}
		}
		
		return valorLetra;
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
