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
import mx.uach.videoclub.modelos.Cinta;
import mx.uach.videoclub.modelos.Ficha;
import mx.uach.videoclub.modelos.Prestamo;
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
public class DaoJdbcJUnitTestPrestamo {
    
    @Test
    public void makePrestamo() throws ParseException{        
        Ficha ficha = new Ficha(1);  
        Ficha ficha2 = new Ficha(2);  
        
        String stringFecha = "2014-09-19";
        Date fecha = Date.valueOf(stringFecha);
        
        String stringFecha2 = "2016-04-15";
        Date fecha2 = Date.valueOf(stringFecha2);
        
                        
        Cinta cinta = new Cinta(1);
        
        Cinta cinta2 = new Cinta(2);
       
        VideoDao dao = new VideoDaoJDBC();
        
        dao.prestamoProcess(new Prestamo(ficha, cinta, fecha, "prestada"), CRUD.CREATE); 
                               
        dao.prestamoProcess(new Prestamo(ficha2, cinta2, fecha2, "prestada"), CRUD.CREATE); 
    }
    
    @Test
    public void prestamoByIdTest(){
        VideoDao dao = new VideoDaoJDBC();
        
        // Id = 1
        Prestamo p = dao.getPrestamoById(1);
        
        assertNotNull(p);
        assertEquals(p.getFicha(), 1);
        
        assertNotEquals(p.getFicha(), 2);
        
        //Id = 2
        Prestamo p2 = dao.getPrestamoById(2);
        
        assertNotNull(p2);
        assertEquals(p2.getFicha(), 2);
        
        assertNotEquals(p2.getFicha(), 1);
        
        List<Prestamo> prestamos = dao.getPrestamosByCriteria("");
        assertEquals(2, prestamos.size());
    }
    
    @Test
    public void updatePrestamo(){
        VideoDao dao = new VideoDaoJDBC();
       
        Prestamo p = dao.getPrestamoById(2);
        assertNotNull(p);
        
        p.setEstatus("Entregado");
        dao.prestamoProcess(p, CRUD.UPDATE);
        
        p = dao.getPrestamoById(2);
        assertNotNull(p);
        assertEquals(p.getEstatus(), "Entregado");
    }
    
    @Test
    public void deletePrestamo(){
        VideoDao dao = new VideoDaoJDBC();
       
        Prestamo p = dao.getPrestamoById(2);
        assertNotNull(p);
        
       
        dao.prestamoProcess(p, CRUD.DELETE);
        
        p = dao.getPrestamoById(2);
        assertNull(p);
    }
    
}
