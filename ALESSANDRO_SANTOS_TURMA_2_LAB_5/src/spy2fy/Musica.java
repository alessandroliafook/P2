package spy2fy;

public class Musica {

	String titulo;
	int duracao;
	String genero;

	public Musica(String titulo, int duracao, String genero) throws Exception {

		if (titulo == null || titulo.trim().equals("")) {
			throw new Exception("Titulo da musica nao pode ser nulo ou vazio.");
		}

		if (duracao <= 0) {
			throw new Exception("Duracao da musica nao pode ser negativa.");
		}

		if (genero == null || genero.trim().equals("")) {
			throw new Exception("Genero da musica nao pode ser nulo ou vazio.");
		}

		this.titulo = titulo;
		this.duracao = duracao;
		this.genero = genero;

	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + duracao;
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {

		if (!(obj instanceof Musica)) {

			return false;
		} else {
			Musica outraMusica = (Musica) obj;

			if (!titulo.equals(outraMusica.getTitulo())) {

				return false;
			} else {

				return true;
			}
		}
	}

	@Override
	public String toString() {
		return "Musica [titulo=" + titulo + ", duracao=" + duracao + ", genero=" + genero + "]";
	}

}
