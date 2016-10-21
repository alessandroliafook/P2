package packageTest;

import static org.junit.Assert.*;

import org.junit.Test;

import spy2fy.Musica;
import spy2fy.Usuario;

public class UsuarioTest {

	@Test
	public void testUsuario() {

		try {
		
			Usuario usuario = new Usuario(null);
			fail(); // se chegar aqui da erro, pois deveria lancar exception.

		} catch (Exception e) {
			assertEquals("Nome do usuario nao pode ser nulo ou vazio.",
					e.getMessage());
		}

		try {
			Usuario usuario = new Usuario("");
			fail(); // se chegar aqui da erro, pois deveria lancar exception.

		} catch (Exception e) {
			assertEquals("Nome do usuario nao pode ser nulo ou vazio.",
					e.getMessage());
		}

		try {
			Usuario usuario = new Usuario("  ");
			fail(); // se chegar aqui da erro, pois deveria lancar exception.

		} catch (Exception e) {
			assertEquals("Nome do usuario nao pode ser nulo ou vazio.",
					e.getMessage());
		}
				
	}

	@Test
	public void testEquals() {
		fail("Not yet implemented");
	}

}
