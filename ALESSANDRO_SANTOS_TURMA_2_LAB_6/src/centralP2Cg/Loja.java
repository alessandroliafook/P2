/* Matricula: 115111170 - Aluno: Alessandro Lia Fook Santos LAB 06 - Turma 2 */

package centralP2Cg;

import constantes.Estilo;
import constantes.Jogabilidade;
import exceptions.ObjetoInvalidoException;
import exceptions.StringInvalidaException;
import exceptions.UsuarioException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import jogos.Jogo;
import jogos.Luta;
import jogos.Plataforma;
import jogos.Rpg;
import usuarios.Noob;
import usuarios.Usuario;
import usuarios.Veterano;

public class Loja {

	HashMap<String, Usuario> clientes;

	public Loja() {

		this.clientes = new HashMap<String, Usuario>();

	}

	/**
	 * O metodo recebe como parametro o nome e o login do usuario a ser
	 * cadastrado na loja.
	 * 
	 * @exception -
	 *                Caso o usuario ja exista, o metodo lanca excecao
	 *                informando.
	 * 
	 *                Caso o usuario nao exista, o metodo igualmente lanca
	 *                excecao.
	 */
	public void addUsuario(String nome, String login) {

		try {

			contemLogin(login);

			Usuario novoUsuario = new Noob(nome, login);
			clientes.put(novoUsuario.getLogin(), novoUsuario);

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}
	}

	/**
	 * Metodo que solicita ao usuario o valor a ser adicionado na conta do
	 * cliente, e: caso o valor seja valido, adiciona a conta solicitada; caso
	 * nao, questiona se o usuario deseja inserir um valor valido.
	 * 
	 * @param login
	 *            - o login do usuario que se pretende adicionar dinheiro.
	 */
	public void addDinheiro(String login, double valor) {

		try {
			naoContemLogin(login);

			Usuario usuario = clientes.get(login);

			usuario.addDinheiro(valor);

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}
	}

	/**
	 * Metodo que realiza a venda de um jogo, que sera criado, ao usuario.
	 * 
	 * @param login
	 *            - Chave de acesso a conta do usuario.
	 */
	public void vendeJogo(String login, HashSet<Jogabilidade> jogabilidades, String nomeDoJogo, double precoDoJogo,
			String estilo) {

		try {

			naoContemLogin(login);

			Usuario usuario = clientes.get(login);

			Jogo jogo = escolherEstilo(jogabilidades, nomeDoJogo, precoDoJogo, estilo);

			usuario.compraJogo(jogo);

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}

	/**
	 * Metodo que cria o jogo a ser vendido para o usuario.
	 * 
	 * @param jogabilidades
	 *            - Colecao com as jogabilidades que serao inseridas no jogo.
	 * @param nomeDoJogo
	 *            - Titulo do jogo.
	 * @param precoDoJogo
	 *            - Preco do jogo.
	 * @return - Retorna o objeto jogo do estilo escolhido no momento da
	 *         criacao.
	 * @throws Exception
	 *             - Retorna excecao acaso algum dos parametros inseridos seja
	 *             invalido.
	 */
	private Jogo escolherEstilo(HashSet<Jogabilidade> jogabilidades, String nomeDoJogo, double precoDoJogo,
			String estilo) throws Exception {

		if (estilo.equalsIgnoreCase(Estilo.RPG.name()))
			return new Rpg(nomeDoJogo, precoDoJogo, jogabilidades);

		else if (estilo.equalsIgnoreCase(Estilo.LUTA.name()))
			return new Luta(nomeDoJogo, precoDoJogo, jogabilidades);

		else if (estilo.equalsIgnoreCase(Estilo.PLATAFORMA.name()))
			return new Plataforma(nomeDoJogo, precoDoJogo, jogabilidades);

		else {

			String variavel = "estilo do jogo";
			String erro = "diferente das opcoes existentes (rpg, luga ou plataforma).";

			throw new StringInvalidaException(variavel, erro);
		}
	}

	/**
	 * Metodo que imprime na tela as informacoes acerca de todos os clientes,
	 * seus respectivos jogos, e o valor acumulado dos jogos.
	 */
	public void imprimeInformacoes() {

		String enter = "\n";
		String informacoes = "=== Central P2­CG ===" + enter + enter;

		Set<String> listaDeLogin = clientes.keySet();

		for (String login : listaDeLogin) {
			informacoes = informacoes + clientes.get(login) + enter;

		}

		System.out.println(informacoes);

	}

	/**
	 * Metodo que realiza o upgrade de um usuario do tipo noob para um usuario
	 * do tipo veterano, caso o usuario preencha o pre-requisto de ter mais de
	 * mil pontos de X2P.
	 * 
	 * @param login
	 *            - Chave de acesso a conta do usuario.
	 */
	public void upgrade(String login){

		try {

			naoContemLogin(login);
			Usuario usuario = clientes.get(login);

			verificaUsuarioVeterano(usuario);
			verificaX2P(usuario);

			Usuario usuarioUpgrade = new Veterano(usuario.getNome(), usuario.getLogin(), usuario.getSaldo(),
					usuario.getX2p(), usuario.getJogos());

			clientes.put(login, usuarioUpgrade);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	protected HashMap<String, Usuario> getClientes() {
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

	/**
	 * Metodo que verifica se o valor de X2P do usuario eh inferior a 1.000.
	 * 
	 * @param usuario
	 *            - Objeto que se pretende fazer a verificacao.
	 * @throws UsuarioException
	 *             - Lanca excecao informando que o usuario nao tem X2P
	 *             suficiente.
	 */
	private void verificaX2P(Usuario usuario) throws UsuarioException {
		if (usuario.getX2p() <= 1000)
			throw new UsuarioException(usuario.getNome());
	}

	/**
	 * Metodo que verifica se o usuario jah eh veterano.
	 * 
	 * @param usuario
	 *            - Recebe como parametro um objeto do tipo Usuario.
	 * @throws Exception
	 *             - Retorna excecao acaso o objeto seja do tipo Veterano, que
	 *             eh subclasse de Usuario.
	 */
	private void verificaUsuarioVeterano(Usuario usuario) throws Exception {

		if (usuario instanceof Veterano) {
			String objeto = "usuario";
			String erro = "jah eh veterano.";

			throw new ObjetoInvalidoException(objeto, erro);
		}
	}

}
