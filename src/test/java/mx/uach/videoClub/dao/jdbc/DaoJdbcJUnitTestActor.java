/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uach.videoClub.dao.jdbc;

import java.sql.Date;
import java.text.ParseException;
import mx.uach.videoclub.dao.VideoDao;
import mx.uach.videoclub.dao.enums.CRUD;
import mx.uach.videoclub.dao.jdbc.VideoDaoJDBC;
import mx.uach.videoclub.modelos.Actor;
import mx.uach.videoclub.modelos.Director;
import mx.uach.videoclub.modelos.Ficha;
import mx.uach.videoclub.modelos.Pelicula;
import mx.uach.videoclub.modelos.Socio;
import org.junit.Test;

/**
 *
 * @author edgar
 */
public class DaoJdbcJUnitTestActor {
    
    @Test
    public void makeActor(){
        VideoDao dao = new VideoDaoJDBC();
        dao.actorProccess(new Actor("Jim", "Carrie"), CRUD.CREATE); 
        dao.actorProccess(new Actor("Leonardo", "DiCaprio"), CRUD.CREATE); 
    }
    
    @Test
    public void makeSocio(){
        VideoDao dao = new VideoDaoJDBC();
        dao.socioProccess(new Socio(2 ,"Edgar", "Chihuahua", "31656"), CRUD.CREATE);        
    }

    @Test
    public void makeFicha() throws ParseException{
        
        String stringFecha = "2014-09-19";
        Date fecha = Date.valueOf(stringFecha);
        System.out.println(fecha);
        
        Socio socio = new Socio(1);
        
        VideoDao dao = new VideoDaoJDBC();
        dao.fichaProccess(new Ficha(socio, fecha), CRUD.CREATE);        
    }    
}
