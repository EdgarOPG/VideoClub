/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uach.videoClub.dao.jdbc;

import java.text.ParseException;
import java.sql.Date;
import mx.uach.videoclub.dao.enums.CRUD;
import mx.uach.videoclub.dao.VideoDao;
import mx.uach.videoclub.dao.jdbc.VideoDaoJDBC;
import mx.uach.videoclub.modelos.Actor;
import mx.uach.videoclub.modelos.Director;
import mx.uach.videoclub.modelos.Ficha;
import mx.uach.videoclub.modelos.Pelicula;
import mx.uach.videoclub.modelos.Socio;
import org.junit.Test;

/**
 * Clase de pruebas unitarias
 * @author Edgar Omar Peinado Garcia
 * @version 1.0
 */
public class DaoJdbcJUnitTest {
        
//    @Test
//    public void directorByIdTest(){
//        VideoDao dao = new VideoDaoJDBC();
//        
//        // Id = 1 James Cameron
//        Director d = dao.getDirectorById(1);
//        
//        assertNotNull(d);
//        assertEquals(d.getNombre(), "James Cameron");
//        
//        assertNotEquals(d.getNombre(), "Alfonso Cuaron");
//        
//        //Id = 2 Alfonso Cuaron
//        Director d2 = dao.getDirectorById(2);
//        
//        assertNotNull(d2);
//        assertEquals(d2.getNombre(), "Alfonso Cuaron");
//        
//        assertNotEquals(d2.getNombre(), "James Cameron");
//        
////        List<Director> directores = dao.getDirectoresByCriteria("");
//        //assertEquals(3, directores.size());
//        
//    }
    
//    @Test
//    public void makeActor(){
//        VideoDao dao = new VideoDaoJDBC();
//        dao.actorProccess(new Actor("Jim", "Carrie"), CRUD.CREATE);        
//    }
    
//    @Test
//    public void makeFicha() throws ParseException{
//        
//        String stringFecha = "2014-09-19";
//        Date fecha = Date.valueOf(stringFecha);
//        System.out.println(fecha);
//        
//        Socio socio = new Socio(1);
//        
//        VideoDao dao = new VideoDaoJDBC();
//        dao.fichaProccess(new Ficha(socio, fecha), CRUD.CREATE);        
//    }
    
    @Test
    public void makePelicula() throws ParseException{        
        Director director = new Director(1);
        VideoDao dao = new VideoDaoJDBC();
        dao.peliculaProccess(new Pelicula("Titanic", "Romance", 120, director), CRUD.CREATE);        
    }
//    
//    @Test
//    public void makeSocio(){
//        VideoDao dao = new VideoDaoJDBC();
//        dao.socioProccess(new Socio(2 ,"Edgar", "Chihuahua", "31656"), CRUD.CREATE);        
//    }
   
//    @Test
//    public void makeDirector(){
//        VideoDao dao = new VideoDaoJDBC();
//        dao.directorProcess(new Director("Tim Burton"), CRUD.CREATE);
//        
//        Director d = dao.getDirectorById(3);
//        assertNotNull(d);
//        assertEquals(d.getNombre(), "Tim Burton");
//    }
    
    
//    @Test
//    public void updateDirector(){
//        VideoDao dao = new VideoDaoJDBC();
//       
//        Director d = dao.getDirectorById(3);
//        assertNotNull(d);
//        
//        d.setNombre("David Yates");
//        dao.directorProcess(d, CRUD.UPDATE);
//        
//        d = dao.getDirectorById(3);
//        assertNotNull(d);
//        assertEquals(d.getNombre(), "David Yates");
//
//
//    }
//    
//    
//    @Test
//    public void deleteDirector(){
//        VideoDao dao = new VideoDaoJDBC();
//       
//        Director d = dao.getDirectorById(6);
//        assertNotNull(d);
//        
//       
//        dao.directorProcess(d, CRUD.DELETE);
//        
//        d = dao.getDirectorById(6);
//        assertNull(d);
//        
//    }

}
