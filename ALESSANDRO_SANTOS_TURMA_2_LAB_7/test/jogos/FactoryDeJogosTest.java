/* Matricula: 115111170 - Aluno: Alessandro Lia Fook Santos LAB 07 - Turma 2 */

package jogos;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class FactoryDeJogosTest {

	FactoryDeJogos desenvolvedor = new FactoryDeJogos();

	@Test
	public void testCriaJogo() {

		Set<String> jogabilidade = new HashSet<String>();
		jogabilidade.add("offline");

		try {
			Jogo smw = desenvolvedor.criaJogo(jogabilidade, "Super Mario World", 30, "plataforma");

			assertEquals("Super Mario World", smw.getNome());
			assertTrue(30 == smw.getPreco());
			assertTrue(smw.getEstilo().contains(Jogabilidade.OFFLINE));

			Jogo stf = desenvolvedor.criaJogo(jogabilidade, "Street Fighter", 0, "LUTA");

			assertEquals("Street Fighter", stf.getNome());
			assertTrue(0 == stf.getPreco());
			assertTrue(stf.getEstilo().contains(Jogabilidade.OFFLINE));

			Jogo fft = desenvolvedor.criaJogo(jogabilidade, "Final Fantasy Tactics", 49.99, "rPg");

			assertEquals("Final Fantasy Tactics", fft.getNome());
			assertTrue(49.99 == fft.getPreco());
			assertTrue(fft.getEstilo().contains(Jogabilidade.OFFLINE));

		} catch (Exception e) {
			fail("Nao deve lancar excecao aqui.");
		}

		try {
			String nomeInvalido = "";
			Jogo jogoInvalido = desenvolvedor.criaJogo(jogabilidade, nomeInvalido, 30, "aventura");
			fail("Se chegar aqui esta errado, pois deve lancar excecao.");
		} catch (Exception e) {
			assertEquals(
					"X estilo do jogo eh invalidx, pois eh diferente das opcoes existentes (rpg, luga ou plataforma).\n",
					e.getMessage());

		}

		try {
			String nomeInvalido = "";
			Jogo jogoInvalido = desenvolvedor.criaJogo(jogabilidade, nomeInvalido, 30, "plataforma");
			fail("Se chegar aqui esta errado, pois deve lancar excecao.");
		} catch (Exception e) {
			assertEquals("X nome do jogo eh invalidx, pois eh vazio.\n", e.getMessage());

		}

		try {
			String nomeInvalido = null;

			Jogo jogoInvalido = desenvolvedor.criaJogo(jogabilidade, nomeInvalido, 1, "LUTA");
			fail("Se chegar aqui esta errado, pois deve lancar excecao.");
		} catch (Exception e) {
			assertEquals("X nome do jogo eh invalidx, pois eh null.\n", e.getMessage());

		}

		try {

			Jogo jogoInvalido = desenvolvedor.criaJogo(jogabilidade, "Final Fantasy", -1, "rpG");
			fail("Se chegar aqui esta errado, pois deve lancar excecao.");
		} catch (Exception e) {
			assertEquals("X preco do jogo eh invalidx, pois eh menor que zero.\n", e.getMessage());

		}

	}
}
