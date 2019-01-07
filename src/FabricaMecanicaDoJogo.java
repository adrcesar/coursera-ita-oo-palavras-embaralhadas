
public class FabricaMecanicaDoJogo {

	MecanicaDoJogo mecanica;

	public FabricaMecanicaDoJogo(MecanicaDoJogo mecanica) {
		this.mecanica = mecanica;
	}
	
	public void carregaPalavras(){
		mecanica.carregaPalavras();
	}
	
	public String exibePalavraEmbaralhada(){
		return mecanica.exibePalavraEmbaralhada();
	}
	
	public boolean acertouPalavra(String palavra){
		return mecanica.acertouPalavra(palavra);
	}
	
	public int pontuacaoPalavra(){
		return mecanica.pontuacaoPalavra();
	}
	
	public int pontuacaoTotal(){
		return mecanica.pontuacaoTotal();
	}
	
	public boolean fimDoJogo(){
		return mecanica.fimDoJogo();
	}
	
}
