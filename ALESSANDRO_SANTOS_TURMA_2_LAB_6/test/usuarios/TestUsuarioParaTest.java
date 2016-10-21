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

public class TestUsuarioParaTest {

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
	public void testNoob() {

		try {

			Usuario alfs = new UsuarioParaTest("Alessandro fook", "alfs");
			assertEquals("Alessandro fook", alfs.getNome());
			assertEquals("alfs", alfs.getLogin());
			assertEquals(jogos, alfs.getJogos());
			assertTrue(alfs.getSaldo() == 0);
			assertTrue(alfs.getX2p() == 0);

		} catch (Exception e) {
			fail("Nao deve lancar excecao.");
		}

		try {

			Usuario usuarioInvalido = new UsuarioParaTest("", "alfs");
			fail("Deve lancar excecao.");

		} catch (Exception e) {

			assertEquals("X nome dx usuarix eh invalidx, pois eh vazio.\n", e.getMessage());
		}

		try {

			Usuario usuarioInvalido = new UsuarioParaTest(null, "alfs");
			fail("Deve lancar excecao.");

		} catch (Exception e) {

			assertEquals("X nome dx usuarix eh invalidx, pois eh igual a null.\n", e.getMessage());
		}

		try {

			Usuario usuarioInvalido = new UsuarioParaTest("Alessandro", " ");
			fail("Deve lancar excecao.");

		} catch (Exception e) {

			assertEquals("X login dx usuarix eh invalidx, pois eh vazio.\n", e.getMessage());
		}

	}

	@Test
	public void testAddDinheiro() {

		try {

			Usuario alfs = new UsuarioParaTest("Alessandro fook", "alfs");
			alfs.addDinheiro(1000);
			assertTrue(alfs.getSaldo() == 1000);

			alfs.addDinheiro(1000);
			assertTrue(alfs.getSaldo() == 2000);

		} catch (Exception e) {
			fail("Nao deve lancar excecao.");
		}

		try {

			Usuario alfs = new UsuarioParaTest("Alessandro fook", "alfs");
			alfs.addDinheiro(-10);
			fail("Deve lancar excecao.");

		} catch (Exception e) {

			assertEquals("X valor em dinheiro inserido eh invalidx, pois eh menor que zero.\n", e.getMessage());
		}

		try {

			Usuario alfs = new UsuarioParaTest("Alessandro fook", "alfs");
			alfs.addDinheiro(0);
			fail("Deve lancar excecao.");

		} catch (Exception e) {

			assertEquals("X valor em dinheiro inserido eh invalidx, pois eh igual a zero.\n", e.getMessage());
		}

	}

	@Test
	public void testRegistraJogada() {

		try {

			Usuario alfs = new UsuarioParaTest("Alessandro fook", "alfs");

			alfs.getJogos().add(stf);
			alfs.getJogos().add(fft);

			alfs.registraJogada("Final Fantasy Tactics", 100, false);
			assertTrue(alfs.getX2p() == 10);

			alfs.registraJogada("Super Mario World", 100, true);
			assertTrue(alfs.getX2p() == 10);

		} catch (Exception e) {
			fail("Nao deve lancar excecao.");
		}

		try {

			Usuario alfs = new UsuarioParaTest("Alessandro fook", "alfs");
			assertTrue(alfs.compraJogo(stf));
			alfs.registraJogada("", 10, true);
			fail("Deve lancar excecao.");

		} catch (Exception e) {

			assertEquals("X nome dx jogo eh invalidx, pois eh vazio.\n", e.getMessage());
		}

		try {

			Usuario alfs = new UsuarioParaTest("Alessandro fook", "alfs");
			assertTrue(alfs.compraJogo(stf));
			alfs.registraJogada("Street Fighter", -1, true);
			fail("Deve lancar excecao.");

		} catch (Exception e) {

			assertEquals("X valor do score eh invalidx, pois eh menor que zero.\n", e.getMessage());
		}

	}

	@Test
	public void testToString() {

		String enter = "\n";
		String mensagem = "+ Street Fighter - Luta:" + enter + "==> Jogou 0vez(es)" + enter + "==> Zerou 0vez(es)"
				+ enter + "==> Maior Score: 0" + enter + enter + "+ Final Fantasy Tactics - RPG:" + enter
				+ "==> Jogou 0vez(es)" + enter + "==> Zerou 0vez(es)" + enter + "==> Maior Score: 0" + enter + enter
				+ "Total de preco dos jogos: R$ 49,99";

		try {

			Usuario alfs = new UsuarioParaTest("Alessandro fook", "alfs");

			alfs.getJogos().add(stf);
			alfs.getJogos().add(fft);

			assertEquals(mensagem, alfs.toString());

		} catch (Exception e) {
			fail("Nao deve lancar excecao.");
		}

	}
}
