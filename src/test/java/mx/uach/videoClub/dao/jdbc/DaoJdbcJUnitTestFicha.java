/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uach.videoClub.dao.jdbc;

import java.sql.Date;
import java.text.ParseException;
import mx.uach.videoclub.dao.enums.CRUD;
import mx.uach.videoclub.dao.VideoDao;
import mx.uach.videoclub.dao.jdbc.VideoDaoJDBC;
import mx.uach.videoclub.modelos.Ficha;
import mx.uach.videoclub.modelos.Socio;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Test;

/**
 * Clase de pruebas unitarias
 * @author Edgar Omar Peinado Garcia
 * @version 1.0
 */
public class DaoJdbcJUnitTestFicha {
        @Test
    public void makeFicha() throws ParseException{
        
        String stringFecha = "2014-09-19";
        Date fecha = Date.valueOf(stringFecha);
        
        Socio socio = new Socio(1);
        
        VideoDao dao = new VideoDaoJDBC();
        dao.fichaProcess(new Ficha(socio, fecha), CRUD.CREATE);        
    }
    
    @Test
    public void deleteFicha(){
        VideoDao dao = new VideoDaoJDBC();
       
        Ficha f = dao.getFichaById(2);
        assertNotNull(f);
        
       
        dao.fichaProcess(f, CRUD.DELETE);
        
        f = dao.getFichaById(2);
        assertNull(f);
    }
}
