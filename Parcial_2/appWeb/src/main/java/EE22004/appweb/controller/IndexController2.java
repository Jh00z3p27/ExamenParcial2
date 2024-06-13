
package EE22004.appweb.controller;

import EE22004.appweb.entidades.Materia;
import EE22004.appweb.negocio.DataService2;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class IndexController2 {

    private List<Materia> materiasList = new ArrayList<>();

    private Materia materia = new Materia();

    @EJB
    DataService2 servicio2;

    @PostConstruct
    public void cargarMaterias() {
        materiasList = servicio2.getMaterias();
    }

    public void guardarMateria() {
        if (materia.getId_materia() != null) {
            servicio2.editMateria(materia);
        } else {
            servicio2.saveMateria(materia);
        }
        materia = new Materia();
        cargarMaterias();
    }

    public void llenarFormEditar(Materia materia) {
        this.materia.setId_materia(materia.getId_materia());
        this.materia.setMateria(materia.getMateria());
        this.materia.setDescripcion(materia.getDescripcion());
        this.materia.setCodigo_materia(materia.getCodigo_materia());
    }

    public void eliminarMateria(Materia materia) {
        servicio2.deleteMateria(materia);
        cargarMaterias();
    }

    //**Getters And Setters**//
    public List<Materia> getMateriasList() {
        return materiasList;
    }

    public void setMateriasList(List<Materia> materiasList) {
        this.materiasList = materiasList;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Materia getMateria() {
        return materia;
    }
}
