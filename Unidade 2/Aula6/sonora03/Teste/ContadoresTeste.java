package Teste;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import src.Usuario;
import src.Musica;

public class ContadoresTeste {
    public Usuario u1;
    public Usuario u2;
    public Usuario u3;

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

}
