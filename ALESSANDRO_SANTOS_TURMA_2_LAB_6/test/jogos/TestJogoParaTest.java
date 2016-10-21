/* Matricula: 115111170 - Aluno: Alessandro Lia Fook Santos LAB 06 - Turma 2 */

package jogos;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Test;

import constantes.Jogabilidade;

public class TestJogoParaTest {

	/**
	 * Testando o construtor da classe.
	 */
	@Test
	public void testJogoParaTest() {

		HashSet<Jogabilidade> jogabilidade = new HashSet<Jogabilidade>();
		jogabilidade.add(Jogabilidade.OFFLINE);

		try {
			Jogo fft = new JogoParaTest("Final Fantasy Tactics", 49.99, jogabilidade);

			assertEquals("Final Fantasy Tactics", fft.getNome());
			assertTrue(49.99 == fft.getPreco());
			assertTrue(fft.getEstilo().contains(Jogabilidade.OFFLINE));

		} catch (Exception e) {
			fail("Nao deve lancar excecao aqui.");
		}

		try {
			String nomeInvalido = "";

			Jogo jogoInvalido = new JogoParaTest(nomeInvalido, 1, jogabilidade);
			fail("Se chegar aqui esta errado, pois deve lancar excecao.");
		} catch (Exception e) {
			assertEquals("X nome do jogo eh invalidx, pois eh vazio.\n", e.getMessage());

		}

		try {
			String nomeInvalido = null;

			Jogo jogoInvalido = new JogoParaTest(nomeInvalido, 1, jogabilidade);
			fail("Se chegar aqui esta errado, pois deve lancar excecao.");
		} catch (Exception e) {
			assertEquals("X nome do jogo eh invalidx, pois eh null.\n", e.getMessage());

		}

		try {

			Jogo jogoInvalido = new JogoParaTest("Final Fantasy", -1, jogabilidade);
			fail("Se chegar aqui esta errado, pois deve lancar excecao.");
		} catch (Exception e) {
			assertEquals("X preco do jogo eh invalidx, pois eh menor que zero.\n", e.getMessage());

		}

		try {

			jogabilidade = null;
			Jogo jogoInvalido = new JogoParaTest("Final Fantasy", 0, jogabilidade);
			fail("Se chegar aqui esta errado, pois deve lancar excecao.");
		} catch (Exception e) {
			assertEquals("X jogabilidade do jogo eh invalidx, pois eh igual a null.\n", e.getMessage());

		}
	}

	@Test
	public void testAddJogabilidade() {
		try {
			HashSet<Jogabilidade> jogabilidade = new HashSet<Jogabilidade>();
			jogabilidade.add(Jogabilidade.OFFLINE);
			Jogo fft = new JogoParaTest("Final Fantasy Tactics", 49.99, jogabilidade);

			try {

				assertTrue(fft.addJogabilidade("online"));
				assertFalse(fft.addJogabilidade("online"));
				assertFalse(fft.addJogabilidade("MMO"));

			} catch (Exception e) {
				fail("Nao deve lancar excecao aqui.");
			}

			try {
				assertTrue(fft.addJogabilidade(""));
				fail("Se chegar deve falhar pois deve lancar excecao.");

			} catch (Exception e) {
				assertEquals("X nome da jogabilidade eh invalidx, pois eh vazia.\n", e.getMessage());
			}

		} catch (Exception e) {
			fail("Nao deve lancar excecao aqui.");

		}
	}

	@Test
	public void testToString() {

		try {
			HashSet<Jogabilidade> jogabilidade = new HashSet<Jogabilidade>();
			jogabilidade.add(Jogabilidade.OFFLINE);
			Jogo fft = new JogoParaTest("Final Fantasy Tactics", 49.99, jogabilidade);

			String enter = "\n";
			String mensagem = "==> Jogou 0vez(es)" + enter + "==> Zerou 0vez(es)" + enter + "==> Maior Score: 0"
					+ enter;

			assertEquals(mensagem, fft.toString());
		} catch (Exception e) {
			fail("Nao deve lancar excecao aqui.");

		}

	}

}
