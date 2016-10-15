/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uach.videoClub.dao.jdbc;

import mx.uach.videoclub.dao.enums.CRUD;
import mx.uach.videoclub.dao.VideoDao;
import mx.uach.videoclub.dao.jdbc.VideoDaoJDBC;
import mx.uach.videoclub.modelos.Socio;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Test;

/**
 * Clase de pruebas unitarias
 * @author Edgar Omar Peinado Garcia
 * @version 1.0
 */
public class DaoJdbcJUnitTestSocio {
    
//    @Test
//    public void makeSocio(){
//        VideoDao dao = new VideoDaoJDBC();
//        dao.socioProcess(new Socio(2 ,"Edgar", "Chihuahua", "31656"), CRUD.CREATE); 
//        dao.socioProcess(new Socio(2 ,"Erik", "Chihuahua", "612323"), CRUD.CREATE);         
//    }
    
//    @Test
//    public void socioByIdTest(){
//        VideoDao dao = new VideoDaoJDBC();
//        
//        // Id = 1 Edgar
//        Socio s = dao.getSocioById(1);
//        
//        assertNotNull(s);
//        assertEquals(s.getNombre(), "Edgar");
//        
//        assertNotEquals(s.getNombre(), "Erik");
//        
//        //Id = 2 Erik
//        Socio s2 = dao.getSocioById(2);
//        
//        assertNotNull(s2);
//        assertEquals(s2.getNombre(), "Erik");
//        
//        assertNotEquals(s2.getNombre(), "Edgar");
//        
//        List<Socio> directores = dao.getSociosByCriteria("");
//        assertEquals(2, directores.size());
//    }
    
//    @Test
//    public void updateSocio(){
//        VideoDao dao = new VideoDaoJDBC();
//       
//        Socio s = dao.getSocioById(2);
//        assertNotNull(s);
//        
//        s.setNombre("Daniela");
//        dao.socioProcess(s, CRUD.UPDATE);
//        
//        s = dao.getSocioById(2);
//        assertNotNull(s);
//        assertEquals(s.getNombre(), "Daniela");
//    }
//    
    @Test
    public void deleteSocio(){
        VideoDao dao = new VideoDaoJDBC();
       
        Socio s = dao.getSocioById(2);
        assertNotNull(s);
        
       
        dao.socioProcess(s, CRUD.DELETE);
        
        s = dao.getSocioById(2);
        assertNull(s);
    }
}
