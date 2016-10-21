/* Matricula: 115111170 - Aluno: Alessandro Lia Fook Santos LAB 06 - Turma 2 */

package jogos;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Test;

import constantes.Jogabilidade;

public class PlataformaTest {

	/**
	 * Testando o construtor da classe.
	 */
	@Test
	public void PlataformaTest() {

		HashSet<Jogabilidade> jogabilidade = new HashSet<Jogabilidade>();
		jogabilidade.add(Jogabilidade.OFFLINE);

		try {
			Jogo smw = new Plataforma("Super Mario World", 30, jogabilidade);

			assertEquals("Super Mario World", smw.getNome());
			assertTrue(30 == smw.getPreco());
			assertTrue(smw.getEstilo().contains(Jogabilidade.OFFLINE));

		} catch (Exception e) {
			fail("Nao deve lancar excecao aqui.");
		}

		try {
			String nomeInvalido = "";

			Jogo jogoInvalido = new Luta(nomeInvalido, 30, jogabilidade);
			fail("Se chegar aqui esta errado, pois deve lancar excecao.");
		} catch (Exception e) {
			assertEquals("X nome do jogo eh invalidx, pois eh vazio.\n", e.getMessage());

		}

		try {
			String nomeInvalido = null;

			Jogo jogoInvalido = new Luta(nomeInvalido, 15, jogabilidade);
			fail("Se chegar aqui esta errado, pois deve lancar excecao.");
		} catch (Exception e) {
			assertEquals("X nome do jogo eh invalidx, pois eh null.\n", e.getMessage());

		}

		try {

			Jogo jogoInvalido = new Luta("Super Mario World", -1, jogabilidade);
			fail("Se chegar aqui esta errado, pois deve lancar excecao.");
		} catch (Exception e) {
			assertEquals("X preco do jogo eh invalidx, pois eh menor que zero.\n", e.getMessage());

		}

		try {

			jogabilidade = null;
			Jogo jogoInvalido = new Luta("Super Mario World", 0, jogabilidade);
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
			Jogo smw = new Plataforma("Super Mario World", 30, jogabilidade);

			try {

				assertTrue(smw.getScore() == 0);
				assertTrue(smw.getVezesConcluidas() == 0);
				assertTrue(smw.getVezesJogadas() == 0);

				assertTrue(smw.registraJogada(10000, false) == 0);
				assertTrue(smw.getScore() == 10000);
				assertTrue(smw.getVezesConcluidas() == 0);
				assertTrue(smw.getVezesJogadas() == 1);

				assertTrue(smw.registraJogada(9000, true) == 20);
				assertTrue(smw.getScore() == 10000);
				assertTrue(smw.getVezesConcluidas() == 1);
				assertTrue(smw.getVezesJogadas() == 2);

				assertTrue(smw.registraJogada(19000, false) == 0);
				assertTrue(smw.getScore() == 19000);
				assertTrue(smw.getVezesConcluidas() == 1);
				assertTrue(smw.getVezesJogadas() == 3);

			} catch (Exception e) {
				fail("Nao deve lancar excecao aqui.");
			}

			try {
				assertTrue(smw.registraJogada(-1, false) == 0);
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
			Jogo smw = new Plataforma("Super Mario World", 30, jogabilidade);

			String enter = "\n";
			String mensagem = "+ Super Mario World - Plataforma:" + enter + "==> Jogou 0vez(es)" + enter
					+ "==> Zerou 0vez(es)" + enter + "==> Maior Score: 0" + enter;

			assertEquals(mensagem, smw.toString());
		} catch (Exception e) {
			fail("Nao deve lancar excecao aqui.");

		}

	}

}
