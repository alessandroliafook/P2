package spy2fy;

import java.util.ArrayList;
import java.util.HashMap;

public class Musicoteca {

	ArrayList<Album> bibliotecaAlbuns;
	HashMap<String, Playlist> playlist;

	public Musicoteca() {

		this.bibliotecaAlbuns = new ArrayList<Album>();
		this.playlist = new HashMap<String, Playlist>();

	}

	// metodos bibliotecaAlbuns

	public boolean addAlbum(Album album) throws Exception {

		verificaAlbum(album);

		if (this.bibliotecaAlbuns.contains(album)) {

			return false;

		} else {

			this.bibliotecaAlbuns.add(album);
			return true;
		}

	}

	public boolean addAlbum(String artista, String titulo, int anoLancamento)
			throws Exception {

		Album album = new Album(artista, titulo, anoLancamento);

		if (this.bibliotecaAlbuns.contains(album)) {

			return false;

		} else {

			this.bibliotecaAlbuns.add(album);
			return true;
		}

	}

	public boolean addMusicaAlbum(Musica musica, Album album) throws Exception {

		verificaMusica(musica);

		verificaAlbum(album);

		if (this.bibliotecaAlbuns.contains(album)) {

			int indice = this.bibliotecaAlbuns.indexOf(album);
			Album outroAlbum = this.bibliotecaAlbuns.get(indice);

			return outroAlbum.adicionaMusica(musica);

		} else {

			return false;

		}

	}

	public boolean removeAlbum(String nomeAlbum) throws Exception {

		verificaNomeAlbum(nomeAlbum);

		int indice = 0;

		while (indice < this.bibliotecaAlbuns.size()) {
			Album album = this.bibliotecaAlbuns.get(indice);

			if (album.getTitulo().equals(nomeAlbum)) {
				this.bibliotecaAlbuns.remove(indice);
				return true;
			}

		}

		return false;
	}

	public boolean removeAlbum(Album album) throws Exception {

		verificaAlbum(album);

		int indice = 0;

		while (indice < this.bibliotecaAlbuns.size()) {
			Album outroAlbum = this.bibliotecaAlbuns.get(indice);

			if (outroAlbum.equals(album)) {
				this.bibliotecaAlbuns.remove(indice);
				return true;
			}

		}

		return false;
	}

	private int indiceAlbum(String nomeAlbum) throws Exception {

		verificaNomeAlbum(nomeAlbum);

		int indice = -1;

		int i = 0;

		while (i < this.bibliotecaAlbuns.size()) {

			Album albumComparado = this.bibliotecaAlbuns.get(i);
			if (albumComparado.getTitulo().equals(nomeAlbum)) {

				indice = i;
				return indice;

			}
			i++;
		}

		return indice;

	}

	public Album procuraAlbum(String nomeAlbum) throws Exception {

		verificaNomeAlbum(nomeAlbum);

		int indiceAlbum = indiceAlbum(nomeAlbum);

		if (indiceAlbum == -1) {
			throw new Exception("Album nao pertence ao Perfil especificado");
		}

		Album albumProcurado = this.bibliotecaAlbuns.get(indiceAlbum);

		return albumProcurado;

	}

	public boolean favoritaAlbum(Album album) throws Exception {

		verificaAlbum(album);

		if (this.bibliotecaAlbuns.contains(album)) {

			Album albumFavorito = procuraAlbum(album.getTitulo());
			albumFavorito.setFavorito();

			return true;

		} else {

			return false;
		}
	}

	public boolean favoritaAlbum(String nomeAlbum) throws Exception {

		verificaNomeAlbum(nomeAlbum);

		Album album = procuraAlbum(nomeAlbum);

		album.setFavorito();
		return true;
	}

	public ArrayList<Album> getAlbunsFavoritos() {

		ArrayList<Album> favoritos = new ArrayList<Album>();

		for (Album album : this.bibliotecaAlbuns) {

			if (album.getFavorito()) {

				favoritos.add(album);
			}
		}
		return favoritos;

	}

	public boolean pesquisaMusicaBiliotecaAlbuns(String nomeMusica)
			throws Exception {

		verificaNomeMusica(nomeMusica);

		for (Album album : this.bibliotecaAlbuns) {

			if (album.verificaMusica(nomeMusica)) {
				return true;
			}
		}
		return false;
	}

	public boolean pesquisaMusicaBiliotecaAlbuns(Musica musica)
			throws Exception {

		verificaMusica(musica);

		for (Album album : this.bibliotecaAlbuns) {

			if (album.verificaMusica(musica)) {
				return true;
			}
		}
		return false;
	}

	public String pesquisaLocalizacaoMusica(String nomeMusica) throws Exception {

		verificaNomeMusica(nomeMusica);

		String localizacao = nomeMusica + "esta no album";

		for (Album album : this.bibliotecaAlbuns) {

			if (album.verificaMusica(nomeMusica)) {

				int faixa = album.procuraIndiceMusica(nomeMusica);
				localizacao = localizacao + album.getTitulo()
						+ "na faixa de numero" + faixa;

				return localizacao;
			}
		}

		localizacao = "Musica nao encontrada";

		return localizacao;

	}

	// metodos playlist

	public boolean adicionaPlaylist(String nomePlaylist, String nomeAlbum,
			int faixa) throws Exception {

		verificaNomePlaylist(nomePlaylist);

		verificaNomeAlbum(nomeAlbum);

		verificaValidadeFaixa(faixa);

		Playlist playlist;

		if (this.playlist.containsKey(nomePlaylist)) {

			playlist = this.playlist.get(nomePlaylist);

		} else {

			playlist = new Playlist(nomePlaylist);
		}

		Album album = procuraAlbum(nomeAlbum);
		if (album.validaIndiceMusica(faixa)) {

			Musica musica = album.getMusica(faixa);

			playlist.addMusica(musica);
			this.playlist.put(nomePlaylist, playlist);

			return true;

		} else {
			return false;
		}
	}

	public boolean removeMusicaPlaylist(String nomePlaylist, String nomeMusica)
			throws Exception {

		verificaNomePlaylist(nomePlaylist);

		verificaNomePlaylist(nomeMusica);

		Playlist playlist = this.playlist.get(nomePlaylist);

		return playlist.rmMusica(nomeMusica);
	}

	public boolean removeMusicaPlaylist(String nomePlaylist, Musica musica)
			throws Exception {

		verificaNomePlaylist(nomePlaylist);

		if (musica == null) {
			throw new Exception("A musica  nao pode ser null");
		}

		if (this.playlist.containsKey(nomePlaylist)) {

			Playlist playlist = this.playlist.get(nomePlaylist);

			return playlist.rmMusica(musica);

		} else {

			return false;
		}
	}

	public boolean pesquisaMusicaPlaylist(String nomePlaylist, String nomeMusica)
			throws Exception {

		verificaNomePlaylist(nomePlaylist);

		verificaNomePlaylist(nomeMusica);

		if (this.playlist.containsKey(nomePlaylist)) {

			Playlist playlist = this.playlist.get(nomePlaylist);

			return playlist.verificaMusica(nomeMusica);

		} else {

			return false;
		}
	}

	public boolean pesquisaMusicaPlaylist(String nomePlaylist, Musica musica)
			throws Exception {

		verificaNomePlaylist(nomePlaylist);

		if (musica == null) {
			throw new Exception("A musica  nao pode ser null");
		}

		if (this.playlist.containsKey(nomePlaylist)) {

			Playlist playlist = this.playlist.get(nomePlaylist);

			return playlist.verificaMusica(musica);

		} else {

			return false;
		}

	}

	public int getDuracaoPlaylist(String nomePlaylist) throws Exception {

		verificaNomePlaylist(nomePlaylist);

		int duracao = 0;

		if (this.playlist.containsKey(nomePlaylist)) {

			Playlist playlist = this.playlist.get(nomePlaylist);

			for (int indice = 0; indice < playlist.getLista().size(); indice++) {

				Musica musica = playlist.getMusica(indice);
				duracao = duracao + musica.getDuracao();

			}

		}

		return duracao;

	}

	private void verificaNomeMusica(String nomeMusica) throws Exception {

		if (nomeMusica == null || nomeMusica.trim().equals("")) {

			throw new Exception("O nome da musica nao pode ser null ou vazio");
		}
	}

	private void verificaAlbum(Album album) throws Exception {

		if (album == null) {
			throw new Exception("O album nao pode ser null.");
		}
	}

	private void verificaNomeAlbum(String nomeAlbum) throws Exception {
		if (nomeAlbum == null || nomeAlbum.trim().equals("")) {

			throw new Exception("O nome do album nao pode ser null ou vazio");
		}
	}

	private void verificaMusica(Musica musica) throws Exception {

		if (musica == null) {
			throw new Exception("A musica nao pode ser null.");
		}
	}

	private void verificaValidadeFaixa(int faixa) throws Exception {
		if (faixa < 0) {

			throw new Exception("O numero da faixa nao pode ser negativo.");
		}
	}

	private void verificaNomePlaylist(String nomePlaylist) throws Exception {
		if (nomePlaylist == null || nomePlaylist.trim().equals("")) {

			throw new Exception(
					"O nome da playlist nao pode ser null ou vazio.");
		}
	}

}
