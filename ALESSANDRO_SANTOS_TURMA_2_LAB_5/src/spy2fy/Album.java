package spy2fy;

import java.util.ArrayList;

public class Album implements Comparable<Album>{

	String artista;
	String titulo;
	int anoLancamento;
	ArrayList<Musica> faixas;
	boolean favorito;

	// COMPARAR PELO NOME DO ALBUM

	public int compareTo(Album album){
		
		
		return 1;
	}
	
	public int compare(Album album, Album album2){
		
		return 1;
	}
	
	public Album(String artista, String titulo, int anoLancamento) throws Exception {

		if (artista == null || artista.trim().equals("")) {
			throw new Exception("Artista do album nao pode ser nulo ou vazio.");
		}

		if (anoLancamento <= 1900) {
			throw new Exception("Ano de lancamento do album nao pode inferior a 1900.");
		}

		if (titulo == null || titulo.trim().equals("")) {
			throw new Exception("Titulo da musica nao pode ser nulo ou vazio.");
		}

		this.artista = artista;
		this.titulo = titulo;
		this.anoLancamento = anoLancamento;
		this.faixas = new ArrayList<Musica>();
		this.favorito = false;

	}

	public boolean adicionaMusica(Musica musica) throws Exception {

		if (musica == null) {
			throw new Exception("A musica nao pode ser null");
		}

		if (this.faixas.contains(musica)) {

			return false;

		} else {

			this.faixas.add(musica);
			return true;
		}
	}

	public boolean removeMusica(String titulo) throws Exception {

		if (titulo == null || titulo.trim().equals("")) {
			throw new Exception("Titulo da musica nao pode ser nulo ou vazio.");
		}

		int indice = 0;

		while (indice < this.faixas.size()) {

			Musica musica = this.faixas.get(indice);

			if (musica.getTitulo().equalsIgnoreCase(titulo)) {
				this.faixas.remove(indice);
				return true;
			}

			indice++;
		}
		return false;
	}

	public boolean verificaMusica(String titulo) throws Exception {

		if (titulo == null || titulo.trim().equals("")) {
			throw new Exception("Titulo da musica nao pode ser nulo ou vazio.");
		}

		int indice = 0;

		while (indice < this.faixas.size()) {

			Musica musica = this.faixas.get(indice);

			if (musica.getTitulo().equalsIgnoreCase(titulo)) {
				return true;
			}

			indice++;
		}

		return false;
	}
	
	public boolean verificaMusica(Musica musica) throws Exception{

		if (musica == null) {
			throw new Exception("Musica da musica nao pode ser nula");
		}

		int indice = 0;

		while (indice < this.faixas.size()) {

			Musica outraMusica = this.faixas.get(indice);

			if (outraMusica.equals(musica)) {
				return true;
			}
			indice++;
		}
		return false;
	}
	
	public boolean validaIndiceMusica(int faixa) throws Exception{
		
		if(faixa < 0){
			throw new Exception("A faixa nao pode ser negativa.");
		}
		
		if(faixa >= faixas.size()){
			return false;
		}
		return true;
	}
	
	public int procuraIndiceMusica(String titulo) throws Exception {

		if (titulo == null || titulo.trim().equals("")) {
			throw new Exception("Titulo da musica nao pode ser nulo ou vazio.");
		}

		int indiceMusica = -1;

		if (this.faixas.size() == 0) {

			return indiceMusica;

		} else {

			int indice = 0;

			while (indice < this.faixas.size() || indiceMusica == -1) {

				Musica musica = this.faixas.get(indice);

				if (musica.getTitulo().equalsIgnoreCase(titulo)) {
					indiceMusica = indice;
				}

				indice++;
			}

			return indiceMusica;
		}
	}

	public Musica getMusica(int faixa) throws Exception {

		if (faixa < 0) {
			throw new Exception("Faixa da musica nao pode ser negativa");
		}
		
		if (faixa >= this.faixas.size()) {
			throw new Exception("Faixa da musica nao pode ultrapassar o numero limite do album");
		}
		
		Musica musica = this.faixas.get(faixa);

		return musica;

	}

	public int getDuracao() {

		int duracao = 0;
		int indice;

		for (indice = 0; indice < this.faixas.size(); indice++) {

			Musica musica = this.faixas.get(indice);

			duracao = duracao + musica.getDuracao();
		}

		return duracao;

	}

	public boolean getFavorito(){

		return this.favorito;
	}
	
	public void setFavorito() {
		
		this.favorito = true;

	}

	public void removeFavorito(){

		this.favorito = false;
	}
	
	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(int anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	public ArrayList<Musica> getFaixas() {
		return faixas;
	}

	public void setFaixas(ArrayList<Musica> faixas) {
		this.faixas = faixas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + anoLancamento;
		result = prime * result + ((artista == null) ? 0 : artista.hashCode());
		result = prime * result + ((faixas == null) ? 0 : faixas.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Album)) {
			return false;

		} else {

			Album outroAlbum = (Album) obj;

			if (!artista.equals(outroAlbum.artista)) {

				return false;

			} else if (!titulo.equals(outroAlbum.titulo)) {

				return false;

			} else {

				return true;
			}
		}
	}

	@Override
	public String toString() {
		return "Album [artista=" + artista + ", titulo=" + titulo + ", anoLancamento=" + anoLancamento + ", faixas="
				+ faixas + "]";
	}

}
