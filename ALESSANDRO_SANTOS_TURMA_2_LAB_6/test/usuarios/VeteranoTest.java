/* Matricula: 115111170 - Aluno: Alessandro Lia Fook Santos LAB 06 - Turma 2 */

package usuarios;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import constantes.Jogabilidade;
import jogos.Jogo;
import jogos.Luta;
import jogos.Plataforma;
import jogos.Rpg;

public class VeteranoTest {

	HashSet<Jogabilidade> jogabilidade;
	HashSet<Jogo> jogos;
	Jogo fft;
	Jogo smw;
	Jogo stf;

	@Before
	public void inicializaObjetos() {

		jogabilidade = new HashSet<Jogabilidade>();
		jogos = new HashSet<Jogo>();

		jogabilidade.add(Jogabilidade.OFFLINE);

		try {

			fft = new Rpg("Final Fantasy Tactics", 49.99, jogabilidade);
			smw = new Plataforma("Super Mario World", 30, jogabilidade);
			stf = new Luta("Street Fighter", 0, jogabilidade);

		} catch (Exception e) {
			fail("Nao deve lancar excecao aqui.");
		}
	}

	@Test
	public void testVeterano() {

		try {

			Usuario alfs = new Veterano("Alessandro fook", "alfs");
			assertEquals("Alessandro fook", alfs.getNome());
			assertEquals("alfs", alfs.getLogin());
			assertEquals(jogos, alfs.getJogos());
			assertTrue(alfs.getSaldo() == 0);
			assertTrue(alfs.getX2p() == 0);

		} catch (Exception e) {
			fail("Nao deve lancar excecao.");
		}

		try {

			Usuario usuarioInvalido = new Veterano("", "alfs");
			fail("Deve lancar excecao.");

		} catch (Exception e) {

			assertEquals("X nome dx usuarix eh invalidx, pois eh vazio.\n", e.getMessage());
		}

		try {

			Usuario usuarioInvalido = new Veterano(null, "alfs");
			fail("Deve lancar excecao.");

		} catch (Exception e) {

			assertEquals("X nome dx usuarix eh invalidx, pois eh igual a null.\n", e.getMessage());
		}

		try {

			Usuario usuarioInvalido = new Veterano("Alessandro", " ");
			fail("Deve lancar excecao.");

		} catch (Exception e) {

			assertEquals("X login dx usuarix eh invalidx, pois eh vazio.\n", e.getMessage());
		}

	}

	@Test
	public void testCompraJogo() {

		try {

			Usuario alfs = new Veterano("Alessandro fook", "alfs");

			assertFalse(alfs.compraJogo(smw));
			assertTrue(alfs.compraJogo(stf));
			assertNotEquals(jogos, alfs.getJogos());

			jogos.add(stf);
			assertEquals(jogos, alfs.getJogos());

			alfs.addDinheiro(1000);
			assertTrue(alfs.compraJogo(fft));
			assertTrue(alfs.getX2p() == 750);

			assertNotEquals(jogos, alfs.getJogos());

		} catch (Exception e) {
			fail("Nao deve lancar excecao.");
		}

		try {

			Usuario alfs = new Veterano("Alessandro fook", "alfs");
			assertTrue(alfs.compraJogo(null));
			fail("Deve lancar excecao.");

		} catch (Exception e) {
			assertEquals("X jogo eh invalidx, pois eh igual a null.\n", e.getMessage());
		}

	}

	@Test
	public void testToString() {

		String enter = "\n";
		String mensagem = "alfs" + enter + "Alessandro fook - Jogador Veterano" + enter + "+ Street Fighter - Luta:" + enter
				+ "==> Jogou 0vez(es)" + enter + "==> Zerou 0vez(es)" + enter + "==> Maior Score: 0" + enter + enter
				+ "+ Final Fantasy Tactics - RPG:" + enter + "==> Jogou 0vez(es)" + enter + "==> Zerou 0vez(es)" + enter
				+ "==> Maior Score: 0" + enter + enter + "Total de preco dos jogos: R$ 49,99";

		try {

			Usuario alfs = new Veterano("Alessandro fook", "alfs");

			assertTrue(alfs.compraJogo(stf));
			alfs.addDinheiro(1000);
			assertTrue(alfs.compraJogo(fft));
			assertTrue(alfs.getX2p() == 750);

			assertEquals(mensagem, alfs.toString());

		} catch (Exception e) {
			fail("Nao deve lancar excecao.");
		}

	}

}
