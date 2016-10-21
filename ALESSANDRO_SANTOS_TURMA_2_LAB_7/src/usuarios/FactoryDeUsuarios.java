/* Matricula: 115111170 - Aluno: Alessandro Lia Fook Santos LAB 07 - Turma 2 */

package usuarios;

public class FactoryDeUsuarios {

	public FactoryDeUsuarios() {
	}

	public Usuario criaUsuario(String nome, String login)throws Exception{
		
		return new Usuario(nome, login);
		
	}
		
}
