/* Matricula: 115111170 - Aluno: Alessandro Lia Fook Santos LAB 07 - Turma 2 */

package usuarios;

import java.util.Set;

import jogos.Jogabilidade;

public interface StatusUsuarioIF {

	double calculaCusto(double precoDoJogo);
	int calculaX2p(double precoDoJogo);
	int recompensar(Set<Jogabilidade> listaDeJogabilidades);
	int punir(Set<Jogabilidade> listaDeJogabilidades);
	String toString();
	
}
