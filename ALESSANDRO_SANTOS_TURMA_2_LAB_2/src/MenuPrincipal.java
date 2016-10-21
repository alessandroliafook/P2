import java.util.Scanner;

public class MenuPrincipal {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		
		int opcao;
			
		do {
			System.out.println("Bem vindo ao Lojão LP2!");
			System.out.println("Menu Inicial: Digite uma das opções abaixo:");
			System.out.println();
		
			System.out.println("1 - Realizar uma compra.");
			System.out.println("2 - Mudar o preço base.");
			System.out.println("3 - Sair");
			System.out.println();
				
			System.out.printf("Opção: ");
			opcao = lerInteiro(); 
				
			switch (opcao) { 
	
				case 1: 
					CompraLojao.compra();
					break;
					
				
				case 2:
					System.out.println("O preço atual é R$ " + CompraLojao.preco);
					System.out.printf("Informe o novo valor do preço: R$ ");
						
					double valor = lerReal();
				
					CompraLojao.alteraPreco(valor);
					break;
				
				}
			} while (opcao != 3); 
	System.out.println("-- Fim de execução --");
	}


	public static int lerInteiro(){
		int inteiro = input.nextInt();
		input.nextLine();
		return inteiro;
	}
	public static String lerString(){
		String palavra = input.nextLine();
		return palavra;
	}
	public static double lerReal(){
		double real = input.nextDouble();
		input.nextLine();
		return real;
	}
}
