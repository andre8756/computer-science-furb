package Teste;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import src.Usuario;
import src.Musica;

public class ContadoresTeste {

    // -------------------------------------------
    // ----------- Exercícios --------------------
    // --------------------------------------------

    // PL03 - Playlist.adicionar(música)

    //ATENÇÃO: RODAR OS MÉTODOS UM DE CADA VEZ

    @Test
    @DisplayName("Criar 3 músicas")
    public void testCriarMusicas() {
        Musica m1 = new Musica("Titulo", "Artista", 150);
        Musica m2 = new Musica("Bohemin", "Queen", 355);
        Musica m3 = new Musica("My Way", "Frank Sinatra", 256);

        assertEquals(1, m1.getId());
        assertEquals(2, m2.getId());
        assertEquals(3, m3.getId());
    }

    @Test
    @DisplayName("Criar 3 usuários")
    public void testCriarUsuarios() {
        Usuario u1 = new Usuario("Andre", "andre@teste");
        Usuario u2 = new Usuario("Camille", "camille@teste");
        Usuario u3 = new Usuario("Oscar", "oscar@teste");;

        assertEquals(1, u1.getId());
        assertEquals(2, u2.getId());
        assertEquals(3, u3.getId());
    }

    @Test
    @DisplayName("Criar 3 músicas e 3 usuários juntos")
    public void testCriarMusicasEUsuariosJuntos() {
        Musica m1 = new Musica("Titulo", "Artista", 150);
        Musica m2 = new Musica("Bohemin", "Queen", 355);
        Musica m3 = new Musica("My Way", "Frank Sinatra", 256);

        Usuario u1 = new Usuario("Andre", "andre@teste");
        Usuario u2 = new Usuario("Camille", "camille@teste");
        Usuario u3 = new Usuario("Oscar", "oscar@teste");;

        assertEquals(1, m1.getId());
        assertEquals(2, m2.getId());
        assertEquals(3, m3.getId());

        assertEquals(1, u1.getId());
        assertEquals(2, u2.getId());
        assertEquals(3, u3.getId());
    }

}
