// Aluno: ALESSANDRO LIA FOOK SANTOS Matricula: 115111170
package lp2;

public class Atleta {

	private String nome;
	private double altura;
	private int peso;
	private String sexo;
	private programaExercicios individual;

	public Atleta(String nome, double altura, int peso, String sexo) {
		this.nome = nome;
		this.altura = altura;
		this.peso = peso;
		this.sexo = sexo;
		this.individual = new programaExercicios();
	}

	public boolean adicionaExercicio(String nome, int calorias) {
		return individual.adicionaExercicio(nome, calorias);
	}

	public int malha(int horas) {
		return individual.calculaCalorias(horas);
	}

	public String toString() {
		String enter = "\n";
		String informacoes = "Atleta: " + nome + " ; Peso: " + peso
				+ " kg; Altura: " + altura + " m" + enter
				+ "Programa de exercicios:" + enter;

		for (int i = 0; i < individual.getExerciciosArmazenados(); i++) {
			informacoes = informacoes + "==> " + individual.getNomeExercicio(i)
					+ ": " + individual.getCaloriasExercicio(i) + " kcal/h"
					+ enter;
		}
		return informacoes;
	}

	public boolean equals(Object obj) {

		if (!(obj instanceof Atleta)) {
			return false;

		} else {
			Atleta outro = (Atleta) obj;

			if (!(this.getIndividual().equals(outro.getIndividual()))) {
				return false;
			}
		}

		return true;
	}

	public String calculaIMC() {

		double imc = this.peso / (this.altura * this.altura);
		String grau = "";

		if (this.getSexo().equals("Feminino")) {

			if (imc <= 18.9) {
				grau = "Abaixo do Peso";

			} else if (imc <= 31.2) {
				grau = "Intermediario";

			} else {
				grau = "Obeso";
			}

		} else if (this.getSexo().equals("Masculino")) {

			if (imc <= 20.8) {
				grau = "Abaixo do Peso";

			} else if (imc <= 32.2) {
				grau = "Intermediario";

			} else {
				grau = "Obeso";

			}
		}
		return grau;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public programaExercicios getIndividual() {
		return individual;
	}

	public void setIndividual(programaExercicios individual) {
		this.individual = individual;
	}

}
