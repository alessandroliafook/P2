/* Matricula: 115111170 - Aluno: Alessandro Lia Fook Santos LAB 06 - Turma 2 */

package jogos;

import static org.junit.Assert.*;

import java.util.HashSet;

import constantes.Jogabilidade;
import org.junit.Test;

public class RpgTest {

	/**
	 * Testando o construtor da classe.
	 */
	@Test
	public void testRpg() {

		HashSet<Jogabilidade> jogabilidade = new HashSet<Jogabilidade>();
		jogabilidade.add(Jogabilidade.OFFLINE);

		try {
			Jogo fft = new Rpg("Final Fantasy Tactics", 49.99, jogabilidade);

			assertEquals("Final Fantasy Tactics", fft.getNome());
			assertTrue(49.99 == fft.getPreco());
			assertTrue(fft.getEstilo().contains(Jogabilidade.OFFLINE));

		} catch (Exception e) {
			fail("Nao deve lancar excecao aqui.");
		}

		try {
			String nomeInvalido = "";

			Jogo jogoInvalido = new Rpg(nomeInvalido, 1, jogabilidade);
			fail("Se chegar aqui esta errado, pois deve lancar excecao.");
		} catch (Exception e) {
			assertEquals("X nome do jogo eh invalidx, pois eh vazio.\n", e.getMessage());

		}

		try {
			String nomeInvalido = null;

			Jogo jogoInvalido = new Rpg(nomeInvalido, 1, jogabilidade);
			fail("Se chegar aqui esta errado, pois deve lancar excecao.");
		} catch (Exception e) {
			assertEquals("X nome do jogo eh invalidx, pois eh null.\n", e.getMessage());

		}

		try {

			Jogo jogoInvalido = new Rpg("Final Fantasy", -1, jogabilidade);
			fail("Se chegar aqui esta errado, pois deve lancar excecao.");
		} catch (Exception e) {
			assertEquals("X preco do jogo eh invalidx, pois eh menor que zero.\n", e.getMessage());

		}

		try {

			jogabilidade = null;
			Jogo jogoInvalido = new Rpg("Final Fantasy", 0, jogabilidade);
			fail("Se chegar aqui esta errado, pois deve lancar excecao.");
		} catch (Exception e) {
			assertEquals("X jogabilidade do jogo eh invalidx, pois eh igual a null.\n", e.getMessage());

		}
	}

	@Test
	public void testRegistraJogada() {

		try {
			HashSet<Jogabilidade> jogabilidade = new HashSet<Jogabilidade>();
			jogabilidade.add(Jogabilidade.OFFLINE);
			Jogo fft = new Rpg("Final Fantasy Tactics", 49.99, jogabilidade);

			try {

				assertTrue(fft.getScore() == 0);
				assertTrue(fft.getVezesConcluidas() == 0);
				assertTrue(fft.getVezesJogadas() == 0);

				assertTrue(fft.registraJogada(10000, false) == 10);
				assertTrue(fft.getScore() == 10000);
				assertTrue(fft.getVezesConcluidas() == 0);
				assertTrue(fft.getVezesJogadas() == 1);

				assertFalse(fft.registraJogada(9000, true) == 9);
				assertTrue(fft.getScore() == 10000);
				assertTrue(fft.getVezesConcluidas() == 1);
				assertTrue(fft.getVezesJogadas() == 2);

				assertFalse(fft.registraJogada(19000, false) == 11);
				assertTrue(fft.getScore() == 19000);
				assertTrue(fft.getVezesConcluidas() == 1);
				assertTrue(fft.getVezesJogadas() == 3);

			} catch (Exception e) {
				fail("Nao deve lancar excecao aqui.");
			}

			try {
				assertTrue(fft.registraJogada(-1, false) == 10);
				fail("Se chegar deve falhar pois deve lancar excecao.");

			} catch (Exception e) {
				assertEquals("X score eh invalidx, pois eh menor que zero.\n", e.getMessage());
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
			Jogo fft = new Rpg("Final Fantasy Tactics", 49.99, jogabilidade);

			String enter = "\n";
			String mensagem = "+ Final Fantasy Tactics - RPG:" + enter + "==> Jogou 0vez(es)" + enter
					+ "==> Zerou 0vez(es)" + enter + "==> Maior Score: 0" + enter;

			assertEquals(mensagem, fft.toString());
		} catch (Exception e) {
			fail("Nao deve lancar excecao aqui.");

		}

	}

}
