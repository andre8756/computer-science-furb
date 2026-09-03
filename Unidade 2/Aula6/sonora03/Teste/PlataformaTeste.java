package Teste;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import src.Plataforma;
import src.Musica;

public class PlataformaTeste {

    public Plataforma plataforma;
    public Musica m1;
    public Musica m2;
    public Musica m3;

    @BeforeEach
    public void inicializarPlataforma(){
        plataforma = new Plataforma();
        
        m1 = new Musica("Titulo", "Artista", 150);
        m2 = new Musica("Bohemin", "Queen", 355);
        m3 = new Musica("My Way", "Frank Sinatra", 256);

        plataforma.cadastrarMusica(m1);
        plataforma.cadastrarMusica(m2);
        plataforma.cadastrarMusica(m3);
    }

    // -------------------------------------------
    // ----------- Exercícios --------------------
    // --------------------------------------------

    // PL06 - Plataforma: buscarMusica(título) e buscarMusicaPorId(id)

    @Test
    @DisplayName("Buscar uma música válida por título")
    public void testBuscarMusicaValida(){
        assertEquals(m2, plataforma.buscarMusica("Bohemin"));
    }

    @Test
    @DisplayName("Buscar uma música válida por id")
    public void testBuscarMusicaPorIdValida(){
        assertEquals(m2, plataforma.buscarMusicaPorId(2));
    }

    @Test
    @DisplayName("Buscar música por título inexistente")
    public void testBuscarMusicaInexistente(){
        assertNull(plataforma.buscarMusica("asdf"));
    }

    @Test
    @DisplayName("Buscar música por id inexistente")
    public void testBuscarMusicaPorIdInexistente(){
        assertNull(plataforma.buscarMusicaPorId(4));
    }

    @Test
    @DisplayName("Buscar música por id negativo")
    public void testBuscarMusicaPorIdNegativo(){
        assertThrows(IndexOutOfBoundsException.class, () -> {
            plataforma.buscarMusicaPorId(-1);
        });
    }

    @Test
    @DisplayName("Buscar música por id além da quantidade de espaço da plataforma")
    public void testBuscarMusicaPorIdMaiorEspaco(){
        assertThrows(IndexOutOfBoundsException.class, () -> {
            plataforma.buscarMusicaPorId(501);
        });
    }

}
