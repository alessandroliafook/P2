package spy2fy;

import java.util.ArrayList;

public class Playlist {

	String nome;
	ArrayList<Musica> lista;

	public Playlist(String nome) throws Exception {

		if (nome == null || nome.trim().equals("")) {
			throw new Exception("Artista do album nao pode ser nulo ou vazio.");
		}

		this.nome = nome;
		lista = new ArrayList<Musica>();
	}

	public boolean addMusica(Musica musica) throws Exception {

		if (musica == null) {
			throw new Exception("Musica nao pode ser null");
		}
		
		if (this.lista.contains(musica)) {
			return false;
		
		} else {
			this.lista.add(musica);
			return true;
		}
	}

	public boolean verificaMusica(String nomeMusica) throws Exception{
		
		if (nomeMusica == null) {
			throw new Exception("O nome da musica nao pode ser null");
		}

		
		int indice = 0;
		
		while(indice < lista.size()){
			
			Musica musica = lista.get(indice);
			
			if(musica.getTitulo().equals(nomeMusica)){
				
				return true;
				
			}

			indice++;
		}
		
		return false;
	}
		
	public boolean verificaMusica(Musica musica) throws Exception{
		
		if (musica == null) {
			throw new Exception("Musica nao pode ser null");
		}

		boolean contem = this.lista.contains(musica); 
		
		return contem;
				
	}
		
	public int procuraIndiceMusica(String titulo) throws Exception {

		if (titulo == null || titulo.trim().equals("")) {
			throw new Exception("Titulo da musica nao pode ser nulo ou vazio.");
		}

		int indiceMusica = -1;

		if (this.lista.size() == 0) {

			return indiceMusica;

		} else {

			int indice = 0;

			while (indice < this.lista.size() && indiceMusica == -1) {

				Musica musica = this.lista.get(indice);

				if (musica.getTitulo().equalsIgnoreCase(titulo)) {

					indiceMusica = indice;
					}

				indice++;
			}

			return indiceMusica;
		}
	}

	public Musica getMusica(int posicao) throws Exception {
		
		if (posicao < 0) {
			throw new Exception("Faixa da musica nao pode ser negativa");
		}
	
		if (posicao >= this.lista.size()) {
			throw new Exception("Faixa da musica nao pode ultrapassar o numero limite do album");
		}
		
		Musica musica = this.lista.get(posicao);

		return musica;

	}
	
	public boolean rmMusica(Musica musica) throws Exception{
		
		if (musica == null) {
			throw new Exception("Musica nao pode ser null");
		}
		
		if (this.lista.contains(musica)) {
			
			this.lista.remove(musica);
			return true;
		
		} else {
			
			return false;
		}
	}

	public boolean rmMusica(String nomeMusica) throws Exception{
		
		if (nomeMusica == null || nomeMusica.trim().equals("")) {

						throw new Exception("O nome da musica nao pode ser null ou vazio");
		}
		
		if (verificaMusica(nomeMusica)) {
			
			int posicao = procuraIndiceMusica(nomeMusica);
			this.lista.remove(posicao);

			return true;
		
		} else {
			
			return false;
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Musica> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Musica> lista) {
		this.lista = lista;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Playlist other = (Playlist) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Playlist [nome=" + nome + ", lista=" + lista + "]";
	}

}
