/* Matricula: 115111170 - Aluno: Alessandro Lia Fook Santos LAB 07 - Turma 2 */

package jogos;

import java.util.Set;
import exceptions.NumeroInvalidoException;

public class Rpg extends Jogo {

	/**
	 * Realiza a construcao de um objeto do tipo RPG, que eh subclasse de jogo,
	 * considerando que neste momento o jogo nao foi jogado nenhuma vez, logo, o
	 * numero de jogadas, conclusoes ou score inicia como o valor 0.
	 * 
	 * @param nome
	 *            - Nome que sera atribuido ao jogo.
	 * @param preco
	 *            - Preco que sera atribuido ao jogo
	 * @param jogabilidades
	 *            - Colecao com os nomes dos tipos de jogabilidade do jogo.
	 * @throws Exception
	 *             - Retorna tres tipos de excecao, vindas de jogo, de acordo
	 *             com o parametro invalido inserido.
	 */
	public Rpg(String nome, double preco, Set<String> jogabilidades) throws Exception {
		super(nome, preco, jogabilidades);
	}

	/**
	 * Sobrescreve o metodo abstrado da classe Jogo, para retornar a quantidade
	 * de pontos de Experience Player Privilege decorrentes da jogada realizada
	 * pelo usuario.
	 * 
	 * @param score
	 *            - Indica o total de pontos conquistados na jogada registrada.
	 * @param conclusao
	 *            - Indica se o jogador conseguiu concluir o jogo.
	 * @throws Exception
	 *             - Retorna uma excecao acaso o score seja menor que zero.
	 */
	public int registraJogada(int score, boolean conclusao) throws Exception {

		validaScore(score);

		final int X2P = 10;
		super.addJogada();

		if (score > super.getScore()) {
			super.setScore(score);
		}

		if (conclusao) {
			super.addConclusao();
		}

		return X2P;
	}

	/**
	 * Verifica se o valor do score eh menor que zero.
	 * 
	 * @param score
	 *            - Representa o valor de pontos decorrentes de uma jogada
	 *            realizada pelo usuario.
	 * @throws NumeroNegativoException
	 *             - Excecao que informa acerca do score informado ser invalido
	 *             por ser negativo.
	 */
	private void validaScore(int score) throws Exception {
		if (score < 0) {
			
			String variavel = "score";
			String erro = "eh menor que zero.";
			
			throw new NumeroInvalidoException(variavel, erro);

		}
	}

	@Override
	public String toString() {
		
		String enter = "\n";
		String mensagem = "+ " + getNome() + " - RPG:" + enter  + super.toString();
		
		return mensagem;	
		
	}

}
