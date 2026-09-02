
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class MusicaTeste {

    private static Musica musica;

    // ------------ Exemplos passados em aula

    @BeforeAll
    public static void inicializarMusica() {
        musica = new Musica("Titulo", "Artista", 120);
    }

    @Test
    public void testCriacaoMusica() {
        assertNotNull(musica);
    }

    @Test
    public void testTituloInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            Musica mus = new Musica("", "Artista", 120);
        });
    }

    @Test
    public void testDuracaoValida() {
        assertEquals(120, musica.getDuracaoSegundos());
    }

    @Test
    public void testDuracaoInvalida() {
        assertThrows(IllegalArgumentException.class, () -> {
            Musica mus = new Musica("Titulo", "Artista", -150);
        });
    }

    // -------------------------------------------
    // ----------- Exercícios --------------------
    // --------------------------------------------

    // PL01 - Musica.getDuracaoFormatada()

    @Test
    public void testDuracaoFormatada125Seg() {
        Musica musica = new Musica("Titulo", "Artista", 125);
        assertEquals("02:05", musica.getDuracaoFormatada());
    }

    @Test
    public void testDuracaoFormatada90Seg() {
        Musica musica = new Musica("Titulo", "Artista", 90);
        assertEquals("01:30", musica.getDuracaoFormatada());
    }

    @Test
    public void testDuracaoFormatada5Seg() {
        Musica musica = new Musica("Titulo", "Artista", 5);
        assertEquals("00:05", musica.getDuracaoFormatada());
    }

    @Test
    public void testDuracaoFormatada600Seg(){
        Musica musica = new Musica("Titulo", "Artista", 600);
        assertEquals("10:00", musica.getDuracaoFormatada());
    }

    @Test
    public void testDuracaoFormatada(){
        Musica musica = new Musica("Titulo", "Artista", 599);
        assertEquals("09:59", musica.getDuracaoFormatada());
    }


}
