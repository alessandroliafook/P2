/* Matricula: 115111170 - Aluno: Alessandro Lia Fook Santos LAB 07 - Turma 2 */

package exceptions;

public class StringInvalidaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6352187059609283543L;


	/**
	 * Construtor vazio
	 */

	public StringInvalidaException(){
	}
	
	
	/**
	 * Contrutor que retorna a mensagem da excecao relativa a string vazia ou igual a null.
	 * @param nomeVariavel - string que informa qual a variavel que esta com o conteudo invalido.
	 */
	public StringInvalidaException(String nomeVariavel, String erro){
		super("X " + nomeVariavel + " eh invalidx, pois " + erro + "\n");
	}

}
