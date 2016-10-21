/* Aluno: Alessandro Santos*/

public class CompraLojao {

	public static double preco = 1.99;
	
	public static void compra(){
	
		System.out.printf("Digite a quantidade de produtos diferentes que será comprada: ");
		int NumProdutos = MenuPrincipal.lerInteiro();
	
		String[] produto = new String[NumProdutos];
		int[] quantidade = new int[NumProdutos];
	
		for (int i = 0; i < NumProdutos; i++) {
			System.out.printf("Digite o nome do produto " +(i + 1)+ ": ");
			produto[i] = MenuPrincipal.lerString();
	
			System.out.printf("Quantidade de " +produto[i]+ ": ");
			quantidade[i] = MenuPrincipal.lerInteiro();
	
		}

		System.out.println("-- Cadastro Concluído --");
	
		imprimeCompra(produto, quantidade);

	}
	
	public static void imprimeCompra(String[] produto, int[] quantidade){
	
		System.out.println("A sua compra foi:");
		int totalProdutos = 0;
		
		for (int i = 0; i < produto.length; i++) {
			totalProdutos += quantidade[i];
		}
		
		for (int i = 0; i < produto.length; i++) {
			double proporcao = (quantidade[i] * 100.0)/ totalProdutos;
			int porcentagem = Math.round((float)proporcao);
	
			System.out.println(quantidade[i] + " " + produto[i] +"( " +porcentagem+ "%)");
		}
	
		System.out.println("Total de produtos: " +totalProdutos);
		double TotalGasto = totalProdutos * preco;		
		System.out.println("Total gasto: R$ " + TotalGasto);

	}
	
	public static void alteraPreco(double valor){
		preco = valor;
	}
}
