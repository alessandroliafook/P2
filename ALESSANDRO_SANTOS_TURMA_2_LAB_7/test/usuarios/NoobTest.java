/* Matricula: 115111170 - Aluno: Alessandro Lia Fook Santos LAB 07 - Turma 2 */

package usuarios;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import jogos.Jogabilidade;

public class NoobTest {

	Set<Jogabilidade> jogabilidades;
	Noob noob;
	
	@Before
	public void setUp() throws Exception {
		
		jogabilidades = new HashSet<Jogabilidade>();
		noob = new Noob();
	}

	@Test
	public void testCalculaCusto() {

		assertTrue(noob.calculaCusto(100) == 90);
		assertTrue(noob.calculaCusto(49.99) == 44.991);
		assertTrue(noob.calculaCusto(0) == 0);
		assertFalse(noob.calculaCusto(100) == 85);

	}

	
	@Test
	public void testCalculax2p() {

		assertFalse(noob.calculaX2p(10) == 150);
		assertTrue(noob.calculaX2p(10) == 100);

	}
	
	@Test
	public void testRecompensar() {

		assertFalse(noob.recompensar(jogabilidades) != 0);
		
		jogabilidades.add(Jogabilidade.OFFLINE);
		
		assertFalse(noob.recompensar(jogabilidades) == 0);
		assertTrue(noob.recompensar(jogabilidades) == 30);
		
		jogabilidades.add(Jogabilidade.MULTPLAYER);
		assertFalse(noob.recompensar(jogabilidades) == 30);
		assertTrue(noob.recompensar(jogabilidades) == 40);
		
		jogabilidades.add(Jogabilidade.ONLINE);
		assertFalse(noob.recompensar(jogabilidades) != 40);

	}

	@Test
	public void testPunir() {
		
		assertFalse(noob.punir(jogabilidades) != 0);

		jogabilidades.add(Jogabilidade.ONLINE);
		assertFalse(noob.punir(jogabilidades) != -10);
		
		jogabilidades.add(Jogabilidade.COOPERATIVO);
		assertTrue(noob.punir(jogabilidades) == -60);

		jogabilidades.add(Jogabilidade.MULTPLAYER);
		assertTrue(noob.punir(jogabilidades) == -60);
		
		jogabilidades.add(Jogabilidade.COMPETITIVO);
		assertTrue(noob.punir(jogabilidades) == -80);
	}
}
