/* Matricula: 115111170 - Aluno: Alessandro Lia Fook Santos LAB 06 - Turma 2 */

package usuarios;

import jogos.Jogo;

public class UsuarioParaTest extends Usuario{

	public UsuarioParaTest (String nome, String login) throws Exception {
		super(nome, login);
	}

	public boolean compraJogo(Jogo jogo) throws Exception{
		return true;
	}

	
}
