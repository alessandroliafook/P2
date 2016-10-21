/* Matricula: 115111170 - Aluno: Alessandro Lia Fook Santos LAB 07 - Turma 2 */

package exceptions;

public class NumeroInvalidoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Construtor vazio
	 */
	public NumeroInvalidoException() {

	}

	/**
	 * Contrutor que retorna a mensagem da excecao relativa a um numero
	 * invalido.
	 * 
	 * @param nomeVariavel
	 *            - string que informa qual a variavel que esta com o numero
	 *            invalido.
	 * @param erro
	 *            - string que informa qual o erro ocorrido.
	 */
	public NumeroInvalidoException(String nomeVariavel, String erro) {
		super("X " + nomeVariavel + " eh invalidx, pois " + erro + "\n");

	}
	
}
