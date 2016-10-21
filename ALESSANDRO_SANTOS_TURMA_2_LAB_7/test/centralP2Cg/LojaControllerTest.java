/* Matricula: 115111170 - Aluno: Alessandro Lia Fook Santos LAB 07 - Turma 2 */

package centralP2Cg;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import jogos.Jogo;
import jogos.Luta;
import jogos.Plataforma;
import jogos.Rpg;
import usuarios.Usuario;

public class LojaControllerTest {

	HashSet<String> jogabilidades;
	HashSet<Jogo> jogos;
	Jogo fft;
	Jogo smw;
	Jogo stf;
	Usuario alfs;
	LojaController loja;

	@Before
	public void setUp() {

		jogabilidades = new HashSet<String>();
		jogos = new HashSet<Jogo>();

		jogabilidades.add("offline");

		loja = new LojaController();

		try {
			fft = new Rpg("Final Fantasy Tactics", 49.99, jogabilidades);
			smw = new Plataforma("Super Mario World", 30, jogabilidades);
			stf = new Luta("Street Fighter", 0, jogabilidades);

			alfs = new Usuario("Alessandro fook", "alfs");

		} catch (Exception e) {
			fail("Nao deve lancar excecao aqui.");
		}
	}

	@Test
	public void testAddUsuario() {

		try {
			loja.addUsuario("Alessandro fook", "alfs");
			assertTrue(loja.getClientes().containsKey("alfs"));
			assertEquals(alfs, loja.getClientes().get("alfs"));
		} catch (Exception e) {
			fail("nao deve falhar");
		}

		try {
			loja.addUsuario("Alessandro fook", "alfs");

		} catch (Exception e) {
			assertEquals("X login dx usuarix eh invalidx, pois jah esta cadastrado no sistema.\n", e.getMessage());
		}

		try {
			loja.addUsuario("", "login");
		} catch (Exception e) {
			assertEquals("X nome dx usuarix eh invalidx, pois eh vazio.\n", e.getMessage());
		}

		try {
			loja.addUsuario(null, "login");
		} catch (Exception e) {
			assertEquals("X nome dx usuarix eh invalidx, pois eh igual a null.\n", e.getMessage());
		}

		try {
			loja.addUsuario("usuario", "");
		} catch (Exception e) {
			assertEquals("X login dx usuarix eh invalidx, pois eh vazio.\n", e.getMessage());
		}

	}

	@Test
	public void testAddDinheiro() {

		try {
			loja.addUsuario("Alessandro fook", "alfs");

			loja.addDinheiro("alfs", 100);
			assertEquals(100, loja.getClientes().get("alfs").getSaldo(), 0.01);
		} catch (Exception e) {
			fail("nao deve lancar excecao");
		}

		try {
			loja.addDinheiro("alfs", -1);
		} catch (Exception e) {
			assertEquals("X valor em dinheiro inserido eh invalidx, pois eh menor que zero.\n", e.getMessage());

		}

		try {
			loja.addDinheiro("DareDevil", 10);
		} catch (Exception e) {
			assertEquals("X login dx usuarix eh invalidx, pois nao existe no sistema.\n", e.getMessage());
		}

	}

	@Test
	public void testVendeJogo() {

		try {
			loja.addUsuario("Alessandro fook", "alfs");
			loja.addUsuario("Frank Castle", "punisher");

			loja.addDinheiro("alfs", 100);
			loja.addDinheiro("punisher", 40.25);

			loja.vendeJogo("alfs", jogabilidades, "Final Fantasy Tactics", 49.99, "rpg");
			loja.vendeJogo("punisher", jogabilidades, "Street Fighter", 0, "Luta");

			assertTrue(loja.getClientes().get("alfs").getJogos().contains(fft));
			assertFalse(loja.getClientes().get("alfs").getJogos().contains(stf));

			assertTrue(loja.getClientes().get("punisher").getJogos().contains(stf));
			assertFalse(loja.getClientes().get("punisher").getJogos().contains(fft));

		} catch (Exception e) {
			fail("nao deve lancar excecao");
		}

		try {
			loja.vendeJogo(null, jogabilidades, "Super Mario World", 30, "PLATAFORMA");
		} catch (Exception e) {
			assertEquals("X login dx usuarix eh invalidx, pois eh igual a null.\n", e.getMessage());
		}

		try {
			loja.vendeJogo("elektra", jogabilidades, "Super Mario World", 30, "PLATAFORMA");
		} catch (Exception e) {
			assertEquals("X login dx usuarix eh invalidx, pois nao existe no sistema.\n", e.getMessage());
		}

	}

	@Test
	public void testImprimeInformacoes() {
		String enter = "\n";

		String mensagem = "=== Central P2-CG ===" + enter + enter + "Jogador Veterano: alfs" + enter
				+ "Alessandro fook - 1050 x2p" + enter + "Lista de Jogos:" + enter + "+ Super Mario World - Plataforma:"
				+ enter + "==> Jogou 0vez(es)" + enter + "==> Zerou 0vez(es)" + enter + "==> Maior Score: 0" + enter
				+ enter + "+ Final Fantasy Tactics - RPG:" + enter + "==> Jogou 0vez(es)" + enter + "==> Zerou 0vez(es)"
				+ enter + "==> Maior Score: 0" + enter + enter + "Total de preco dos jogos: R$ 105,00" + enter + enter
				+ "Jogador Noob: punisher" + enter + "Frank Castle - 0 x2p" +enter + "Lista de Jogos:" + enter + "+ Street Fighter - Luta:" + enter
				+ "==> Jogou 0vez(es)" + enter + "==> Zerou 0vez(es)" + enter + "==> Maior Score: 0" + enter + enter
				+ "Total de preco dos jogos: R$ 0,00" + enter + enter + "-----------------------------------------------------";

		try {

			loja.addUsuario("Alessandro fook", "alfs");
			loja.addUsuario("Frank Castle", "punisher");

			loja.addDinheiro("alfs", 100);
			loja.addDinheiro("punisher", 40.25);

			HashSet<String> jogabilidade = new HashSet<String>();
			jogabilidade.add("offline");

			loja.vendeJogo("alfs", jogabilidade, "Final Fantasy Tactics", 60, "rpg");
			loja.vendeJogo("alfs", jogabilidade, "Super Mario World", 45, "PLATAFORMA");
			loja.vendeJogo("punisher", jogabilidade, "Street Fighter", 0, "Luta");

			assertEquals(mensagem, loja.imprimeInformacoes());

		} catch (Exception e) {
			fail("nao deve lancar excecao");
		}

	}
}
