/* Matricula: 115111170 - Aluno: Alessandro Lia Fook Santos LAB 03 - Turma 2 */

package lojao;

import java.util.Scanner;

public class Menu {

	Scanner entrada;
	Supermercado economizaP2;

	public Menu() {

		entrada = new Scanner(System.in);
		economizaP2 = new Supermercado();
	}

	public void inicial() {

		int opcao = 0;
		final int SAIR = 4;
		String menuOpcoes = "= = = = Bem vindo(a) ao Economiza = = = =" + enter() 
							+ "Digite a opcao desejada:" + enter()
							+ "1 - Cadastrar um Produto" + enter() 
							+ "2 - Vender um Produto" + enter() 
							+ "3 - Imprimir Balanco" + enter() 
							+ "4 - Sair" + enter() 
							+ enter() 
							+ "Opcao: ";

		do {

			opcao = lerInteiro(menuOpcoes);
			System.out.println();

			executaOpcao(opcao);

		} while (opcao != SAIR);

		System.out.println("-- Fim de execucao --");

	}

	private void executaOpcao(int opcao) {

		final int REALIZA_CADASTRO = 1;
		final int REALIZA_VENDA = 2;
		final int IMPRIME_BALANCO = 3;

		switch (opcao) {

		case REALIZA_CADASTRO:

			cadastro();
			break;

		case REALIZA_VENDA:

			venda();
			break;

		case IMPRIME_BALANCO:

			balanco();
			break;
		}

	}

	public boolean validaContinuidade(String continuar) {

		if (!(continuar.equalsIgnoreCase("sim")) && !(continuar.equalsIgnoreCase("nao"))) {

			return true;
		}
		return false;
	}

	public boolean verificaContinuidade(String continuar) {

		if (continuar.equalsIgnoreCase("sim")) {

			return true;
		}

		return false;
	}

	private void cadastro() {

		System.out.println("= = = = Cadastro de Produtos = = = = ");
		String continuar = "";

		do {

			String nomeProduto = lerString("Digite o nome do produto: ");

			double precoProduto = lerReal("Digite o preco unitario do produto: ");

			String tipoProduto = lerString("Digite o tipo do produto: ");

			int quantidadeProduto = lerInteiro("Digite a quantidade no estoque: ");

			this.economizaP2.ordenaCadastro(nomeProduto, precoProduto, tipoProduto, quantidadeProduto);

			String resultado = enter() + quantidadeProduto + " " + nomeProduto 
								+ "(s) cadastrado com sucesso."	+ enter();

			System.out.println(resultado);

			do {

				continuar = lerString("Deseja cadastrar outro produto? ");

			} while (validaContinuidade(continuar));

			System.out.println();

		} while (verificaContinuidade(continuar));
	}

	private void venda() {

		System.out.println("= = = = Venda de Produtos = = = =");
		String continuar = "";

		do {
			String nomeProduto = lerString("Digite o nome do produto: ");

			boolean produtoExiste = this.economizaP2.verificaExistenciaProduto(nomeProduto);

			if (produtoExiste) {

				String descricaoProduto = this.economizaP2.descricaoProduto(nomeProduto);

				System.out.println("==> " + descricaoProduto);
				System.out.println();

				int quantidadeVendida = lerInteiro("Digite a quantidade que deseja vender: ");
				boolean autorizaVenda = this.economizaP2.verificaEstoque(nomeProduto, quantidadeVendida);

				if (autorizaVenda) {

					double valorVendido = this.economizaP2.ordenaVenda(nomeProduto, quantidadeVendida);

					System.out.println("==> Total arrecadado: R$ " + valorVendido);

				} else {

					System.out.println("Nao foi possivel vender pois nao ha: " 
										+ nomeProduto + " suficiente.");
				}

			} else {

				System.out.println(nomeProduto + " ==> " + nomeProduto + " nao cadastrado no sistema");
			}

			System.out.println();

			do {
				continuar = lerString("Deseja vender outro produto? ");

			} while (validaContinuidade(continuar));

			System.out.println();

		} while (verificaContinuidade(continuar));
	}

	private void balanco() {

		String balanco = this.economizaP2.balancoEstoque();

		String totalVendido = "Total arrecadado: " 
							+ String.format("%.2f", this.economizaP2.getTotalArrecadado());

		String potencialArrecadacao = "Total que pode ser arrecadado: "
									+ String.format("%.2f", this.economizaP2.getArrecadacaoEmPotencial());

		System.out.println("= = = = Impressao de Balanco = = = =" + enter() 
							+ "Produtos cadastrados:" + enter()
							+ balanco + enter() 
							+ totalVendido + enter() 
							+ potencialArrecadacao + enter());
	}

	public int lerInteiro(String prompt) {
		System.out.print(prompt);
		int inteiro = entrada.nextInt();
		entrada.nextLine();

		return inteiro;
	}

	public String lerString(String prompt) {

		System.out.print(prompt);
		String string = entrada.nextLine();

		return string;
	}

	public double lerReal(String prompt) {

		System.out.print(prompt);
		double real = entrada.nextDouble();
		entrada.nextLine();

		return real;
	}

	public String enter() {
		return "\n";
	}
}