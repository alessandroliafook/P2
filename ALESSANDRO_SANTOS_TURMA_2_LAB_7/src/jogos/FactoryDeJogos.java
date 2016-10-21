/* Matricula: 115111170 - Aluno: Alessandro Lia Fook Santos LAB 07 - Turma 2 */

package jogos;

import java.util.Set;
import exceptions.StringInvalidaException;

public class FactoryDeJogos {

	public FactoryDeJogos() {
	}

	/**
	 * Metodo que cria o jogo a ser vendido para o usuario.
	 * 
	 * @param jogabilidades
	 *            - Colecao com as jogabilidades que serao inseridas no jogo.
	 * @param nomeDoJogo
	 *            - Titulo do jogo.
	 * @param precoDoJogo
	 *            - Preco do jogo.
	 * @param estilo
	 *            - Indica qual o tipo de jogo sera criado.
	 * @return - Retorna o objeto jogo do estilo escolhido no momento da
	 *         criacao.
	 * @throws Exception
	 *             - Retorna excecao acaso algum dos parametros inseridos seja
	 *             invalido.
	 */
	public Jogo criaJogo(Set<String> jogabilidades, String nomeDoJogo, double precoDoJogo, String estilo)
			throws Exception {

		switch (estilo.toUpperCase()) {

		case "RPG":
			return new Rpg(nomeDoJogo, precoDoJogo, jogabilidades);

		case "LUTA":
			return new Luta(nomeDoJogo, precoDoJogo, jogabilidades);

		case "PLATAFORMA":
			return new Plataforma(nomeDoJogo, precoDoJogo, jogabilidades);

		default:
			String variavel = "estilo do jogo";
			String erro = "eh diferente das opcoes existentes (rpg, luga ou plataforma).";

			throw new StringInvalidaException(variavel, erro);
		}

	}

}
