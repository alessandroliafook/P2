/* Matricula: 115111170 - Aluno: Alessandro Lia Fook Santos LAB 07 - Turma 2 */

package usuarios;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import jogos.*;

public class VeteranoTest {

	Set<Jogabilidade> jogabilidades;
	Veterano veterano;
	
	@Before
	public void setUp() throws Exception {
		
		jogabilidades = new HashSet<Jogabilidade>();
		veterano = new Veterano();
	}

	@Test
	public void testCalculaCusto() {

		assertTrue(veterano.calculaCusto(100) == 85);
		assertTrue(veterano.calculaCusto(49.99) == 42.4915);
		assertTrue(veterano.calculaCusto(0) == 0);
		assertFalse(veterano.calculaCusto(100) == 82);

	}

	
	@Test
	public void testCalculax2p() {

		assertFalse(veterano.calculaX2p(10) == 100);
		assertTrue(veterano.calculaX2p(10) == 150);

	}
	
	@Test
	public void testRecompensar() {

		assertFalse(veterano.recompensar(jogabilidades) == 1);
		assertTrue(veterano.recompensar(jogabilidades) == 0);
		
		jogabilidades.add(Jogabilidade.ONLINE);
		
		assertFalse(veterano.recompensar(jogabilidades) == 0);
		assertTrue(veterano.recompensar(jogabilidades) == 10);
		
		jogabilidades.add(Jogabilidade.COOPERATIVO);
		assertFalse(veterano.recompensar(jogabilidades) == 10);
		assertTrue(veterano.recompensar(jogabilidades) == 30);
		
		jogabilidades.add(Jogabilidade.OFFLINE);
		assertFalse(veterano.recompensar(jogabilidades) != 30);

	}

	@Test
	public void testPunir() {
		
		assertFalse(veterano.punir(jogabilidades) != 0);

		jogabilidades.add(Jogabilidade.OFFLINE);
		assertFalse(veterano.punir(jogabilidades) != -20);
		

		jogabilidades.add(Jogabilidade.MULTPLAYER);
		assertTrue(veterano.punir(jogabilidades) == -20);
		
		jogabilidades.add(Jogabilidade.COMPETITIVO);
		assertTrue(veterano.punir(jogabilidades) == -40);
	}
	
}
