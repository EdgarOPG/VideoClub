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

    /**
     * Regresa un director basado en un id del registro de la base de datos.
     *
     * @param id entero que identifica la entidad.
     * @return null si el id no se encuentra en la base de datos ó un
     * {@code Director} si el id es valido.
     */
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

    /**
     * Regresa una lista de directores basado en un criterio especifico de 
     * la base de datos.
     * @param criterio Cadena de texto para buscar por cualquier atributo.
     * @return null si no encuentra ninguna coincidencia
     * {@code List<Director>} si hay al menos una.
     */
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
    
    
    /**
     * Crea, actualiza o elimina un director basado en un id del registro de 
     * la base de datos.
     *
     * @param director recibe una instancia de esta clase, para utilizar despues
     * sus atributos como parametros para las operacines del CRUD.
     * @param crud un valor enum que puede ser CREATE, UPDATE, DELETE.
     */
    @Override
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
    
    /**
     * Regresa un actor basado en un id del registro de la base de datos.
     *
     * @param id entero que identifica la entidad.
     * @return null si el id no se encuentra en la base de datos ó un
     * {@code Actor} si el id es valido.
     */
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
    
    /**
     * Regresa una lista de actores basado en un criterio especifico de la base 
     * de datos.
     * @param criterio Cadena de texto para buscar por cualquier atributo.
     * @return null si no encuentra ninguna coincidencia
     * {@code List<Actor>} si hay al menos una.
     */
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
    
    /**
     * Crea, actualiza o elimina un actor basado en un id del registro de 
     * la base de datos.
     *
     * @param actor recibe una instancia de esta clase, para utilizar despues
     * sus atributos como parametros para las operacines del CRUD.
     * @param crud un valor enum que puede ser CREATE, UPDATE, DELETE.
     */
    @Override
    public void actorProccess(Actor actor, CRUD crud) {
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

    /**
     * Regresa una ficha basado en un id del registro de la base de datos.
     *
     * @param id entero que identifica la entidad.
     * @return null si el id no se encuentra en la base de datos ó un
     * {@code Ficha} si el id es valido.
     */
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
    
    /**
     * Regresa una lista de fichas basado en un criterio especifico de la base 
     * de datos.
     * @param criterio Cadena de texto para buscar por cualquier atributo.
     * @return null si no encuentra ninguna coincidencia
     * {@code List<Actor>} si hay al menos una.
     */
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
    
    /**
     * Crea, actualiza o elimina una ficha basado en un id del registro de 
     * la base de datos.
     *
     * @param ficha recibe una instancia de esta clase, para utilizar despues
     * sus atributos como parametros para las operacines del CRUD.
     * @param crud un valor enum que puede ser CREATE, UPDATE, DELETE.
     */
    @Override
    public void fichaProccess(Ficha ficha, CRUD crud) {
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
    
    /**
     * Regresa un socio basado en un id del registro de la base de datos.
     *
     * @param id entero que identifica la entidad.
     * @return null si el id no se encuentra en la base de datos ó un
     * {@code Socio} si el id es valido.
     */
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
    
    /**
     * Regresa una lista de socios basado en un criterio especifico de la base 
     * de datos.
     * @param criterio Cadena de texto para buscar por cualquier atributo.
     * @return null si no encuentra ninguna coincidencia
     * {@code List<Socio>} si hay al menos una.
     */
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
    
    /**
     * Crea, actualiza o elimina un socio basado en un id del registro de 
     * la base de datos.
     *
     * @param socio recibe una instancia de esta clase, para utilizar despues
     * sus atributos como parametros para las operacines del CRUD.
     * @param crud un valor enum que puede ser CREATE, UPDATE, DELETE.
     */
    @Override
    public void socioProccess(Socio socio, CRUD crud) {
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

    /**
     * Regresa una pelicula basado en un id del registro de la base de datos.
     *
     * @param id entero que identifica la entidad.
     * @return null si el id no se encuentra en la base de datos ó un
     * {@code Pelicula} si el id es valido.
     */
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
    
    /**
     * Regresa una lista de peliculas basado en un criterio especifico de la base 
     * de datos.
     * @param criterio Cadena de texto para buscar por cualquier atributo.
     * @return null si no encuentra ninguna coincidencia
     * {@code List<Pelicula>} si hay al menos una.
     */
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
    
    /**
     * Crea, actualiza o elimina una pelicula basado en un id del registro de 
     * la base de datos.
     *
     * @param pelicula recibe una instancia de esta clase, para utilizar despues
     * sus atributos como parametros para las operacines del CRUD.
     * @param crud un valor enum que puede ser CREATE, UPDATE, DELETE.
     */
    @Override
    public void peliculaProccess(Pelicula pelicula, CRUD crud) {
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
    
    /**
     * Regresa una cinta basado en un id del registro de la base de datos.
     *
     * @param id entero que identifica la entidad.
     * @return null si el id no se encuentra en la base de datos ó un
     * {@code Pelicula} si el id es valido.
     */
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
    
    /**
     * Regresa una lista de cintas basado en un criterio especifico de la base 
     * de datos.
     * @param criterio Cadena de texto para buscar por cualquier atributo.
     * @return null si no encuentra ninguna coincidencia
     * {@code List<Cinta>} si hay al menos una.
     */
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
    
    /**
     * Crea, actualiza o elimina una pelicula basado en un id del registro de 
     * la base de datos.
     *
     * @param pelicula recibe una instancia de esta clase, para utilizar despues
     * sus atributos como parametros para las operacines del CRUD.
     * @param crud un valor enum que puede ser CREATE, UPDATE, DELETE.
     */
    @Override
    public void cintaProccess(Cinta cinta, CRUD crud) {
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
    
    /**
     * Regresa una solo prestamo basado en un id del registro de la base de datos.
     *
     * @param id entero que identifica la entidad.
     * @return null si el id no se encuentra en la base de datos ó un
     * {@code Prestamo} si el id es valido.
     */
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
    
   /**
     * Regresa una lista de los prestamos basado en un criterio especifico de la base 
     * de datos.
     * @param criterio Cadena de texto para buscar por cualquier atributo.
     * @return null si no encuentra ninguna coincidencia
     * {@code List<Prestamo>} si hay al menos una.
     */
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

    /**
     * Crea, actualiza o elimina una pelicula basado en un id del registro de 
     * la base de datos.
     *
     * @param prestamo recibe una instancia de esta clase, para utilizar despues
     * sus atributos como parametros para las operacines del CRUD.
     * @param crud un valor enum que puede ser CREATE, UPDATE, DELETE.
     */
    @Override
    public void prestamoProccess(Prestamo prestamo, CRUD crud) {
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
}
