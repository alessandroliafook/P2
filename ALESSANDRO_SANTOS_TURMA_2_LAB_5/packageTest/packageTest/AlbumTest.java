package packageTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import spy2fy.Album;
import spy2fy.Musica;

public class AlbumTest {

	Musica musica;
	Musica musica2;
	Musica musica3;

	@Before
	public void inicializaVariaveisGlobais() throws Exception {

		this.musica = new Musica("Chandelier", 3, "Pop");
		this.musica2 = new Musica("Elastic Heart", 3, "Pop");
		this.musica3 = new Musica("Cellophane", 4, "Pop");

	}

	@Test
	public void testContrutor() {

		// testa construtores funcionais

		try {

			Album album = new Album("LinkinPark", "Meteora", 2000);
			Album album1 = new Album("Quenn", "Live", 1985);
			Album album2 = new Album("LinkinPark", "Meteora", 2001);

			assertEquals("LinkinPark", album.getArtista());
			assertEquals("Meteora", album.getTitulo());
			assertEquals(2000, album.getAnoLancamento());
			assertEquals(album, album2);
			assertFalse(album.equals(album1));

		} catch (Exception e) {
			fail("nao deve falhar, pois os construtores devem estar funcionais");
		}

	}

	@Test
	public void testConstrutorInvalido() {

		// testa artista vazio ou null

		try {

			Album album = new Album("  ", "AoVivo", 2012);
			fail("se chegar aqui da erro, pois deveria lancar exception.");

		} catch (Exception e) {

			assertEquals("Artista do album nao pode ser nulo ou vazio.", e.getMessage());

		}
		try {

			Album album1 = new Album("", "AoVivo", 2012);
			fail("se chegar aqui da erro, pois deveria lancar exception.");

		} catch (Exception e) {

			assertEquals("Artista do album nao pode ser nulo ou vazio.", e.getMessage());

		}
		try {

			Album album2 = new Album(null, "AoVivo", 2012);
			fail("se chegar aqui da erro, pois deveria lancar exception.");

		} catch (Exception e) {

			assertEquals("Artista do album nao pode ser nulo ou vazio.", e.getMessage());

		}

		// testa titulo vazio ou null

		try {

			Album album = new Album("ZeRamalho", "", 2012);
			fail("se chegar aqui da erro, pois deveria lancar exception.");

		} catch (Exception e) {

			assertEquals("Titulo da musica nao pode ser nulo ou vazio.", e.getMessage());

		}
		try {
			Album album1 = new Album("ZeRamalho", "  ", 2012);
			fail("se chegar aqui da erro, pois deveria lancar exception.");

		} catch (Exception e) {

			assertEquals("Titulo da musica nao pode ser nulo ou vazio.", e.getMessage());

		}
		try {

			Album album2 = new Album("ZeRamalho", null, 2012);
			fail("se chegar aqui da erro, pois deveria lancar exception.");

		} catch (Exception e) {

			assertEquals("Titulo da musica nao pode ser nulo ou vazio.", e.getMessage());

		}

		// testa limites do ano

		try {

			Album album = new Album("ZeRamalho", "Acustico", -1);
			fail("se chegar aqui da erro, pois deveria lancar exception.");

		} catch (Exception e) {

			assertEquals("Ano de lancamento do album nao pode inferior a 1900.", e.getMessage());

		}
		try {

			Album album1 = new Album("ZeRamalho", "Acustico", 0);
			fail("se chegar aqui da erro, pois deveria lancar exception.");

		} catch (Exception e) {

			assertEquals("Ano de lancamento do album nao pode inferior a 1900.", e.getMessage());

		}
		try {

			Album album2 = new Album("ZeRamalho", "Acustico", 1899);
			fail("se chegar aqui da erro, pois deveria lancar exception.");

		} catch (Exception e) {

			assertEquals("Ano de lancamento do album nao pode inferior a 1900.", e.getMessage());

		}
	}

	@Test
	public void testAdicionaMusica() {

		try {

			Album album = new Album("LinkinPark", "Meteora", 2000);

			try {

				// testa a funcao adiciona musica

				assertTrue(album.adicionaMusica(this.musica));
				assertTrue(album.adicionaMusica(this.musica2));
				assertTrue(album.adicionaMusica(this.musica3));

			} catch (Exception e) {
				fail("nao deveria ter lancado nenhuma Exception nesse teste.");
			}

			try {

				// testa a funcao adiciona musica

				assertFalse(album.adicionaMusica(this.musica));
				assertFalse(album.adicionaMusica(this.musica2));
				assertFalse(album.adicionaMusica(this.musica3));

			} catch (Exception e) {
				fail("nao deveria ter lancado nenhuma Exception nesse teste.");
			}

		} catch (Exception e) {

			fail("nao deveria ter lancado nenhuma Exception nesse teste.");
		}
	}

	@Test
	public void testAddMusicaInvalida() {

		try {
			Album album = new Album("LinkinPark", "Meteora", 2000);

			try {

				// musica com nome vazio

				musica = null;
				album.adicionaMusica(musica);
				fail("se chegar aqui da erro, pois deveria lancar exception.");

			} catch (Exception e) {
				assertEquals("A musica nao pode ser null", e.getMessage());
			}

		} catch (Exception e) {

			fail("nao deveria ter lancado nenhuma Exception nesse teste.");
		}

	}

	@Test
	public void testOrdemFaixas() {

		try {

			Album album = new Album("LinkinPark", "Meteora", 2000);
			Album album1 = new Album("Quenn", "Live", 1985);
			Album album2 = new Album("LinkinPark", "Meteora", 2000);

			album.adicionaMusica(this.musica);
			album.adicionaMusica(this.musica2);
			album.adicionaMusica(this.musica3);

			album2.adicionaMusica(this.musica);
			album2.adicionaMusica(this.musica2);
			album2.adicionaMusica(this.musica3);

			try {

				// compara se as musicas fora adicionadas na ordem

				assertEquals(album.getMusica(0), this.musica);
				assertEquals(album.getMusica(1), this.musica2);
				assertEquals(album.getMusica(2), this.musica3);

			} catch (Exception e) {

				fail("nao deveria ter lancado nenhuma Exception nesse teste.");

			}
			try {

				// verifica se a musica esta na ordem errada

				assertFalse(album.getMusica(1).equals(musica));

			} catch (Exception e) {

				fail("nao deveria ter lancado nenhuma Exception nesse teste.");

			}
			try {

				// compara albuns

				equals(album.getFaixas().equals(album2));
				assertFalse(album.getFaixas().equals(album1));

			} catch (Exception e) {

				fail("nao deveria ter lancado nenhuma Exception nesse teste.");
			}
		} catch (Exception e) {

			fail("nao deveria ter lancado nenhuma Exception nesse teste.");
		}

	}

	@Test
	public void testRemoveMusica() {

		try {

			Album album = new Album("LinkinPark", "Meteora", 2000);
			Album album1 = new Album("Quenn", "Live", 1985);
			Album album2 = new Album("LinkinPark", "Meteora", 2000);

			album.adicionaMusica(this.musica);
			album.adicionaMusica(this.musica2);
			album.adicionaMusica(this.musica3);

			album1.adicionaMusica(this.musica);
			album1.adicionaMusica(this.musica2);
			album1.adicionaMusica(this.musica3);

			album2.adicionaMusica(this.musica);
			album2.adicionaMusica(this.musica2);
			album2.adicionaMusica(this.musica3);

			try {

				assertTrue(album.verificaMusica("Chandelier"));
				album.removeMusica("Chandelier");
				assertFalse(album.verificaMusica("Chandelier"));

				assertTrue(album2.verificaMusica("Elastic Heart"));
				album2.removeMusica("Elastic Heart");
				assertFalse(album2.verificaMusica("Elastic Heart"));

				assertTrue(album1.verificaMusica("Cellophane"));
				album1.removeMusica("Cellophane");
				assertFalse(album1.verificaMusica("Cellophane"));

			} catch (Exception e) {
				fail("nao deveria ter lancado nenhuma Exception nesse teste.");
			}

		} catch (Exception e) {
			fail("nao deveria ter lancado nenhuma Exception nesse teste.");
		}
	}

	@Test
	public void testRemoveMusicaInvalida() {

		try {

			Album album = new Album("LinkinPark", "Meteora", 2000);
			Album album1 = new Album("Quenn", "Live", 1985);

			album.adicionaMusica(this.musica);
			album.adicionaMusica(this.musica2);
			album.adicionaMusica(this.musica3);

			try {

				assertFalse(album.removeMusica(""));
				fail("se chegar aqui da erro, pois deveria lancar exception.");

			} catch (Exception e) {

				assertEquals("Titulo da musica nao pode ser nulo ou vazio.", e.getMessage());
			}

			try {

				assertFalse(album.removeMusica("  "));
				fail("se chegar aqui da erro, pois deveria lancar exception.");

			} catch (Exception e) {

				assertEquals("Titulo da musica nao pode ser nulo ou vazio.", e.getMessage());
			}

			try {

				assertFalse(album.removeMusica(null));
				fail("se chegar aqui da erro, pois deveria lancar exception.");

			} catch (Exception e) {

				assertEquals("Titulo da musica nao pode ser nulo ou vazio.", e.getMessage());
			}

			try {

				assertFalse(album1.removeMusica(""));
				fail("se chegar aqui da erro, pois deveria lancar exception.");

			} catch (Exception e) {

				assertEquals("Titulo da musica nao pode ser nulo ou vazio.", e.getMessage());
			}

			try {

				assertFalse(album1.removeMusica("  "));
				fail("se chegar aqui da erro, pois deveria lancar exception.");

			} catch (Exception e) {

				assertEquals("Titulo da musica nao pode ser nulo ou vazio.", e.getMessage());
			}

			try {

				assertFalse(album1.removeMusica(null));
				fail("se chegar aqui da erro, pois deveria lancar exception.");

			} catch (Exception e) {

				assertEquals("Titulo da musica nao pode ser nulo ou vazio.", e.getMessage());
			}

		} catch (Exception e) {
			fail("nao deveria ter lancado nenhuma Exception nesse teste.");
		}

	}

	@Test
	public void testVerificaMusica() {

		try {

			Album album = new Album("LinkinPark", "Meteora", 2000);
			Album album1 = new Album("Quenn", "Live", 1985);
			Album album2 = new Album("LinkinPark", "Meteora", 2000);

			album.adicionaMusica(this.musica);
			album.adicionaMusica(this.musica2);
			album.adicionaMusica(this.musica3);

			try {

				assertTrue(album.verificaMusica("Chandelier"));
				assertTrue(album.verificaMusica("Elastic Heart"));
				assertTrue(album.verificaMusica("Chandelier"));

				assertFalse(album1.verificaMusica("Chandelier"));
				assertFalse(album1.verificaMusica("Elastic Heart"));

				assertFalse(album2.verificaMusica("Elastic Heart"));
				album2.adicionaMusica(this.musica2);
				assertTrue(album.verificaMusica("Elastic Heart"));

			} catch (Exception e) {

				fail("nao deveria ter lancado nenhuma Exception nesse teste.");

			}

		} catch (Exception e) {

			fail("nao deveria ter lancado nenhuma Exception nesse teste.");
		}

	}

	@Test
	public void testVerificaMusicaInvalida() {

		try {

			Album album = new Album("LinkinPark", "Meteora", 2000);

			album.adicionaMusica(this.musica);
			album.adicionaMusica(this.musica2);
			album.adicionaMusica(this.musica3);

			try {
				// procura musica com parametro nulo

				String string = null;
				assertFalse(album.verificaMusica(string));
				fail("se chegar aqui da erro, pois deveria lancar exception.");

			} catch (Exception e) {

				assertEquals("Titulo da musica nao pode ser nulo ou vazio.", e.getMessage());
			}

			try {
				// procura musica com parametro nulo

				String musica = null;
				assertFalse(album.verificaMusica(musica));
				fail("se chegar aqui da erro, pois deveria lancar exception.");

			} catch (Exception e) {

				assertEquals("Titulo da musica nao pode ser nulo ou vazio.", e.getMessage());
			}

			try {
				// procura musica com parametro vazio

				assertFalse(album.verificaMusica(""));
				fail("se chegar aqui da erro, pois deveria lancar exception.");

			} catch (Exception e) {

				assertEquals("Titulo da musica nao pode ser nulo ou vazio.", e.getMessage());
			}

			try {

				// procura musica com parametro de espacos

				assertFalse(album.verificaMusica("  "));
				fail("se chegar aqui da erro, pois deveria lancar exception.");

			} catch (Exception e) {

				assertEquals("Titulo da musica nao pode ser nulo ou vazio.", e.getMessage());
			}

		} catch (Exception e) {
			fail("nao deveria ter lancado nenhuma Exception nesse teste.");
		}
	}

	@Test
	public void testValidaIndiceMusica() {

		try {

			Album album = new Album("LinkinPark", "Meteora", 2000);
			Album album1 = new Album("Quenn", "Live", 1985);

			album.adicionaMusica(this.musica);
			album.adicionaMusica(this.musica2);
			album.adicionaMusica(this.musica3);

			try{
				
				assertTrue(album.validaIndiceMusica(0));
				assertTrue(album.validaIndiceMusica(2));
				assertFalse(album1.validaIndiceMusica(0));
				assertFalse(album.validaIndiceMusica(3));
				
			}catch(Exception e){

				fail("nao deveria ter lancado nenhuma Exception nesse teste.");
			}
			
		} catch (Exception e) {
			
			fail("nao deveria ter lancado nenhuma Exception nesse teste.");
		}

	}

	@Test
	public void testValidaIndiceMusicaInvalida() {

		try {

			Album album = new Album("LinkinPark", "Meteora", 2000);

			album.adicionaMusica(this.musica);
			album.adicionaMusica(this.musica2);
			album.adicionaMusica(this.musica3);

			try{
				
				assertTrue(album.validaIndiceMusica(-3));
				
			}catch(Exception e){

				assertEquals("A faixa nao pode ser negativa.", e.getMessage());
			}

			
			
		} catch (Exception e) {
			fail("nao deveria ter lancado nenhuma Exception nesse teste.");

		}

	}

	@Test
	public void testProcuraMusica() {

		try {

			Album album = new Album("LinkinPark", "Meteora", 2000);
			Album album1 = new Album("Quenn", "Live", 1985);
			Album album2 = new Album("LinkinPark", "Meteora", 2000);

			album.adicionaMusica(this.musica);
			album.adicionaMusica(this.musica2);
			album.adicionaMusica(this.musica3);

			try {

				assertEquals(0, album.procuraIndiceMusica("Chandelier"));
				assertEquals(1, album.procuraIndiceMusica("Elastic Heart"));
				assertEquals(2, album.procuraIndiceMusica("Cellophane"));

			} catch (Exception e) {

				fail("nao deveria ter lancado nenhuma Exception nesse teste.");

			}

			try {

				assertEquals((-1), album1.procuraIndiceMusica("Chandelier"));
				assertEquals((-1), album1.procuraIndiceMusica("Elastic Heart"));

			} catch (Exception e) {

				fail("nao deveria ter lancado nenhuma Exception nesse teste.");

			}

			try {

				assertEquals(-1, album2.procuraIndiceMusica("Elastic Heart"));
				album2.adicionaMusica(this.musica2);
				assertEquals(0, album2.procuraIndiceMusica("Elastic Heart"));

			} catch (Exception e) {

				fail("nao deveria ter lancado nenhuma Exception nesse teste.");

			}

		} catch (Exception e) {

			fail("nao deveria ter lancado nenhuma Exception nesse teste.");
		}

	}

	@Test
	public void testGetMusica() {

		try {

			Album album = new Album("LinkinPark", "Meteora", 2000);

			album.adicionaMusica(this.musica);
			album.adicionaMusica(this.musica2);
			album.adicionaMusica(this.musica3);

			try {

				assertEquals(this.musica, album.getMusica(0));
				assertEquals(this.musica2, album.getMusica(1));
				assertEquals(this.musica3, album.getMusica(2));

			} catch (Exception e) {

				fail("nao deveria ter lancado nenhuma Exception nesse teste.");
			}

		} catch (Exception e) {

			fail("nao deveria ter lancado nenhuma Exception nesse teste.");
		}

	}

	@Test
	public void testGetMusicaInvalida() {

		try {

			Album album = new Album("LinkinPark", "Meteora", 2000);
			Album album1 = new Album("Quenn", "Live", 1985);

			album.adicionaMusica(this.musica);
			album.adicionaMusica(this.musica2);
			album.adicionaMusica(this.musica3);

			try {
				Musica musica4 = album.getMusica(3);
				fail("se chegar aqui da erro, pois deveria lancar exception.");

			} catch (Exception e) {
				assertEquals("Faixa da musica nao pode ultrapassar o numero limite do album", e.getMessage());
			}

			try {

				Musica musica5 = album1.getMusica(1);
				fail("se chegar aqui da erro, pois deveria lancar exception.");

			} catch (Exception e) {
				assertEquals("Faixa da musica nao pode ultrapassar o numero limite do album", e.getMessage());
			}

			try {

				album.getMusica(-1);
				fail("se chegar aqui da erro, pois deveria lancar exception.");

			} catch (Exception e) {

				assertEquals("Faixa da musica nao pode ser negativa", e.getMessage());

			}

			try {

				album1.getMusica(-10);
				fail("se chegar aqui da erro, pois deveria lancar exception.");

			} catch (Exception e) {

				assertEquals("Faixa da musica nao pode ser negativa", e.getMessage());

			}

		} catch (Exception e) {
			fail("nao deveria ter lancado nenhuma Exception nesse teste.");
		}

	}

	@Test
	public void testGetDuracao() {

		try {

			Album album = new Album("LinkinPark", "Meteora", 2000);
			Album album1 = new Album("Quenn", "Live", 1985);
			Album album2 = new Album("LinkinPark", "Meteora", 2000);

			album.adicionaMusica(this.musica);
			album.adicionaMusica(this.musica2);
			album.adicionaMusica(this.musica3);

			album1.adicionaMusica(this.musica);
			album1.adicionaMusica(this.musica3);

			try {

				assertTrue(album.getDuracao() == 10);
				assertTrue(album1.getDuracao() == 7);
				assertTrue(album2.getDuracao() == 0);

				assertFalse(album.getDuracao() == 1);
				assertFalse(album1.getDuracao() == -5);
				assertFalse(album2.getDuracao() == 2);

			} catch (Exception e) {

				fail("nao deveria ter lancado nenhuma Exception nesse teste.");
			}

		} catch (Exception e) {
			fail("nao deveria ter lancado nenhuma Exception nesse teste.");
		}

	}

	@Test
	public void testFavorito() {
		try {

			Album album = new Album("LinkinPark", "Meteora", 2000);
			Album album1 = new Album("Quenn", "Live", 1985);
			Album album2 = new Album("LinkinPark", "Meteora", 2000);

			try {

				assertFalse(album.getFavorito());
				assertFalse(album1.getFavorito());
				assertFalse(album2.getFavorito());

			} catch (Exception e) {
				fail("nao deveria ter lancado nenhuma Exception nesse teste.");

			}

			try {

				album1.setFavorito();
				assertTrue(album1.getFavorito());

			} catch (Exception e) {

				fail("nao deveria ter lancado nenhuma Exception nesse teste.");

			}
			try {

				album2.setFavorito();
				assertTrue(album2.getFavorito());
			} catch (Exception e) {

				fail("nao deveria ter lancado nenhuma Exception nesse teste.");

			}

		} catch (Exception e) {
			fail("nao deveria ter lancado nenhuma Exception nesse teste.");
		}
	}

	public void testRemoveFavorito() {
		try {

			Album album = new Album("LinkinPark", "Meteora", 2000);
			Album album1 = new Album("Quenn", "Live", 1985);
			Album album2 = new Album("LinkinPark", "Meteora", 2000);

			album.setFavorito();
			album1.setFavorito();
			album2.setFavorito();

			try {

				album.removeFavorito();
				assertFalse(album.getFavorito());

			} catch (Exception e) {
				fail("nao deveria ter lancado nenhuma Exception nesse teste.");

			}

			try {

				album1.removeFavorito();
				assertFalse(album1.getFavorito());

			} catch (Exception e) {

				fail("nao deveria ter lancado nenhuma Exception nesse teste.");

			}
			try {

				album2.removeFavorito();
				assertFalse(album2.getFavorito());

			} catch (Exception e) {

				fail("nao deveria ter lancado nenhuma Exception nesse teste.");

			}

		} catch (Exception e) {
			fail("nao deveria ter lancado nenhuma Exception nesse teste.");
		}
	}

}
