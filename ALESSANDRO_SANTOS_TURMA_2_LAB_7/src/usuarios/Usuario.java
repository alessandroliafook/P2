/* Matricula: 115111170 - Aluno: Alessandro Lia Fook Santos LAB 07 - Turma 2 */

package usuarios;

import java.util.HashSet;
import java.util.Set;

import exceptions.NumeroInvalidoException;
import exceptions.ObjetoInvalidoException;
import exceptions.StringInvalidaException;
import jogos.Jogo;

public class Usuario {

	private String nome;
	private String login;
	private double saldo;
	private int x2p;
	private Set<Jogo> jogos;
	private StatusUsuarioIF statusDoUsuario;

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
		this.statusDoUsuario = new Noob();
		this.saldo = 0;
		this.x2p = 0;
		jogos = new HashSet<Jogo>();

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

		double precoDoJogo = jogo.getPreco();
		double custoDoJogo = statusDoUsuario.calculaCusto(precoDoJogo); // chamada
																		// polimorfica

		if (custoDoJogo > this.getSaldo()) {
			return false;

		} else {

			int X2P = statusDoUsuario.calculaX2p(precoDoJogo); // chamada
																// polimorfica
			double novoSaldo = this.getSaldo() - custoDoJogo;
			int novoX2p = this.getX2p() + X2P;

			this.setSaldo(novoSaldo);
			this.getJogos().add(jogo);
			this.setX2p(novoX2p);

			return true;
		}
	}

	/**
	 * Registra uma jogada realizada pelo usuario, com uma recompensa,
	 * adicionando ao total de Experience Players Point, o valor respectivo a
	 * mesma.
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
	public void recompensar(String nomeDoJogo, int score, boolean conclusao) throws Exception {

		validaString(nomeDoJogo, "nome dx jogo");
		validaScore(score, "valor do score");

		int X2P = 0;

		for (Jogo jogo : this.jogos) {

			if (jogo.getNome().equals(nomeDoJogo)) {

				X2P = jogo.registraJogada(score, conclusao);
				X2P = X2P + statusDoUsuario.recompensar(jogo.getEstilo()); // chamada
																			// polimorfica
			}
		}
		
		int novoX2p = this.getX2p() + X2P; 
		this.setX2p(novoX2p);
	}

	/**
	 * Registra uma jogada realizada pelo usuario, com uma punicao, adicionando
	 * ao total de Experience Players Point, o valor respectivo a mesma.
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
	public void punir(String nomeDoJogo, int score, boolean conclusao) throws Exception {

		validaString(nomeDoJogo, "nome dx jogo");
		validaScore(score, "valor do score");

		int X2P = 0;

		for (Jogo jogo : this.jogos) {

			if (jogo.getNome().equals(nomeDoJogo)) {
				X2P = jogo.registraJogada(score, conclusao);
				X2P = X2P + statusDoUsuario.punir(jogo.getEstilo()); // chamada
																		// polimorfica
			}
		}

		int novoX2p = this.getX2p() + X2P; 
		this.setX2p(novoX2p);
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
	 * Metodo que verifica a pontuacao atual de X2P do usuario, e verifica se o
	 * valor total eh maior que 1000. Caso seja, modifica o status para
	 * veterano, caso seja menor modifica para noob.
	 */
	private void atualizaStatus() {

		if (this.getX2p() > 1000 && !(this.statusDoUsuario instanceof Veterano)) {

			this.statusDoUsuario = new Veterano();

		} else if (!(this.statusDoUsuario instanceof Noob)) {

			this.statusDoUsuario = new Noob();
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
	public Set<Jogo> getJogos() {
		return jogos;
	}

	public StatusUsuarioIF getCategoria() {
		return statusDoUsuario;
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

		atualizaStatus();
	}

	/**
	 * @param jogos
	 *            - the jogos to set
	 */
	protected void setJogos(HashSet<Jogo> jogos) {
		this.jogos = jogos;
	}

	public void setCategoria(String categoria) {

		switch (categoria.toLowerCase()) {

		case "noob":
			this.statusDoUsuario = new Noob();
			break;

		case "veterano":
			this.statusDoUsuario = new Veterano();
			break;

		}

	}

	/**
	 * Metodo sobrescrito que retorna as informacoes do usuario.
	 * @return - String com as informacoes do usuario(status, login, nome, x2p e lista de jogos);
	 */
	@Override
	public String toString() {

		String enter = "\n";
		String string = "Jogador " + statusDoUsuario + ": " + getLogin() + enter + getNome() + " - " + getX2p() + " x2p"
				+ enter + "Lista de Jogos:" + enter;
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
