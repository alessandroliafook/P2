/* Matricula: 115111170 - Aluno: Alessandro Lia Fook Santos LAB 07 - Turma 2 */

package centralP2Cg;

import java.util.Set;
import centralP2Cg.LojaController;

public class LojaFacade {

	LojaController controler;

	public LojaFacade() {

		try {
			this.controler = new LojaController();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void addUsuario(String nome, String login) {
		try {
			controler.addUsuario(nome, login);

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}

	public void addDinheiro(String login, double valor) {
		try {
			controler.addDinheiro(login, valor);

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}

	public void imprimeInformacoes() {

		try {
			System.out.println(controler.imprimeInformacoes());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void vendeJogo(String login, Set<String> jogabilidades, String nomeDoJogo, double precoDoJogo,
			String estilo) {

		try {
			controler.vendeJogo(login, jogabilidades, nomeDoJogo, precoDoJogo, estilo);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
