/* Matricula: 115111170 - Aluno: Alessandro Lia Fook Santos LAB 07 - Turma 2 */

package centralP2Cg;

import exceptions.StringInvalidaException;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import jogos.Jogo;
import jogos.FactoryDeJogos;

import usuarios.Usuario;
import usuarios.FactoryDeUsuarios;

public class LojaController {

	Map<String, Usuario> clientes;
	FactoryDeJogos desenvolvedor;
	FactoryDeUsuarios cadastro;

	public LojaController(){

		this.clientes = new HashMap<String, Usuario>();
		this.desenvolvedor = new FactoryDeJogos();
		this.cadastro = new FactoryDeUsuarios();
	}

	/**
	 * O metodo recebe como parametro o nome e o login do usuario a ser
	 * cadastrado na loja.
	 * 
	 * @exception - Caso o usuario ja exista, o metodo lanca excecao informando.
	 * 
	 *            Caso o usuario nao exista, o metodo igualmente lanca excecao.
	 */
	public void addUsuario(String nome, String login) throws Exception {

		contemLogin(login);

		Usuario novoUsuario = cadastro.criaUsuario(nome, login);
		clientes.put(novoUsuario.getLogin(), novoUsuario);

	}

	/**
	 * Metodo que solicita ao usuario o valor a ser adicionado na conta do
	 * cliente, e: caso o valor seja valido, adiciona a conta solicitada; caso
	 * nao, questiona se o usuario deseja inserir um valor valido.
	 * 
	 * @param login
	 *            - o login do usuario que se pretende adicionar dinheiro.
	 */
	public void addDinheiro(String login, double valor) throws Exception {

		naoContemLogin(login);

		Usuario usuario = clientes.get(login);

		usuario.addDinheiro(valor);
	}

	/**
	 * Metodo que realiza a venda de um jogo, que sera criado, ao usuario.
	 * 
	 * @param login
	 *            - Chave de acesso a conta do usuario.
	 */
	public void vendeJogo(String login, Set<String> jogabilidades,
			String nomeDoJogo, double precoDoJogo, String estilo)
			throws Exception {

		naoContemLogin(login);

		Usuario usuario = clientes.get(login);
		Jogo jogo = desenvolvedor.criaJogo(jogabilidades, nomeDoJogo,
				precoDoJogo, estilo); // chamada polimorfica

		usuario.compraJogo(jogo);

	}

	/**
	 * Metodo que imprime na tela as informacoes acerca de todos os clientes,
	 * seus respectivos jogos, e o valor acumulado dos jogos.
	 */
	public String imprimeInformacoes() throws Exception {

		String enter = "\n";
		String informacoes = "=== Central P2-CG ===" + enter + enter;

		Set<String> listaDeLogin = clientes.keySet();

		for (String login : listaDeLogin) {
			informacoes = informacoes + clientes.get(login) + enter;

		}

		informacoes = informacoes
				+ "-----------------------------------------------------";

		return informacoes;

	}

	protected Map<String, Usuario> getClientes() {
		return clientes;
	}

	/**
	 * Metodo verifica se o login jah esta cadastrado no sistema.
	 * 
	 * @param login
	 *            - o login do usuario a ser procurado no sistema.
	 * @throws StringInvalidaException
	 *             - erro informando que o usuario ja esta cadastrado no
	 *             sistema.
	 */
	private void contemLogin(String login) throws Exception {

		String variavel = "login dx usuarix";

		if (login == null) {

			String erro = "eh igual a null.";

			throw new StringInvalidaException(variavel, erro);

		} else if (login.trim().equals("")) {

			String erro = "eh vazio.";

			throw new StringInvalidaException(variavel, erro);

		} else if (clientes.containsKey(login)) {

			String erro = "jah esta cadastrado no sistema.";

			throw new StringInvalidaException(variavel, erro);
		}
	}

	/**
	 * Metodo que verifica se o login inserido nao esta cadastrado no sistema.
	 * 
	 * @param login
	 *            - O login a ser verificado.
	 * @throws StringInvalidaException
	 *             - Retorna excecao informando que o usuario nao existe no
	 *             sistema.
	 */

	private void naoContemLogin(String login) throws Exception {

		String variavel = "login dx usuarix";

		if (login == null) {

			String erro = "eh igual a null.";

			throw new StringInvalidaException(variavel, erro);

		} else if (login.trim().equals("")) {

			String erro = "eh vazio.";

			throw new StringInvalidaException(variavel, erro);

		} else if (!(clientes.containsKey(login))) {

			String erro = "nao existe no sistema.";

			throw new StringInvalidaException(variavel, erro);
		}
	}

}
