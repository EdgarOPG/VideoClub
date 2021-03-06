/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uach.videoclub.dao.jdbc.helpers;

import java.sql.ResultSet;
import java.sql.SQLException;
import mx.uach.videoclub.dao.jdbc.VideoDaoJDBC;
import mx.uach.videoclub.modelos.Actor;
import mx.uach.videoclub.modelos.Cinta;
import mx.uach.videoclub.modelos.Director;
import mx.uach.videoclub.modelos.Ficha;
import mx.uach.videoclub.modelos.Lista;
import mx.uach.videoclub.modelos.Pelicula;
import mx.uach.videoclub.modelos.Prestamo;
import mx.uach.videoclub.modelos.Socio;

/**
 *
 * @author edgar
 */
public class VideoDaoJdbcHelper {

    public final static Director makeDirector(ResultSet rs) throws SQLException {
        Director obj = new Director(rs.getInt(Director.FIELDS[0]),
                rs.getString(Director.FIELDS[1]));
        return obj;
    }

    public final static Actor makeActor(ResultSet rs) throws SQLException {
        Actor obj = new Actor(rs.getInt(Actor.FIELDS[0]),
                rs.getString(Actor.FIELDS[1]),rs.getString(Actor.FIELDS[2]));
        return obj;
    }
    
    public final static Ficha makeFicha(ResultSet rs) throws SQLException {
        VideoDaoJDBC dao = new VideoDaoJDBC();
        Ficha obj = new Ficha(rs.getInt(Ficha.FIELDS[0]),
                dao.getSocioById(rs.getInt(Ficha.FIELDS[1])), 
                rs.getDate(Ficha.FIELDS[2]));
        return obj;
    }
    
    public final static Socio makeSocio(ResultSet rs) throws SQLException {
       Socio obj = new Socio(rs.getInt(Socio.FIELDS[0]),
               rs.getString(Socio.FIELDS[1]), rs.getString(Socio.FIELDS[2]),
               rs.getString(Socio.FIELDS[3]));
        return obj;
    }
    
    public final static Pelicula makePelicula(ResultSet rs) throws SQLException {
        VideoDaoJDBC dao = new VideoDaoJDBC();
        Pelicula obj = new Pelicula(rs.getInt(Pelicula.FIELDS[0]),
                rs.getString(Pelicula.FIELDS[1]), rs.getString(Pelicula.FIELDS[2]),
                rs.getInt(Pelicula.FIELDS[3]), 
                dao.getDirectorById(rs.getInt(Pelicula.FIELDS[4])));
        return obj;
    }
    
    public final static Cinta makeCinta(ResultSet rs) throws SQLException {
        VideoDaoJDBC dao = new VideoDaoJDBC();
        Cinta obj = new Cinta(rs.getInt(Cinta.FIELDS[0]),
                dao.getPeliculaById(rs.getInt(Cinta.FIELDS[1])),
                rs.getInt(Cinta.FIELDS[2]));
        return obj;
    }
    
    public final static Prestamo makePrestamo(ResultSet rs) throws SQLException {
        VideoDaoJDBC dao = new VideoDaoJDBC();
        Prestamo obj = new Prestamo(rs.getInt(Prestamo.FIELDS[0]),
                dao.getFichaById(rs.getInt(Prestamo.FIELDS[1])), 
                dao.getCintaById(rs.getInt(Prestamo.FIELDS[2])), 
                rs.getDate(Prestamo.FIELDS[3]), rs.getString(Prestamo.FIELDS[4]));
        return obj;
    }
    
    public final static Lista makeLista(ResultSet rs) throws SQLException {
        VideoDaoJDBC dao = new VideoDaoJDBC();
        Lista obj = new Lista(rs.getInt(Lista.FIELDS[0]),
                dao.getSocioById(rs.getInt(Lista.FIELDS[1])),
                rs.getDate(Lista.FIELDS[2]), rs.getString(Lista.FIELDS[3]), 
                dao.getPeliculaById(rs.getInt(Lista.FIELDS[4])));
        return obj;
    }
}
