import static org.junit.Assert.*;

import org.junit.Test;

public class TesteEmbaralhador {
	
	FabricaEmbaralhadores embaralhador;
	boolean instancia = false;
	
	@Test
	public void testeRandomico() {
		Embaralhador r = new Randomica("baralho");
		embaralhador = new FabricaEmbaralhadores(r);
		
		if (r instanceof Embaralhador){
			instancia = true;
		}
		//verifica se é uma instância da Interface FormatadorNome
		assertEquals(true, instancia);
		//verifica o retorno
		assertNotEquals("baralho", embaralhador.embaralhar());	
		
	}
	
	@Test
	public void testeValorLetra() {
		Embaralhador vl = new ValorLetra("baralho");
		embaralhador = new FabricaEmbaralhadores(vl);
		
		if (vl instanceof Embaralhador){
			instancia = true;
		}
		//verifica se é uma instância da Interface FormatadorNome
		assertEquals(true, instancia);
		//verifica o retorno
		assertNotEquals("baralho", embaralhador.embaralhar());	
		
	}

}
