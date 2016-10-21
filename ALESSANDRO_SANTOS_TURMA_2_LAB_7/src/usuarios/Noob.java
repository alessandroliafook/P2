/* Matricula: 115111170 - Aluno: Alessandro Lia Fook Santos LAB 07 - Turma 2 */

package usuarios;

import java.util.Set;

import jogos.Jogabilidade;

public class Noob implements StatusUsuarioIF {

	public Noob() {
	}

	/**
	 * Metodo que calcula o valor que sera pago pelo usuario, considerando o
	 * desconto de 10% concernente ao Noob ao preco do jogo.
	 * 
	 * @param precoDoJogo - O valor do jogo que se pretende calcular o preco com
	 * desconto a ser pago pelo Noob.
	 */
	public double calculaCusto(double precoDoJogo) {

		final double DESCONTO = 0.9;
		double custo = precoDoJogo * DESCONTO;

		return custo;
	}

	/**
	 * Metodo que calcula o X2P a ser ganho pelo usuario como consequencia da
	 * compra do jogo.
	 * 
	 * @param precoDoJogo - O preco do jogo que serve como base de calculo para o
	 * valor do X2P.
	 */
	public int calculaX2p(double precoDoJogo) {

		final int FATORX2P = 10;

		return Math.round((float) precoDoJogo * FATORX2P);

	}

	/**
	 * Metodo que calcula a recompensa em X2P do usuario considerando as
	 * jogabilidades presentes no jogo.
	 * @param listaDeJogabilidades - Representa a lista de jogabilidades do jogo.
	 */
	public int recompensar(Set<Jogabilidade> listaDeJogabilidades) {

		int x2p = 0;

		for (Jogabilidade jogabilidade : listaDeJogabilidades) {

			switch (jogabilidade) {

			case OFFLINE:
				x2p = x2p + 30;
				break;

			case MULTPLAYER:
				x2p = x2p + 10;
				break;

			default:
				break;

			}

		}

		return x2p;
	}

	/**
	 * Metodo que calcula as penalidades em X2P do usuario considerando as
	 * jogabilidades presentes no jogo.
	 * @param listaDeJogabilidades - Representa a lista de jogabilidades do jogo.
	 */
	public int punir(Set<Jogabilidade> listaDeJogabilidades) {

		int x2p = 0;

		for (Jogabilidade jogabilidade : listaDeJogabilidades) {

			switch (jogabilidade) {

			case ONLINE:
				x2p = x2p - 10;
				break;

			case COMPETITIVO:
				x2p = x2p - 20;
				break;

			case COOPERATIVO:
				x2p = x2p - 50;
				break;

			default:
				break;

			}

		}

		return x2p;
	}

	public String toString() {
		return "Noob";
	}

}
