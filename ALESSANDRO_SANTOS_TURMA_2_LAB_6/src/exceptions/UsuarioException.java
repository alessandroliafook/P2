/* Matricula: 115111170 - Aluno: Alessandro Lia Fook Santos LAB 06 - Turma 2 */

package exceptions;

public class UsuarioException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public UsuarioException() {
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
		public UsuarioException(String nome) {
			super("O upgrade dx usuarix " + nome + " nao foi possivel, pois tem menos de 1.000 pontos de X2P.");
		}
	}
