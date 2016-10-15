/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uach.videoClub.dao.jdbc;

import java.text.ParseException;
import java.util.List;
import mx.uach.videoclub.dao.enums.CRUD;
import mx.uach.videoclub.dao.VideoDao;
import mx.uach.videoclub.dao.jdbc.VideoDaoJDBC;
import mx.uach.videoclub.modelos.Director;
import mx.uach.videoclub.modelos.Pelicula;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Test;

/**
 * Clase de pruebas unitarias
 * @author Edgar Omar Peinado Garcia
 * @version 1.0
 */
public class DaoJdbcJUnitTestPelicula {
    
    @Test
    public void makePelicula() throws ParseException{        
        
        Director director = new Director(1);
        Director director2 = new Director(2);
        
        VideoDao dao = new VideoDaoJDBC();
        
        dao.peliculaProcess(new Pelicula("Titanic", "Romance", 120, director), CRUD.CREATE);
        dao.peliculaProcess(new Pelicula("Melancholia", "Drama", 120, director2), CRUD.CREATE);           
    }    
        
    @Test
    public void peliculaByIdTest(){
        VideoDao dao = new VideoDaoJDBC();
        
        // Id = 1 Titanic
        Pelicula p = dao.getPeliculaById(1);
        
        assertNotNull(p);
        assertEquals(p.getTitulo(), "Titanic");
        
        assertNotEquals(p.getTitulo(), "Melancholia");
        
        //Id = 2 Melancholia
        Pelicula p2 = dao.getPeliculaById(2);
        
        assertNotNull(p2);
        assertEquals(p2.getTitulo(), "Melancholia");
        
        assertNotEquals(p2.getTitulo(), "Titanic");
        
        List<Pelicula> peliculas = dao.getPeliculasByCriteria("");
        assertEquals(2, peliculas.size());
    }
    
    @Test
    public void updatePelicula(){
        VideoDao dao = new VideoDaoJDBC();
       
        Pelicula p = dao.getPeliculaById(2);
        assertNotNull(p);
        
        p.setTitulo("El Conjuro");
        dao.peliculaProcess(p, CRUD.UPDATE);
        
        p = dao.getPeliculaById(2);
        assertNotNull(p);
        assertEquals(p.getTitulo(), "El Conjuro");
    }
    
    @Test
    public void deletePelicula(){
        VideoDao dao = new VideoDaoJDBC();
       
        Pelicula p = dao.getPeliculaById(2);
        assertNotNull(p);
        
       
        dao.peliculaProcess(p, CRUD.DELETE);
        
        p = dao.getPeliculaById(2);
        assertNull(p);
    }    
}
