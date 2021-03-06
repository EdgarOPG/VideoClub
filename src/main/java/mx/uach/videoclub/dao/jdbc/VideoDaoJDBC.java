/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uach.videoclub.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mx.uach.videoclub.conexiones.Conexion;
import mx.uach.videoclub.dao.VideoDao;
import mx.uach.videoclub.dao.enums.CRUD;
import mx.uach.videoclub.dao.jdbc.helpers.VideoDaoJdbcHelper;
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
 * @author luis
 */
public class VideoDaoJDBC implements VideoDao {

    public VideoDaoJDBC() {
    }
 
//  Interface de la clase Director
    @Override
    public Director getDirectorById(Integer id) {
        try {
            Statement st = Conexion.getInstance().getCon().createStatement();
            ResultSet rs = st.executeQuery(String.format("%s %s %s ", Director.Q,
                    Director.Q_WHRE_ID, id));
            Director obj = null;
            while (rs.next()) {
                obj = VideoDaoJdbcHelper.makeDirector(rs);
            }
            return obj;
        } catch (SQLException ex) {

        }
        return null;
    }

    @Override
    public List<Director> getDirectoresByCriteria(String criterio) {
        List<Director> objects = new ArrayList<>();
        try {
            Statement st = Conexion.getInstance().getCon().createStatement();
            ResultSet rs = st.executeQuery(String.format("%s %s %s ", Director.Q,
                    criterio.isEmpty() ? "" : Director.Q_WHERE, criterio));
            Director obj = null;
            while (rs.next()) {
                obj = VideoDaoJdbcHelper.makeDirector(rs);
                objects.add(obj);
            }

        } catch (SQLException ex) {

        }
        return objects;
    }
    
    public void directorProcess(Director director, CRUD crud) {
        try {
            PreparedStatement ps = null;
            switch (crud) {
                case CREATE:
                    ps = Conexion.getInstance().
                    getCon().prepareStatement(Director.INSERT_DIRECTOR);
                    ps.setString(1, director.getNombre());
                    break;
                case UPDATE:
                    //UPDATE TABLA SET()
                    ps = Conexion.getInstance().
                    getCon().prepareStatement(Director.UPDATE_DIRECTOR);
                    ps.setString(1, director.getNombre());
                    ps.setInt(2, director.getId());
                    break;
                case DELETE:
                    ps = Conexion.getInstance().
                    getCon().prepareStatement(Director.DELETE_DIRECTOR);
                    ps.setInt(1, director.getId());
                    break;
                default:
                    break;
            }
            
            Boolean result = ps.execute();            
            
        } catch (SQLException ex) {
            System.out.println( ex.getMessage());
        }
    }
    
//  Interface de la clase Actor
    @Override
    public Actor getActorById(Integer id) {
        try {
            Statement st = Conexion.getInstance().getCon().createStatement();
            ResultSet rs = st.executeQuery(String.format("%s %s %s ", Director.Q,
                    Director.Q_WHRE_ID, id));
            Actor obj = null;
            while (rs.next()) {
                obj = VideoDaoJdbcHelper.makeActor(rs);
            }
            return obj;
        } catch (SQLException ex) {

        }
        return null;
    }
   
    @Override
    public List<Actor> getActoresByCriteria(String criterio) {
                List<Actor> objects = new ArrayList<>();
        try {
            Statement st = Conexion.getInstance().getCon().createStatement();
            ResultSet rs = st.executeQuery(String.format("%s %s %s ", Actor.Q,
                    criterio.isEmpty() ? "" : Actor.Q_WHERE, criterio));
            Actor obj = null;
            while (rs.next()) {
                obj = VideoDaoJdbcHelper.makeActor(rs);
                objects.add(obj);
            }

        } catch (SQLException ex) {

        }
        return objects;
    }
    

    @Override
    public void actorProcess(Actor actor, CRUD crud) {
        try {
            PreparedStatement ps = null;
            switch (crud) {
                case CREATE:
                    ps = Conexion.getInstance().
                    getCon().prepareStatement(Actor.INSERT_ACTOR);
                    ps.setString(1, actor.getNombre());
                    ps.setString(2, actor.getApellido());
                    System.out.println(ps);
                    break;
                case UPDATE:
                    //UPDATE TABLA SET()
                    ps = Conexion.getInstance().
                    getCon().prepareStatement(Actor.UPDATE_ACTOR);
                    System.out.println(ps);
                    ps.setString(1, actor.getNombre());
                    ps.setString(2, actor.getApellido());
                    ps.setInt(3, actor.getId());
                    break;
                case DELETE:
                    ps = Conexion.getInstance().
                    getCon().prepareStatement(Actor.DELETE_ACTOR);
                    ps.setInt(1, actor.getId());
                    break;
                default:
                    break;
            }
            
            Boolean result = ps.execute();            
            
        } catch (SQLException ex) {
            System.out.println( ex.getMessage());
        }
    }

//  Interface de la clase Ficha
    @Override
    public Ficha getFichaById(Integer id) {
        try {
            Statement st = Conexion.getInstance().getCon().createStatement();
            ResultSet rs = st.executeQuery(String.format("%s %s %s ", Ficha.Q,
                    Ficha.Q_WHRE_ID, id));
            Ficha obj = null;
            while (rs.next()) {
                obj = VideoDaoJdbcHelper.makeFicha(rs);
            }
            return obj;
        } catch (SQLException ex) {

        }
        return null;
    }
    
    @Override
    public List<Ficha> getFichasByCriteria(String criterio) {
                List<Ficha> objects = new ArrayList<>();
        try {
            Statement st = Conexion.getInstance().getCon().createStatement();
            ResultSet rs = st.executeQuery(String.format("%s %s %s ", Ficha.Q,
                    criterio.isEmpty() ? "" : Ficha.Q_WHERE, criterio));
            Ficha obj = null;
            while (rs.next()) {
                obj = VideoDaoJdbcHelper.makeFicha(rs);
                objects.add(obj);
            }

        } catch (SQLException ex) {

        }
        return objects;
    }
    
    @Override
    public void fichaProcess(Ficha ficha, CRUD crud) {
        try {
            PreparedStatement ps = null;
            switch (crud) {
                case CREATE:
                    ps = Conexion.getInstance().
                    getCon().prepareStatement(Ficha.INSERT_FICHA);
                    ps.setInt(1, ficha.getSocio().getId());
                    ps.setDate(2, ficha.getFechaPrestamo());
                    break;
                case UPDATE:
                    //UPDATE TABLA SET()
                    ps = Conexion.getInstance().
                    getCon().prepareStatement(Ficha.UPDATE_FICHA);
                    ps.setInt(1, ficha.getSocio().getId());
                    ps.setDate(2, ficha.getFechaPrestamo());
                    ps.setInt(3, ficha.getId());
                    break;
                case DELETE:
                    ps = Conexion.getInstance().
                    getCon().prepareStatement(Ficha.DELETE_FICHA);
                    ps.setInt(1, ficha.getId());
                    break;
                default:
                    break;
            }
            
            Boolean result = ps.execute();            
            
        } catch (SQLException ex) {
            System.out.println( ex.getMessage());
        }
    }

//  Interface de la clase Socio    
    @Override
    public Socio getSocioById(Integer id) {
        try {
            Statement st = Conexion.getInstance().getCon().createStatement();
            ResultSet rs = st.executeQuery(String.format("%s %s %s ", Socio.Q,
                    Socio.Q_WHRE_ID, id));
            Socio obj = null;
            while (rs.next()) {
                obj = VideoDaoJdbcHelper.makeSocio(rs);
            }
            return obj;
        } catch (SQLException ex) {

        }
        return null;
    }
    
    @Override
    public List<Socio> getSociosByCriteria(String criterio) {
                List<Socio> objects = new ArrayList<>();
        try {
            Statement st = Conexion.getInstance().getCon().createStatement();
            ResultSet rs = st.executeQuery(String.format("%s %s %s ", Socio.Q,
                    criterio.isEmpty() ? "" : Socio.Q_WHERE, criterio));
            Socio obj = null;
            while (rs.next()) {
                obj = VideoDaoJdbcHelper.makeSocio(rs);
                objects.add(obj);
            }

        } catch (SQLException ex) {

        }
        return objects;
    }
    
    @Override
    public void socioProcess(Socio socio, CRUD crud) {
        try {
            PreparedStatement ps = null;
            switch (crud) {
                case CREATE:
                    ps = Conexion.getInstance().
                    getCon().prepareStatement(Socio.INSERT_SOCIO);
                    System.out.println(ps);                    
                    ps.setString(1, socio.getNombre());
                     ps.setString(2, socio.getDireccion());
                     ps.setString(3, socio.getTelefono());
                     System.out.println(ps);
                    break;
                case UPDATE:
                    //UPDATE TABLA SET()
                    ps = Conexion.getInstance().
                    getCon().prepareStatement(Socio.UPDATE_SOCIO);
                    ps.setString(1, socio.getNombre());
                    ps.setString(2, socio.getDireccion());                    
                    ps.setString(3, socio.getTelefono());
                    ps.setInt(4, socio.getId());
                    System.out.println(ps);
                    break;
                case DELETE:
                    ps = Conexion.getInstance().
                    getCon().prepareStatement(Socio.DELETE_SOCIO);
                    ps.setInt(1, socio.getId());
                    System.out.println(ps);
                    break;
                default:
                    break;
            }
            
            Boolean result = ps.execute();            
            
        } catch (SQLException ex) {
            System.out.println( ex.getMessage());
        }
    }

//  Interface de la clase Pelicula
    @Override
    public Pelicula getPeliculaById(Integer id) {
        try {
            Statement st = Conexion.getInstance().getCon().createStatement();
            ResultSet rs = st.executeQuery(String.format("%s %s %s ", Pelicula.Q,
                    Pelicula.Q_WHRE_ID, id));
            Pelicula obj = null;
            while (rs.next()) {
                obj = VideoDaoJdbcHelper.makePelicula(rs);
            }
            return obj;
        } catch (SQLException ex) {

        }
        return null;
    }
    
    @Override
    public List<Pelicula> getPeliculasByCriteria(String criterio) {
                List<Pelicula> objects = new ArrayList<>();
        try {
            Statement st = Conexion.getInstance().getCon().createStatement();
            ResultSet rs = st.executeQuery(String.format("%s %s %s ", Pelicula.Q,
                    criterio.isEmpty() ? "" : Pelicula.Q_WHERE, criterio));
            Pelicula obj = null;
            while (rs.next()) {
                obj = VideoDaoJdbcHelper.makePelicula(rs);
                objects.add(obj);
            }

        } catch (SQLException ex) {

        }
        return objects;
    }
    
    @Override
    public void peliculaProcess(Pelicula pelicula, CRUD crud) {
        try {
            PreparedStatement ps = null;
            switch (crud) {
                case CREATE:
                    ps = Conexion.getInstance().
                    getCon().prepareStatement(Pelicula.INSERT_PELICULA);
                    ps.setString(1, pelicula.getTitulo());
                    ps.setString(2, pelicula.getGenero());
                    ps.setInt(3, pelicula.getDuracion());
                    ps.setInt(4, pelicula.getDirector().getId());
                    break;
                case UPDATE:
                    //UPDATE TABLA SET()
                    ps = Conexion.getInstance().
                    getCon().prepareStatement(Pelicula.UPDATE_PELICULA);
                    ps.setString(1, pelicula.getTitulo());
                    ps.setString(2, pelicula.getGenero());
                    ps.setInt(3, pelicula.getDuracion());
                    ps.setInt(4, pelicula.getDirector().getId());
                    ps.setInt(5, pelicula.getId());
                    break;
                case DELETE:
                    ps = Conexion.getInstance().
                    getCon().prepareStatement(Pelicula.DELETE_PELICULA);
                    ps.setInt(1, pelicula.getId());
                    break;
                default:
                    break;
            }
            System.out.println(ps);
            Boolean result = ps.execute();            
            
        } catch (SQLException ex) {
            System.out.println( ex.getMessage());
        }
    }

//  Interface de la clase Cinta
    @Override
    public Cinta getCintaById(Integer id) {
        try {
            Statement st = Conexion.getInstance().getCon().createStatement();
            ResultSet rs = st.executeQuery(String.format("%s %s %s ", Cinta.Q,
                    Cinta.Q_WHRE_ID, id));
            Cinta obj = null;
            while (rs.next()) {
                obj = VideoDaoJdbcHelper.makeCinta(rs);
            }
            return obj;
        } catch (SQLException ex) {

        }
        return null;
    }
    
    @Override
    public List<Cinta> getCintasByCriteria(String criterio) {
        List<Cinta> objects = new ArrayList<>();
        try {
            Statement st = Conexion.getInstance().getCon().createStatement();
            ResultSet rs = st.executeQuery(String.format("%s %s %s ", Cinta.Q,
                    criterio.isEmpty() ? "" : Cinta.Q_WHERE, criterio));
            Cinta obj = null;
            while (rs.next()) {
                obj = VideoDaoJdbcHelper.makeCinta(rs);
                objects.add(obj);
            }

        } catch (SQLException ex) {

        }
        return objects;
    }
    
    @Override
    public void cintaProcess(Cinta cinta, CRUD crud) {
        try {
            PreparedStatement ps = null;
            switch (crud) {
                case CREATE:
                    ps = Conexion.getInstance().
                    getCon().prepareStatement(Cinta.INSERT_CINTA);
                    ps.setInt(1, cinta.getPelicula().getId());
                    ps.setInt(2, cinta.getNumeroCopia());
                    break;
                case UPDATE:
                    //UPDATE TABLA SET()
                    ps = Conexion.getInstance().
                    getCon().prepareStatement(Cinta.UPDATE_CINTA);
                    ps.setInt(1, cinta.getPelicula().getId());
                    ps.setInt(2, cinta.getNumeroCopia());
                    ps.setInt(3, cinta.getId());
                    break;
                case DELETE:
                    ps = Conexion.getInstance().
                    getCon().prepareStatement(Cinta.DELETE_CINTA);
                    ps.setInt(1, cinta.getId());
                    break;
                default:
                    break;
            }
            System.out.println(ps);
            Boolean result = ps.execute();            
            
        } catch (SQLException ex) {
            System.out.println( ex.getMessage());
        }
    }
    
//  Interface de la clase Prestamo
    @Override
    public Prestamo getPrestamoById(Integer id) {
        try {
            Statement st = Conexion.getInstance().getCon().createStatement();
            ResultSet rs = st.executeQuery(String.format("%s %s %s ", Prestamo.Q,
                    Prestamo.Q_WHRE_ID, id));
            Prestamo obj = null;
            while (rs.next()) {
                obj = VideoDaoJdbcHelper.makePrestamo(rs);
            }
            return obj;
        } catch (SQLException ex) {

        }
        return null;
    }
    
    @Override
    public List<Prestamo> getPrestamosByCriteria(String criterio) {
        List<Prestamo> objects = new ArrayList<>();
        try {
            Statement st = Conexion.getInstance().getCon().createStatement();
            ResultSet rs = st.executeQuery(String.format("%s %s %s ", Prestamo.Q,
                    criterio.isEmpty() ? "" : Prestamo.Q_WHERE, criterio));
            Prestamo obj = null;
            while (rs.next()) {
                obj = VideoDaoJdbcHelper.makePrestamo(rs);
                objects.add(obj);
            }

        } catch (SQLException ex) {

        }
        return objects;
    }

    @Override
    public void prestamoProcess(Prestamo prestamo, CRUD crud) {
        try {
            PreparedStatement ps = null;
            switch (crud) {
                case CREATE:
                    ps = Conexion.getInstance().
                    getCon().prepareStatement(Prestamo.INSERT_PRESTAMO);
                    ps.setInt(1, prestamo.getFicha().getId());
                    ps.setInt(2, prestamo.getCinta().getId());
                    ps.setDate(3, prestamo.getFechaEntrega());
                    ps.setString(4, prestamo.getEstatus());
                    break;
                case UPDATE:
                    //UPDATE TABLA SET()
                    ps = Conexion.getInstance().
                    getCon().prepareStatement(Prestamo.UPDATE_PRESTAMO);
                    ps.setInt(1, prestamo.getFicha().getId());
                    ps.setInt(2, prestamo.getCinta().getId());
                    ps.setDate(3, prestamo.getFechaEntrega());
                    ps.setString(4, prestamo.getEstatus());
                    ps.setInt(5, prestamo.getId());
                    break;
                case DELETE:
                    ps = Conexion.getInstance().
                    getCon().prepareStatement(Prestamo.DELETE_PRESTAMO);
                    ps.setInt(1, prestamo.getId());
                    break;
                default:
                    break;
            }
            System.out.println(ps);
            Boolean result = ps.execute();            
            
        } catch (SQLException ex) {
            System.out.println( ex.getMessage());
        }
    }

    @Override
    public Lista getListaById(Integer id) {
        try {
            Statement st = Conexion.getInstance().getCon().createStatement();
            ResultSet rs = st.executeQuery(String.format("%s %s %s ", Lista.Q,
                    Lista.Q_WHRE_ID, id));
            Lista obj = null;
            while (rs.next()) {
                obj = VideoDaoJdbcHelper.makeLista(rs);
            }
            return obj;
        } catch (SQLException ex) {

        }
        return null;
    }

    @Override
    public List<Lista> getListasByCriteria(String criterio) {
        List<Lista> objects = new ArrayList<>();
        try {
            Statement st = Conexion.getInstance().getCon().createStatement();
            ResultSet rs = st.executeQuery(String.format("%s %s %s ", Lista.Q,
                    criterio.isEmpty() ? "" : Lista.Q_WHERE, criterio));
            Lista obj = null;
            while (rs.next()) {
                obj = VideoDaoJdbcHelper.makeLista(rs);
                objects.add(obj);
            }

        } catch (SQLException ex) {

        }
        return objects;        
    }

    @Override
    public void listaProcess(Lista lista, CRUD crud) {
        try {
            PreparedStatement ps = null;
            switch (crud) {
                case CREATE:
                    ps = Conexion.getInstance().
                    getCon().prepareStatement(Lista.INSERT_LISTA);
                    ps.setInt(1, lista.getSocio().getId());
                    ps.setDate(2, lista.getFecha());
                    ps.setString(3, lista.getEstatus());
                    ps.setInt(4, lista.getPelicula().getId());
                    break;
                case UPDATE:
                    //UPDATE TABLA SET()
                    ps = Conexion.getInstance().
                    getCon().prepareStatement(Lista.UPDATE_LISTA);
                    ps.setInt(1, lista.getSocio().getId());
                    ps.setDate(2, lista.getFecha());
                    ps.setString(3, lista.getEstatus());
                    ps.setInt(4, lista.getId());
                    break;
                case DELETE:
                    ps = Conexion.getInstance().
                    getCon().prepareStatement(Lista.DELETE_LISTA);
                    ps.setInt(1, lista.getId());
                    break;
                default:
                    break;
            }
            System.out.println(ps);
            Boolean result = ps.execute();            
            
        } catch (SQLException ex) {
            System.out.println( ex.getMessage());
        }
    }
}
