// Aluno: ALESSANDRO LIA FOOK SANTOS Matricula: 115111170
package lp2;

public class Exercicio {

	private String nome;
	private int calorias;

	public Exercicio(String nome, int calorias) {
		this.nome = nome;
		this.calorias = calorias;
	}

	public int caloriasExercicio(int horas) {
		return horas * this.calorias;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof Exercicio)) {
			return false;
		} else {
			Exercicio outroExercicio = (Exercicio) obj;
			if (!(this.nome.equals(outroExercicio.getNome()))) {
				return false;
			}
		}
		return true;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCalorias() {
		return calorias;
	}

	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}

}
