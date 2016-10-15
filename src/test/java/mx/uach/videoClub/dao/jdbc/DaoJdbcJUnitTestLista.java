/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uach.videoClub.dao.jdbc;

import java.sql.Date;
import java.text.ParseException;
import java.util.List;
import mx.uach.videoclub.dao.VideoDao;
import mx.uach.videoclub.dao.enums.CRUD;
import mx.uach.videoclub.dao.jdbc.VideoDaoJDBC;
import mx.uach.videoclub.modelos.Lista;
import mx.uach.videoclub.modelos.Pelicula;
import mx.uach.videoclub.modelos.Socio;
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
public class DaoJdbcJUnitTestLista {
    
    public void makeLista() throws ParseException{
        
        String stringFecha = "2014-09-19";
        Date fecha = Date.valueOf(stringFecha);
        
        Socio socio = new Socio(1);
        Pelicula pelicula = new Pelicula(1);
        
               
        VideoDao dao = new VideoDaoJDBC();
        dao.listaProcess(new Lista(socio, fecha, "esperando", pelicula), CRUD.CREATE);        
    }
    
            
    @Test
    public void peliculaByIdTest(){
        VideoDao dao = new VideoDaoJDBC();
        
        // Id = 1 Titanic
        Lista l = dao.getListaById(1);
        
        assertNotNull(l);
        assertEquals(l.getEstatus(), "esperando");
        
        List<Lista> listas = dao.getListasByCriteria("");
        assertEquals(1, listas.size());
    }
    
    @Test
    public void updateLista(){
        VideoDao dao = new VideoDaoJDBC();
       
        Lista l = dao.getListaById(1);
        assertNotNull(l);
        
        l.setEstatus("completado");
        dao.listaProcess(l, CRUD.UPDATE);
        
        l = dao.getListaById(2);
        assertNotNull(l);
        assertEquals(l.getEstatus(), "completado");
    }
    
    @Test
    public void deletePelicula(){
        VideoDao dao = new VideoDaoJDBC();
       
        Lista l = dao.getListaById(1);
        assertNotNull(l);
        
       
        dao.listaProcess(l, CRUD.DELETE);
        
        l = dao.getListaById(2);
        assertNull(l);
    }    
}
