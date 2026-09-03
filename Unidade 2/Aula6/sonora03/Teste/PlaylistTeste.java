package Teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import src.Playlist;
import src.Musica;
import src.Usuario;

public class PlaylistTeste {

    public static Playlist playlist;
    public static Usuario dono;
    public static Musica m1;
    public static Musica m2;

    @BeforeAll
    public static void inicializarPlaylist() {
        Usuario usuario = new Usuario("Andre", "andre@teste.com");

        playlist = new Playlist("Playlist1", usuario);

        m1 = new Musica("Titulo", "Artista", 150);
        m2 = new Musica("Bohemin", "Queen", 355);

        playlist.adicionar(m1);
        playlist.adicionar(m2);
    }

    // -------------------------------------------
    // ----------- Exercícios --------------------
    // --------------------------------------------

    // PL03 - Playlist.adicionar(música)

    @Test
    @DisplayName("Adicionar Música Válida com espaço na playlist")
    public void adicionarMusicaValidaEPlaylistComEspaco() {
        Musica m = new Musica("Wave", "Tom Jobim", 355);

        assertTrue(playlist.adicionar(m));
    }

    @Test
    @DisplayName("Adicionar Musica Null com espaço na playlist")
    public void adicionarMusicaNullEPlaylistComEspaco() {
        Musica m = null;

        assertFalse(playlist.adicionar(m));
    }

    @Test
    @DisplayName("Adicionar Música Válida sem espaço na playlist")
    public void adicionarMusicaValidaEPlaylistCheia() {
        Usuario usuario = new Usuario("Andre", "andre@teste.com");

        playlist = new Playlist("Playlist1", usuario);

        Musica m = new Musica("Wave", "Tom Jobim", 355);
        for (int i = 0; i < (playlist.getQuantidadeMax()); i++) {
            playlist.adicionar(m);
        }

        assertFalse(playlist.adicionar(m));
    }

    @Test
    @DisplayName("Adicionar Música null sem espaço na playlist")
    public void adicionarMusicaNullEPlaylistCheia() {
        Usuario usuario = new Usuario("Andre", "andre@teste.com");

        playlist = new Playlist("Playlist1", usuario);

        Musica m = new Musica("Wave", "Tom Jobim", 355);
        for (int i = 0; i < (playlist.getQuantidadeMax()); i++) {
            playlist.adicionar(m);
        }

        Musica outraMusica = null;

        assertFalse(playlist.adicionar(outraMusica));
    }

    // ---------------------------------------
    // PL04 - Playlist.getNaPosicao(indice)
    // ---------------------------------------

    @Test
    @DisplayName("getNaPosicao primeira posicao")
    public void testGetNaPosicaoPrimeiraPosicao() {
        assertEquals(m1, playlist.getNaPosicao(1));
    }

    @Test
    @DisplayName("getNaPosicao no meio da playlist")
    public void testGetPosicaoMeio() {
        Usuario usuario = new Usuario("Andre", "andre@teste.com");

        playlist = new Playlist("Playlist1", usuario);

        Musica m = new Musica("Wave", "Tom Jobim", 355);
        for (int i = 0; i < (playlist.getQuantidadeMax()); i++) {
            playlist.adicionar(m);
        }

        assertEquals(m, playlist.getNaPosicao(50));
    }

    @Test
    @DisplayName("getNaPosicao no final da playlist")
    public void testGetPosicaoFinal() {
        Usuario usuario = new Usuario("Andre", "andre@teste.com");

        playlist = new Playlist("Playlist1", usuario);

        Musica m = new Musica("Wave", "Tom Jobim", 355);
        for (int i = 0; i < (playlist.getQuantidadeMax()); i++) {
            playlist.adicionar(m);
        }

        assertEquals(m, playlist.getNaPosicao(100));
    }

    @Test
    @DisplayName("getNaPosicao com indice negativo")
    public void testGetNaPosicaoIndiceNegativo() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            playlist.getNaPosicao(-1);
        });
    }

    @Test
    @DisplayName("getNaPosicao com indice além da quantidade de espaço")
    public void testGetNaPosicaoIndiceMaiorQueEspaco() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            playlist.getNaPosicao(101);
        });
    }

    @Test
    @DisplayName("getNaPosicao com indice zero")
    public void testGetNaPosicaoIndiceZero() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            playlist.getNaPosicao(0);
        });
    }

    // ---------------------------------------
    // PL05 - Playlist.removerNaPosicao(indice)
    // ---------------------------------------
}
