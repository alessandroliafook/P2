/* Matricula: 115111170 - Aluno: Alessandro Lia Fook Santos LAB 06 - Turma 2 */

package usuarios;

import java.util.HashSet;

import exceptions.NumeroInvalidoException;
import exceptions.ObjetoInvalidoException;
import exceptions.StringInvalidaException;
import jogos.Jogo;

public abstract class Usuario {

	private String nome;
	private String login;
	private double saldo;
	private int x2p;
	private HashSet<Jogo> jogos;

	/**
	 * Construtor que sera utilizado pelas subclasses para construir objetos
	 * herdeiros de Usuario, que ira inicializar o saldo e o x2p iguais a zero,
	 * assim como a lista de jogos vazia.
	 * 
	 * @param nome
	 *            - O nome do usuario.
	 * @param login
	 *            - O login do usuario.
	 * @throws Exception
	 *             - Retorna excecao acaso o nome ou o login inseridos sejam
	 *             vazios ou iguais a null.
	 */
	public Usuario(String nome, String login) throws Exception {

		validaString(nome, "nome dx usuarix");
		validaString(login, "login dx usuarix");

		this.nome = nome;
		this.login = login;
		this.saldo = 0;
		this.x2p = 0;
		jogos = new HashSet<Jogo>();

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
	 *             vazios. - Retorna uma mensagem de excesao acaso nome, login
	 *             ou jogos sejam iguais a null. - retorna uma mensagem de
	 *             excecao acaso x2p ou saldo sejam negativos.
	 */

	public Usuario(String nome, String login, double saldo, int x2p, HashSet<Jogo> jogos) throws Exception {

		validaString(nome, "nome dx usuarix");
		validaString(login, "login do usuario");
		validaSaldo(saldo);
		validaX2p(x2p);
		validaListaDeJogos(jogos);

		this.nome = nome;
		this.login = login;
		this.saldo = saldo;
		this.x2p = x2p;
		this.jogos = jogos;

	}

	// Metodo abstrato

	public abstract boolean compraJogo(Jogo jogo) throws Exception;

	/**
	 * Registra uma jogada realizada pelo usuario, adicionando ao total de
	 * Experience Players Point, o valor respectivo a mesma.
	 * 
	 * @param nomeDoJogo
	 *            - Representa o nome do jogo a ser registrado.
	 * @param score
	 *            - Indica a quantidade de pontos conquistada na respectica
	 *            jogada.
	 * @param conclusao
	 *            - Indica se o jogo foi concluido durante a respectiva jogada.
	 * @throws Exception
	 *             - Retorna excecao acaso o nome do jogo, seja vazio ou null,
	 *             ou então, acaso o score seja inferior a zero.
	 */
	public void registraJogada(String nomeDoJogo, int score, boolean conclusao) throws Exception {

		validaString(nomeDoJogo, "nome dx jogo");
		validaScore(score, "valor do score");

		int X2P = 0;

		for (Jogo jogo : this.jogos) {

			if (jogo.getNome().equals(nomeDoJogo))
				X2P = jogo.registraJogada(score, conclusao);

		}

		addX2p(X2P);
	}

	/**
	 * Metodo que adiciona o valor de X2P passado no parametro ao total do
	 * usuario.
	 * 
	 * @param valor
	 *            - Valor de X2P a ser adicionado.
	 * @throws Exception
	 *             - Retorna uma excecao acaso o valor informado no parametro
	 *             seja menor que zero.
	 */
	protected void addX2p(int valor) throws Exception {

		validaX2p(valor);

		this.x2p = this.x2p + valor;
	}

	/**
	 * Adiciona o valor ao saldo do usuario.
	 * 
	 * @param valor
	 *            - Quantidade de dinheiro a ser adicionada ao saldo do usuario;
	 * @throws Exception
	 *             - Retorna a mensagem informando que o saldo inserido eh menor
	 *             ou igual a zero.
	 */
	public void addDinheiro(double valor) throws Exception {

		validaSaldo(valor);

		this.saldo = this.saldo + valor;
	}

	/**
	 * Metodo que verifica se a lista de jogos que foi passada eh igual a null.
	 * 
	 * @param jogos
	 *            - recebe uma lista de jogos.
	 * @throws ObjetoInvalidoException
	 *             - retorna uma excecao informando que o objeto eh igual a
	 *             null.
	 */
	private void validaListaDeJogos(HashSet<Jogo> jogos) throws ObjetoInvalidoException {
		if (jogos == null) {
			throw new ObjetoInvalidoException("lista de jogos", "eh igual a null.");
		}
	}

	/**
	 * Verifica se o numerario do valor eh negativo, retornando uma excecao em
	 * caso positivo.
	 * 
	 * @param valor
	 *            - numerario do X2P a ser avaliado.
	 * @throws NumeroNegativoException
	 *             - Excecao que informa sobre a invalidade do numero negativo.
	 */
	private void validaScore(int score, String nomeVariavel) throws NumeroInvalidoException {

		if (score < 0) {
			String erro = "eh menor que zero.";

			throw new NumeroInvalidoException(nomeVariavel, erro);
		}
	}

	/**
	 * Verifica se o numerario do valor eh negativo, retornando uma excecao em
	 * caso positivo.
	 * 
	 * @param valor
	 *            - numerario do X2P a ser avaliado.
	 * @throws NumeroNegativoException
	 *             - Excecao que informa sobre a invalidade do numero negativo.
	 */
	private void validaX2p(int valor) throws Exception {
		if (valor < 0) {

			String variavel = "valor do x2p";
			String erro = "eh menor que zero.";

			throw new NumeroInvalidoException(variavel, erro);
		}
	}

	/**
	 * Verifica se o saldo tem valor maior ou igual a zero.
	 * 
	 * @param valor
	 *            - Numerario a ser adicionado ao saldo do usuario.
	 * @throws NumeroInvalidoException
	 *             - Retorna a mensagem informando que o saldo inserido eh menor
	 *             ou igual a zero.
	 * @throws NumeroNegativoException
	 */
	private void validaSaldo(double valor) throws Exception {

		if (valor < 0) {

			String variavel = "valor em dinheiro inserido";
			String erro = "eh menor que zero.";

			throw new NumeroInvalidoException(variavel, erro);
		}

	}

	/**
	 * Verifica se a variavel string eh valida.
	 * 
	 * @param string
	 *            - String a ser avaliada.
	 * @param nomeDaVariavel
	 *            - Nome da variavel associada a string avaliada.
	 * @throws StringInvalidaException
	 *             - Lanca a excecao associada a variavel avaliada.
	 */
	private void validaString(String string, String nomeDaVariavel) throws Exception {

		if (string == null) {

			String erro = "eh igual a null.";

			throw new StringInvalidaException(nomeDaVariavel, erro);

		} else if (string.trim().equals("")) {

			String erro = "eh vazio.";

			throw new StringInvalidaException(nomeDaVariavel, erro);
		}

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	/**
	 * @return O nome do usuario.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @return O login do usuario.
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @return O saldo do usuario.
	 */
	public double getSaldo() {
		return saldo;
	}

	/**
	 * @return O valor do X2P do usuario.
	 */
	public int getX2p() {
		return x2p;
	}

	/**
	 * @return A colecao de jogos do usuario.
	 */
	public HashSet<Jogo> getJogos() {
		return jogos;
	}

	// Setters

	/**
	 * @param nome
	 *            - the nome to set
	 */
	protected void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @param login
	 *            - the login to set
	 */
	protected void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @param saldo
	 *            - the saldo to set
	 */
	protected void setSaldo(double saldo) throws Exception {

		validaSaldo(saldo);

		this.saldo = saldo;
	}

	/**
	 * @param x2p
	 *            - the x2p to set
	 */
	protected void setX2p(int x2p) {

		this.x2p = x2p;
	}

	/**
	 * @param jogos
	 *            - the jogos to set
	 */
	protected void setJogos(HashSet<Jogo> jogos) {
		this.jogos = jogos;
	}

	@Override
	public String toString() {

		String enter = "\n";
		String string = "";

		double totalPreco = 0.0;

		for (Jogo jogo : getJogos()) {
			string = string + jogo + enter;
			totalPreco = totalPreco + jogo.getPreco();
		}

		String total = String.format("%.2f", totalPreco);

		string = string + "Total de preco dos jogos: R$ " + total + enter;

		return string;
	}

}
