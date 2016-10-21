/* Matricula: 115111170 - Aluno: Alessandro Lia Fook Santos LAB 03 - Turma 2 */

package lojao;

public class Supermercado {

	private double totalArrecadado;
	Estoque estoque;

	public Supermercado() {

		totalArrecadado = 0;
		estoque = new Estoque();
	}

	public void ordenaCadastro(String nome, double preco, String tipo, int quantidade) {

		this.estoque.realizaCadastro(nome, preco, tipo, quantidade);
	}

	public double ordenaVenda(String nomeProduto, int quantidadeVendida) {

		double totalVenda = this.estoque.realizaVenda(nomeProduto, quantidadeVendida);

		this.totalArrecadado = this.totalArrecadado + totalVenda;

		return totalVenda;
	}

	public boolean autorizaVenda(String nomeProduto, int quantidadeVendida) {

		return true;
	}

	public String descricaoProduto(String nomeProduto) {

		return this.estoque.getDescricaoProduto(nomeProduto);
	}

	public boolean verificaExistenciaProduto(String nomeProduto) {

		return this.estoque.verificaExistenciaProduto(nomeProduto);
	}

	public boolean verificaEstoque(String nomeProduto, int quantidadeVendida) {

		return this.estoque.verificaQuantidadeEstocada(nomeProduto, quantidadeVendida);
	}

	public String balancoEstoque() {

		return this.estoque.getListaCompleta();
	}

	public double getArrecadacaoEmPotencial() {

		return this.estoque.getPotencialArrecadavel();
	}

	public double getTotalArrecadado() {

		return this.totalArrecadado;
	}

	
}
