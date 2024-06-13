package EE22004.appweb.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "materia")
public class Materia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "materia_id_seq", sequenceName = "materia_id_seq", allocationSize = 1)
    @Column(name = "id_materia")
    private Long id_materia;
    @Column(name = "materia")
    private String materia;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "codigo_materia")
    private String codigo_materia;
    @OneToMany(mappedBy = "materia")
    private Set<Inscripcion> inscripciones;
    
     // Constructor, getters y setters
    
    public Long getId_materia(){
        return id_materia;
    }
    public void setId_materia(Long id_materia){
        this.id_materia = id_materia;
    }
    
    public String getMateria(){
        return materia;
    }
    
    public void setMateria(String materia){
        this.materia = materia;
    }
    
    public String getDescripcion(){
        return descripcion;
    }
    
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    
    public String getCodigo_materia(){
        return codigo_materia;
    }
    
    public void setCodigo_materia(String codigo_materia){
        this.codigo_materia = codigo_materia;
    }
   
    public Materia(Long id_materia) {
        this.id_materia = id_materia;
    }

    public Materia(Long id_materia, String materia, String descripcion, String codigo_materia) {
        this.id_materia = id_materia;
        this.materia = materia;
        this.descripcion = descripcion;
        this.codigo_materia = codigo_materia;
    }
    
    public Materia() {
        
    }

    public Materia(Long id_materia, String materia) {
        this.id_materia = id_materia;
        this.materia = materia;
    }
   
    public Set<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(Set<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
    }

}
