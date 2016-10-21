/* Matricula: 115111170 - Aluno: Alessandro Lia Fook Santos LAB 06 - Turma 2 */

package jogos;

import java.util.HashSet;

import constantes.Jogabilidade;
import exceptions.ObjetoInvalidoException;
import exceptions.StringInvalidaException;
import exceptions.NumeroInvalidoException;

public abstract class Jogo {

	private String nome;
	private int vezesJogadas;
	private int score;
	private int vezesConcluidas;
	private double preco;
	private HashSet<Jogabilidade> jogabilidades;

	/**
	 * Realiza a construcao de um objeto do tipo jogo, considerando que neste
	 * momento o jogo nao foi jogado nenhuma vez, logo, o numero de jogadas,
	 * conclusoes ou score inicia como o valor 0.
	 * 
	 * @param nome
	 *            - Nome que sera atribuido ao jogo.
	 * @param preco
	 *            - Preco que sera atribuido ao jogo
	 * @param jogabilidade
	 *            - Colecao com os estidos atribuidos a um jogo.
	 * @throws Exception
	 *             - Retorna tres tipos de excecao, de acordo com o parametro
	 *             invalido inserido.
	 */
	public Jogo(String nome, double preco, HashSet<Jogabilidade> jogabilidade) throws Exception {

		validaNome(nome);
		validaPreco(preco);
		validaJogabilidade(jogabilidade);

		this.nome = nome;
		this.vezesJogadas = 0;
		this.score = 0;
		this.vezesConcluidas = 0;
		this.preco = preco;
		this.jogabilidades = jogabilidade;

	}

	/**
	 * Metodo abstrado para realizar o registro de cada vez que o usuario jogar
	 * um jogo.
	 * 
	 * @param score
	 *            - Indica a quantidade de pontos acumulado na jogada
	 *            registrada.
	 * @param conclusao
	 *            - Indica se o usuario concluiu o jogo.
	 * @return - A quantidade de pontos do experience player privilege
	 *         decorrentes da jogada.
	 */
	public abstract int registraJogada(int score, boolean conclusao) throws Exception;

	/**
	 * Adiciona um genero de jogabilidade ao jogo, caso o mesmo jah nao possua a
	 * mesma.
	 * 
	 * @return - Retorna true acaso a jogabilidade tenha sido adicionada.
	 *         Retorna falso caso a jogabilidade nao exista ou jah esteja
	 *         presente no jogo.
	 */

	public boolean addJogabilidade(String nomeJogabilidade) throws Exception {

		validaNomeJogabilidade(nomeJogabilidade);

		for (Jogabilidade jogabilidade : Jogabilidade.values()) {

			if (jogabilidade.name().equalsIgnoreCase(nomeJogabilidade)) {

				return this.jogabilidades.add(jogabilidade);
			}
		}
		return false;
	}

	/**
	 * Adiciona uma jogada a quantidade total de vezes que o jogo foi usado pelo
	 * usuario
	 */
	protected void addJogada() {
		this.vezesJogadas = this.vezesJogadas + 1;
	}

	/**
	 * Adiciona uma conclusao a quantidade total de vezes que o jogo foi
	 * concluido pelo usuario
	 */
	protected void addConclusao() {
		this.vezesConcluidas = this.vezesConcluidas + 1;
	}

	/**
	 * Verifica se a colecao estilo e igual a null. Caso seja, lanca uma excecao
	 * do tipo ColecaoInvalidaException.
	 * 
	 * @param estilo
	 *            - Recebe uma colecao com nome de estilo.
	 * @throws ObjetoInvalidoException
	 *             - Retorna uma excecao caso a colecao seja null.
	 */

	private void validaJogabilidade(HashSet<Jogabilidade> estilo) throws Exception {

		if (estilo == null) {
			String objeto = "jogabilidade do jogo";
			String erro = "eh igual a null.";

			throw new ObjetoInvalidoException(objeto, erro);
		}
	}

	/**
	 * Metodo que verifica se o nome da jogabilidade passada eh uma string null
	 * ou vazia, retornando uma excecao.
	 * 
	 * @param nomeJogabilidade
	 *            - String a ser avaliada.
	 * @throws StringInvalidaException
	 *             - Excecao que eh lancada informando qual o erro ocorrido.
	 */
	private void validaNomeJogabilidade(String nomeJogabilidade) throws StringInvalidaException {
		if (nomeJogabilidade == null) {
			String variavel = "nome da jogabilidade";
			String erro = "eh igual a null.";

			throw new StringInvalidaException(variavel, erro);
		} else if (nomeJogabilidade.trim().equalsIgnoreCase("")) {

			String variavel = "nome da jogabilidade";
			String erro = "eh vazia.";

			throw new StringInvalidaException(variavel, erro);

		}
	}

	/**
	 * Verifica se o preco e menor que zero. Caso seja, lanca uma excecao do
	 * tipo NumeroInvalidoException.
	 * 
	 * @param preco
	 *            - Recebe um double com o preco do jogo.
	 * @throws ObjetoInvalidoException
	 *             - Retorna uma excecao caso a colecao seja null.
	 */

	private void validaPreco(double preco) throws Exception {

		if (preco < 0) {
			String variavel = "preco do jogo";
			String erro = "eh menor que zero.";

			throw new NumeroInvalidoException(variavel, erro);

		}
	}

	/**
	 * Verifica se o nome do jogo e igual a null ou vazio. Caso seja, lanca uma
	 * excecao do tipo NomeInvalidoException.
	 * 
	 * @param nome
	 *            - Recebe uma string com o nome do jogo.
	 * @throws NomeInvalidaException
	 *             - Retorna uma excecao caso o nome recebido seja null ou
	 *             vazio.
	 */

	private void validaNome(String nome) throws Exception {

		String variavel = "nome do jogo";

		if (nome == null) {

			String erro = "eh null.";

			throw new StringInvalidaException(variavel, erro);

		} else if (nome.trim().equals("")) {

			String erro = "eh vazio.";

			throw new StringInvalidaException(variavel, erro);
		}
	}

	/**
	 * Realiza a comparacao considerando as informacoes recebidas no construtor,
	 * nome, estilo e preco.
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((jogabilidades == null) ? 0 : jogabilidades.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		long temp;
		temp = Double.doubleToLongBits(preco);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/**
	 * Realiza a comparacao considerando as informacoes recebidas no construtor,
	 * nome, estilo e preco.
	 */

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jogo other = (Jogo) obj;
		if (jogabilidades == null) {
			if (other.jogabilidades != null)
				return false;
		} else if (!jogabilidades.equals(other.jogabilidades))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (Double.doubleToLongBits(preco) != Double.doubleToLongBits(other.preco))
			return false;
		return true;
	}

	// geters

	@Override
	public String toString() {
		String enter = "\n";

		return "==> Jogou " + getVezesJogadas() + "vez(es)" + enter + "==> Zerou " + getVezesConcluidas() + "vez(es)"
				+ enter + "==> Maior Score: " + getScore() + enter;

	}

	/**
	 * @return O nome do Jogo.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @return O numero de vezes que o jogo foi jogado.
	 */
	public int getVezesJogadas() {
		return vezesJogadas;
	}

	/**
	 * @return A maior pontuacao conquistada pelo usuario no jogo.
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @return O numero de vezes que o jogo foi concluido.
	 */
	public int getVezesConcluidas() {
		return vezesConcluidas;
	}

	/**
	 * @return O preco do jogo.
	 */
	public double getPreco() {
		return preco;
	}

	/**
	 * @return Os estilos associados ao jogo.
	 */
	public HashSet<Jogabilidade> getEstilo() {
		return jogabilidades;
	}

	// Seters

	/**
	 * Atualiza a pontuacao maxima atingida pelo usuario ao jogar o jogo.
	 * 
	 * @param score
	 *            - Valor da pontuacao maxima a ser inserida no jogo.
	 */
	protected void setScore(int score) {
		this.score = score;
	}

	/**
	 * Atualiza o preco do jogo.
	 * 
	 * @param preco
	 *            - O preco que se pretende atribuir ao jogo.
	 */
	protected void setPreco(double preco) {
		this.preco = preco;
	}

}
