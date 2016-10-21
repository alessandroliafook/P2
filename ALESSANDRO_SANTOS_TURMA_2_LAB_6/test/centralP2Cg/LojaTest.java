/* Matricula: 115111170 - Aluno: Alessandro Lia Fook Santos LAB 06 - Turma 2 */

package centralP2Cg;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import constantes.Jogabilidade;
import jogos.Jogo;
import jogos.Luta;
import jogos.Plataforma;
import jogos.Rpg;
import usuarios.Noob;
import usuarios.Usuario;
import usuarios.Veterano;

public class LojaTest {

	HashSet<Jogabilidade> jogabilidade;
	HashSet<Jogo> jogos;
	Jogo fft;
	Jogo smw;
	Jogo stf;
	Usuario alfs;
	Loja loja;

	@Before
	public void setUp() {

		jogabilidade = new HashSet<Jogabilidade>();
		jogos = new HashSet<Jogo>();

		jogabilidade.add(Jogabilidade.OFFLINE);

		loja = new Loja();

		try {
			fft = new Rpg("Final Fantasy Tactics", 49.99, jogabilidade);
			smw = new Plataforma("Super Mario World", 30, jogabilidade);
			stf = new Luta("Street Fighter", 0, jogabilidade);

			alfs = new Noob("Alessandro fook", "alfs");

		} catch (Exception e) {
			fail("Nao deve lancar excecao aqui.");
		}
	}

	@Test
	public void testAddUsuario() {

		loja.addUsuario("Alessandro fook", "alfs");
		assertTrue(loja.getClientes().containsKey("alfs"));
		assertEquals(alfs, loja.getClientes().get("alfs"));

		// vai imprimir a mensagem de excecao na tela
		System.out.println("X nome do usuarix eh invalidx, pois jah esta cadastrado no sistema.");
		loja.addUsuario("Alessandro fook", "alfs");

		System.out.println("X nome dx usuarix eh invalidx, pois eh vazio.");
		loja.addUsuario("", "login");

		System.out.println("X nome dx usuarix eh invalidx, pois eh igual a null.");
		loja.addUsuario(null, "login");

		System.out.println("X login dx usuarix eh invalidx, pois eh vazio.");
		loja.addUsuario("usuario", "");

	}

	@Test
	public void testAddDinheiro() {

		loja.addUsuario("Alessandro fook", "alfs");

		loja.addDinheiro("alfs", 100);
		assertEquals(100, loja.getClientes().get("alfs").getSaldo(), 0.01);

		// excecoes serao lancadas no console

		System.out.println("X valor em dinheiro inserido eh invalidx, pois eh menor que zero.");
		loja.addDinheiro("alfs", -1);

		System.out.println("X login do usuarix eh invalidx, pois nao existe no sistema.");
		loja.addDinheiro("DareDevil", 10);

	}

	@Test
	public void testVendeJogo() {

		loja.addUsuario("Alessandro fook", "alfs");
		loja.addUsuario("Frank Castle", "punisher");

		loja.addDinheiro("alfs", 100);
		loja.addDinheiro("punisher", 40.25);

		loja.vendeJogo("alfs", jogabilidade, "Final Fantasy Tactics", 49.99, "rpg");
		loja.vendeJogo("punisher", jogabilidade, "Street Fighter", 0, "Luta");

		assertTrue(loja.getClientes().get("alfs").getJogos().contains(fft));
		assertFalse(loja.getClientes().get("alfs").getJogos().contains(stf));

		assertTrue(loja.getClientes().get("punisher").getJogos().contains(stf));
		assertFalse(loja.getClientes().get("punisher").getJogos().contains(fft));

		// as excecoes serao lancadas na tela

		System.out.println("X login do usuarix eh invalidx, pois eh igual a null.");
		loja.vendeJogo(null, jogabilidade, "Super Mario World", 30, "PLATAFORMA");

		System.out.println("X login do usuarix eh invalidx, pois nao existe no sistema.");
		loja.vendeJogo("elektra", jogabilidade, "Super Mario World", 30, "PLATAFORMA");

	}

	@Test
	public void testUpgrade() {

		loja.addUsuario("Alessandro fook", "alfs");
		loja.addUsuario("Frank Castle", "punisher");

		loja.addDinheiro("alfs", 100);
		loja.addDinheiro("punisher", 40.25);

		loja.vendeJogo("alfs", jogabilidade, "Final Fantasy Tactics", 60, "rpg");
		loja.vendeJogo("alfs", jogabilidade, "Super Mario World", 45, "rpg");
		loja.vendeJogo("punisher", jogabilidade, "Street Fighter", 0, "Luta");

		loja.upgrade("alfs");
		assertTrue(loja.getClientes().get("alfs") instanceof Veterano);

		System.out
				.println("O upgrade dx usuarix Frank Castle nao foi possivel, pois tem menos de 1.000 pontos de X2P.");
		loja.upgrade("punisher");

	}

	@Test
	public void testImprimeInformacoes() {
		String enter = "\n";
		String mensagem = "=== Central P2­CG ===" + enter + enter + "alfs" + enter
				+ "Alessandro fook - Jogador Veterano" + enter + "+ Super Mario World - RPG:" + enter
				+ "==> Jogou 0vez(es)" + enter + "==> Zerou 0vez(es)" + enter + "==> Maior Score: 0" + enter + enter
				+ "+ Final Fantasy Tactics - RPG:" + enter + "==> Jogou 0vez(es)" + enter + "==> Zerou 0vez(es)" + enter
				+ "==> Maior Score: 0" + enter + enter + "Total de preco dos jogos: R$ 105,00" + enter + enter
				+ "punisher" + enter + "Frank Castle - Jogador Noob" + enter + "+ Street Fighter - Luta:" + enter
				+ "==> Jogou 0vez(es)" + enter + "==> Zerou 0vez(es)" + enter + "==> Maior Score: 0" + enter + enter
				+ "Total de preco dos jogos: R$ 0,00" + enter;

		loja.addUsuario("Alessandro fook", "alfs");
		loja.addUsuario("Frank Castle", "punisher");

		loja.addDinheiro("alfs", 100);
		loja.addDinheiro("punisher", 40.25);

		HashSet<Jogabilidade> jogabilidade = new HashSet<Jogabilidade>();

		loja.vendeJogo("alfs", jogabilidade, "Final Fantasy Tactics", 60, "rpg");
		loja.vendeJogo("alfs", jogabilidade, "Super Mario World", 45, "rpg");
		loja.vendeJogo("punisher", jogabilidade, "Street Fighter", 0, "Luta");

		loja.upgrade("alfs");

		loja.imprimeInformacoes();
		System.out.println(mensagem);
		
	}
}
