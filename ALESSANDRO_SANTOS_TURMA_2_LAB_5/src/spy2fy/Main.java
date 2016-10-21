package spy2fy;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws Exception {

		Musica chandelier;
		Musica elasticHeart;
		Musica cellophane;

		Album meteora;
		Album live;
		Album meteora2;
		
		chandelier = new Musica("Chandelier", 3, "Pop");
		elasticHeart = new Musica("Elastic Heart", 3, "Pop");
		cellophane = new Musica("Cellophane", 4, "Pop");
		
		meteora = new Album("LinkinPark", "Meteora", 2000);
		live = new Album("Quenn", "Live", 1985);
		meteora2 = new Album("LinkinPark", "Meteora", 2001);
		
		
		meteora.adicionaMusica(chandelier);
		meteora.adicionaMusica(elasticHeart);
		meteora.adicionaMusica(cellophane);
		
		live.adicionaMusica(chandelier);
		live.adicionaMusica(elasticHeart);

		Musicoteca musicoteca = new Musicoteca();
		Musicoteca musicoteca2 = new Musicoteca();

		
	
		// "se chegar aqui da erro, pois deveria lancar exception."
		//"nao deveria ter lancado nenhuma Exception nesse teste."
		
	}
}

/*
 * � composta pela cole��o de albuns do usu�rio e pela cole��o de playlists do
 * usu�rio
 * 
 * Albuns podem ser adicionados � cole��o e removidos da cole��o.
 * 
 * Albuns null n�o devem ser aceitos.
 * 
 * Deve ser poss�vel marcar albuns como favoritos e obter todos os albuns que
 * s�o favoritos.
 * 
 * M�todos que adicionam, removem e pesquisam albuns s�o necess�rios
 * 
 * Uma playlist encapsula uma cole��o de m�sicas, mas ao contr�rio do album,
 * essas m�sicas podem ser de diferentes artistas.
 * 
 * As playlists s�o armazenadas de forma que o nome da playlist (que serve de
 * chave) pode ser usado para recuperar as m�sicas da playlist.
 * 
 * � poss�vel adicionar m�sicas a uma playlist as m�sicas de qualquer playlist
 * devem ser todas m�sicas de albuns do usu�rio, caso contr�rio a m�sica n�o
 * pode ser adicionada � playlist.
 * 
 * Uma playlist inicia vazia e as m�sicas s�o adicionadas uma a uma.
 * 
 * Uma nova m�sica adicionada vai sempre para o fim da playlist.
 * 
 * Crie o m�todo adicionaPlaylist(String nomePlaylist, String nomeAlbum, int faixa)
 * 
 * todos os m�todos que adicionam, removem e pesquisam objetos em cole��es devem retornar um boolean
 */
