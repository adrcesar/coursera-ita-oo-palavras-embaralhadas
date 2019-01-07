
public interface MecanicaDoJogo {
	
	public void carregaPalavras();
	
	public String exibePalavraEmbaralhada();
	
	public boolean acertouPalavra(String palavra);
	
	public int pontuacaoPalavra();
	
	public int pontuacaoTotal();
	
	public boolean fimDoJogo();
	
}
