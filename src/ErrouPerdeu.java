import java.util.ArrayList;
import java.util.Random;

public class ErrouPerdeu implements MecanicaDoJogo {
	
	private int numeroDeVidas;
	private static int pontos;
	private static int palavrasExibidas = 0;
	private FabricaEmbaralhadores embaralhador;
	private boolean fimDasPalavras = false;
	private int palavrasAExibir = 3;
	
	private ArrayList<String> carregaPalavras = new ArrayList<>();
	
	
	public ErrouPerdeu(int numeroDeVidas) {
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
		
		Random randomNum = new Random(); 
		int posicao = randomNum.nextInt(this.carregaPalavras.size());
		String palavraNormal = this.carregaPalavras.get(posicao);
		this.carregaPalavras.remove(posicao);
		ErrouPerdeu.palavrasExibidas++;
			
		Randomica r = new Randomica(palavraNormal);	
		embaralhador = new FabricaEmbaralhadores(r);
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
		
		if (ErrouPerdeu.palavrasExibidas == this.palavrasAExibir){
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
		return ErrouPerdeu.pontos;
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
	
	private FabricaEmbaralhadores getEmbaralhador() {
		return embaralhador;
	}
	
	private void calculapontuacao() {
		ErrouPerdeu.pontos += getEmbaralhador().pontuacao();
	}
	
	private void perdeVida() {
		this.numeroDeVidas--;
	}
	
	private boolean isFimDasPalavras() {
		return fimDasPalavras;
	}
	
	private int getNumeroDeVidas() {
		return numeroDeVidas;
	}

}
