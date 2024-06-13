
package EE22004.appweb.negocio;

import EE22004.appweb.entidades.Alumno;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;

@Stateless
public class DataService {
    
    
    @PersistenceContext(unitName = "pu")
    EntityManager entityManager;
    
    public List<Alumno> getAlumnos(){
    
        Query query = entityManager.createQuery("SELECT e FROM Alumno e ORDER BY e.id ASC");
        List<Alumno> alumnos = query.getResultList();
        
    return alumnos;
    }
    
    @Transactional
    public void saveAlumno(Alumno alumno){
        entityManager.persist(alumno);
    }
    @Transactional
    public void editAlumno(Alumno alumno){
    entityManager.merge(alumno);
    }
    @Transactional
    public void deleteAlumno(Alumno alumno){
     Alumno alumnoEliminar = entityManager.find(Alumno.class, alumno.getId());
     entityManager.remove(alumnoEliminar);
    }
    
  }
