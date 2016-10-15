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
import mx.uach.videoclub.modelos.Cinta;
import mx.uach.videoclub.modelos.Pelicula;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Test;

/**
 * Clase de pruebas unitarias
 * @author Edgar Omar Peinado Garcia
 * @version 1.0
 */
public class DaoJdbcJUnitTestCinta {
    
    @Test
    public void makeCinta() throws ParseException{        
        
        Cinta cinta = new Cinta(1);
        Cinta cinta2 = new Cinta(2);
        
        Pelicula pelicula = new Pelicula(1);
        VideoDao dao = new VideoDaoJDBC();
        
        dao.cintaProcess(new Cinta(pelicula, 1), CRUD.CREATE);     
    }
    
    @Test
    public void deleteCinta(){
        VideoDao dao = new VideoDaoJDBC();
       
        Cinta c = dao.getCintaById(2);
        assertNotNull(c);
        
       
        dao.cintaProcess(c, CRUD.DELETE);
        
        c = dao.getCintaById(2);
        assertNull(c);
    }
    
}
