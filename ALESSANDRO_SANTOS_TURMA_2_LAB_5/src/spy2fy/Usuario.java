package spy2fy;

public class Usuario {

	String nome;
	Musicoteca musicoteca;
	
	public Usuario(String nome) throws Exception{
		
		verificaNome(nome);

		this.nome = nome;
		musicoteca = new Musicoteca();
		
	}


	private void verificaNome(String nome) throws Exception {
		if (nome == null || nome.trim().equals("")) {
			throw new Exception("Nome do usuario nao pode ser nulo ou vazio.");
		}
	}

	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Musicoteca getMusicoteca() {
		return musicoteca;
	}


	public void setMusicoteca(Musicoteca musicoteca) {
		this.musicoteca = musicoteca;
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
		Usuario other = (Usuario) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	
	
}
