/* Matricula: 115111170 - Aluno: Alessandro Lia Fook Santos LAB 07 - Turma 2 */

package usuarios;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import jogos.Jogabilidade;
import jogos.Jogo;
import jogos.Luta;
import jogos.Plataforma;
import jogos.Rpg;

public class UsuarioTest {

	Set<String> jogabilidade;
	HashSet<Jogo> jogos;
	Jogo fft;
	Jogo smw;
	Jogo stf;

	@Before
	public void inicializaObjetos() {

		jogabilidade = new HashSet<String>();
		jogos = new HashSet<Jogo>();

		jogabilidade.add("offline");

		try {

			fft = new Rpg("Final Fantasy Tactics", 49.99, jogabilidade);
			smw = new Plataforma("Super Mario World", 30, jogabilidade);
			stf = new Luta("Street Fighter", 0, jogabilidade);

		} catch (Exception e) {
			fail("Nao deve lancar excecao aqui.");
		}
	}

	@Test
	public void testUsuari0() {

		try {

			Usuario alfs = new Usuario("Alessandro fook", "alfs");
			assertEquals("Alessandro fook", alfs.getNome());
			assertEquals("alfs", alfs.getLogin());
			assertEquals(jogos, alfs.getJogos());
			assertTrue(alfs.getSaldo() == 0);
			assertTrue(alfs.getX2p() == 0);

		} catch (Exception e) {
			fail("Nao deve lancar excecao.");
		}

		try {

			Usuario usuarioInvalido = new Usuario("", "alfs");
			fail("Deve lancar excecao.");

		} catch (Exception e) {

			assertEquals("X nome dx usuarix eh invalidx, pois eh vazio.\n", e.getMessage());
		}

		try {

			Usuario usuarioInvalido = new Usuario(null, "alfs");
			fail("Deve lancar excecao.");

		} catch (Exception e) {

			assertEquals("X nome dx usuarix eh invalidx, pois eh igual a null.\n", e.getMessage());
		}

		try {

			Usuario usuarioInvalido = new Usuario("Alessandro", " ");
			fail("Deve lancar excecao.");

		} catch (Exception e) {

			assertEquals("X login dx usuarix eh invalidx, pois eh vazio.\n", e.getMessage());
		}

	}

	@Test
	public void testAddDinheiro() {

		try {

			Usuario alfs = new Usuario("Alessandro fook", "alfs");
			alfs.addDinheiro(1000);
			assertTrue(alfs.getSaldo() == 1000);

			alfs.addDinheiro(1000);
			assertTrue(alfs.getSaldo() == 2000);

		} catch (Exception e) {
			fail("Nao deve lancar excecao.");
		}

		try {

			Usuario alfs = new Usuario("Alessandro fook", "alfs");
			alfs.addDinheiro(-10);
			fail("Deve lancar excecao.");

		} catch (Exception e) {

			assertEquals("X valor em dinheiro inserido eh invalidx, pois eh menor que zero.\n", e.getMessage());
		}

	}

	public void testCompraJogo() {

		// teste usuario Noob
		
		try {
		
			Usuario alfs = new Usuario("Alessandro fook", "alfs");

			assertFalse(alfs.compraJogo(smw));
			assertTrue(alfs.compraJogo(stf));
	

		try {

			assertNotEquals(jogos, alfs.getJogos());

			jogos.add(stf);
			assertEquals(jogos, alfs.getJogos());

			alfs.addDinheiro(1000);
			assertTrue(alfs.compraJogo(fft));
			assertTrue(alfs.getX2p() == 500);

			assertNotEquals(jogos, alfs.getJogos());

		} catch (Exception e) {
			fail("Nao deve lancar excecao.");
		}

		} catch (Exception e) {
			fail("Nao deve lancar excecao.");
		}

		try {

			Usuario alfs = new Usuario("Alessandro fook", "alfs");
			assertTrue(alfs.compraJogo(null));
			fail("Deve lancar excecao.");

		} catch (Exception e) {
			assertEquals("X jogo eh invalidx, pois eh igual a null.\n", e.getMessage());
		}

		// teste para usuario Veterano
		
		try {

			Usuario alfs = new Usuario("Alessandro fook", "alfs");

			fft = new Rpg("Final Fantasy Tactics", 60, jogabilidade);
			smw = new Plataforma("Super Mario World", 45, jogabilidade);
			stf = new Luta("Street Fighter", 10, jogabilidade);
			
			alfs.addDinheiro(200);
			
			alfs.compraJogo(smw);
			alfs.compraJogo(fft);

			assertTrue(alfs.getCategoria() instanceof Veterano);
			alfs.compraJogo(stf);
			assertTrue(alfs.getSaldo() == 1200);
	
		} catch (Exception e) {
			fail("Nao deve lancar excecao.");
		}

		
	}
	
	@Test
	public void testRecompensar() {

		// teste para o usuario Noob
		
		try {

			Usuario alfs = new Usuario("Alessandro fook", "alfs");

			alfs.getJogos().add(stf);
			alfs.getJogos().add(fft);

			alfs.recompensar("Final Fantasy Tactics", 100, false);
			assertTrue(alfs.getX2p() == 40);

			alfs.recompensar("Super Mario World", 100, true);
			assertTrue(alfs.getX2p() == 40);

		} catch (Exception e) {
			fail("Nao deve lancar excecao.");
		}

		try {

			Usuario alfs = new Usuario("Alessandro fook", "alfs");
			alfs.addDinheiro(1);
			alfs.compraJogo(stf);
			alfs.recompensar("", 10, true);
			fail("Deve lancar excecao.");

		} catch (Exception e) {

			assertEquals("X nome dx jogo eh invalidx, pois eh vazio.\n", e.getMessage());
		}

		try {

			Usuario alfs = new Usuario("Alessandro fook", "alfs");
			assertTrue(alfs.compraJogo(stf));
			alfs.recompensar("Street Fighter", -1, true);
			fail("Deve lancar excecao.");

		} catch (Exception e) {

			assertEquals("X valor do score eh invalidx, pois eh menor que zero.\n", e.getMessage());
		}

		
		// teste para o usuario veterano
		
		
		// teste para usuario Veterano
		
		try {

			Usuario alfs = new Usuario("Alessandro fook", "alfs");
			Set<String> jogabilidade2 = new HashSet<String>();
			
			jogabilidade2.add("online");
			jogabilidade2.add("competitivo");
			
			fft = new Rpg("Final Fantasy Tactics", 60, jogabilidade2);
			smw = new Plataforma("Super Mario World", 45, jogabilidade);
			
			alfs.addDinheiro(200);
			
			alfs.compraJogo(smw);
			alfs.compraJogo(fft);

			alfs.recompensar("Final Fantasy Tactics", 10, true);
			assertTrue(alfs.getX2p() == 1070);
			

		} catch (Exception e) {
			fail("Nao deve lancar excecao.");
		}

		
	}

	@Test
	public void testPunir() {

		// testes para usuario Noob
		
		try {

			Usuario alfs = new Usuario("Alessandro fook", "alfs");

			alfs.getJogos().add(stf);
			alfs.getJogos().add(fft);

			alfs.punir("Final Fantasy Tactics", 100, false);
			assertTrue(alfs.getX2p() == 10);

			alfs.punir("Super Mario World", 100, true);
			assertTrue(alfs.getX2p() == 10);

		} catch (Exception e) {
			fail("Nao deve lancar excecao.");
		}

		try {

			Usuario alfs = new Usuario("Alessandro fook", "alfs");
			alfs.addDinheiro(1);
			alfs.compraJogo(stf);
			alfs.punir("", 10, true);
			fail("Deve lancar excecao.");

		} catch (Exception e) {

			assertEquals("X nome dx jogo eh invalidx, pois eh vazio.\n", e.getMessage());
		}

		try {

			Usuario alfs = new Usuario("Alessandro fook", "alfs");
			assertTrue(alfs.compraJogo(stf));
			alfs.punir("Street Fighter", -1, true);
			fail("Deve lancar excecao.");

		} catch (Exception e) {

			assertEquals("X valor do score eh invalidx, pois eh menor que zero.\n", e.getMessage());
		}

		// teste para usuario Veterano
		
		try {

			Usuario alfs = new Usuario("Alessandro fook", "alfs");
			Set<String> jogabilidade2 = new HashSet<String>();
			
			jogabilidade2.add("online");
			jogabilidade2.add("competitivo");
			
			fft = new Rpg("Final Fantasy Tactics", 60, jogabilidade2);
			smw = new Plataforma("Super Mario World", 45, jogabilidade);
			
			alfs.addDinheiro(200);
			
			alfs.compraJogo(smw);
			alfs.compraJogo(fft);

			alfs.punir("Final Fantasy Tactics", 10, true);
			assertTrue(alfs.getX2p() == 1040);
			

		} catch (Exception e) {
			fail("Nao deve lancar excecao.");
		}
		
	}
	
	@Test
	public void testToString() {

		String enter = "\n";
		String mensagem = "Jogador Veterano: alfs" + enter + "Alessandro fook - 1050 x2p" + enter + "Lista de Jogos:"
				+ enter + "+ Super Mario World - Plataforma:" + enter + "==> Jogou 0vez(es)" + enter + "==> Zerou 0vez(es)"
				+ enter + "==> Maior Score: 0" + enter + enter + "+ Final Fantasy Tactics - RPG:" + enter
				+ "==> Jogou 0vez(es)" + enter + "==> Zerou 0vez(es)" + enter + "==> Maior Score: 0" + enter + enter
				+ "Total de preco dos jogos: R$ 105,00" + enter;

		try {

			Usuario alfs = new Usuario("Alessandro fook", "alfs");

			fft = new Rpg("Final Fantasy Tactics", 60, jogabilidade);
			smw = new Plataforma("Super Mario World", 45, jogabilidade);
			
			alfs.addDinheiro(200);
			
			alfs.compraJogo(smw);
			alfs.compraJogo(fft);

			assertEquals(mensagem, alfs.toString());

		} catch (Exception e) {
			fail("Nao deve lancar excecao.");
		}

	}
}
