/* Matricula: 115111170 - Aluno: Alessandro Lia Fook Santos LAB 07 - Turma 2 */

package jogos;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class LutaTest {


		/**
		 * Testando o construtor da classe.
		 */
		@Test
		public void LutaTest() {

			Set<String> jogabilidade = new HashSet<String>();
			jogabilidade.add("offline");

			try {
				Jogo stf = new Luta("Street Fighter", 0, jogabilidade);

				assertEquals("Street Fighter", stf.getNome());
				assertTrue(0 == stf.getPreco());
				assertTrue(stf.getEstilo().contains(Jogabilidade.OFFLINE));

			} catch (Exception e) {
				fail("Nao deve lancar excecao aqui.");
			}

			try {
				String nomeInvalido = "";

				Jogo jogoInvalido = new Luta(nomeInvalido, 1, jogabilidade);
				fail("Se chegar aqui esta errado, pois deve lancar excecao.");
			} catch (Exception e) {
				assertEquals("X nome do jogo eh invalidx, pois eh vazio.\n", e.getMessage());

			}

			try {
				String nomeInvalido = null;

				Jogo jogoInvalido = new Luta(nomeInvalido, 1, jogabilidade);
				fail("Se chegar aqui esta errado, pois deve lancar excecao.");
			} catch (Exception e) {
				assertEquals("X nome do jogo eh invalidx, pois eh null.\n", e.getMessage());

			}

			try {

				Jogo jogoInvalido = new Luta("Street Fighter", -1, jogabilidade);
				fail("Se chegar aqui esta errado, pois deve lancar excecao.");
			} catch (Exception e) {
				assertEquals("X preco do jogo eh invalidx, pois eh menor que zero.\n", e.getMessage());

			}

			try {

				jogabilidade = null;
				Jogo jogoInvalido = new Luta("Street Fighter", 0, jogabilidade);
				fail("Se chegar aqui esta errado, pois deve lancar excecao.");
			} catch (Exception e) {
				assertEquals("X jogabilidade do jogo eh invalidx, pois eh igual a null.\n", e.getMessage());

			}
		}
		
		@Test
		public void testRegistraJogada() {

			try {
				Set<String> jogabilidade = new HashSet<String>();
				jogabilidade.add("offline");
				Jogo stf = new Luta("Street Fighter", 0, jogabilidade);

				try {

					assertTrue(stf.getScore() == 0);
					assertTrue(stf.getVezesConcluidas() == 0);
					assertTrue(stf.getVezesJogadas() == 0);

					assertTrue(stf.registraJogada(10000, false) == 10);
					assertTrue(stf.getScore() == 10000);
					assertTrue(stf.getVezesConcluidas() == 0);
					assertTrue(stf.getVezesJogadas() == 1);

					assertTrue(stf.registraJogada(9000, true) == 0);
					assertTrue(stf.getScore() == 10000);
					assertTrue(stf.getVezesConcluidas() == 1);
					assertTrue(stf.getVezesJogadas() == 2);

					assertTrue(stf.registraJogada(19000, false) == 19);
					assertTrue(stf.getScore() == 19000);
					assertTrue(stf.getVezesConcluidas() == 1);
					assertTrue(stf.getVezesJogadas() == 3);

				} catch (Exception e) {
					fail("Nao deve lancar excecao aqui.");
				}

				try {
					assertTrue(stf.registraJogada(-1, false) == 0);
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
				Set<String> jogabilidade = new HashSet<String>();
				jogabilidade.add("offline");
				Jogo stf = new Luta("Street Fighter", 0, jogabilidade);

				String enter = "\n";
				String mensagem = "+ Street Fighter - Luta:" + enter + "==> Jogou 0vez(es)" + enter
						+ "==> Zerou 0vez(es)" + enter + "==> Maior Score: 0" + enter;

				assertEquals(mensagem, stf.toString());
			} catch (Exception e) {
				fail("Nao deve lancar excecao aqui.");

			}

		}

}

