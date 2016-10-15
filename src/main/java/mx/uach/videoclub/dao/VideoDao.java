
package mx.uach.videoclub.dao;

import mx.uach.videoclub.dao.enums.CRUD;
import java.util.List;
import mx.uach.videoclub.modelos.Actor;
import mx.uach.videoclub.modelos.Cinta;
import mx.uach.videoclub.modelos.Director;
import mx.uach.videoclub.modelos.Ficha;
import mx.uach.videoclub.modelos.Lista;
import mx.uach.videoclub.modelos.Pelicula;
import mx.uach.videoclub.modelos.Prestamo;
import mx.uach.videoclub.modelos.Socio;

/**
 * Declaracion de los metodos de escritura 
 * y lectura de un modelo a otro.
 * @author Edgar Omar Peinado Garcia
 * @version 1.0
 */
public interface VideoDao {
    
    /**
     * Regresa un director basado en un id del registro de la base de datos.
     *
     * @param id entero que identifica la entidad.
     * @return null si el id no se encuentra en la base de datos ó un
     * {@code Director} si el id es valido.
     */
    public Director getDirectorById(Integer id);
    
    /**
     * Regresa una lista de directores basado en un criterio especifico de 
     * la base de datos.
     * @param criterio Cadena de texto para buscar por cualquier atributo.
     * @return null si no encuentra ninguna coincidencia
     * {@code List<Director>} si hay al menos una.
     */
    public List<Director> getDirectoresByCriteria(String criterio);
    
    /**
     * Crea, actualiza o elimina un director basado en un id del registro de 
     * la base de datos.
     *
     * @param director recibe una instancia de esta clase, para utilizar despues
     * sus atributos como parametros para las operacines del CRUD.
     * @param crud un valor enum que puede ser CREATE, UPDATE, DELETE.
     * @Override
     */    
    public void directorProcess(Director director, CRUD crud);
    
    /**
     * Regresa un actor basado en un id del registro de la base de datos.
     *
     * @param id entero que identifica la entidad.
     * @return null si el id no se encuentra en la base de datos ó un
     * {@code Actor} si el id es valido.
     */
    public Actor getActorById(Integer id);
    
    /**
     * Regresa una lista de actores basado en un criterio especifico de la base 
     * de datos.
     * @param criterio Cadena de texto para buscar por cualquier atributo.
     * @return null si no encuentra ninguna coincidencia
     * {@code List<Actor>} si hay al menos una.
     */
    public List<Actor> getActoresByCriteria(String criterio);

        /**
     * Crea, actualiza o elimina un actor basado en un id del registro de 
     * la base de datos.
     *
     * @param actor recibe una instancia de esta clase, para utilizar despues
     * sus atributos como parametros para las operacines del CRUD.
     * @param crud un valor enum que puede ser CREATE, UPDATE, DELETE.
     */
    public void actorProcess(Actor actor, CRUD crud);
    
    /**
     * Regresa una ficha basado en un id del registro de la base de datos.
     *
     * @param id entero que identifica la entidad.
     * @return null si el id no se encuentra en la base de datos ó un
     * {@code Ficha} si el id es valido.
     */
    public Ficha getFichaById(Integer id);

    /**
     * Regresa una lista de fichas basado en un criterio especifico de la base 
     * de datos.
     * @param criterio Cadena de texto para buscar por cualquier atributo.
     * @return null si no encuentra ninguna coincidencia
     * {@code List<Actor>} si hay al menos una.
     */
    public List<Ficha> getFichasByCriteria(String criterio);

    /**
     * Crea, actualiza o elimina una ficha basado en un id del registro de 
     * la base de datos.
     *
     * @param ficha recibe una instancia de esta clase, para utilizar despues
     * sus atributos como parametros para las operacines del CRUD.
     * @param crud un valor enum que puede ser CREATE, UPDATE, DELETE.
     */    
    public void fichaProcess(Ficha ficha, CRUD crud);  
    
    /**
     * Regresa un socio basado en un id del registro de la base de datos.
     *
     * @param id entero que identifica la entidad.
     * @return null si el id no se encuentra en la base de datos ó un
     * {@code Socio} si el id es valido.
     */ 
    public Socio getSocioById(Integer id);
    
    /**
     * Regresa una lista de socios basado en un criterio especifico de la base 
     * de datos.
     * @param criterio Cadena de texto para buscar por cualquier atributo.
     * @return null si no encuentra ninguna coincidencia
     * {@code List<Socio>} si hay al menos una.
     */    
    public List<Socio> getSociosByCriteria(String criterio);

    /**
     * Crea, actualiza o elimina un socio basado en un id del registro de 
     * la base de datos.
     *
     * @param socio recibe una instancia de esta clase, para utilizar despues
     * sus atributos como parametros para las operacines del CRUD.
     * @param crud un valor enum que puede ser CREATE, UPDATE, DELETE.
     */    
    public void socioProcess(Socio socio, CRUD crud); 
    
    /**
     * Regresa una pelicula basado en un id del registro de la base de datos.
     *
     * @param id entero que identifica la entidad.
     * @return null si el id no se encuentra en la base de datos ó un
     * {@code Pelicula} si el id es valido.
     */    
    public Pelicula getPeliculaById(Integer id);
    
    /**
     * Regresa una lista de peliculas basado en un criterio especifico de la base 
     * de datos.
     * @param criterio Cadena de texto para buscar por cualquier atributo.
     * @return null si no encuentra ninguna coincidencia
     * {@code List<Pelicula>} si hay al menos una.
     */
    public List<Pelicula> getPeliculasByCriteria(String criterio);

    /**
     * Crea, actualiza o elimina una pelicula basado en un id del registro de 
     * la base de datos.
     *
     * @param pelicula recibe una instancia de esta clase, para utilizar despues
     * sus atributos como parametros para las operacines del CRUD.
     * @param crud un valor enum que puede ser CREATE, UPDATE, DELETE.
     */    
    public void peliculaProcess(Pelicula pelicula, CRUD crud); 
    
    /**
     * Regresa una cinta basado en un id del registro de la base de datos.
     *
     * @param id entero que identifica la entidad.
     * @return null si el id no se encuentra en la base de datos ó un
     * {@code Pelicula} si el id es valido.
     */    
    public Cinta getCintaById(Integer id);
    
    /**
     * Regresa una lista de cintas basado en un criterio especifico de la base 
     * de datos.
     * @param criterio Cadena de texto para buscar por cualquier atributo.
     * @return null si no encuentra ninguna coincidencia
     * {@code List<Cinta>} si hay al menos una.
     */
    public List<Cinta> getCintasByCriteria(String criterio);

    /**
     * Crea, actualiza o elimina una pelicula basado en un id del registro de 
     * la base de datos.
     *
     * @param cinta recibe una instancia de esta clase, para utilizar despues
     * sus atributos como parametros para las operacines del CRUD.
     * @param crud un valor enum que puede ser CREATE, UPDATE, DELETE.
     */
    public void cintaProcess(Cinta cinta, CRUD crud); 
    
    /**
     * Regresa una solo prestamo basado en un id del registro de la base de datos.
     *
     * @param id entero que identifica la entidad.
     * @return null si el id no se encuentra en la base de datos ó un
     * {@code Prestamo} si el id es valido.
     */
    public Prestamo getPrestamoById(Integer id);
    
   /**
     * Regresa una lista de los prestamos basado en un criterio especifico de la base 
     * de datos.
     * @param criterio Cadena de texto para buscar por cualquier atributo.
     * @return null si no encuentra ninguna coincidencia
     * {@code List<Prestamo>} si hay al menos una.
     */
    public List<Prestamo> getPrestamosByCriteria(String criterio);

    /**
     * Crea, actualiza o elimina una pelicula basado en un id del registro de 
     * la base de datos.
     *
     * @param prestamo recibe una instancia de esta clase, para utilizar despues
     * sus atributos como parametros para las operacines del CRUD.
     * @param crud un valor enum que puede ser CREATE, UPDATE, DELETE.
     */    
    public void prestamoProcess(Prestamo prestamo, CRUD crud); 
    
        /**
     * Regresa una solo prestamo basado en un id del registro de la base de datos.
     *
     * @param id entero que identifica la entidad.
     * @return null si el id no se encuentra en la base de datos ó un
     * {@code Lista} si el id es valido.
     */
    
    public Lista getListaById(Integer id);
   /**
     * Regresa una lista de los prestamos basado en un criterio especifico de la base 
     * de datos.
     * @param criterio Cadena de texto para buscar por cualquier atributo.
     * @return null si no encuentra ninguna coincidencia
     * {@code List<Lista>} si hay al menos una.
     */
    public List<Lista> getListasByCriteria(String criterio);

    /**
     * Crea, actualiza o elimina una pelicula basado en un id del registro de 
     * la base de datos.
     *
     * @param lista recibe una instancia de esta clase, para utilizar despues
     * sus atributos como parametros para las operacines del CRUD.
     * @param crud un valor enum que puede ser CREATE, UPDATE, DELETE.
     */    
    public void listaProcess(Lista lista, CRUD crud); 
    
}
