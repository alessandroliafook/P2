/* Matricula: 115111170 - Aluno: Alessandro Lia Fook Santos LAB 06 - Turma 2 */

package jogos;

import java.util.HashSet;

import constantes.Jogabilidade;
import exceptions.NumeroInvalidoException;

public class Luta extends Jogo {

	/**
	 * Realiza a construcao de um objeto do tipo Luta, que eh subclasse de jogo,
	 * considerando que neste momento o jogo nao foi jogado nenhuma vez, logo, o
	 * numero de jogadas, conclusoes ou score inicia como o valor 0.
	 * 
	 * @param nome
	 *            - Nome que sera atribuido ao jogo.
	 * @param preco
	 *            - Preco que sera atribuido ao jogo
	 * @param estilo
	 *            - Colecao com os estidos atribuidos a um jogo.
	 * @throws Exception
	 *             - Retorna tres tipos de excecao, vindas de jogo, de acordo
	 *             com o parametro invalido inserido.
	 */
	public Luta(String nome, double preco, HashSet<Jogabilidade> estilo) throws Exception {
		super(nome, preco, estilo);
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

		validaScorePositivo(score);
		validaScoreTeto(score);
		
		int X2P = 0;
		super.addJogada();

		if (score > super.getScore()) {
			X2P = score / 1000;
			super.setScore(score);
		}

		if (conclusao) {
			super.addConclusao();
		}

		return X2P;
	}

	/**
	 * Verifica se o score eh acima do teto de 100.000.
	 * 
	 * @param score
	 *            - Representa a quantidade de pontos acumulada com a jogada.
	 * @throws ScoreAcimaTeto
	 *             - Retorna a excecao informando que o valor esta acima do
	 *             maximo permitido.
	 */
	private void validaScoreTeto(int score) throws Exception {
		if (score > 100000) {
			
			String variavel = "score";
			String erro = "eh maior que o teto de 100.000.";
			
			throw new NumeroInvalidoException(variavel, erro);
		}
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
	private void validaScorePositivo(int score) throws Exception {
		if (score < 0) {
			
			String variavel = "score";
			String erro = "eh menor que zero.";
			throw new NumeroInvalidoException(variavel, erro);

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		String enter = "\n";
		String mensagem = "+ " + getNome() + " - Luta:" + enter + super.toString();
		
		return mensagem;
	}

}
