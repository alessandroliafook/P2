/* Matricula: 115111170 - Aluno: Alessandro Lia Fook Santos LAB 06 - Turma 2 */

package usuarios;

import java.util.HashSet;

import exceptions.ObjetoInvalidoException;
import jogos.Jogo;

public class Veterano extends Usuario {

	/**
	 * Realiza a construcao de um objeto do tipo Veterano, que eh subclasse de
	 * Usuario, que inicia sem qualquer dinheiro no saldo ou jogo.
	 * 
	 * @param nome
	 *            - Indica o nome do usuario.
	 * @param login
	 *            - Indica o login com o qual usuario podera ser acessado.
	 * @throws Exception
	 *             - Retorna uma mensagem de excecao acaso o nome ou o login
	 *             sejam inseridos vazios ou iguais a null.
	 */
	public Veterano(String nome, String login) throws Exception {
		super(nome, login);
	}

	/**
	 * Construtor sobrecarregado para viabilizar a execucao do upgrade.
	 * 
	 * @param nome
	 *            - Indica o nome do usuario.
	 * @param login
	 *            - Indica o login do usuario.
	 * @param saldo
	 *            - Indica o saldo atual do usuario.
	 * @param x2p
	 *            - Indica a quantidade de pontos de X2P atual do usuario.
	 * @param jogos
	 *            - Indica a lista de jogos possuidos pelo usuario.
	 * @throws Exception
	 *             - Retorna uma mensagem de excecao acaso nome ou login sejam
	 *             vazios. 
	 *             - Retorna uma mensagem de excesao acaso nome, login
	 *             ou jogos sejam iguais a null. 
	 *             - retorna uma mensagem de
	 *             excecao acaso x2p ou saldo sejam negativos.
	 */
	public Veterano(String nome, String login, double saldo, int x2p, HashSet<Jogo> jogos) throws Exception {
		super(nome, login, saldo, x2p, jogos);

	}

	/**
	 * Realiza a compra de um jogo, acaso o usuario tenha saldo superior ao
	 * preco do jogo, adicionando o respectivo bonus em Experience Players Point
	 * ao total do usuario, acaso a compra seja realizada com sucesso.
	 * 
	 * @param jogo
	 *            - Recebe como parametro um objeto do tipo Jogo.
	 * @throws Exception
	 *             - Retorna uma mensagem de excecao, acaso o jogo seja igual a
	 *             null.
	 */
	public boolean compraJogo(Jogo jogo) throws Exception {

		validaJogo(jogo);

		if (jogo.getPreco() > super.getSaldo()) {
			return false;

		} else {

			final double DESCONTO = 0.8;
			int X2P = Math.round((float)jogo.getPreco() * 15);
			double novoSaldo = super.getSaldo() - (jogo.getPreco() * DESCONTO);
			
			super.setSaldo(novoSaldo);
			super.getJogos().add(jogo);
			super.addX2p(X2P);

			return true;
		}

	}

	/**
	 * Verifica se o objeto do tipo Jogo eh igual a null.
	 * 
	 * @param jogo
	 *            - Objeto do tipo Jogo.
	 * @throws ObjetoInvalidoException
	 *             - Retorna uma mensagem informando que o jogo eh invalido.
	 */
	private void validaJogo(Jogo jogo) throws Exception {
		if (jogo == null) {
			String objeto = "jogo";
			String erro = "eh igual a null.";

			throw new ObjetoInvalidoException(objeto, erro);
		}
	}

	public String toString() {

		String enter = "\n";
		String string = getLogin() + enter + getNome() + " - Jogador Veterano" + enter + super.toString();

		return string;
	}

}
