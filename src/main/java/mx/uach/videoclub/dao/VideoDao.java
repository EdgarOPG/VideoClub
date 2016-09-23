
package mx.uach.videoclub.dao;

import java.util.List;
import mx.uach.videoclub.modelos.Director;

/**
 * Declaracion de los metodos de escritura 
 * y lectura de un modelo a otro.
 * @author Edgar Omar Peinado Garcia
 * @version 1.0
 */
public interface VideoDao {
    public Director getDirectorById(Integer id);
    
    public List<Director> getDirectoresByCriteria(String criterio);
    
    public void directorProcess(Director director, CRUD crud);
}
