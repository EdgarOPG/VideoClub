/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uach.videoClub.dao.jdbc;

import java.util.List;
import mx.uach.videoclub.dao.enums.CRUD;
import mx.uach.videoclub.dao.VideoDao;
import mx.uach.videoclub.dao.jdbc.VideoDaoJDBC;
import mx.uach.videoclub.modelos.Director;
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
public class DaoJdbcJUnitTestDirector {
    
    @Test
    public void makeDirectors(){
        VideoDao dao = new VideoDaoJDBC();

        dao.directorProcess(new Director("Tim Burton"), CRUD.CREATE);
        dao.directorProcess(new Director("Alfonso Cuaron"), CRUD.CREATE);
        
    }
        
    @Test
    public void directorByIdTest(){
        VideoDao dao = new VideoDaoJDBC();
        
        // Id = 1 Tim Burton
        Director d = dao.getDirectorById(1);
        
        assertNotNull(d);
        assertEquals(d.getNombre(), "Tim Burton");
        
        assertNotEquals(d.getNombre(), "Alfonso Cuaron");
        
        //Id = 2 Alfonso Cuaron
        Director d2 = dao.getDirectorById(2);
        
        assertNotNull(d2);
        assertEquals(d2.getNombre(), "Alfonso Cuaron");
        
        assertNotEquals(d2.getNombre(), "Tim Burton");
        
        List<Director> directores = dao.getDirectoresByCriteria("");
        assertEquals(2, directores.size());
    }
    
    @Test
    public void updateDirector(){
        VideoDao dao = new VideoDaoJDBC();
       
        Director d = dao.getDirectorById(2);
        assertNotNull(d);
        
        d.setNombre("David Yates");
        dao.directorProcess(d, CRUD.UPDATE);
        
        d = dao.getDirectorById(2);
        assertNotNull(d);
        assertEquals(d.getNombre(), "David Yates");
    }
    
    @Test
    public void deleteDirector(){
        VideoDao dao = new VideoDaoJDBC();
       
        Director d = dao.getDirectorById(2);
        assertNotNull(d);
        
       
        dao.directorProcess(d, CRUD.DELETE);
        
        d = dao.getDirectorById(2);
        assertNull(d);
    }
}
