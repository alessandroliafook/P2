/* Matricula: 115111170 - Aluno: Alessandro Lia Fook Santos LAB 03 - Turma 2 */

package lojao;

public class Estoque {

	private Produto[] prateleira;
	private int numeroProdutos;

	public Estoque() {

		this.prateleira = new Produto[5];
		this.numeroProdutos = 0;
	}

	private boolean verificaTamanhoEstoque() {

		return this.numeroProdutos == this.prateleira.length;

	}

	private void aumentaEstoque() {

		Produto[] novoArray = new Produto[this.numeroProdutos * 2];

		for (int i = 0; i < this.numeroProdutos; i++) {

			novoArray[i] = this.prateleira[i];
		}

		this.prateleira = novoArray;
	}

	public void realizaCadastro(String nome, double preco, String tipo, int quantidade) {

		Produto novoProduto = new Produto(nome, preco, tipo, quantidade);

		if (this.numeroProdutos == 0) {

			this.prateleira[numeroProdutos] = novoProduto;
			this.numeroProdutos++;

		} else if (this.numeroProdutos != 0) {

			boolean flag = false;
			int indice = 0;

			while (indice < this.numeroProdutos) {

				if (novoProduto.equals(this.prateleira[indice])) {

					int valorAumentado = novoProduto.getQuantidade();
					double novoPreco = novoProduto.getPreco();

					this.prateleira[indice].setPreco(novoPreco);
					this.prateleira[indice].incrementaQuantidade(valorAumentado);
					flag = true;
				}

				indice++;
			}

			if (flag == false) {

				if (verificaTamanhoEstoque()) {

					aumentaEstoque();
				}

				this.prateleira[numeroProdutos] = novoProduto;
				this.numeroProdutos++;

			}
		}
	}

	public double realizaVenda(String nomeProduto, int quantidadeVendida) {

		int indiceProduto = getIndice(nomeProduto);
		Produto produto = this.prateleira[indiceProduto];

		produto.decrementaQuantidade(quantidadeVendida);

		double totalArrecadado = quantidadeVendida * produto.getPreco();

		return totalArrecadado;

	}

	public boolean verificaExistenciaProduto(String nomeProduto) {

		int indice = 0;

		while (indice < this.numeroProdutos) {

			if (this.prateleira[indice].getNome().equals(nomeProduto)) {

				return true;
			}

			indice++;
		}

		return false;
	}

	private int getIndice(String nomeProduto) {

		int indiceProduto = -1;
		int indice = 0;

		while (indice < this.numeroProdutos) {

			if (prateleira[indice].getNome().equals(nomeProduto)) {

				indiceProduto = indice;
				break;
			}

			indice++;
		}

		return indiceProduto;
	}

	public String getDescricaoProduto(String nomeProduto) {
		int indiceProduto = getIndice(nomeProduto);
		String produto = this.prateleira[indiceProduto].toString();

		return produto;
	}

	public boolean verificaQuantidadeEstocada(String nomeProduto, int quantidadeVendida) {

		int indiceProduto = getIndice(nomeProduto);
		Produto produto = this.prateleira[indiceProduto];
		int quantidadeEstocada = produto.getQuantidade();

		if (quantidadeVendida > quantidadeEstocada || quantidadeVendida < 0) {

			return false;
		}

		return true;
	}

	public double getPotencialArrecadavel() {

		double potencialArrecadacao = 0.0;

		for (int i = 0; i < this.numeroProdutos; i++) {

			int quantidade = this.prateleira[i].getQuantidade();
			double preco = this.prateleira[i].getPreco();

			potencialArrecadacao = potencialArrecadacao + (quantidade * preco);
		}

		return potencialArrecadacao;
	}

	public int getTamanhoPrateleira() {

		return this.numeroProdutos;
	}

	public String getListaCompleta() {

		String listaCompletaEstoque = "";

		for (int i = 0; i < this.numeroProdutos; i++) {

			listaCompletaEstoque = listaCompletaEstoque + (i + 1) + ") " + this.prateleira[i] + " Restante: "
					+ this.prateleira[i].getQuantidade() + "\n";
		}

		return listaCompletaEstoque;
	}

	@Override
	public String toString() {

		return "Estoque";
	}

}
