// Aluno: ALESSANDRO LIA FOOK SANTOS Matricula: 115111170
// FIZ O EXTRA
package lp2;

public class programaExercicios {

	private Exercicio[] listaExercicios;
	private int exerciciosArmazenados;

	public programaExercicios() {
		listaExercicios = new Exercicio[3];
		exerciciosArmazenados = 0;
	}

	
	private void arrayDinamico() {
		if (exerciciosArmazenados == listaExercicios.length) {
			int novoTamanho = exerciciosArmazenados * 2;
			Exercicio[] novaLista = new Exercicio[novoTamanho];
			for (int i = 0; i < exerciciosArmazenados; i++) {
				novaLista[i] = this.listaExercicios[i];
			}
			this.listaExercicios = novaLista;
		}
	}

	public boolean adicionaExercicio(String nome, int calorias) {
		
		this.arrayDinamico();
		
		if (exerciciosArmazenados == listaExercicios.length) {
			return false;

		} else {
			Exercicio exercicio = new Exercicio(nome, calorias);
			int indice = 0;

			while (indice < this.exerciciosArmazenados) {
				if (exercicio.equals(listaExercicios[indice])) {
					return false;
				}
				indice++;
			}
			listaExercicios[exerciciosArmazenados] = exercicio;
			exerciciosArmazenados++;
			return true;
		}

	}

	public int calculaCalorias(int horas) {
		int total = 0;
		for (int indice = 0; indice < this.exerciciosArmazenados; indice++) {
			total = total + listaExercicios[indice].caloriasExercicio(horas);
		}
		return total;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof programaExercicios)) {
			return false;
		} else {
			programaExercicios outroPrograma = (programaExercicios) obj;

			if (!(this.getExerciciosArmazenados() == outroPrograma
					.getExerciciosArmazenados())) {
				return false;
			} else {

				int i = 0;
				while (i < this.exerciciosArmazenados) {
					if (!(this.listaExercicios[i]
							.equals(outroPrograma.listaExercicios[i]))) {
						return false;
					}
				}
			}
		}
		return true;
	}

	@Override
	public String toString() {
		String string = "";
		for (int i = 0; i < this.exerciciosArmazenados; i++) {
			string = string + "(" + this.listaExercicios[i].getNome() + ","
					+ this.listaExercicios[i].getCalorias() + ")";
			if (i > 0) {
				string = string + ", ";
			}
		}
		return string;
	}

	public String getNomeExercicio(int indice) {
		return this.listaExercicios[indice].getNome();
	}

	public int getCaloriasExercicio(int indice) {
		return this.listaExercicios[indice].getCalorias();

	}

	public Exercicio[] getListaExercicios() {
		return listaExercicios;
	}

	public void setListaExercicios(Exercicio[] listaExercicios) {
		this.listaExercicios = listaExercicios;
	}

	public int getExerciciosArmazenados() {
		return exerciciosArmazenados;
	}

	public void setExerciciosArmazenados(int exerciciosArmazenados) {
		this.exerciciosArmazenados = exerciciosArmazenados;
	}

}
