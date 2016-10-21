package packageTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import spy2fy.Album;
import spy2fy.Musica;
import spy2fy.Musicoteca;

public class MusicotecaTest {

	Musica chandelier;
	Musica elasticHeart;
	Musica cellophane;

	Album meteora;
	Album live;
	Album meteora2;

	@Before
	public void inicializaVariaveis() throws Exception {

		this.chandelier = new Musica("Chandelier", 3, "Pop");
		this.elasticHeart = new Musica("Elastic Heart", 3, "Pop");
		this.cellophane = new Musica("Cellophane", 4, "Pop");

		this.meteora = new Album("LinkinPark", "Meteora", 2000);
		this.live = new Album("Quenn", "Live", 1985);
		this.meteora2 = new Album("LinkinPark", "Meteora", 2001);

		meteora.adicionaMusica(chandelier);
		meteora.adicionaMusica(elasticHeart);
		meteora.adicionaMusica(cellophane);

		live.adicionaMusica(chandelier);
		live.adicionaMusica(elasticHeart);

	}

	@Test
	public void testMusicoteca() {

		Musicoteca musicoteca = new Musicoteca();
		Musicoteca musicoteca2 = new Musicoteca();

	}

	@Test
	public void testAddAlbum() {
	
		try{
		
			Musicoteca musicoteca = new Musicoteca();
			Musicoteca musicoteca2 = new Musicoteca();
			
			try{
				
				assertTrue(musicoteca.addAlbum(live));
				assertTrue(musicoteca.addAlbum(meteora));

				assertFalse(musicoteca.addAlbum(live));
				assertFalse(musicoteca.addAlbum(meteora));
				assertFalse(musicoteca.addAlbum(meteora2));
				
			}catch(Exception e){
				fail("nao deveria ter lancado nenhuma Exception nesse teste.");
				
			}
			
			try{
				assertTrue(musicoteca.addAlbum(null));
				fail("se chegar aqui da erro, pois deveria lancar exception."); 
			
			}catch(Exception e){
			
				assertEquals("O album nao pode ser null.", e.getMessage());
			}
			
			try{
			
				assertTrue(musicoteca2.addAlbum("  ", "AoVivo", 2012));
				fail("se chegar aqui da erro, pois deveria lancar exception.");
				
			}catch(Exception e){

				assertEquals("Artista do album nao pode ser nulo ou vazio.", e.getMessage());
			}

			try{

				assertTrue(musicoteca2.addAlbum("", "AoVivo", 2012));
				fail("se chegar aqui da erro, pois deveria lancar exception.");
				
			}catch(Exception e){
				
				assertEquals("Artista do album nao pode ser nulo ou vazio.", e.getMessage());
			}

			try{

				assertTrue(musicoteca2.addAlbum(null, "AoVivo", 2012));
				fail("se chegar aqui da erro, pois deveria lancar exception.");
				
			}catch(Exception e){
				
				assertEquals("Artista do album nao pode ser nulo ou vazio.", e.getMessage());
			}

			try{

				assertTrue(musicoteca2.addAlbum("ZeRamalho", "", 2012));
				fail("se chegar aqui da erro, pois deveria lancar exception.");
				
			}catch(Exception e){
				
				assertEquals("Titulo da musica nao pode ser nulo ou vazio.", e.getMessage());
			}

			try{

				assertTrue(musicoteca2.addAlbum("ZeRamalho", "  ", 2012));
				fail("se chegar aqui da erro, pois deveria lancar exception.");
				
			}catch(Exception e){
				
				assertEquals("Titulo da musica nao pode ser nulo ou vazio.", e.getMessage());
			}

			try{

				assertTrue(musicoteca2.addAlbum("ZeRamalho", null, 2012));
				fail("se chegar aqui da erro, pois deveria lancar exception.");
				
			}catch(Exception e){
				
				assertEquals("Titulo da musica nao pode ser nulo ou vazio.", e.getMessage());
			}

			try{

				assertTrue(musicoteca2.addAlbum("ZeRamalho", "Acustico", -1));
				fail("se chegar aqui da erro, pois deveria lancar exception.");
				
			}catch(Exception e){
				
				assertEquals("Ano de lancamento do album nao pode inferior a 1900.", e.getMessage());
			} agrupamento vazio de mú

			try{

				assertTrue(musicoteca2.addAlbum("ZeRamalho", "Acustico", 0));
				fail("se chegar aqui da erro, pois deveria lancar exception.");
				
			}catch(Exception e){
				
				assertEquals("Ano de lancamento do album nao pode inferior a 1900.", e.getMessage());
			}

			try{

				assertTrue(musicoteca2.addAlbum("ZeRamalho", "Acustico", 1899));
				fail("se chegar aqui da erro, pois deveria lancar exception.");
				
			}catch(Exception e){
				
				assertEquals("Ano de lancamento do album nao pode inferior a 1900.", e.getMessage());
			}
			
		}catch(Exception e){
			fail("nao deveria ter lancado nenhuma Exception nesse teste.");

		}
	}

	public void testAddMusicaAlbum() {

		try {

			Musicoteca musicoteca = new Musicoteca();
			Musicoteca musicoteca2 = new Musicoteca();

			assertTrue(musicoteca.addAlbum(live));
			assertTrue(musicoteca.addAlbum(meteora));

			assertFalse(musicoteca.addAlbum(live));
			assertFalse(musicoteca.addAlbum(meteora));
			assertFalse(musicoteca.addAlbum(meteora2));

			try {

				assertTrue(musicoteca.addMusicaAlbum(cellophane, live));
				assertFalse(musicoteca.addMusicaAlbum(cellophane, live));
				assertTrue(musicoteca.addMusicaAlbum(chandelier, live));
				assertTrue(musicoteca.addMusicaAlbum(elasticHeart, live));
				assertFalse(musicoteca.addMusicaAlbum(chandelier, live));

			} catch (Exception e) {

				fail("nao deveria ter lancado nenhuma Exception nesse teste.");

			}
			try {

				assertTrue(musicoteca.addMusicaAlbum(null, live));
				fail("se chegar aqui da erro, pois deveria lancar exception.");

			} catch (Exception e) {

				assertEquals("A musica nao pode ser null.", e.getMessage());
			}
			try {

				assertTrue(musicoteca.addMusicaAlbum(elasticHeart, null));
				fail("se chegar aqui da erro, pois deveria lancar exception.");

			} catch (Exception e) {

				assertEquals("O album nao pode ser null.", e.getMessage());

			}

		} catch (Exception e) {
			fail("nao deveria ter lancado nenhuma Exception nesse teste.");

		}

	}

	@Test
	public void testRemoveAlbum() {

		try {

			Musicoteca musicoteca = new Musicoteca();
			Musicoteca musicoteca2 = new Musicoteca();

			assertTrue(musicoteca.addAlbum(live));
			assertTrue(musicoteca.addAlbum(meteora));

			assertTrue(musicoteca2.addAlbum(live));
			assertTrue(musicoteca2.addAlbum(meteora));

			try {

				assertTrue(musicoteca.removeAlbum(live));
				assertTrue(musicoteca.removeAlbum("Meteora"));

			} catch (Exception e) {

				fail("nao deveria ter lancado nenhuma Exception nesse teste.");

			}
			try {
				assertFalse(musicoteca.removeAlbum(live));
				assertFalse(musicoteca.removeAlbum("Acustico"));

			} catch (Exception e) {

				fail("nao deveria ter lancado nenhuma Exception nesse teste.");

			}
			try {

				String string = null;
				assertFalse(musicoteca2.removeAlbum(string));
				fail("se chegar aqui da erro, pois deveria lancar exception.");

			} catch (Exception e) {
				assertEquals("O titulo nao pode ser null ou vazio.",
						e.getMessage());
			}

			try {
				Album album = null;
				assertTrue(musicoteca.removeAlbum(album));
				fail("se chegar aqui da erro, pois deveria lancar exception.");

			} catch (Exception e) {

				assertEquals("O album nao pode ser null.", e.getMessage());
			}

			try {

				assertTrue(musicoteca2.removeAlbum("  "));
				fail("se chegar aqui da erro, pois deveria lancar exception.");

			} catch (Exception e) {

				assertEquals("O titulo nao pode ser null ou vazio.",
						e.getMessage());
			}

			try {

				assertTrue(musicoteca2.removeAlbum(""));
				fail("se chegar aqui da erro, pois deveria lancar exception.");

			} catch (Exception e) {

				assertEquals("O titulo nao pode ser null ou vazio.",
						e.getMessage());
			}

		} catch (Exception e) {
			fail("nao deveria ter lancado nenhuma Exception nesse teste.");

		}

	}

	@Test
	public void testProcuraAlbum() {

		try {

			Musicoteca musicoteca = new Musicoteca();
			Musicoteca musicoteca2 = new Musicoteca();

			assertTrue(musicoteca.addAlbum(live));
			assertTrue(musicoteca.addAlbum(meteora));

			try {
				assertEquals(live, musicoteca.procuraAlbum("Live"));
				assertEquals(meteora, musicoteca.procuraAlbum("Meteora"));

			} catch (Exception e) {
				fail("nao deveria ter lancado nenhuma Exception nesse teste.");

			}
			try {

				assertEquals(live, musicoteca2.procuraAlbum("Live"));
				fail("se chegar aqui da erro, pois deveria lancar exception.");

			} catch (Exception e) {

				assertEquals("Album nao pertence ao Perfil especificado",
						e.getMessage());
			}
			try {

				assertEquals(live, musicoteca1.procuraAlbum("Acustico"));
				fail("se chegar aqui da erro, pois deveria lancar exception.");

			} catch (Exception e) {

				assertEquals("Album nao pertence ao Perfil especificado",
						e.getMessage());

			}
			try {

				assertEquals(live, musicoteca1.procuraAlbum(null));
				fail("se chegar aqui da erro, pois deveria lancar exception.");

			} catch (Exception e) {

				assertEquals("O nome do album nao pode ser null ou vazio.",
						e.getMessage());
			}

		} catch (Exception e) {

			fail("nao deveria ter lancado nenhuma Exception nesse teste.");

		}

		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testFavoritaAlbum() {

		try {

			Musicoteca musicoteca = new Musicoteca();
			Musicoteca musicoteca2 = new Musicoteca();
			Musicoteca musicoteca3 = new Musicoteca();

			assertTrue(musicoteca.addAlbum(live));
			assertTrue(musicoteca.addAlbum(meteora));

			assertTrue(musicoteca2.addAlbum(live));
			assertTrue(musicoteca2.addAlbum(meteora));

			try {

				assertTrue(musicoteca.favoritaAlbum(live));
				assertTrue(musicoteca.favoritaAlbum(meteora));
				assertFalse(musicoteca.favoritaAlbum(meteora2));

			} catch (Exception e) {

				fail("nao deveria ter lancado nenhuma Exception nesse teste.");

			}
			try {

				assertTrue(musicoteca2.favoritaAlbum("Live"));
				assertTrue(musicoteca2.favoritaAlbum("Meteora"));

			} catch (Exception e) {

				fail("nao deveria ter lancado nenhuma Exception nesse teste.");

			}
			try {

				assertFalse(musicoteca3.favoritaAlbum("Meteora"));
				assertFalse(musicoteca3.favoritaAlbum(live));

			} catch (Exception e) {
				fail("nao deveria ter lancado nenhuma Exception nesse teste.");

			}
			try {

				assertFalse(musicoteca3.favoritaAlbum(null));
				fail("se chegar aqui da erro, pois deveria lancar exception.");

			} catch (Exception e) {
				assertEquals("O nome do album nao pode ser null ou vazio.",
						e.getMessage());

			}
			try {

				assertFalse(musicoteca.favoritaAlbum(null));
				fail("se chegar aqui da erro, pois deveria lancar exception.");

			} catch (Exception e) {
				assertEquals("O nome do album nao pode ser null ou vazio.",
						e.getMessage());

			}

			try {

				assertFalse(musicoteca.favoritaAlbum(""));
				fail("se chegar aqui da erro, pois deveria lancar exception.");

			} catch (Exception e) {
				assertEquals("O nome do album nao pode ser null ou vazio.",
						e.getMessage());

			}

			try {

				assertFalse(musicoteca.favoritaAlbum("  "));
				fail("se chegar aqui da erro, pois deveria lancar exception.");

			} catch (Exception e) {
				assertEquals("O nome do album nao pode ser null ou vazio.",
						e.getMessage());

			}

		} catch (Exception e) {

			fail("nao deveria ter lancado nenhuma Exception nesse teste.");

		}
	}

	@Test
	public void testGetAlbunsFavoritos() {

		try{
			
			Musicoteca musicoteca = new Musicoteca();
			Musicoteca musicoteca2 = new Musicoteca();
			Musicoteca musicoteca3 = new Musicoteca();

			assertTrue(musicoteca.addAlbum(live));
			assertTrue(musicoteca.addAlbum(meteora));

			assertTrue(musicoteca2.addAlbum(live));
			assertTrue(musicoteca2.addAlbum(meteora));
			
			assertTrue(musicoteca.favoritaAlbum(live));
			assertTrue(musicoteca.favoritaAlbum(meteora));

						
			try{

				ArrayList<Album> favoritos = new ArrayList<Album>();
				favoritos.add(live);
				favoritos.add(meteora);
				
				assertEquals(favoritos, musicoteca.getAlbunsFavoritos());
				
			}catch(Exception e){
				
				fail("nao deveria ter lancado nenhuma Exception nesse teste.");
				
			}
			try{
				
				ArrayList<Album> favoritos = new ArrayList<Album>();
				assertEquals(favoritos, musicoteca2.getAlbunsFavoritos());
				
			}catch(Exception e){

				fail("nao deveria ter lancado nenhuma Exception nesse teste.");

			}
			try{
				ArrayList<Album> favoritos = new ArrayList<Album>();
				
				assertFalse(assertEquals(favoritos, musicoteca.getAlbunsFavoritos()));

			}catch(Exception e){
				
				fail("nao deveria ter lancado nenhuma Exception nesse teste.");

			}

			
		}catch(Exception e){
			
			fail("nao deveria ter lancado nenhuma Exception nesse teste.");

		}
		
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testPesquisaMusicaBiliotecaAlbuns() {
		try{
			
			Musicoteca musicoteca = new Musicoteca();
			Musicoteca musicoteca2 = new Musicoteca();
			Musicoteca musicoteca3 = new Musicoteca();

			assertTrue(musicoteca.addAlbum(live));
			assertTrue(musicoteca.addAlbum(meteora));

			assertTrue(musicoteca2.addAlbum(live));
			assertTrue(musicoteca2.addAlbum(meteora));
	
		try{
			
			assertTrue(musicoteca.pesquisaMusicaBiliotecaAlbuns(chandelier));
			assertTrue(musicoteca.pesquisaMusicaBiliotecaAlbuns(elasticHeart));
			
		}catch(){
			
			fail("nao deveria ter lancado nenhuma Exception nesse teste.");

		}

		try{
			
			assertTrue(musicoteca.pesquisaMusicaBiliotecaAlbuns(live));
			assertTrue(musicoteca.pesquisaMusicaBiliotecaAlbuns(meteora));
			
		}catch(){
			
			fail("nao deveria ter lancado nenhuma Exception nesse teste.");

		}

		try{}catch(){}
		try{}catch(){}
		try{}catch(){}
		
		} catch(Exception e){

			fail("nao deveria ter lancado nenhuma Exception nesse teste.");

		}
	}

	@Test
	public void testAdicionaPlaylist() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testRemoveMusicaPlaylistStringString() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testRemoveMusicaPlaylistStringMusica() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testPesquisaMusicaPlaylistStringString() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testPesquisaMusicaPlaylistStringMusica() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetDuracaoPlaylist() {
		fail("Not yet implemented"); // TODO
	}

}
