// Aluno: ALESSANDRO LIA FOOK SANTOS Matricula: 115111170

package lp2;

public class MainTeste {

	public static void main(String[] args) {
		//criando atletas.
		Atleta rhonda = new Atleta("Rhonda Rousy", 1.70, 61, "Feminino");
		Atleta neymar = new Atleta("Neymar Junior", 1.74, 68, "Masculino");
		Atleta messi = new Atleta("Messi", 1.69, 69, "Masculino");
		Atleta zezinho = new Atleta("Zezinho", 1.80, 120, "Masculino");
		Atleta mariazinha = new Atleta("Mariazinha", 1.6, 48, "Feminino");
		Atleta luke = new Atleta("Luke Skywalker", 1.73, 62, "Masculino");
		Atleta leia = new Atleta("Leia Skywalker", 1.73, 62, "Feminino");
		
		//Passo 2:
		System.out.println("========= Passo 2 =========");
		System.out.println("Deve ser true: "+neymar.adicionaExercicio("Futebol", 200));
		System.out.println("Deve ser true: "+neymar.adicionaExercicio("Corrida", 350));
		
		System.out.println("Deve ser true: "+rhonda.adicionaExercicio("Boxe", 500));
		System.out.println("Deve ser true: "+rhonda.adicionaExercicio("Corrida", 350));
		System.out.println("Deve ser false: "+rhonda.adicionaExercicio("Corrida", 350));
		System.out.println("Deve ser true: "+rhonda.adicionaExercicio("Jiu-jitsu", 840));
		System.out.println("Deve ser false: "+rhonda.adicionaExercicio("Judo", 460));

		System.out.println("Deve ser true: "+messi.adicionaExercicio("Futebol", 200));
		System.out.println("Deve ser true: "+messi.adicionaExercicio("Corrida", 350));
		
		System.out.println("Deve ser true: "+zezinho.adicionaExercicio("Jogar video game", 50));
		
		//Passo3:
		System.out.println();
		System.out.println("========= Passo 3 =========");
		System.out.println("Deve ser 1650: "+messi.malha(3));
		System.out.println("Deve ser 1650: "+neymar.malha(3));
		System.out.println("Deve ser 5070: "+rhonda.malha(3));
		System.out.println("Deve ser 150: "+zezinho.malha(3));
		System.out.println("Deve ser 0: "+mariazinha.malha(3));
		
		//Passo 4:
		System.out.println();
		System.out.println("========= Passo 4 =========");
		System.out.println("Deve ser Intermediario: "+rhonda.calculaIMC());
		System.out.println("Deve ser Intermediario: "+messi.calculaIMC());
		System.out.println("Deve ser Intermediario: "+neymar.calculaIMC());
		System.out.println("Deve ser Obeso: "+zezinho.calculaIMC());
		System.out.println("Deve ser Abaixo do Peso: "+mariazinha.calculaIMC());
		System.out.println("Deve ser Abaixo do Peso: "+luke.calculaIMC());
		System.out.println("Deve ser Intermediario: "+leia.calculaIMC());

		//Passo 5:
		System.out.println();
		System.out.println("========= Passo 5 =========");
		System.out.println(messi);
		System.out.println(neymar);
		System.out.println(rhonda);
		System.out.println(zezinho);
		System.out.println(mariazinha);
		
		//Passo 6:
		System.out.println();
		System.out.println("========= Passo 6 =========");
		System.out.println("Deve ser false:"+messi.equals(rhonda));
		System.out.println("Deve ser true:"+messi.equals(neymar));
	}	
}