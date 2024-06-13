package EE22004.appweb.controller;

import EE22004.appweb.entidades.Alumno;
import EE22004.appweb.entidades.Inscripcion;
import EE22004.appweb.entidades.Materia;
import EE22004.appweb.negocio.DataService3;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class IndexController3 {

    private List<Inscripcion> inscripcionesList = new ArrayList<>();
    private List<Alumno> alumnosList = new ArrayList<>();
    private List<Materia> materiasList = new ArrayList<>();

    private Inscripcion inscripcion = new Inscripcion();

    @EJB
    private DataService3 servicio3;

    @PostConstruct
    public void cargarDatos() {
        try {
            inscripcionesList = servicio3.getInscripciones();
            alumnosList = servicio3.getAlumnos();
            materiasList = servicio3.getMaterias();
        } catch (Exception e) {
            e.printStackTrace(); // Registro de la excepción para diagnóstico
        }
    }

    public void guardarInscripcion() {
        try {
            if (inscripcion.getId() != null) {
                servicio3.editInscripcion(inscripcion);
            } else {
                servicio3.saveInscripcion(inscripcion);
            }
            inscripcion = new Inscripcion();
            cargarDatos();
        } catch (Exception e) {
            // Registro de la excepción para diagnóstico
            
        }
    }

    public void llenarFormEditar(Inscripcion inscripcion) {
        this.inscripcion = inscripcion;
    }

    public void eliminarInscripcion(Inscripcion inscripcion) {
        try {
            servicio3.deleteInscripcion(inscripcion);
            cargarDatos();
        } catch (Exception e) {
            e.printStackTrace(); // Registro de la excepción para diagnóstico
        }
    }

    // Getters and Setters
    public List<Inscripcion> getInscripcionesList() {
        return inscripcionesList;
    }

    public void setInscripcionesList(List<Inscripcion> inscripcionesList) {
        this.inscripcionesList = inscripcionesList;
    }

    public Inscripcion getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(Inscripcion inscripcion) {
        this.inscripcion = inscripcion;
    }

    public List<Alumno> getAlumnosList() {
        return alumnosList;
    }

    public void setAlumnosList(List<Alumno> alumnosList) {
        this.alumnosList = alumnosList;
    }

    public List<Materia> getMateriasList() {
        return materiasList;
    }

    public void setMateriasList(List<Materia> materiasList) {
        this.materiasList = materiasList;
    }
}
