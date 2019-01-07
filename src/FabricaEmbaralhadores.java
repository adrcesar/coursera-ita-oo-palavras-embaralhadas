
public class FabricaEmbaralhadores {
	
	Embaralhador embaralhador;
	
	public FabricaEmbaralhadores(Embaralhador embaralhador) {
		this.embaralhador = embaralhador;
	}
	
	public String embaralhar() {
		return embaralhador.embaralhar();
	}
	
	public String palavraCorreta() {
		return embaralhador.palavraCorreta();
	}
	
	public int pontuacao() {
		return embaralhador.pontuacao();
	}

}
