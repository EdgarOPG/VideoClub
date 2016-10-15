
package mx.uach.videoclub.dao;

import mx.uach.videoclub.dao.enums.CRUD;
import java.util.List;
import mx.uach.videoclub.modelos.Actor;
import mx.uach.videoclub.modelos.Cinta;
import mx.uach.videoclub.modelos.Director;
import mx.uach.videoclub.modelos.Ficha;
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
    * Interface de la clase Director
    */
    
    public Director getDirectorById(Integer id);
    
    public List<Director> getDirectoresByCriteria(String criterio);
    
    public void directorProcess(Director director, CRUD crud);
    
   /**
    * Interface de la clase Actor
    */
    
    public Actor getActorById(Integer id);
    
    public List<Actor> getActoresByCriteria(String criterio);

    public void actorProccess(Actor actor, CRUD crud);
     
   /**
    * Interface de la clase Ficha
    */
    
    public Ficha getFichaById(Integer id);
    
    public List<Ficha> getFichasByCriteria(String criterio);

    public void fichaProccess(Ficha ficha, CRUD crud);  
    
   /**
    * Interface de la clase Socio
    */    
 
    public Socio getSocioById(Integer id);
    
    public List<Socio> getSociosByCriteria(String criterio);

    public void socioProccess(Socio socio, CRUD crud); 
    
   /**
    * Interface de la clase Pelicula
    */
    
    public Pelicula getPeliculaById(Integer id);
    
    public List<Pelicula> getPeliculasByCriteria(String criterio);

    public void peliculaProccess(Pelicula pelicula, CRUD crud); 
    
   /**
    * Interface de la clase Cinta
    */
    
    public Cinta getCintaById(Integer id);
    
    public List<Cinta> getCintasByCriteria(String criterio);

    public void cintaProccess(Cinta cinta, CRUD crud); 
    
   /**
    * Interface de la clase Prestamo
    */
    
    public Prestamo getPrestamoById(Integer id);
    
    public List<Prestamo> getPrestamosByCriteria(String criterio);

    public void prestamoProccess(Prestamo prestamo, CRUD crud); 
    
}
