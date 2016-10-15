/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uach.videoClub.dao.jdbc;

import java.text.ParseException;
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
        
        dao.peliculaProccess(new Pelicula("Titanic", "Romance", 120, director), CRUD.CREATE);
        dao.peliculaProccess(new Pelicula("Melancholia", "Drama", 120, director2), CRUD.CREATE);           
    }
}
