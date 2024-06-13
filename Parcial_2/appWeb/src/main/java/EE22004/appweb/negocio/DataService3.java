package EE22004.appweb.negocio;

import EE22004.appweb.entidades.Alumno;
import EE22004.appweb.entidades.Inscripcion;
import EE22004.appweb.entidades.Materia;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class DataService3 {

    @PersistenceContext(unitName = "pu")
    private EntityManager em;

    public List<Inscripcion> getInscripciones() {
        return em.createQuery("SELECT i FROM Inscripcion i", Inscripcion.class).getResultList();
    }

    public List<Alumno> getAlumnos() {
        return em.createQuery("SELECT a FROM Alumno a", Alumno.class).getResultList();
    }

    public List<Materia> getMaterias() {
        return em.createQuery("SELECT m FROM Materia m", Materia.class).getResultList();
    }

    public void saveInscripcion(Inscripcion inscripcion) {
        em.persist(inscripcion);
    }

    public void editInscripcion(Inscripcion inscripcion) {
        em.merge(inscripcion);
    }

    public void deleteInscripcion(Inscripcion inscripcion) {
        em.remove(em.contains(inscripcion) ? inscripcion : em.merge(inscripcion));
    }
}
