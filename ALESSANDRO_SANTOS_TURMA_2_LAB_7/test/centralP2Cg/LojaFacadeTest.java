/* Matricula: 115111170 - Aluno: Alessandro Lia Fook Santos LAB 07 - Turma 2 */

package centralP2Cg;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import jogos.Jogo;
import usuarios.Usuario;

public class LojaFacadeTest {

	HashSet<String> jogabilidades;
	HashSet<Jogo> jogos;
	Usuario alfs;
	LojaFacade loja;

	@Before
	public void setUp() {

		jogabilidades = new HashSet<String>();
		jogos = new HashSet<Jogo>();
		
		jogabilidades.add("offline");

		loja = new LojaFacade();
	}

	@Test
	public void testAddUsuario() {

		loja.addUsuario("Alessandro fook", "alfs");

		// vai imprimir a mensagem de excecao na tela

		System.out.println("X login dx usuarix eh invalidx, pois jah esta cadastrado no sistema.");
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

		// excecoes serao lancadas no console

		System.out.println("X valor em dinheiro inserido eh invalidx, pois eh menor que zero.");
		loja.addDinheiro("alfs", -1);

		System.out.println("X login dx usuarix eh invalidx, pois nao existe no sistema.");
		loja.addDinheiro("DareDevil", 10);

	
	}

	@Test
	public void testVendeJogo() {

		loja.addUsuario("Alessandro fook", "alfs");
		loja.addUsuario("Frank Castle", "punisher");

		loja.addDinheiro("alfs", 100);
		loja.addDinheiro("punisher", 40.25);

		loja.vendeJogo("alfs", jogabilidades, "Final Fantasy Tactics", 49.99, "rpg");
		System.out.println("encontra erro");
		loja.vendeJogo("punisher", jogabilidades, "Street Fighter", 0, "Luta");
		loja.imprimeInformacoes();
		

		
		
		// as excecoes serao lancadas na tela

		System.out.println("X login dx usuarix eh invalidx, pois eh igual a null.");
		loja.vendeJogo(null, jogabilidades, "Super Mario World", 30, "PLATAFORMA");

		System.out.println("X login dx usuarix eh invalidx, pois nao existe no sistema.");
		loja.vendeJogo("elektra", jogabilidades, "Super Mario World", 30, "PLATAFORMA");

	}

	@Test
	public void testImprimeInformacoes() {
		String enter = "\n";
		String mensagem = "=== Central P2-CG ===" + enter + enter + "Jogador Veterano: alfs" + enter
				+ "Alessandro fook - 1050 x2p" + enter + "Lista de Jogos:" + enter + "+ Super Mario World - RPG:"
				+ enter + "==> Jogou 0vez(es)" + enter + "==> Zerou 0vez(es)" + enter + "==> Maior Score: 0" + enter
				+ enter + "+ Final Fantasy Tactics - RPG:" + enter + "==> Jogou 0vez(es)" + enter + "==> Zerou 0vez(es)"
				+ enter + "==> Maior Score: 0" + enter + enter + "Total de preco dos jogos: R$ 105,00" + enter + enter
				+ "Jogador Noob: punisher" + enter + "Frank Castle - 0 x2p" +enter + "Lista de Jogos:" + enter + "+ Street Fighter - Luta:" + enter
				+ "==> Jogou 0vez(es)" + enter + "==> Zerou 0vez(es)" + enter + "==> Maior Score: 0" + enter + enter
				+ "Total de preco dos jogos: R$ 0,00" + enter + enter + "-----------------------------------------------------";

		loja.addUsuario("Alessandro fook", "alfs");
		loja.addUsuario("Frank Castle", "punisher");

		loja.addDinheiro("alfs", 100);
		loja.addDinheiro("punisher", 40.25);

		HashSet<String> jogabilidade = new HashSet<String>();

		loja.vendeJogo("alfs", jogabilidade, "Final Fantasy Tactics", 60, "rpg");
		loja.vendeJogo("alfs", jogabilidade, "Super Mario World", 45, "rpg");
		loja.vendeJogo("punisher", jogabilidade, "Street Fighter", 0, "Luta");

		loja.imprimeInformacoes();
		System.out.println(mensagem);

	}
}
