import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		FabricaMecanicaDoJogo mecanica = null;

		Scanner ler = new Scanner(System.in);

		System.out.printf("**********Descubra a palavra**********\n");
		System.out.printf("--------------------------------------\n");
		System.out.printf("Opcao 1 - 3 vidas para acertar todas as palavras do jogo\n");
		System.out.printf("Opcao 2 - Acerte 3 palavras escolhidas aleatoriamente sem errar nenhuma\n");
		System.out.printf("Informe a opcao[1 ou 2]\n");
		String opcao = ler.nextLine();

		if (opcao.equals("1")) {
			Vida vida = new Vida(3);
			mecanica = new FabricaMecanicaDoJogo(vida);
		} else if (opcao.equals("2")) {
			ErrouPerdeu ep = new ErrouPerdeu(1);
			mecanica = new FabricaMecanicaDoJogo(ep);
		} else {
			System.out.println("Opção inválida");
		}

		if (opcao.equals("1") || opcao.equals("2")) {
			mecanica.carregaPalavras();
			while (!mecanica.fimDoJogo()) {
				
				System.out.printf("Palavra Embaralhada: " + mecanica.exibePalavraEmbaralhada() + "\n"); // exibe
																										// palavra
				System.out.printf("Resposta\n");
				String resposta = ler.nextLine();
				//
				if (mecanica.acertouPalavra(resposta)) { // verifica se acertou
															// palavras

					System.out.printf("Você acertou!!!!\n");
					System.out.printf("Pontos da palavra " + mecanica.pontuacaoPalavra() + "\n"); // exibe
																									// pontuacao
																									// da
																									// palavra
					System.out.printf("Total de Pontos " + mecanica.pontuacaoTotal() + "\n"); // exibe
																								// pontuacao
																								// total
					if (mecanica.fimDoJogo()) { // verifica se ganhou o jogo
						System.out.printf("Parabéns, você finalizou o jogo!!!\n");
					}
					System.out.printf(" \n");

				} else {
					System.out.printf("Você errou!!!!\n");
					System.out.printf("Pontos Marcados: 0\n");
					System.out.printf("Total de Pontos " + mecanica.pontuacaoTotal() + "\n"); // exibe
																								// pontuacao
																								// total
					if (mecanica.fimDoJogo()) {
						System.out.printf("Acabaram suas vidas, tente novamente!!!!\n");
					}
					System.out.printf(" \n");
				}

			}
		}
		ler.close();
	}

}
