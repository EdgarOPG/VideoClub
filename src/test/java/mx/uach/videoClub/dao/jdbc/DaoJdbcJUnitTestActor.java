/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uach.videoClub.dao.jdbc;

import java.util.List;
import mx.uach.videoclub.dao.VideoDao;
import mx.uach.videoclub.dao.enums.CRUD;
import mx.uach.videoclub.dao.jdbc.VideoDaoJDBC;
import mx.uach.videoclub.modelos.Actor;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Test;

/**
 *
 * @author edgar
 */
public class DaoJdbcJUnitTestActor {
    
    @Test
    public void makeActor(){
        VideoDao dao = new VideoDaoJDBC();
        dao.actorProcess(new Actor("Jim", "Carrey"), CRUD.CREATE); 
        dao.actorProcess(new Actor("Leonardo", "DiCaprio"), CRUD.CREATE); 
    }
    
    @Test
    public void actorByIdTest(){
        VideoDao dao = new VideoDaoJDBC();
        
        // Id = 1 Jim 
        Actor a = dao.getActorById(1);
        
        assertNotNull(a);
        assertEquals(a.getNombre(), "Jim");
        
        assertNotEquals(a.getNombre(), "Leonardo");
        
        //Id = 2 Leonardo
        Actor a2 = dao.getActorById(2);
        
        assertNotNull(a2);
        assertEquals(a2.getNombre(), "Leonardo");
        
        assertNotEquals(a2.getNombre(), "Jim");
        
        List<Actor> actores = dao.getActoresByCriteria("");
        assertEquals(2, actores.size());
    }
    
    @Test
    public void updateActor(){
        VideoDao dao = new VideoDaoJDBC();
       
        Actor a = dao.getActorById(2);
        assertNotNull(a);
        
        a.setNombre("Will");
        dao.actorProcess(a, CRUD.UPDATE);
        
        a = dao.getActorById(2);
        assertNotNull(a);
        assertEquals(a.getNombre(), "Will");
    }
    
    @Test
    public void deleteActor(){
        VideoDao dao = new VideoDaoJDBC();
       
        Actor a = dao.getActorById(2);
        assertNotNull(a);
        
       
        dao.actorProcess(a, CRUD.DELETE);
        
        a = dao.getActorById(2);
        assertNull(a);
    }
}
