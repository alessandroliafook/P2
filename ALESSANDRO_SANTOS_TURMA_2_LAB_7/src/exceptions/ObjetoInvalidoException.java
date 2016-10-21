/* Matricula: 115111170 - Aluno: Alessandro Lia Fook Santos LAB 07 - Turma 2 */

package exceptions;

public class ObjetoInvalidoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Construtor vazio
	 */

	public ObjetoInvalidoException() {
	}

	/**
	 * Contrutor que retorna a mensagem da excecao relativa ao objeto igual a
	 * null.
	 * 
	 * @param nomeVariavel
	 *            - string que informa qual o objeto que esta com o conteudo
	 *            invalido.
	 * @param erro
	 *            - string que informa o motivo da excecao ser lancada.
	 */
	public ObjetoInvalidoException(String nomeDoObjeto, String erro) {
		super("X " + nomeDoObjeto + " eh invalidx, pois " + erro + "\n");
	}

}
