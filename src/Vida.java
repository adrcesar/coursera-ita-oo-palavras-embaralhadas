import java.util.ArrayList;

public class Vida implements MecanicaDoJogo {

	private int numeroDeVidas;
	private static int pontos;
	private static int palavrasExibidas = 0;
	private FabricaEmbaralhadores embaralhador;
	private boolean fimDasPalavras = false;
	
	private ArrayList<String> carregaPalavras = new ArrayList<>();
		
	
	public Vida(int numeroDeVidas) {
		this.numeroDeVidas = numeroDeVidas;
	}

	@Override
	public void carregaPalavras() {
		BancoDePalavras palavra = new BancoDePalavras();
		palavra.buscaPalavras();
		this.carregaPalavras.addAll(palavra.getPalavras());
	}
	
	@Override
	public String exibePalavraEmbaralhada() {
				
		String palavraNormal = "";
		palavraNormal = carregaPalavras.get(palavrasExibidas);
		Vida.palavrasExibidas++;
			
		ValorLetra v = new ValorLetra(palavraNormal);	
		embaralhador = new FabricaEmbaralhadores(v);
		return getEmbaralhador().embaralhar();
	}
	
	@Override
	public boolean acertouPalavra(String palavra) {
		
		boolean resultado;
		if (palavra.toLowerCase().equals(getEmbaralhador().palavraCorreta())){
			this.calculapontuacao();
			resultado = true;
		} else {
			this.perdeVida();
			resultado = false;
		}
		
		int numeroDePalavras = carregaPalavras.size();
		if (Vida.palavrasExibidas == numeroDePalavras){
			this.fimDasPalavras = true;
		}
		
		return resultado;
			
	}
	
	@Override
	public int pontuacaoPalavra() {
		return getEmbaralhador().pontuacao();
	}
	
	@Override
	public int pontuacaoTotal() {
		return Vida.pontos;
	}
	
	@Override
	public boolean fimDoJogo() {
		boolean resultado;
		if (this.getNumeroDeVidas() > 0) {
			if (this.isFimDasPalavras()){
				resultado = true;
			} else {
				resultado = false;
			}
		} else {
			resultado = true;
		}
		return resultado;
			
	}
	
	public void calculapontuacao() {
		Vida.pontos += getEmbaralhador().pontuacao();
	}

	private int getNumeroDeVidas() {
		return numeroDeVidas;
	}
	
	private void perdeVida() {
		this.numeroDeVidas--;
	}
	
	private FabricaEmbaralhadores getEmbaralhador() {
		return embaralhador;
	}

	private boolean isFimDasPalavras() {
		return fimDasPalavras;
	}
	
}
