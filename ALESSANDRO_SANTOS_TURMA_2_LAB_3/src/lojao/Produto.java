/* Matricula: 115111170 - Aluno: Alessandro Lia Fook Santos LAB 03 - Turma 2 */

package lojao;

public class Produto {

	private String nomeProduto;
	private double precoProduto;
	private String tipoProduto;
	private int quantidadeProduto;

	public Produto(String nome, double preco, String tipo, int quantidade) {

		nomeProduto = nome;
		precoProduto = preco;
		tipoProduto = tipo;
		quantidadeProduto = quantidade;
	}

	public void setNome(String nome) {

		this.nomeProduto = nome;
	}

	public String getNome() {

		return this.nomeProduto;
	}

	public void setPreco(double preco) {

		this.precoProduto = preco;
	}

	public double getPreco() {

		return this.precoProduto;
	}

	public void setTipo(String tipo) {

		this.tipoProduto = tipo;
	}

	public String getTipo() {

		return this.tipoProduto;
	}

	public void incrementaQuantidade(int quantidade) {

		this.quantidadeProduto = this.quantidadeProduto + quantidade;
	}

	public void decrementaQuantidade(int quantidade) {

		this.quantidadeProduto = this.quantidadeProduto - quantidade;
	}

	public int getQuantidade() {

		return this.quantidadeProduto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.nomeProduto == null) ? 0 : this.nomeProduto.hashCode());
		result = prime * result + ((this.tipoProduto == null) ? 0 : this.tipoProduto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {

		if (!(obj instanceof Produto)) {

			return false;
		}

		Produto produto = (Produto) obj;
		String nomeProduto = produto.getNome();

		if (!(this.nomeProduto.equals(nomeProduto))) {

			return false;
		}

		return true;

	}

	@Override
	public String toString() {

		String precoProduto = String.format("%.2f", this.precoProduto);

		String referenciaProduto = this.nomeProduto + "(" + this.tipoProduto + "). R$ " + precoProduto;

		return referenciaProduto;
	}

}
